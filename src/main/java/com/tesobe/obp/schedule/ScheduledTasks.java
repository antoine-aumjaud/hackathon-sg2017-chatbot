package com.tesobe.obp.schedule;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.tesobe.obp.account.Account;
import com.tesobe.obp.account.AccountService;
import com.tesobe.obp.account.Transaction;
import com.tesobe.obp.auth.DirectAuthenticationService;
import com.tesobe.obp.botclient.DataUser;
import com.tesobe.obp.botclient.DataUserMock;
import com.tesobe.obp.transaction.MonetaryTransactionsService;
import com.tesobe.obp.utils.DataFormatter;

@Component
public class ScheduledTasks {

	private static final Logger logger = LoggerFactory.getLogger(ScheduledTasks.class);

	@Value("${obp.username}")
	private String username;

	@Value("${obp.password}")
	private String password;

	@Value("${chatfuel.url}")
	private String chatfuelUrl;

	@Value("${chatfuel.token}")
	private String chatfuelToken;

	@Value("${chatfuel.botId}")
	private String chatfuelBotId;

	@Value("${obp.mock}")
	private boolean mock;

	@Autowired
	private DataUserMock dataUserMock;

	@Autowired
	private DataUser dataUser;

	@Autowired
	private DataFormatter dataFormatter;

	@Autowired
	private DirectAuthenticationService authenticationService;
	@Autowired
	private AccountService accountService;
	@Autowired
	private MonetaryTransactionsService monetaryTransactionService;

	@Value("${obp.datatime.start}")
	private String datatimeStart;

	@Scheduled(fixedRate = 10 * 1000)
	public void reportCurrentTime() {
		if (dataUser.chabotId == null) {
			logger.debug("userId not defined");
			return;
		}
		pushBotPay();
		pushBotAlertSolde();
		pushBotEpargne();
	}

	private void pushBotPay() {
		logger.info("Enter pushBotPay, payNotify : " + dataUser.payNotifAlreadyDone);
		if (!dataUser.payNotifAlreadyDone) {
			if (mock) {
				double pay = 3600 + Math.random() * 2 * 100;
				pushBot("notif_pay", new ParameterPay(pay));
				dataUser.payNotifAlreadyDone = true;
			} else {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
				String token = authenticationService.login(username, password);
				List<Account> accounts = accountService.fetchPrivateAccounts(token, true);
				logger.info("On récupère " + accounts.size() + " comptes du pushBotPay.");
				List<Transaction> transactions = monetaryTransactionService
						.fetchTransactionList(token, accounts.get(0));
				logger.info("On récupère " + transactions.size()
						+ " transactions sur le compte 1");
				// search for transaction of day and > at 1000 to get salary
				for (Transaction transaction : transactions) {
					int currentAmount = transaction.getDetails().getValue().getAmount()
							.intValue();
					logger.info("Transaction " + transaction.getDetails().getDescription()
							+ " montant : " + currentAmount + "Condition salaire : "
							+ (currentAmount > 900 && sdf
									.format(transaction.getDetails().getCompletedDate())
									.compareTo(datatimeStart) > 0)
							+ " / compare to "
							+ sdf.format(transaction.getDetails().getCompletedDate())
									.compareTo(datatimeStart));
					if (currentAmount > 900
							&& sdf.format(transaction.getDetails().getCompletedDate())
									.compareTo(datatimeStart) > 0) {
						logger.info("Salary found, launch notify");
						pushBot("notif_pay", new ParameterPay(currentAmount,
								"https://media.giphy.com/media/l3q2tBVPkO6PHnTJC/200w_d.gif"));
						dataUser.payNotifAlreadyDone = true;
						break;
					}
				}
			}

		}
	}

	private void pushBotAlertSolde() {
		if (!dataUser.soldeAlerteAlreadyDone) {
			if (mock) {
				if (dataUserMock.cc_amount < dataUserMock.cc_seuil) {
					pushBot("notif_alert_solde", new ParameterAlert(dataUserMock.cc_seuil,
							dataUserMock.cc_amount, dataUserMock.epargne_amount, 100));
				}
			} else {

			}
			dataUser.soldeAlerteAlreadyDone = true;
		}
	}

	private void pushBotEpargne() {
		if (!dataUser.epargneAlreadyDone) {
			if (mock && dataUserMock.cc_amount > 500) {
				pushBot("notif_epargne",
						new ParameterEpargne(dataUserMock.cc_amount, 500));
			}
			dataUser.epargneAlreadyDone = true;
		}
	}

	private class ParameterPay {
		private final String pay;
		private final String urlAttachment;

		public ParameterPay(double pay) {
			this.pay = dataFormatter.formatAmount(pay);
			urlAttachment = null;
		}

		public ParameterPay(double pay, String urlAttachment) {
			this.pay = dataFormatter.formatAmount(pay);
			this.urlAttachment = urlAttachment;
		}
	}

	private class ParameterEpargne {
		private final String ccAmount;
		private final String transfertAmount;

		public ParameterEpargne(double ccAmount, double transfertAmount) {
			this.ccAmount = dataFormatter.formatAmount(ccAmount);
			this.transfertAmount = dataFormatter.formatAmount(transfertAmount);
		}
	}

	private class ParameterAlert {
		private final String seuil;
		private final String ccAmount;
		private final String epargneAmount;
		private final String transfertAmount;

		public ParameterAlert(double seuil, double ccAmount, double epargneAmount,
				double transfertAmount) {
			this.seuil = dataFormatter.formatAmount(seuil);
			this.ccAmount = dataFormatter.formatAmount(ccAmount);
			this.epargneAmount = dataFormatter.formatAmount(epargneAmount);
			this.transfertAmount = dataFormatter.formatAmount(transfertAmount);
		}
	}

	private void pushBot(String blocName, Object args) {

		String data = new Gson().toJson(args);
		String urlstr = String.format(chatfuelUrl, chatfuelBotId, dataUser.chabotId,
				chatfuelToken, blocName);
		logger.debug("Send POST data to {}", urlstr);

		byte[] postData = data.getBytes(StandardCharsets.UTF_8);
		try {
			URL url = new URL(urlstr);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setInstanceFollowRedirects(false);
			conn.setUseCaches(false);
			conn.setRequestProperty("Content-Type", "application/json; charset=utf-8");
			conn.setRequestProperty("Content-Length", Integer.toString(postData.length));
			conn.setRequestMethod("POST");
			// Write POST data
			try (DataOutputStream dos = new DataOutputStream(conn.getOutputStream())) {
				dos.write(postData);
			}
			// Read reponse
			String resultContent = getResultContent(conn);
			logger.debug("Response {} ({}) :{}", conn.getResponseCode(),
					conn.getResponseMessage(), resultContent);
		} catch (IOException e) {
			logger.error("Can't do a POST", e);
		}
	}

	private String getResultContent(HttpURLConnection conn) throws IOException {
		StringBuilder result = new StringBuilder();
		try (BufferedReader rd = new BufferedReader(
				new InputStreamReader(conn.getInputStream()))) {
			String line;
			while ((line = rd.readLine()) != null) {
				result.append(line);
			}
		}
		return result.toString();
	}

}
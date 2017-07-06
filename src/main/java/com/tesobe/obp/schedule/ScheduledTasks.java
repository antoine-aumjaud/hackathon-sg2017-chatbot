package com.tesobe.obp.schedule;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import com.tesobe.obp.transaction.MonetaryTransactionsService;

@Component
public class ScheduledTasks {

	private static final Logger logger = LoggerFactory.getLogger(ScheduledTasks.class);

	@Value("${chatfuel.url}")
	private String chatfuelUrl;

	@Value("${chatfuel.token}")
	private String chatfuelToken;

	@Value("${chatfuel.botId}")
	private String chatfuelBotId;

	@Autowired
	private DirectAuthenticationService authenticationService;
	@Autowired
	private AccountService accountService;
	@Autowired
	private MonetaryTransactionsService monetaryTransactionService;
	@Value("${obp.mock}")
	private String mock;

	@Value("${obp.username}")
	private String username;

	@Value("${obp.password}")
	private String password;

	public static String chatfuelUserId;
	/**
	 * If bot have already sent a notification for salary today
	 */
	public static boolean foundSalaryOfDay = false;

	@Scheduled(fixedRate = 10 * 1000)
	public void reportCurrentTime() {
		checkForSalary();
		// switch ((int) (Math.random() * 3)) {
		// case 0:
		// pushBotPay();
		// break;
		// case 1:
		// pushBotAlertVirement();
		// break;
		// case 2:
		// pushBotSeuilCC();
		// break;
		// }
	}

	private void pushBotPay() {
		double pay = 3600 + Math.random() * 2 * 100;
		pushBot("notif_pay", new ParameterPay(pay));
	}

	private void checkForSalary() {
		if (!foundSalaryOfDay) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String token = authenticationService.login(username, password);
			List<Account> accounts = accountService.fetchPrivateAccounts(token, true);
			List<Transaction> transactions = monetaryTransactionService
					.fetchTransactionList(token, accounts.get(0));
			int currentAmount;
			// search for transaction of day and > at 1000 to get salary
			for (Transaction transaction : transactions) {
				currentAmount = transaction.getDetails().getValue().getAmount()
						.intValue();
				if (currentAmount > 1000
						&& sdf.format(transaction.getDetails().getCompletedDate())
								.equals(sdf.format(new Date()))) {
					logger.info("Salary found, launch notify");
					pushBot("notif_pay", new ParameterPay(currentAmount));
					foundSalaryOfDay = true;
					break;
				}
			}
		}
	}

	private void pushBotAlertVirement() {
		double pay = 3600 + Math.random() * 2 * 100;
		pushBot("notif_pay", new ParameterPay(pay));
	}

	private void pushBotSeuilCC() {
		double pay = 3600 + Math.random() * 2 * 100;
		pushBot("notif_pay", new ParameterPay(pay));
	}

	private class ParameterPay {
		private final double pay;

		public ParameterPay(double pay) {
			this.pay = pay;
		}
	}

	private void pushBot(String blocName, Object args) {
		if (chatfuelUserId == null) {
			logger.debug("userId not defined");
			return;
		}

		String data = new Gson().toJson(args);
		String urlstr = String.format(chatfuelUrl, chatfuelBotId, chatfuelUserId,
				chatfuelToken, blocName);
		logger.debug("Send POST data to {}", urlstr);
		// chatfuel.url=https://api.chatfuel.com/bots/%s/users/%s/send?chatfuel_token=%s&chatfuel_block_name=%s

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
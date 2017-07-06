package com.tesobe.obp.botclient;

import java.net.URISyntaxException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tesobe.obp.account.Account;
import com.tesobe.obp.account.AccountService;
import com.tesobe.obp.account.Transaction;
import com.tesobe.obp.auth.DirectAuthenticationService;
import com.tesobe.obp.botclient.dto.AttachmentDTO;
import com.tesobe.obp.botclient.dto.MessageDTO;
import com.tesobe.obp.botclient.dto.QuickReplyDTO;
import com.tesobe.obp.transaction.MonetaryTransactionsService;
import com.tesobe.obp.utils.DataFormatter;

/**
 * REST controller for managing Asset.
 */
@RestController
public class ChatbotTransactionRessource {

	private final Logger log = LoggerFactory.getLogger(ChatbotTransactionRessource.class);

	@Autowired
	private DirectAuthenticationService authenticationService;

	@Autowired
	private AccountService accountService;

	@Autowired
	private MonetaryTransactionsService monetaryTransactionService;

	@Autowired
	private DataFormatter dataFormatter;

	@Autowired
	private DataUserMock dataUserMock;

	@Autowired
	private DataUser dataUser;

	@Value("${obp.mock}")
	private boolean mock;

	@Value("${obp.username}")
	private String username;

	@Value("${obp.password}")
	private String password;

	@Value("${obp.transactionMock.username}")
	private String usernameTransaction;

	@Value("${obp.transactionMock.password}")
	private String passwordTransaction;

	@RequestMapping("/addTransaction")
	public ResponseEntity addTransaction(@RequestParam("montant") String montant,
			@RequestParam("IBAN") String iban,
			@RequestParam("description") String description) {
		if (mock) {
			double amount = Double.parseDouble(montant);

			dataUserMock.cc_amount += amount;
			// dataUserMock.epargne_amount -= amount;
			dataUser.epargneAlreadyDone = false;
			dataUser.soldeAlerteAlreadyDone = false;
		} else {
			// On se connecte avec le user source
			String token = authenticationService.login(username, password);
			Account account = accountService.fetchPrivateAccounts(token, true).get(0);
			monetaryTransactionService.addTransaction(token, account, description,
					montant, null);
		}
		return ResponseEntity.ok(
				"<h1 style=\"color:green\">Votre demande de virement a bien été prise en compte");
	}

	@RequestMapping("/bot/transfert")
	public ResponseEntity doTransfer(@RequestParam("amount") String amount,
			@RequestParam("transfert_type") String transfertType) {
		if (mock) {
			double iamount = Double.parseDouble(amount);

			if (transfertType.equals("epargne"))
				iamount = -iamount;
			dataUserMock.cc_amount += iamount;
			dataUserMock.epargne_amount -= iamount;
		} else {
			String token = authenticationService.login(username, password);
			List<Account> accounts = accountService.fetchPrivateAccounts(token, true);
			Account accountCC = accounts.get(0);
			Account accountEpargne = accounts.get(1);
			if (transfertType.equals("cc")) { // epargne->cc
				monetaryTransactionService.addTransaction(token, accountCC,
						"automatic cc->epargne", amount, accountEpargne);
			} else {
				monetaryTransactionService.addTransaction(token, accountEpargne,
						"Epargne depuis CC", amount, accountCC);
			}
		}
		return ResponseEntity.ok("done");
	}

	@RequestMapping("/bot/transaction")
	public ResponseEntity transactionList() throws URISyntaxException {
		MessageDTO message = new MessageDTO();
		message.addText(
				"Voici la liste des dernières transactions sur votre compte courant :\n");
		if (mock) {
			message.addText("- votre salaire (" + dataFormatter.formatAmount(3000)
					+ " €) est arrivé hier!.");
			message.addMessage(AttachmentDTO.createImageAttachement(
					"https://media.giphy.com/media/l3q2tBVPkO6PHnTJC/200w_d.gif"));
			message.addText("- vous avez payé votre facture EDF ("
					+ dataFormatter.formatAmount(44.5) + " €).");
			message.addText("- vous avez payé " + dataFormatter.formatAmount(79)
					+ " € hier à 'Histoire De'.");
			// message.addText("C'est votre première transaction avec ce
			// tiers.");
			// message.addMessage(new QuickReplyDTO("Ajouter aux tiers connus",
			// "add_tiers"));
			return ResponseEntity.ok(message);
		} else {
			String token = authenticationService.login(username, password);
			List<Account> accounts = accountService.fetchPrivateAccounts(token, true);
			List<Transaction> transactions = monetaryTransactionService
					.fetchTransactionList(token, accounts.get(0));
			for (int i = 0; ((i < transactions.size()) && (i < 3)); i++) {
				String currentDate = dataFormatter
						.formatDate(transactions.get(i).getDetails().getCompletedDate());
				// if > at 1000 then put gif
				message.addText(currentDate + " : " //
						+ transactions.get(i).getDetails().getDescription() //
						+ " (" //
						+ dataFormatter.formatAmount(
								transactions.get(i).getDetails().getValue().getAmount()) //
						+ ")"); //
				if (transactions.get(i).getDetails().getValue().getAmount().toBigInteger()
						.intValue() > 1000) {
					message.addMessage(AttachmentDTO.createImageAttachement(
							"https://media.giphy.com/media/l3q2tBVPkO6PHnTJC/200w_d.gif"));
				}
			}
			message.addMessage(
					new QuickReplyDTO("ajouter aux tiers connus", "Default Block"));
			return ResponseEntity.ok(message);
		}
	}
}

package com.tesobe.obp.botclient;

import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tesobe.obp.account.Account;
import com.tesobe.obp.account.AccountService;
import com.tesobe.obp.account.Transaction;
import com.tesobe.obp.auth.DirectAuthenticationService;
import com.tesobe.obp.transaction.MonetaryTransactionsService;

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

	@Value("${obp.mock}")
	private String mock;

	@Value("${obp.username}")
	private String username;

	@Value("${obp.password}")
	private String password;

	public ChatbotTransactionRessource() {
	}

	@RequestMapping("/bot/transaction")
	public ResponseEntity test() throws URISyntaxException {

		MessageDTO message = new MessageDTO();
		TextDTO texte = new TextDTO();
		String currentDate = "";
		texte.setText(
				"Voici la liste des dernières transactions sur votre compte courant :\n");
		message.getMessages().add(texte);
		if (mock.equals("true")) {

			texte = new TextDTO();
			texte.setText("votre salaire (+ 3 000 €) est arrivé hier!.");
			message.getMessages().add(texte);
			AttachmentDTO attachmentDTO = AttachmentDTO
					.createImageAttachement("http://gph.is/2ki7Qrt");
			message.getMessages().add(attachmentDTO);
			texte = new TextDTO();
			texte.setText("vous avez payé votre facture EDF (+ 44,5 €).");
			message.getMessages().add(texte);
			texte = new TextDTO();
			texte.setText(
					"vous avez payé 22 € hier à 'Histoire De'. C'est votre première transaction avec ce tiers.");
			message.getMessages().add(texte);
			QuickReplyDTO quickReplyDTO = new QuickReplyDTO("ajouter aux tiers connus",
					"Default Block");
			message.getMessages().add(quickReplyDTO);
			return ResponseEntity.ok(message);
		} else {
			String token = authenticationService.login(username, password);
			List<Account> accounts = accountService.fetchPrivateAccounts(token, true);
			List<Transaction> transactions = monetaryTransactionService
					.fetchTransactionList(token, accounts.get(0));
			for (int i = 0; ((i < transactions.size()) && (i < 3)); i++) {
				texte = new TextDTO();
				SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
				transactions.get(i).getDetails().getCompletedDate();
				currentDate = formatter
						.format(transactions.get(i).getDetails().getCompletedDate());
				texte.setText(currentDate + " : "
						+ transactions.get(i).getDetails().getDescription() + " ("
						+ transactions.get(i).getDetails().getValue().getAmount() + ")");
				// if > at 1000 then put gif
				message.getMessages().add(texte);
				if (transactions.get(i).getDetails().getValue().getAmount().toBigInteger()
						.intValue() > 1000) {
					AttachmentDTO attachmentDTO = AttachmentDTO.createImageAttachement(
							"https://media.giphy.com/media/l3q2tBVPkO6PHnTJC/200w_d.gif");
					message.getMessages().add(attachmentDTO);
				}
			}
			QuickReplyDTO quickReplyDTO = new QuickReplyDTO("ajouter aux tiers connus",
					"Default Block");
			message.getMessages().add(quickReplyDTO);
			return ResponseEntity.ok(message); 
		}

	}

}

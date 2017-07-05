package com.tesobe.obp.botclient;

import java.net.URISyntaxException;
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
import com.tesobe.obp.auth.DirectAuthenticationService;

/**
 * REST controller for managing Asset.
 */
@RestController
public class ChatbotAccountRessource {

	private final Logger log = LoggerFactory.getLogger(ChatbotAccountRessource.class);

	private static final String ENTITY_NAME = "asset";

	@Autowired
	private DirectAuthenticationService authenticationService;
	@Autowired
	private AccountService accountService;

	@Value("${obp.mock}")
	private String mock;

	@Value("${obp.username}")
	private String username;

	@Value("${obp.password}")
	private String password;

	public ChatbotAccountRessource() {
	}

	@RequestMapping("/bot/account")
	public ResponseEntity test() throws URISyntaxException {
		MessageDTO message = new MessageDTO();
		TextDTO texte = new TextDTO();
		String messageContent = "Voici la liste de vos comptes:\n";
		texte = new TextDTO();
		if (mock.equals("true")) {
			messageContent += "compte chèques: + 1 346 €\n"
					+ "épargne immobilier: + 10 493 €\n" + "prêt immobilier: - 139 696 €";
		} else {
			String token = authenticationService.login(username, password);
			List<Account> accounts = accountService.fetchPrivateAccounts(token, true);
			for (Account account : accounts) {
				messageContent += "Votre compte " + account.getLabel() + " de type "
						+ account.getType() + " a un solde de : "
						+ account.getBalance().getAmount() + " "
						+ account.getBalance().getCurrency() + "\n";

			}
		}
		texte.setText(messageContent);
		message.getMessages().add(texte);
		return ResponseEntity.ok(message);
	}

}

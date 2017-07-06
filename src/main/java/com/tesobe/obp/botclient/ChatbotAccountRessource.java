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
import com.tesobe.obp.botclient.dto.*;
import com.tesobe.obp.utils.DataFormatter;

/**
 * REST controller for managing Asset.
 */
@RestController
public class ChatbotAccountRessource {

	private final Logger log = LoggerFactory.getLogger(ChatbotAccountRessource.class);

	@Autowired
	private DirectAuthenticationService authenticationService;

	@Autowired
	private AccountService accountService;

	@Autowired
	private DataUserMock dataUserMock;

	@Autowired
	private DataFormatter dataFormatter;

	@Value("${obp.mock}")
	private boolean mock;

	@Value("${obp.username}")
	private String username;

	@Value("${obp.password}")
	private String password;
	
	@RequestMapping("/bot/account")
	public ResponseEntity test() throws URISyntaxException {
		MessageDTO message = new MessageDTO();
		String messageContent = "Voici la liste de vos comptes:\n";
		if (mock) {
			messageContent += "- compte chèques: " + dataFormatter.formatAmount(dataUserMock.cc_amount) + " €\n" //
					+ "- épargne immobilier: " + dataFormatter.formatAmount(dataUserMock.epargne_amount) + " €\n" //
					+ "- prêt immobilier: " + dataFormatter.formatAmount(dataUserMock.credit_amount) + " €"; 
		} else {
			String token = authenticationService.login(username, password);
			List<Account> accounts = accountService.fetchPrivateAccounts(token, true);
			for (Account account : accounts) {
				messageContent += "Votre compte " + account.getLabel() + " de type "
						+ account.getType() + " a un solde de : "
						+ dataFormatter.formatAmount(account.getBalance().getAmount()) + " "
						+ account.getBalance().getCurrency() + "\n";
			}
		}
		message.addText(messageContent);
		return ResponseEntity.ok(message);
	}

}

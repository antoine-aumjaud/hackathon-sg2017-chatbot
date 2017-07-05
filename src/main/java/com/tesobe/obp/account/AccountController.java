package com.tesobe.obp.account;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tesobe.obp.auth.DirectAuthenticationService;

@RestController
public class AccountController {
	@Autowired
	private AccountService accountService;

	@Autowired
	private DirectAuthenticationService authenticationService;

	@Value("${obp.username}")
	private String username;

	@Value("${obp.password}")
	private String password;

	@Value("${obp.mock}")
	private String mock;

	@RequestMapping("/account")
	public List<Account> fetchPrivateAccounts() {
		String token = authenticationService.login(username, password);
		return accountService.fetchPrivateAccounts(token, true);
	}
}
package com.tesobe.obp.transaction;

import java.util.List;

import org.apache.log4j.Logger;
import org.joda.money.Money;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.tesobe.obp.account.Account;
import com.tesobe.obp.account.Transaction;
import com.tesobe.obp.account.Views;
import com.tesobe.obp.auth.DirectAuthenticationService;
import com.tesobe.obp.transactionRequest.pojo.To;
import com.tesobe.obp.transactionRequest.pojo.TransactionRequest;
import com.tesobe.obp.transactionRequest.pojo.TransactionValue;

import lombok.Data;

@Component
public class MonetaryTransactionsService {

	@Value("${obp.api.versionedUrl}")
	private String apiUrl;

	private RestTemplate restTemplate = new RestTemplate();

	private static final Logger LOGGER = Logger
			.getLogger(MonetaryTransactionsService.class);

	@Autowired
	private DirectAuthenticationService authenticationService;

	@Value("${obp.transactionMock.username}")
	private String usernameTransaction;

	@Value("${obp.transactionMock.password}")
	private String passwordTransaction;

	public List<Transaction> fetchTransactionList(String token, Account account) {
		String allTransactionsUrl = String.format(
				"%s/banks/%s/accounts/%s/owner/transactions", apiUrl, account.getBankId(),
				account.getId());
		HttpEntity<Void> req = prepareAuthRequest(token);
		Transactions transactions = restTemplate
				.exchange(allTransactionsUrl, HttpMethod.GET, req, Transactions.class)
				.getBody();
		return transactions.getTransactions();
	}

	public List<Transaction> addTransaction(String token, Account account, String desc,
			String amount, Account accountSource) {
		String sourceToken = authenticationService.login(usernameTransaction,
				passwordTransaction);
		String viewId = getFirstViewOfAccount(sourceToken, account);
		String addTransactionsUrl = "";
		if (accountSource != null) {
			addTransactionsUrl = String.format(
					"%s/banks/%s/accounts/%s/%s/transaction-request-types/SANDBOX_TAN/transaction-requests",
					apiUrl, accountSource.getBankId(), accountSource.getId(), viewId);

		} else {
			addTransactionsUrl = String.format(
					"%s/banks/%s/accounts/%s/%s/transaction-request-types/SANDBOX_TAN/transaction-requests",
					apiUrl, "socgen.31.fr.fr", "123456789", viewId);
		}
		LOGGER.info("Add transaction URL : " + addTransactionsUrl);
		HttpEntity<TransactionRequest> req = prepareTransactionRequest(sourceToken,
				account, desc, amount);
		Transactions transactions = restTemplate
				.exchange(addTransactionsUrl, HttpMethod.POST, req, Transactions.class)
				.getBody();
		return transactions.getTransactions();
	}

	private String getFirstViewOfAccount(String token, Account account) {
		String viewUrl = String.format("%s/banks/%s/accounts/%s/views", apiUrl,
				"socgen.31.fr.fr", "123456789");
		LOGGER.info("View account URL " + viewUrl);
		HttpEntity<Void> req = prepareAuthRequest(token);
		Views views = restTemplate.exchange(viewUrl, HttpMethod.GET, req, Views.class)
				.getBody();
		return views.getViews().get(0).getId();
	}

	public Transaction getTransactionById(String token, Account account, String txId) {
		String txUrl = String.format(
				"%s/banks/%s/accounts/%s/owner/transactions/%s/transaction", apiUrl,
				account.getBankId(), account.getId(), txId);
		HttpEntity<Void> req = prepareAuthRequest(token);
		return restTemplate.exchange(txUrl, HttpMethod.GET, req, Transaction.class)
				.getBody();
	}

	private HttpEntity<TransactionRequest> prepareTransactionRequest(String token,
			Account account, String desc, String amount) {
		TransactionRequest request = new TransactionRequest();
		request.setDescription(desc);
		To toTransaction = new To();
		toTransaction.setAccountId(account.getId());
		toTransaction.setBankId(account.getBankId());
		request.setTo(toTransaction);
		TransactionValue value = new TransactionValue();
		value.setAmount(amount);
		value.setCurrency("EUR");
		request.setValue(value);
		HttpHeaders authHeaders = new HttpHeaders();
		String dlHeader = String.format("DirectLogin token=%s", token);
		authHeaders.add(HttpHeaders.AUTHORIZATION, dlHeader);
		LOGGER.info(new Gson().toJson(request));
		LOGGER.info("Token => : " + token);
		return new HttpEntity<>(request, authHeaders);
	}

	private HttpEntity<Void> prepareAuthRequest(String token) {
		HttpHeaders authHeaders = new HttpHeaders();
		String dlHeader = String.format("DirectLogin token=%s", token);
		authHeaders.add(HttpHeaders.AUTHORIZATION, dlHeader);
		return new HttpEntity<>(null, authHeaders);
	}

	public void transferMoney(String token, Account sourceAccount, Account targetAccount,
			Money amount) {

	}

	@Data
	private static class Transactions {
		private List<Transaction> transactions;
	}
}

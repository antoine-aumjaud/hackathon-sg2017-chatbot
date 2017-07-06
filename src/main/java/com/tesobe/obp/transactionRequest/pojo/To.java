
package com.tesobe.obp.transactionRequest.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "bank_id", "account_id" })
public class To {

	@JsonProperty("bank_id")
	private String bank_id;
	@JsonProperty("account_id")
	private String account_id;

	@JsonProperty("bank_id")
	public String getBankId() {
		return bank_id;
	}

	@JsonProperty("bank_id")
	public void setBankId(String bankId) {
		this.bank_id = bankId;
	}

	@JsonProperty("account_id")
	public String getAccountId() {
		return account_id;
	}

	@JsonProperty("account_id")
	public void setAccountId(String accountId) {
		this.account_id = accountId;
	}
}

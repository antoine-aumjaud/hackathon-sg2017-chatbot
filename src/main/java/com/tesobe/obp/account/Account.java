package com.tesobe.obp.account;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Account {
	private String id;
	private String label;
	@JsonProperty("bank_id")
	private String bankId;

	@JsonProperty("balance")
	private AccountBalance balance;

	private String type;

	@JsonProperty("IBAN")
	private String iban;

	@JsonProperty("swist_bic")
	private String bic;

}

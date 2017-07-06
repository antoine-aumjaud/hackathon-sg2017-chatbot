
package com.tesobe.obp.transactionRequest.pojo;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "bank_id", "account_id" })
public class To {

	@JsonProperty("bank_id")
	private String bankId;
	@JsonProperty("account_id")
	private String accountId;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("bank_id")
	public String getBankId() {
		return bankId;
	}

	@JsonProperty("bank_id")
	public void setBankId(String bankId) {
		this.bankId = bankId;
	}

	@JsonProperty("account_id")
	public String getAccountId() {
		return accountId;
	}

	@JsonProperty("account_id")
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

}


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
@JsonPropertyOrder({ "to", "value", "description" })
public class TransactionRequest {

	@JsonProperty("to")
	private To to;
	@JsonProperty("value")
	private TransactionValue value;
	@JsonProperty("description")
	private String description;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("to")
	public To getTo() {
		return to;
	}

	@JsonProperty("to")
	public void setTo(To to) {
		this.to = to;
	}

	@JsonProperty("value")
	public TransactionValue getValue() {
		return value;
	}

	@JsonProperty("value")
	public void setValue(TransactionValue value) {
		this.value = value;
	}

	@JsonProperty("description")
	public String getDescription() {
		return description;
	}

	@JsonProperty("description")
	public void setDescription(String description) {
		this.description = description;
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

package com.credit.card.model;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RequestModel {

	@JsonProperty("holderName")
	private String holderName;
	@JsonProperty("cardlimit")
	private Integer cardlimit;
	@JsonProperty("balance")
	private Integer balance;
	
	@JsonProperty("ccardNumber")
	@NotNull
	@Size(min = 10, max = 19, message = "card number must be {min} to {max} characters long")
	private String ccardNumber;

	public String getHolderName() {
		return holderName;
	}

	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}

	public Integer getLimit() {
		return cardlimit;
	}

	public void setLimit(Integer limit) {
		this.cardlimit = limit;
	}

	public Integer getBalance() {
		return balance;
	}

	public void setBalance(Integer balance) {
		this.balance = balance;
	}

	public String getCcardNumber() {
		return ccardNumber;
	}

	public void setCcardNumber(String ccardNumber) {
		this.ccardNumber = ccardNumber;
	}

	@Override
	public String toString() {
		return "RequestModel [holderName=" + holderName + ", limit=" + cardlimit + ", balance=" + balance
				+ ", ccardNumber=" + ccardNumber + "]";
	}

}

package com.credit.card.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "card_details")
public class CCard {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;

	@Column(name = "card_number")
	private String cardNumber;

	@Column(name = "card_holder")
	private String name;

	@Column(name = "balance")
	private Integer balance;

	@Column(name = "card_limit")
	private Integer cardlimit;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getBalance() {
		return balance;
	}

	public void setBalance(Integer balance) {
		this.balance = balance;
	}

	public Integer getLimit() {
		return cardlimit;
	}

	public void setLimit(Integer limit) {
		this.cardlimit = limit;
	}

	@Override
	public String toString() {
		return "CCard [id=" + id + ", cardNumber=" + cardNumber + ", name=" + name + ", balance=" + balance + ", limit="
				+ cardlimit + "]";
	}

}

package com.credit.card.services.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.credit.card.dao.CardRepository;
import com.credit.card.entity.CCard;
import com.credit.card.model.RequestModel;
import com.credit.card.services.CardServices;

@Service
public class CardServicesImpl implements CardServices {

	@Autowired
	private CardRepository cardRepo;

	@Override
	public boolean isValid(String number) {

		if (number.chars().allMatch(Character::isDigit)) {
			if (isLuhnCompliant(number)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public List<CCard> getAll() {

		return cardRepo.findAll();

	}

	@Override
	public CCard add(RequestModel card) {
		CCard ccard = new CCard();
		ccard.setBalance(new BigDecimal(0));
		ccard.setCardNumber(card.getCcardNumber());
		ccard.setName(card.getHolderName());
		ccard.setLimit(card.getLimit());
		return cardRepo.save(ccard);

	}

	private boolean isLuhnCompliant(String cardNumber) {
		int length = cardNumber.length();

		int sum = 0;
		boolean next = false;
		for (int i = length - 1; i >= 0; i--) {

			int d = cardNumber.charAt(i) - '0';

			if (next == true)
				d = d * 2;

			sum += d / 10;
			sum += d % 10;

			next = !next;
		}
		return (sum % 10 == 0);

	}

}

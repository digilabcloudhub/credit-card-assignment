package com.credit.card.services;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.lenient;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.credit.card.dao.CardRepository;
import com.credit.card.entity.CCard;
import com.credit.card.model.RequestModel;
import com.credit.card.services.impl.CardServicesImpl;

@RunWith(MockitoJUnitRunner.class)
public class CardServicesTests {

	@InjectMocks
	private CardServicesImpl cardService;
	@Mock
	private CardRepository userRepository;

	@Test
	public void isValidTrue() {
		String number = "12345678911";
		assertTrue(cardService.isValid(number));
	}

	@Test
	public void isValidFalse() {
		String number = "12345678913";
		assertFalse(cardService.isValid(number));
	}

	@Test
	public void add() {
		RequestModel model = new RequestModel();
		CCard card = new CCard();
		card.setCardNumber("12345678911");
		lenient().when(cardService.add(model)).thenReturn(card);
		assertNotNull(card);

	}

	@Test
	public void getAll() {

		assertNotNull(cardService.getAll());

	}

}

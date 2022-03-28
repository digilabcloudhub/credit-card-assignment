package com.credit.card.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.credit.card.entity.CCard;
import com.credit.card.exception.InavlidRequestException;
import com.credit.card.exception.ResourceNotFoundException;
import com.credit.card.model.RequestModel;
import com.credit.card.model.ResponseModel;
import com.credit.card.services.CardServices;

@RequestMapping("api/v1")
@RestController
public class CardController {

	
	private final CardServices cardService;
	
	 public CardController(CardServices cardService) {
		this.cardService=cardService;
	}

	@CrossOrigin
	@GetMapping("/cards")
	public ResponseEntity<ResponseModel> getCards() throws ResourceNotFoundException {

		List<CCard> cards = cardService.getAll();
		if (null != cards && cards.size() > 0) {
			ResponseModel response = new ResponseModel();
			response.setListofCards(cards);
			response.setTimestamp(LocalDateTime.now());
			response.setStatus(HttpStatus.OK.value());
			response.setMessage("Success");
			return new ResponseEntity<>(response, HttpStatus.OK);
		} else {
			throw new ResourceNotFoundException("No Record Found");
		}

	}

	@CrossOrigin
	@PostMapping("/card")
	public ResponseEntity<ResponseModel> addCard(@RequestBody RequestModel request) throws InavlidRequestException {

		Boolean isValid = cardService.isValid(request.getCcardNumber());

		if (isValid) {
			CCard card = cardService.add(request);
			if (null != card && card.getId() != null) {
				ResponseModel response = new ResponseModel();
				response.setTimestamp(LocalDateTime.now());
				response.setStatus(HttpStatus.CREATED.value());
				response.setMessage("Success");
				return new ResponseEntity<>(response, HttpStatus.CREATED);
			} else {
				throw new InavlidRequestException("Not Able to add card.Try after sometime.");
			}

		} else {
			throw new InavlidRequestException("Card number is invalid .Please enter correct number");
		}

	}

}

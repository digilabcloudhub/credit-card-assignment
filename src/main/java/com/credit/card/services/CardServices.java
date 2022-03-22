package com.credit.card.services;

import java.util.List;

import com.credit.card.entity.CCard;
import com.credit.card.model.RequestModel;
public interface CardServices  {
	
	public boolean isValid(String number);
	public List<CCard> getAll();
	public CCard add(RequestModel card);
	
	

}

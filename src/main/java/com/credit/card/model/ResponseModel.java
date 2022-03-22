package com.credit.card.model;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.credit.card.entity.CCard;

public class ResponseModel {
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
	private LocalDateTime timestamp;
	private int status;
	private String message;
	private List<CCard> listofCards;
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public List<CCard> getListofCards() {
		return listofCards;
	}
	public void setListofCards(List<CCard> listofCards) {
		this.listofCards = listofCards;
	}
	@Override
	public String toString() {
		return "ResponseModel [timestamp=" + timestamp + ", status=" + status + ", message=" + message + "]";
	}

}

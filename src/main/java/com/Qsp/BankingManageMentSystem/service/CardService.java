package com.Qsp.BankingManageMentSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.Qsp.BankingManageMentSystem.dao.CardDao;
import com.Qsp.BankingManageMentSystem.dto.Card;
import com.Qsp.BankingManageMentSystem.util.ResponseStructure;

@Service
public class CardService {
@Autowired
CardDao cardDao;
@Autowired
ResponseStructure<Card> responseStructure;

public ResponseEntity<ResponseStructure<Card>> saveCard( Card card) {
	responseStructure.setMessage("successfully created Card in db");
	responseStructure.setStatusCode(HttpStatus.CREATED.value());
	responseStructure.setData(cardDao.saveCard(card));
	return new ResponseEntity<ResponseStructure<Card>>(responseStructure,HttpStatus.CREATED);
	}

public ResponseEntity<ResponseStructure<Card>>  fetchCardById(int cardId) {
	responseStructure.setMessage("successfully fetched Card in db");
	responseStructure.setStatusCode(HttpStatus.OK.value());
	responseStructure.setData(cardDao.fetchCardById(cardId));
	return new ResponseEntity<ResponseStructure<Card>>(responseStructure,HttpStatus.OK);	}

public ResponseEntity<ResponseStructure<Card>>  deleteCardById(int cardId) {
	responseStructure.setMessage("successfully deleted Card in db");
	responseStructure.setStatusCode(HttpStatus.CREATED.value());
	responseStructure.setData(cardDao.deleteCardById(cardId));
	return new ResponseEntity<ResponseStructure<Card>>(responseStructure,HttpStatus.CREATED);
}

public ResponseStructure<Card> updateCardById(int oldCardId,Card newCard) {
	responseStructure.setMessage("successfully Updated Card in db");
	responseStructure.setStatusCode(HttpStatus.CREATED.value());
	responseStructure.setData(cardDao.updateCardById(oldCardId, newCard));
	return responseStructure;

}
public List<Card>  fetchAllCards() {
	return cardDao.fetchAllCards();
	
}

}

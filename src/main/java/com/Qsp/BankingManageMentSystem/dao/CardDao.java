package com.Qsp.BankingManageMentSystem.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

 import com.Qsp.BankingManageMentSystem.dto.Card;
import com.Qsp.BankingManageMentSystem.repo.CardRepo;

@Repository
public class CardDao {
	@Autowired
	CardRepo cardRepo;

	public Card saveCard( Card card) {
		return cardRepo.save(card);
		}

	
	public Card fetchCardById(int cardId) {
		Optional<Card>card=cardRepo.findById(cardId);
			if(card.isEmpty()) {
				return null;
			}
			else {
				return card.get();
			}
				}

	public Card deleteCardById(int cardId) {
		Card card=fetchCardById(cardId);
		 cardRepo.deleteById(cardId);
		return  card;
	}

	public Card updateCardById(int oldCardId,Card newCard) {
	  newCard.setCardId(oldCardId);
		return cardRepo.save(newCard);

	}
	public List<Card>  fetchAllCards() {
		return cardRepo.findAll();
		
	}
	
	

}

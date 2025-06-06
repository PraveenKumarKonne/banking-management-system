package com.Qsp.BankingManageMentSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Qsp.BankingManageMentSystem.dto.Card;
import com.Qsp.BankingManageMentSystem.service.CardService;
import com.Qsp.BankingManageMentSystem.util.ResponseStructure;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
@RestController
public class CardController {
	@Autowired
	CardService cardService;
	
	@Operation
	(summary = "Save card", description = "API is used to save the card")
	@ApiResponses
	(value = { @ApiResponse (responseCode = "201", description = "Successfully created"),
			@ApiResponse (responseCode = "404", description = "card not found for the given id") })
@PostMapping("/saveCard")
public ResponseEntity<ResponseStructure<Card>> saveCard(@RequestBody Card card) {
	return cardService.saveCard(card);
	}
	@Operation
	(summary = "fetch card", description = "API is used to fetch the card")
	@ApiResponses
	(value = { @ApiResponse (responseCode = "302", description = "Successfully fetched"),
			@ApiResponse (responseCode = "404", description = "card not found for the given id") })
@GetMapping("/fetchCardById")
public ResponseEntity<ResponseStructure<Card>> fetchCardById(@RequestParam int cardId) {
	return cardService.fetchCardById(cardId);
	}
	@Operation
	(summary = "Delete card", description = "API is used to delete the card")
	@ApiResponses
	(value = { @ApiResponse (responseCode = "200", description = "Successfully created"),
			@ApiResponse (responseCode = "404", description = "card not found for the given id") })
@DeleteMapping("/deleteCardById")
public ResponseEntity<ResponseStructure<Card>> deleteCardById(@RequestParam int cardId) {
	ResponseEntity<ResponseStructure<Card>> card=fetchCardById(cardId);
	cardService.deleteCardById(cardId);
	return  card;
}
	@Operation
	(summary = "update card", description = "API is used to update the card")
	@ApiResponses
	(value = { @ApiResponse (responseCode = "200", description = "Successfully updated"),
			@ApiResponse (responseCode = "404", description = "card not found for the given id") })
@PutMapping("/updateCardById")
public ResponseEntity<ResponseStructure<Card>> updateCardById(@RequestParam int oldCardId,@RequestBody Card newCard) {
  newCard.setCardId(oldCardId);
	return cardService.saveCard(newCard);

}
@GetMapping("/fetchAllCards")
public List<Card>  fetchAllCards() {
	return cardService.fetchAllCards();
}
}

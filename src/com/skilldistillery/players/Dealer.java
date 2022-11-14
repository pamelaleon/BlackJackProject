package com.skilldistillery.players;

import java.util.List;

import com.skilldistillery.cardgame.BlackjackHand;
import com.skilldistillery.cardgame.Hand;
import com.skilldistillery.cards.Card;
import com.skilldistillery.cards.Deck;

public class Dealer {

	private BlackjackHand hand;

	public Dealer(BlackjackHand hand) {
		this.addHand(hand);
	}

	public void addHand(BlackjackHand hand) {
		this.hand = hand;

	}
	
	public void addCard(Card card) {
		this.hand.getHand().add(card);
	}
	
	public void emptyHand() {
		this.hand.emptyHand();
	}

	public List<Card> getDealerHand() {
		return this.hand.getHand();
	}

	public int sumOfCardValue() {
		return this.hand.getHandValue();
		
	}
}

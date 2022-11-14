package com.skilldistillery.cardgame;

import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.cards.Card;

public class BlackjackHand extends Hand{

	 private List<Card> hand = new ArrayList<>();
	
	public BlackjackHand() {
		super();
		
	}
	
	public void emptyHand() {
		hand.clear();
	}
	
	 public void addCard(Card card) {
	       hand.add(card);
}


	@Override
	public int getHandValue() {
		int sum = 0;
		
		for (Card card : hand) {
			sum = sum + card.getValue();
			
		}
		
		return sum;
	}

	public List<Card> getHand() {
		return hand;
	}
	
	public void addHand(Card card) {
		hand.add(card);
		
	}

	public void setHand(List<Card> hand) {
		this.hand = hand;
	}
}

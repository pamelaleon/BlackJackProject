package com.skilldistillery.cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
// hold a list of cards 
	private List<Card> deck = new ArrayList<>();
	
	private Deck() {
		Rank[] ranks = Rank.values();
		Suit[] suits = Suit.values(); 
		
		//generate a fresh deck of all 52 cards
		for (Suit suit : suits) {
			// for each suit (all 4 of them)
			
			for ( Rank rank : ranks) {
				//for each rank (all 13 of them)
				Card aCard = new Card(rank,suit);
				
				deck.add(aCard);
			}
		}
	}
	
	public int checkDeckSize() {
		return deck.size();
	}
	
	public Card dealCard() {
		return deck.remove(0);
	}
	
	public void shuffle() {
		Collections.shuffle(deck);
	}
}


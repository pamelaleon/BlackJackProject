package com.skilldistillery.cardgame;

import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.cards.Card;
import com.skilldistillery.cards.Deck;


public abstract class Hand {

    private List<Card> cards = new ArrayList<>();
    
    
    public Hand () {
    	
    	
    }
    
    public void addCard(Card card) {
    	       cards.add(card);
    }
    
    
    public void clear() {  
    	
    }                         
    
    public abstract int getHandValue();

	@Override
	public String toString() {
		return "Hand [cards = " + cards + "]";
	}
    
}


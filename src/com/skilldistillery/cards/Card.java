package com.skilldistillery.cards;

import java.util.Objects;

public class Card {
// has a 
	private Rank rank;
	private Suit suit;

	public Card(Rank rank, Suit suit) {
		this.suit = suit;
		this.rank = rank;

	}

	public int getValue() {
		return rank.getValue();
	}

	@Override
	public String toString() {
		return "Card [ rank = " + rank + " of " + ", suit = " + suit + " ]";
	}

	public Rank getRank() {
		return rank;
	}

	public void setRank(Rank rank) {
		this.rank = rank;
	}

	public Suit getSuit() {
		return suit;
	}

	public void setSuit(Suit suit) {
		this.suit = suit;
	}

	@Override
	public int hashCode() {
		return Objects.hash(rank, suit);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Card other = (Card) obj;
		return rank == other.rank && suit == other.suit;
	}

}

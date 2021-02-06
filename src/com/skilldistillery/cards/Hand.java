package com.skilldistillery.cards;

import java.util.ArrayList;
import java.util.List;

public abstract class Hand {
	private List<Card> cards;

	public Hand() {
		setCards(new ArrayList<>()); 
	}
	
	public void addCard(Card card) {
		getCards().add(card);
	}
	
	public void clear() {
		
	}
	public abstract int getHandVal();

	@Override
	public String toString() {
		return "Hand [cards=" + getCards() + "]";
	}

	public List<Card> getCards() {
		return cards;
	}

	public void setCards(List<Card> cards) {
		this.cards = cards;
	}
	
	
	
}

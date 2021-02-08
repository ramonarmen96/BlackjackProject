package com.skilldistillery.cards;

public enum Suit {
	HEARTS("Hearts"), SPADES("Spades"), CLUBS("Clubs"), DIAMONDS("Diamonds");

	private String card;

	Suit(String c) {
		this.card = c;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return card;
	}
}

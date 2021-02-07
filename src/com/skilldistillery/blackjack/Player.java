package com.skilldistillery.blackjack;

public class Player {

	public BlackjackHand ph;

	public Player() {
		this.ph = new BlackjackHand();

	}

	public void showCardValueRank() {
		System.out.println(ph.getCards().get(0) + " & " + ph.getCards().get(1));
	}

	public void showHand() {
		System.out.println("Your Hand: " + ph.getCards() + " " + ph.getHandVal());

	}

	public void playerWins() {
		System.out.println("You win!");
		System.out.println("New Game Y or N?");
	}

}

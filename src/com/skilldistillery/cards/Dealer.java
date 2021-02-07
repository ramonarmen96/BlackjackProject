package com.skilldistillery.cards;

import java.util.List;
import com.skilldistillery.blackjack.BlackjackHand;

public class Dealer {
	public BlackjackHand dh;

	public Dealer() {
		this.dh = new BlackjackHand();

	}

	public void showCardValueRank() {
		System.out.println(dh.getCards().get(1));

	}

	private void printHandAndValue(List<Card> hand, int value) {
		for (Card card : hand) {
			System.out.println(card);
		}
		System.out.println("Total value: " + value);
	}

	public void dealerWins() {
		System.out.println("The House always wins...");
		System.out.println("New Game Y or N?");
		
	}
	public void showHand() {
		System.out.println("Dealer Hand: " + dh.getCards() + " " + dh.getHandVal());
	}

}

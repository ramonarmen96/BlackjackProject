package com.skilldistillery.blackjack;

import java.util.Scanner;

import com.skilldistillery.cards.Card;
import com.skilldistillery.cards.Dealer;
import com.skilldistillery.cards.Deck;

public class BlackJackApp {

	public Player p1;
	public Dealer d;
	public Deck deck;
	public Scanner kb;

	public static void main(String[] args) {
		BlackJackApp a = new BlackJackApp();
		a.run();
	}

	public void run() {
		kb = new Scanner(System.in);
		this.p1 = new Player();
		this.d = new Dealer();
		this.deck = new Deck();

		System.out.println("Welcome to underground Blackjack..");
		System.out.println("Would you like to play some Blackjack? Y or N?");
		String answer = kb.nextLine();
		if (answer.equals("N")) {

			System.out.println("Well then you shouldn't have come in here buddy");
		} else {
			System.out.println("Well then come on over to the Blackjack table!");
			System.out.println("Ready? (Y or N)");
			answer = kb.nextLine();
			if (answer.equals("Y")) {
				newGame();

			}
		}
	}

	private void newGame() {
//		First we need to shuffle

		this.deck.shuffle();
//		we need to be able to use our deck class to deal our hands 
		this.p1.ph.addCard(this.deck.dealCard());
		this.d.dh.addCard(this.deck.dealCard());
		this.p1.ph.addCard(this.deck.dealCard());
		this.d.dh.addCard(this.deck.dealCard());
//		we need to be able to view the first card of the dealer but not the second
		System.out.println("Dealer has: ");
		this.d.showCardValueRank();
//		then we need to have it add up our cards(maybe another class will do this math)
//		we need to be able to see our total and have the option to hit or stay
		System.out.println("You have: ");
		this.p1.showCardValueRank();
		checkHand();
		hitOrStay();
	}

	private void hitOrStay() {
		System.out.println("to Hit type H to Stay type S");
		String option = kb.nextLine();
		if (option.equals("H")) {
			this.p1.ph.addCard(this.deck.dealCard());
			this.p1.showHand();
			System.out.println("You: " + this.p1.ph.getHandVal());
			checkHand();
			hitOrStay();
		}

		else {
			System.out.println("Dealer: " + this.d.dh.getHandVal());
			System.out.println("You: " + this.p1.ph.getHandVal());

		}
	}

	private void checkHand() {

		if (this.p1.ph.bust()) {
			System.out.println("You: " + this.p1.ph.getHandVal() + " Bust");
		} else {
			hitOrStay();

		}
		if (this.p1.ph.isBlackJack()) {
			System.out.println("You: " + this.p1.ph.getHandVal() + " Black Jack");
		} else {
			hitOrStay();
		}

	}

//		now we need to have the dealers cards add up and do have him hit or stay
//		the dealer will automatically draw a card if he is < 16 if he is over he will stay

//		so now that the dealer and player have both stayed we need to decide who has won
//		if either has over 21 they bust 
//		who ever is closer to 21 wins

}

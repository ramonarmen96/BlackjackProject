package com.skilldistillery.blackjack;

import java.util.Scanner;

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

		System.out.println("Welcome to the Lucky 38 ");
		System.out.println("You must be the HighRoller");
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
		this.deck.shuffle();
		this.p1.ph.addCard(this.deck.dealCard());
		this.d.dh.addCard(this.deck.dealCard());
		this.p1.ph.addCard(this.deck.dealCard());
		this.d.dh.addCard(this.deck.dealCard());
		System.out.println("Dealer has: ");
		this.d.showCardValueRank();
		System.out.println("You have: ");
		this.p1.showCardValueRank();
		checkHand();
	}

	private void hitOrStay() {
		System.out.println("to Hit type H to Stay type S");
		String option = kb.nextLine();
		if (option.equals("H")) {
			this.p1.ph.addCard(this.deck.dealCard());
			this.p1.showHand();
			checkHand();
		}

		else if (option.equals("S")) {
			System.out.println("You: " + this.p1.ph.getCards() + " " + this.p1.ph.getHandVal());
			dealerTurn();

		}
	}

	private void dealerTurn() {
		while (this.d.dh.getHandVal() < 17) {
			d.dh.addCard(this.deck.dealCard());
		}

		whoWins();
	}

	private void checkHand() {
		if (this.p1.ph.bust()) {
			System.out.println("Bust");
			whoWins();
		}
		if (this.p1.ph.isBlackJack()) {
			System.out.println("Black Jack");
			whoWins();
		}
		if (!this.p1.ph.bust() || !this.p1.ph.isBlackJack()) {
			hitOrStay();
		}

	}

	private void whoWins() {

		if (this.p1.ph.bust() || this.d.dh.isBlackJack()
				|| !this.d.dh.bust() && this.d.dh.getHandVal() > this.p1.ph.getHandVal()) {
			this.d.showHand();
			d.dealerWins();
		}
		if (this.p1.ph.isBlackJack() || this.d.dh.bust()
				|| !this.p1.ph.bust() && this.p1.ph.getHandVal() > this.d.dh.getHandVal()) {
			this.d.showHand();
			p1.playerWins();

		}
		if (this.p1.ph.getHandVal() == this.d.dh.getHandVal()) {
			this.d.showHand();
			System.out.println("PUSH");
		}
		String playAgain = kb.nextLine();
		if (playAgain.equals("Y")) {
			this.d.dh.clear();
			this.p1.ph.clear();
			Deck deck = new Deck();
			newGame();
		} else if (playAgain.equals("N")) {
			System.out.println("Good Game");

		}
		kb.close();
	}
}

//		who ever is closer to 21 wins

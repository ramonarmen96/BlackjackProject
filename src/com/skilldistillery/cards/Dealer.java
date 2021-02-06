package com.skilldistillery.cards;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

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
	
}

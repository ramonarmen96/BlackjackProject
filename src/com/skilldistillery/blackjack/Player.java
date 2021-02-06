package com.skilldistillery.blackjack;

import java.lang.reflect.Array;

import com.skilldistillery.cards.Hand;

public class Player {

	public BlackjackHand ph;
	
	public Player() {
		this.ph = new BlackjackHand();
	
	
	}
	
public void showCardValueRank() {
	   System.out.println(ph.getCards().get(0) + " & " + ph.getCards().get(1)); 
	}
public void showHand() {
	System.out.println(ph.getCards());
}
	
	
}

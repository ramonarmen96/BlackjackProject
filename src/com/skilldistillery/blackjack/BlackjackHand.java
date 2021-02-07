package com.skilldistillery.blackjack;

import com.skilldistillery.cards.Card;
import com.skilldistillery.cards.Hand;

public class BlackjackHand extends Hand{
	
@Override
public int getHandVal() {
	int sum = 0;
	for (Card card : this.getCards()) {
		sum += card.getValue();
	}
	return sum;
	
}
public boolean isBlackJack() {
	int sum = getHandVal();
	if (sum == 21) {
		return true;
	}
	else{
		return false;
	}
}
public boolean bust() {
	int sum = getHandVal();
	if (sum > 21) {
		return true;
	} else { 
		return false;	
	}
}

}

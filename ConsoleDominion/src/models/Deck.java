package models;

import java.util.ArrayList;

public abstract class Deck {
	
	protected ArrayList<Card> deck;
	
	public void addToDeck(Card card) {
		
	}
	
	public void removeFromDeck(int index) {
		
	}
	
	public int getDeckSize() {
		return deck.size();
	}
	
	public abstract Card drawCard();
}

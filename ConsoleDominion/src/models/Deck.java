package models;

import java.util.ArrayList;

public abstract class Deck {
	
	protected ArrayList<Card> deck = new ArrayList<>();
	
	public void addToDeck(Card card) {
		deck.add(card);
	}
	
	public void removeFromDeck(int index) {
		deck.remove(index);
	}
	
	public int getDeckSize() {
		return deck.size();
	}
	
	public abstract Card drawCard();
}

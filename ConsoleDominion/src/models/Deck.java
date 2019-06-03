package models;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class Deck implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7001549761673902284L;
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

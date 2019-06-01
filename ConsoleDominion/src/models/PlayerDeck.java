package models;

import java.util.ArrayList;

public class PlayerDeck extends Deck{
	
	@Override
	public Card drawCard() {
		//index out of bounds  if u put in 3 or 4 players 
		//after u give the name this line thow a index out of bounds.
		// if u put a number in as the name 
		Card drawnCard = deck.get(0);
		deck.remove(0);
		return drawnCard;
	}
	// index out of bounds here on line 18 
	public Card getCard(int index) {
		return deck.get(index);
	}
	public void clear() {
		int index = getDeckSize();
		for(int i = 0; i < index; i++) {
			removeFromDeck(0);			
		}
	}

	public void addToDeck(int index, Card card) {
		deck.add(index, card);
	}
	
	public ArrayList<Card> getDeck() {
		return deck;
	}
	
}

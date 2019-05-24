package models;

public class PlayerDeck extends Deck{
	
	@Override
	public Card drawCard() {
		
		return null;
	}
	
	public Card getCard(int index) {
		deck.get(index);
		return null;
	}
	public void clear() {
		int index = getDeckSize();
		for(int i = 0; i < index; i++) {
			removeFromDeck(0);			
		}
	}

}

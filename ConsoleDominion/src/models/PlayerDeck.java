package models;

public class PlayerDeck extends Deck{
	
	@Override
	public Card drawCard() {
		Card drawnCard = deck.get(0);
		deck.remove(0);
		return drawnCard;
	}
	
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
	
	
}

package models;

public class SupplyDeck extends Deck{
// Spencer made
	private int amount;

	public SupplyDeck(int amount, Card card) {
		super();
		setAmount(amount);
		deck.add(card);
	}

	public int getAmount() {
		return amount;
	}  

	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	public Card getCard() {
		return deck.get(0) ;
	}

	@Override
	public Card drawCard() {
		setAmount(getAmount() - 1);
		return deck.get(0);
	}
	
}

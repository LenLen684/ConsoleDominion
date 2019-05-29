package models;

public class SupplyDeck extends Deck{

	private int amount;

	public SupplyDeck(int amount) {
		super();
		setAmount(amount);
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	public Card getCard() {
		return deck.get(0);
	}

	@Override
	public Card drawCard() {
		setAmount(getAmount() - 1);
		return deck.get(0);
	}
	
}

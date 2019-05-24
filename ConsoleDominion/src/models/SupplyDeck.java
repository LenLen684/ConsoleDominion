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

	@Override
	public Card drawCard() {
		
		return null;
	}
	
}

package models;

import java.io.Serializable;

import enums.CardType;
import enums.SubType;

public abstract class Card implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8211876606486773865L;
	protected final String name;
	protected final CardType cardType;
	protected final SubType secondayType;
	protected final int cost;
	
	public Card(String name, CardType cardType, SubType secondayType, int cost) {
		this.name = name;
		this.cardType = cardType;
		this.secondayType = secondayType;
		this.cost = cost;
	}
	
	public abstract void action(Player player);

	public String getName() {
		return name;
	}

	public CardType getCardType() {
		return cardType;
	}

	public SubType getSecondayCardType() {
		return secondayType;
	}

	public int getCost() {
		return cost;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Card [name=").append(name).append(", cardType=").append(cardType).append(", secondayType=")
				.append(secondayType).append(", cost=").append(cost).append("]");
		return builder.toString();
	}
	
}

package models;

import enums.CardType;

public class Market extends Card {

	public Market() {
		super("MARKET", CardType.ACTION, null, 5);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Market []");
		return builder.toString();
	}

}

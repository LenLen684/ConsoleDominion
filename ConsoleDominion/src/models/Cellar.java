package models;

import enums.CardType;

public class Cellar extends Card {

	public Cellar() {
		super("CELLAR", CardType.ACTION, null, 2);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Cellar []").append(super.toString());
		return builder.toString();
	}
	
}

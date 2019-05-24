package models;

import enums.CardType;
import enums.SubType;

public class Militia extends Card {

	public Militia() {
		super("MILITIA", CardType.ACTION, SubType.ATTACK, 4);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Militia []");
		return builder.toString();
	}

}

package models;

import enums.CardType;

public class Remodel extends Card {

	public Remodel() {
		super("REMODEL", CardType.ACTION, null, 4);
	}

	@Override
	public void action() {
		
		
		
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Remodel []");
		return builder.toString();
	}

}

package models;

import enums.CardType;

public class Woodcutter extends Card {

	public Woodcutter() {
		super("WOODCUTTER", CardType.ACTION, null, 3);
	}

	@Override
	public void action() {
		
		
		
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Woodcutter []");
		return builder.toString();
	}

}

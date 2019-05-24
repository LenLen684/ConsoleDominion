package models;

import enums.CardType;

public class Mine extends Card {

	public Mine() {
		super("MINE", CardType.ACTION, null, 5);
	}

	@Override
	public void action(Player player) {
		
		
		
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Mine []").append(super.toString());
		return builder.toString();
	}
	
	

}

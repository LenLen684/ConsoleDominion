package models;

import enums.CardType;

public class Workshop extends Card {

	public Workshop() {
		super("WORKSHOP", CardType.ACTION, null, 3);
	}

	@Override
	public void action(Player player) {
		
		
		
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Workshop []");
		return builder.toString();
	}


}

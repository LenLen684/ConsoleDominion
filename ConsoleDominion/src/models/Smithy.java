package models;

import enums.CardType;

public class Smithy extends Card {

	public Smithy() {
		super("SMITHY", CardType.ACTION, null, 4);
	}

	@Override
	public void action(Player player) {
		player.setDrawNumber(player.getDrawNumber() + 3);
		
		
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Smithy []");
		return builder.toString();
	}


}

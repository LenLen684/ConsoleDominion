package models;

import enums.CardType;
import enums.SubType;

public class Militia extends Card {

	public Militia() {
		super("MILITIA", CardType.ACTION, SubType.ATTACK, 4);
	}
	//Done until I'm able to identify when the card is played and
	//we have to go through all the other players
	@Override
	public void action(Player player) {
		player.setTreasure(player.getTreasure() + 2);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Militia []");
		return builder.toString();
	}

}

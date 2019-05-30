package models;

import enums.CardType;
import enums.SubType;

public class Moat extends Card {

	public Moat() {
		super("MOAT", CardType.ACTION, SubType.REACTION, 2);
	}
	//Done until I have the Militia class done
	@Override
	public void action(Player player) {
		player.drawCards(2);
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Moat []").append(super.toString());
		return builder.toString();
	}

}

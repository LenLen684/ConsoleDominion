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
		builder.append("\r\n" + 
				"  _____________________\r\n" + 
				" /               MILITIA      \\\r\n" + 
				"|     	             	|\r\n" + 
				"| Each player discards down   	|\r\n" + 
				"|	  to 3 cards in hand		|\r\n" + 
				"|    				     |\r\n" + 
				"|-----------------------|\r\n" + 
				"|			|\r\n" + 
				"|			|\r\n" + 
				"|			|\r\n" + 
				"|			|\r\n" + 
				"|			|\r\n" + 
				"|		cost 4     Action-Attack	|\r\n" + 
				" \\_____________________/\r\n" + 
				"");
		return builder.toString();
	}

}

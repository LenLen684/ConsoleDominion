package models;

import controllers.GameMaster;
import enums.CardType;

public class Workshop extends Card {

	public Workshop() {
		super("WORKSHOP", CardType.ACTION, null, 3);
	}

	@Override
	public void action(Player player) {

		GameMaster.openShop(4, null);
		
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("\r\n" + 
				"  _____________________\r\n" + 
				" /            WORKSHOP         \\\r\n" + 
				"|     	           	|\r\n" + 
				"|	            	|\r\n" + 
				"|	            	|\r\n" + 
				"|                 |\r\n" + 
				"|-----------------------|\r\n" + 
				"|			|\r\n" + 
				"|			|\r\n" + 
				"|		gain a card cost  up to 4	|\r\n" + 
				"|			|\r\n" + 
				"|			|\r\n" + 
				"|		cost 3     Action	|\r\n" + 
				" \\_____________________/\r\n" + 
				"");
		return builder.toString();
	}


}

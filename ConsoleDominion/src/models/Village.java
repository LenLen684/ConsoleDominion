package models;

import enums.CardType;

public class Village extends Card{

	public Village() {
		super("VILLAGE", CardType.ACTION, null, 3);
	}

	@Override
	public void action(Player player) {
		player.drawCards(1);
		player.setActions(player.getActions() + 2);
	}

	@Override
	public String toString() {
		
		StringBuilder builder = new StringBuilder();
		builder.append("\r\n" + 
				"  _____________________\r\n" + 
				" /            	VILLAGE         \\\r\n" + 
				"|     	           	|\r\n" + 
				"|	            	|\r\n" + 
				"|	            	|\r\n" + 
				"|                 |\r\n" + 
				"|-----------------------|\r\n" + 
				"|			|\r\n" + 
				"|			|\r\n" + 
				"|		+1 card 	|\r\n" + 
				"|		+2 action	|\r\n" + 
				"|			|\r\n" + 
				"|		cost 3     Action	|\r\n" + 
				" \\_____________________/\r\n" + 
				"");
		return builder.toString();
		
	}


}
 
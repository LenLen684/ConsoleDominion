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
				"  _____________________________\r\n" + 
				" /           WORKSHOP          \\\r\n" + 
				"|-------------------------------|\r\n" + 
				"|                               |\r\n" + 
				"|                               |\r\n" + 
				"|                               |\r\n" + 
				"|                               |\r\n" + 
				"|      Gain a card              |\r\n" + 
				"|      costing up to 4          |\r\n" + 
				"|                               |\r\n" + 
				"|                               |\r\n" + 
				"|                               |\r\n" + 
				"|                               |\r\n" + 
				"|                               |\r\n" + 
				"|  cost 3               Action  |\r\n" + 
				" \\_____________________________/\r\n" + 
				"");
		return builder.toString();
	}


}

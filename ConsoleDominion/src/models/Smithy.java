package models;

import enums.CardType;

public class Smithy extends Card {

	public Smithy() {
		super("SMITHY", CardType.ACTION, null, 4);
	}

	@Override
	public void action(Player player) {
		player.drawCards(3);
		
		
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("\r\n" + 
				"  _____________________________\r\n" + 
				" /             SMITHY          \\\r\n" + 
				"|                               |\r\n" + 
				"|                               |\r\n" + 
				"|                               |\r\n" + 
				"|                               |\r\n" + 
				"|-------------------------------|\r\n" + 
				"|                               |\r\n" + 
				"|                               |\r\n" + 
				"|            +3 Cards           |\r\n" + 
				"|                               |\r\n" + 
				"|                               |\r\n" + 
				"|  cost 4               Action  |\r\n" + 
				" \\_____________________________/\r\n" + 
				"");
		return builder.toString();
	}


}

package models;

import enums.CardType;
// wells made
public class Woodcutter extends Card {

	public Woodcutter() {
		super("WOODCUTTER", CardType.ACTION, null, 3);
	}

	@Override
	public void action(Player player) {

		// this line is for the action of gain 2 money
		player.setTreasure(player.getTreasure()+2);

		
		// this line in for the gain one buy
		player.setBuys(player.getBuys()+1);
		
		
	}
	// Spencer fixed spacing in toString
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("\r\n" + 
				"  _____________________________\r\n" + 
				" /           WOODCUTTER        \\\r\n" + 
				"|                               |\r\n" + 
				"|             +1 Buy            |\r\n" + 
				"|             +2 Treasure       |\r\n" + 
				"|                               |\r\n" + 
				"|-------------------------------|\r\n" + 
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

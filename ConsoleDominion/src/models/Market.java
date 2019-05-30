package models;

import enums.CardType;

public class Market extends Card {

	public Market() {
		super("MARKET", CardType.ACTION, null, 5);
	}

	@Override
	public void action(Player player) {
		player.setActions(player.getActions() + 1);
		player.setTreasure(player.getTreasure() + 1);
		player.setBuys(player.getBuys() + 1);
		player.drawCards(1);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("\r\n" + 
				"  _____________________\r\n" + 
				" /        Market       \\\r\n" + 
				"|     	 +1 Card        |\r\n" + 
				"|	+1 Action	|\r\n" + 
				"|	+1 Buy		|\r\n" + 
				"|	+1 Money        |\r\n" +
				"|-----------------------|\r\n" + 
				"|			|\r\n" + 
				"|			|\r\n" + 
				"|			|\r\n" + 
				"|			|\r\n" + 
				"|			|\r\n" + 
				"|cost 4     	Action  |\r\n" + 
				" \\_____________________/\r\n" + 
				"");
		return builder.toString();
	}
}
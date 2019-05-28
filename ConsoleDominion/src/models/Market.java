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
		player.setDrawNumber(player.getDrawNumber() + 1);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(" _____________________\r\n" + " / ").append(getName())
				.append(" \\\r\n" + "| |\r\n" + "| |\r\n" + "| |\r\n" + "| |\r\n" + "|-----------------------|\r\n"
						+ "| |\r\n" + "| +1 Cards |\r\n" + "| +1 Action |\r\n" + "| +1 Buy |\r\n"
						+ "| +1 Treasure |\r\n" + "| |\r\n" + "| |\r\n" + "| cost 3 Action |\r\n"
						+ " \\_____________________/");
		return builder.toString();
	}
}
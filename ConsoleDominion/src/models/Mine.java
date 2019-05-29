package models;

import java.util.ArrayList;

import controllers.GameMaster;
import enums.CardType;
import lib.ConsoleIO;

public class Mine extends Card {

	public Mine() {
		super("MINE", CardType.ACTION, null, 5);
	}

	@Override
	public void action(Player player) {
		boolean treasureInHand = false;
		for (int i = 0; i < player.getHand().getDeckSize(); i++) {
			if (player.getHand().getCard(i).cardType == CardType.TREASURE) {
				treasureInHand = true;
			}
		}
		if (treasureInHand) {
			boolean invalidSelection = true;
			int selection;
			do {
				selection = ConsoleIO.promptForInt("Which treasure card would you like to trash from your hand?", 0,
						player.getHand().getDeckSize());
				if (player.getHand().getCard(selection).cardType == CardType.TREASURE) {
					invalidSelection = false;
				}
			} while (invalidSelection);
			int tempCost = player.getHand().getCard(selection).cost;
			player.getHand().removeFromDeck(selection);
			tempCost = tempCost + 3;
			ArrayList<String> aLOptions = new ArrayList<>();
			switch (tempCost) {
			case 3:
				aLOptions.add("Copper");
				aLOptions.add("Silver");
			case 6:
				aLOptions.add("Gold");
			case 9:
			}
			String[] options = (String[]) aLOptions.toArray();
			int cardsel = ConsoleIO.promptForMenuSelection("Which treasure card would you like to add to your hand? ",
					options, null, true);
			Card card;
			switch (cardsel) {
			case 1:
				// add copper
//				card;
				break;
			case 2:
				// add silver
				break;
			case 3:
				// add gold
				break;
			}
			player.getHand().addToDeck(card);
		}
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Mine []").append(super.toString());
		return builder.toString();
	}

}

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
		ArrayList<String> cards = new ArrayList<>();
		for(Card card : player.getHand().getDeck()) {
				cards.add(card.toString());
		}
		String[] options = new String[cards.size()];
		cards.toArray(options);
		if (options.length > 0) {
			int choice;
			do {
			choice = ConsoleIO.promptForMenuSelection("Which treasure card would you like to trash: ", options, "Quit", false);
				if(player.getHand().getCard(choice).getCardType() != CardType.TREASURE) {
					System.out.println("You can only trash treasure cards.");
				}
			} while(player.getHand().getCard(choice).getCardType() != CardType.TREASURE);
			GameMaster.openShop(player.getHand().getCard(choice).getCost() + 3, CardType.TREASURE);
		}
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("\r\n" + 
				"  _____________________________\r\n" + 
				" /             MINE	       \\\r\n" + 
				"|     	             		|\r\n" + 
				"| Trash a treasure card from   	|\r\n" + 
				"|your hand. Gain a treasure card|\r\n" +
				"|    costing up to +3; put      |\r\n" + 
				"|         it into hand          |\r\n" + 
				"|-------------------------------|\r\n" + 
				"|			        |\r\n" + 
				"|			        |\r\n" + 
				"|			        |\r\n" + 
				"|			        |\r\n" + 
				"|			        |\r\n" + 
				"|  cost 5     		Action	|\r\n" + 
				" \\_____________________________/\r\n" + 
				"");
		return builder.toString();
	}

}

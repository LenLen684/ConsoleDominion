package models;

import controllers.GameMaster;
import enums.CardType;
import lib.ConsoleIO;

public class Remodel extends Card {

	public Remodel() {
		super("REMODEL", CardType.ACTION, null, 4);
	}

	@Override
	public void action(Player player) {
		System.out.println(player.getHand().toString());
		int discardedCardIndex = ConsoleIO.promptForInt("Which card would you like to discard?", 1, player.getHand().getDeckSize());
		Card discardedCard = player.getHand().getCard(discardedCardIndex);
		int value = discardedCard.getCost() + 2;
		player.trashCard(discardedCardIndex);
		GameMaster.openShop(value, null);
		
		
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("\r\n" + 
				"  _______________________________\r\n" + 
				" /            REMODEL     	 \\\r\n" + 
				"|     	             	          |\r\n" + 
				"|   Trash a card from your hand   |\r\n" + 
				"|     Gain a card costing +2      |\r\n" + 
				"|     more than trashed card      |\r\n" + 
				"|---------------------------------|\r\n" + 
				"|				  |\r\n" + 
				"|				  |\r\n" + 
				"|				  |\r\n" + 
				"|				  |\r\n" + 
				"|				  |\r\n" + 
				"|  cost 4     		Action	  |\r\n" + 
				" \\_______________________________/\r\n" + 
				"");
		return builder.toString();
	}


}

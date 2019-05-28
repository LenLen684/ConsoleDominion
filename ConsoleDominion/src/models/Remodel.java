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
		GameMaster.openShop(value);
		
		
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Remodel []");
		return builder.toString();
	}


}

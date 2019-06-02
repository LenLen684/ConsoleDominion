package models;

import enums.CardType;
import lib.ConsoleIO;

public class Cellar extends Card {

	public Cellar() {
		super("CELLAR", CardType.ACTION, null, 2);
	}

	@Override
	public void action(Player player) {
		int discardAmount = 0;
		boolean discarding = ConsoleIO.promptForBool("Do you want to discard any cards? Y/N", "Y", "N");
		
		while(discarding == true) {
			if(player.getHand().getDeckSize() > 0) {
				System.out.println(player.getHand().toString());
				int discardedCardIndex = ConsoleIO.promptForInt("Select which card to discard.", 1, player.getHand().getDeckSize());
				player.discard(discardedCardIndex);
				discardAmount ++;
				discarding = ConsoleIO.promptForBool("Do you want to discard more cards? Y/N", "Y", "N");
			}
			else if(player.getHand().getDeckSize() == 0) {
				discarding = false;
				System.out.println("You cannot discard any more cards.");
			}
		}
		
		player.drawCards(discardAmount);
		player.setActions(player.getActions() + 1);
		
	}
	
	@Override
	public String toString() {
		
		
		
		StringBuilder builder = new StringBuilder();
		builder.append("\r\n" + 
				"  _____________________________\r\n" + 
				" /            CELLAR           \\\r\n" + 
				"|                               |\r\n" + 
				"|                               |\r\n" + 
				"|           + 1 action          |\r\n" + 
				"|                               |\r\n" + 
				"|-------------------------------|\r\n" + 
				"|                               |\r\n" + 
				"|                               |\r\n" + 
				"|       Discard any number      |\r\n" + 
				"|       of cards add 1 card     |\r\n" + 
				"|       per card discarded      |\r\n" + 
				"|                               |\r\n" +
				"|   cost 2             Action   |\r\n" + 
				" \\_____________________________/\r\n" + 
				"");
		return builder.toString();
		
		
		
		
	}

}

package models;

import java.util.ArrayList;

import enums.CardType;
import lib.ConsoleIO;

public class Cellar extends Card {
	
	private static ArrayList<String> cardsInHand = new ArrayList<>();

	public Cellar() {
		super("CELLAR", CardType.ACTION, null, 2);
	}

	@Override
	public void action(Player player) {
		int discardAmount = 0;
		boolean discarding = ConsoleIO.promptForBool("Do you want to discard any cards? Y/N ", "Y", "N");
		boolean removed = false;
		int forbiddenIndex = player.getHand().getDeckSize();
		
		for(Card card: player.getHand().getDeck()) {
			cardsInHand.add(card.toString() + "\n\n");
		}
		
		//Remove the action card that 
		for(int i=0; i<cardsInHand.size(); i++ ) {
			if(cardsInHand.get(i).toString().contains(toString())) {
				forbiddenIndex = i;
				cardsInHand.set(i, null);
				removed = true;
				break;
			}
		}
		int handsize = cardsInHand.size();
		
		cardsInHand.clear();
		
		while(discarding == true) {
			if(discardAmount < handsize) {
				for (Card card : player.getHand().getDeck()) {
					cardsInHand.add(card.toString() + "\n\n");
				}
				
				for(int i = 0; i< player.getHand().getDeckSize(); i++) {
					if(cardsInHand.get(i) != null) {
						System.out.println((i+1) + ") \n" + cardsInHand.get(i).toString());
					}
				}
				
				int discardedCardIndex = ConsoleIO.promptForInt("Select which card to discard. ", 1, player.getHand().getDeckSize());
				if(discardedCardIndex-1 != forbiddenIndex) {
					cardsInHand.set(discardedCardIndex-1, null);
					discardAmount ++;
				}
				else {
					System.out.println("You have already played that card.");
				}
				discarding = ConsoleIO.promptForBool("Do you want to discard more cards? Y/N", "Y", "N");
			}
			else {
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

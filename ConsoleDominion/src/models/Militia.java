package models;

import java.util.ArrayList;

import controllers.GameMaster;
import enums.CardType;
import enums.SubType;
import lib.ConsoleIO;

public class Militia extends Card {

	public Militia() {
		super("MILITIA", CardType.ACTION, SubType.ATTACK, 4);
	}
	//Done until I'm able to identify when the card is played and
	//we have to go through all the other players
	@Override
	public void action(Player player) {
		player.setTreasure(player.getTreasure() + 2);
		for(Player otherPlayer : GameMaster.getPlayers()) {
			boolean reactionRevealed;
			if(player != otherPlayer) {
				reactionRevealed = otherPlayer.revealReaction();
				
				if(!reactionRevealed) {
					ArrayList<String> cards = new ArrayList<>();
					for(Card card : otherPlayer.getHand().getDeck()) {
						cards.add(card.toString());
					}
					String[] options = new String[cards.size()];
					cards.toArray(options);
					while(otherPlayer.getHand().getDeckSize() > 3) {
						otherPlayer.discard(ConsoleIO.promptForMenuSelection("Select the card you would like to discard: ", options, "Quit", false));
					}
				}
			}
		}
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("\r\n" + 
				"  ___________________________________\r\n" + 
				" /        	MILITIA  	     \\\r\n" + 
				"|     	             		      |\r\n" + 
				"|    Each player discards down        |\r\n" + 
				"|	  to 3 cards in hand	      |\r\n" + 
				"|    				      |\r\n" + 
				"|-------------------------------------|\r\n" + 
				"|				      |\r\n" + 
				"|				      |\r\n" + 
				"|				      |\r\n" + 
				"|				      |\r\n" + 
				"|				      |\r\n" + 
				"|  cost 4     		Action-Attack |\r\n" + 
				" \\___________________________________/\r\n" + 
				"");
		return builder.toString();
	}

}

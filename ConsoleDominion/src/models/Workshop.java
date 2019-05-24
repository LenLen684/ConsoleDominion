package models;

import enums.CardType;
import lib.ConsoleIO;

public class Workshop extends Card {

	public Workshop() {
		super("WORKSHOP", CardType.ACTION, null, 3);
	}

	@Override
	public void action(Player player) {
		//prompt user for card they wont to add that has a value of up to 4
		ConsoleIO.promptForInput("please pick a card from supply cards that have a value of up to 4", false, false);
		
		//openShop();
		
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("\r\n" + 
				"  _____________________\r\n" + 
				" /            ").append(getName()).append("         \\\r\n" + 
				"|     	           	|\r\n" + 
				"|	            	|\r\n" + 
				"|	            	|\r\n" + 
				"|                 |\r\n" + 
				"|-----------------------|\r\n" + 
				"|			|\r\n" + 
				"|			|\r\n" + 
				"|		gain a card costion up to 4	|\r\n" + 
				"|			|\r\n" + 
				"|			|\r\n" + 
				"|		cost 3     Action	|\r\n" + 
				" \\_____________________/\r\n" + 
				"");
		return builder.toString();
	}

}

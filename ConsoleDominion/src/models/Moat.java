package models;

import enums.CardType;
import enums.SubType;

public class Moat extends Card {

	public Moat() {
		super("MOAT", CardType.ACTION, SubType.REACTION, 2);
	}
	//Done until I have the Militia class done
	@Override
	public void action(Player player) {
		player.drawCards(2);
	}
	
	@Override
	public String toString() {
		
		
			
				
				
				"|		cost 2     Action	|\r\n" + 
				" \\_____________________/\r\n" + 
				"");
		return builder.toString();
		
		StringBuilder builder = new StringBuilder();
		builder.append("\r\n" + 
				"  _____________________\r\n" + 
				" /    		   MOAT             \\\r\n" + 
				"|     	        						   	|\r\n" + 
				"|	          							  	|\r\n" + 
				"|	          							  	|\r\n" + 
				"|                  						|\r\n" + 
				"|--------------------------------|\r\n" + 
				"|		+ 2 cards	|\r\n" + 
				"|			|\r\n" + 
				"|	      When an attack card  |\r\n" + 
				"|		is played you may show	|\r\n" + 
				"|	this card from your hand	|\r\n" + 
				"|	if you do you are not 		|\r\n" + 
				"|	affected by that attack	|\r\n" + 
				"|											|\r\n" + 
				"|  cost 2     Action               |\r\n" + 
				" \\_____________________/\r\n" + 
				"");
		return builder.toString();
		
	}

}

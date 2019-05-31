package models;

public class Copper extends Treasure{

	public Copper() {
		super("COPPER", null, 0, 1);
	}

	@Override
	public String toString() {
		
		StringBuilder builder = new StringBuilder();
		builder.append("\r\n" + 
				"  _____________________\r\n" + 
				" /            	COPPER        \\\r\n" + 
				"|     	           	|\r\n" + 
				"|	            	|\r\n" + 
				"|	            	|\r\n" + 
				"|                 |\r\n" + 
				"|-----------------------|\r\n" + 
				"|			|\r\n" + 
				"|			|\r\n" + 
				"|			VALUE 1|\r\n" + 
				"|			|\r\n" + 
				"|			|\r\n" + 
				"|		cost 0     Treasure	|\r\n" + 
				" \\_____________________/\r\n" + 
				"");
		return builder.toString();
		
	}
	
}

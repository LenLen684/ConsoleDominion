package models;

public class Gold extends Treasure {

	public Gold() {
		super("GOLD", null, 6, 3);
	}

	@Override
	public String toString() {
		
		StringBuilder builder = new StringBuilder();
		builder.append("\r\n" + 
				"  _____________________\r\n" + 
				" /            	GOLD        \\\r\n" + 
				"|     	           	|\r\n" + 
				"|	            	|\r\n" + 
				"|	            	|\r\n" + 
				"|                 |\r\n" + 
				"|-----------------------|\r\n" + 
				"|			|\r\n" + 
				"|			 value 3|\r\n" + 
				"|		 	|\r\n" + 
				"|			|\r\n" + 
				"|			|\r\n" + 
				"|		cost 6     Treasure	|\r\n" + 
				" \\_____________________/\r\n" + 
				"");
		return builder.toString();
		
	}
	
}

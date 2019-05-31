package models;

public class Silver extends Treasure {

	public Silver() {
		super("SILVER", null, 3, 2);
	}

	@Override
	public String toString() {
		
		StringBuilder builder = new StringBuilder();
		builder.append("\r\n" + 
				"  _____________________\r\n" + 
				" /            	SILVER       \\\r\n" + 
				"|     	           	|\r\n" + 
				"|	            	|\r\n" + 
				"|	            	|\r\n" + 
				"|                 |\r\n" + 
				"|-----------------------|\r\n" + 
				"|			|\r\n" + 
				"|			|\r\n" + 
				"|			VALUE 2|\r\n" + 
				"|			|\r\n" + 
				"|			|\r\n" + 
				"|		cost 3     Treasure	|\r\n" + 
				" \\_____________________/\r\n" + 
				"");
		return builder.toString();
		
	}
	
}

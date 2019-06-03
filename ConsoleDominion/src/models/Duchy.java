package models;

public class Duchy extends Victory {
// spencer made
	public Duchy() {
		super("DUCHY", null, 5, 3);
	}

	@Override
	// kathy made toString
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("\r\n" + 
				"  _____________________________\r\n" + 
				" /            DUCHY  	       \\\r\n" + 
				"|     	             	        |\r\n" + 
				"|	  	      		|\r\n" + 
				"|    				|\r\n" + 
				"|-------------------------------|\r\n" + 
				"|				|\r\n" + 
				"|				|\r\n" + 
				"|           3 Points	        |\r\n" + 
				"|				|\r\n" + 
				"|				|\r\n" + 
				"|				|\r\n" + 
				"|  cost 5     		Victory |\r\n" + 
				" \\_____________________________/\r\n" + 
				"");
		return builder.toString();
	}
}

package models;

public class Province extends Victory {
// spencer made 
	public Province() {
		super("PROVINCE", null, 8, 6);
	}

	@Override
	//tosting kathy
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("\r\n" + 
				"  _____________________________\r\n" + 
				" /           Province          \\\r\n" + 
				"|     	             	        |\r\n" + 
				"|	  	      		|\r\n" + 
				"|-------------------------------|\r\n" + 
				"|    				|\r\n" + 
				"|				|\r\n" + 
				"|				|\r\n" + 
				"|           6 Points	        |\r\n" + 
				"|				|\r\n" + 
				"|				|\r\n" + 
				"|				|\r\n" + 
				"|  cost 8     		Victory |\r\n" + 
				" \\_____________________________/\r\n" + 
				"");
		return builder.toString();
	}
}

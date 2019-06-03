package models;

public class Silver extends Treasure {
// spencer made
	public Silver() {
		super("SILVER", null, 3, 2);
	}

	@Override
	//wells built spencer fixed spacing
	public String toString() {
		
		StringBuilder builder = new StringBuilder();
		builder.append("\r\n" + 
				"  _____________________________\r\n" + 
				" /            SILVER           \\\r\n" + 
				"|                               |\r\n" + 
				"|                               |\r\n" + 
				"|                               |\r\n" + 
				"|                               |\r\n" + 
				"|-------------------------------|\r\n" + 
				"|                               |\r\n" + 
				"|                               |\r\n" + 
				"|            VALUE 2            |\r\n" + 
				"|                               |\r\n" + 
				"|                               |\r\n" + 
				"|  cost 3             Treasure  |\r\n" + 
				" \\_____________________________/\r\n" + 
				"");
		return builder.toString();
		
	}
	
}

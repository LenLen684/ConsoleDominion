package models;

public class Copper extends Treasure{
// spincer made
	public Copper() {
		super("COPPER", null, 0, 1);
	}

	@Override
	public String toString() {
		// wells made spincer fixed spacing
		StringBuilder builder = new StringBuilder();
		builder.append("\r\n" + 
				"  _____________________________\r\n" + 
				" /            COPPER           \\\r\n" + 
				"|                               |\r\n" + 
				"|                               |\r\n" + 
				"|                               |\r\n" + 
				"|                               |\r\n" + 
				"|-------------------------------|\r\n" + 
				"|                               |\r\n" + 
				"|                               |\r\n" + 
				"|            VALUE 1            |\r\n" + 
				"|                               |\r\n" + 
				"|                               |\r\n" + 
				"|  cost 0             Treasure  |\r\n" + 
				" \\_____________________________/\r\n" + 
				"");
		return builder.toString();
		
	}
	
}

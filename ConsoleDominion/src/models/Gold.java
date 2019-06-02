package models;

public class Gold extends Treasure {

	public Gold() {
		super("GOLD", null, 6, 3);
	}

	@Override
	public String toString() {
		
		StringBuilder builder = new StringBuilder();
		builder.append("\r\n" + 
				"  _____________________________\r\n" + 
				" /             GOLD            \\\r\n" + 
				"|                               |\r\n" + 
				"|                               |\r\n" + 
				"|                               |\r\n" + 
				"|                               |\r\n" + 
				"|-------------------------------|\r\n" + 
				"|                               |\r\n" + 
				"|                               |\r\n" + 
				"|            VALUE 3            |\r\n" + 
				"|                               |\r\n" + 
				"|                               |\r\n" + 
				"|  cost 6             Treasure  |\r\n" + 
				" \\_____________________________/\r\n" + 
				"");
		return builder.toString();
		
	}
	
}

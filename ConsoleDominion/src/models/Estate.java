package models;

public class Estate extends Victory {
// Spencer made
	public Estate() {
		super("ESTATE", null, 2, 1);
	}

	@Override
	// kathy made toString
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("\r\n" + 
				"  _____________________________\r\n" + 
				" /            ESTATE  	       \\\r\n" + 
				"|                               |\r\n" + 
				"|                               |\r\n" + 
				"|                               |\r\n" + 
				"|-------------------------------|\r\n" + 
				"|                               |\r\n" + 
				"|                               |\r\n" + 
				"|            1 Point            |\r\n" + 
				"|                               |\r\n" + 
				"|                               |\r\n" + 
				"|                               |\r\n" + 
				"|  cost 2              Victory  |\r\n" + 
				" \\_____________________________/\r\n" + 
				"");
		return builder.toString();
	}
}

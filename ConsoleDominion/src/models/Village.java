package models;

import enums.CardType;

public class Village extends Card{

	public Village() {
		super("VILLAGE", CardType.ACTION, null, 3);
	}

	@Override
	public void action(Player player) {
		
		
		
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Village").append(super.toString());
		return builder.toString();
	}


}
 
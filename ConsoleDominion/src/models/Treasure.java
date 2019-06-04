package models;

import enums.CardType;
import enums.SubType;

public class Treasure extends Card{
	// Spencer made 
	protected final int treasureValue;
	
	public Treasure(String name, SubType secondayType, int cost, int treasureValue) {
		super(name, CardType.TREASURE, secondayType, cost);
		this.treasureValue = treasureValue;
	}

	public int getTreasureValue() {
		return treasureValue;
	}

	@Override
	public void action(Player player) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Treasure [treasureValue=").append(treasureValue).append("]");
		return builder.toString();
	}

	
}

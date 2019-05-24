package models;

import enums.CardType;
import enums.SubType;

public class Victory extends Card {
	
	protected final int victoryPoints;
	
	public Victory(String name, SubType secondayType, int cost, int victoryPoints) {
		super(name, CardType.VICTORY, secondayType, cost);
		this.victoryPoints = victoryPoints;
	}

	public int getVictoryPoints() {
		return victoryPoints;
	}

	@Override
	public void action(Player player) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Victory [victoryPoints=").append(victoryPoints).append("]");
		return builder.toString();
	}

	
}

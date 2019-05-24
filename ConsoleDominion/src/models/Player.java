package models;

import java.util.ArrayList;

public class Player {
	
	private String name;
	private int treasure;
	private int actions;
	private int buys;
	private int drawNumber;
	private PlayerDeck drawPile;
	private PlayerDeck hand;
	private PlayerDeck discardPile;
	private ArrayList<Integer> deckOrder = new ArrayList<>();
	
	public Player(String name) {
		super();
		setName(name);
	}
	
	public void initializeHand() {
		
	}
	
	public void addToHand(Card card) {
		
	}
	
	public void shuffleDiscardPile() {
		
	}
	
	public void discard(int index) {
		
	}
	
	public void discardHand() {
		
	}
	
	public void trashCard(int index) {
		
	}
	
	public void resetPlayer() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTreasure() {
		return treasure;
	}

	public void setTreasure(int treasure) {
		this.treasure = treasure;
	}

	public int getActions() {
		return actions;
	}

	public void setActions(int actions) {
		this.actions = actions;
	}

	public int getBuys() {
		return buys;
	}

	public void setBuys(int buys) {
		this.buys = buys;
	}

	public PlayerDeck getHand() {
		return hand;
	}
	
	public int getDrawNumber() {
		return drawNumber;
	}
	
	public void setDrawNumber(int drawNumber) {
		this.drawNumber = drawNumber;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Player [name=").append(name).append(", treasure=").append(treasure).append(", actions=")
				.append(actions).append(", buys=").append(buys).append(", drawPile=").append(drawPile).append(", hand=")
				.append(hand).append(", discardPile=").append(discardPile).append("]");
		return builder.toString();
	}

}

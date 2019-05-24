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
	
	/**
	 * Adds 5 cards to the hand from the draw pile.
	 * 
	 * @return void
	 */
	public void initializeHand() {
		setDrawNumber(5);
		if (drawPile.getDeckSize() < 5) {
			for(int i = 0; i < getDrawNumber(); i++) {
				addToHand(drawPile.drawCard());
			}			
		}else {
			int size = drawPile.getDeckSize();
			for(int i = 0; i < size; i++) {
				addToHand(drawPile.drawCard());
			}
			shuffleDiscardPile();		
			for(int i = 0; i < 5-size; i++) {
				addToHand(drawPile.drawCard());
			}
		}
	}
	
	/**
	 * Adds the card in the parameters to the hand.
	 * 
	 * @param card - The card to be added to the user's hand
	 * @return void
	 */
	public void addToHand(Card card) {
		
	}
	
	/**
	 * Shuffles the discard pile into the draw pile.
	 * 
	 * @return void
	 */
	public void shuffleDiscardPile() {
		//For a set amount of times
		
		//
		
	}
	
	/**
	 * Discards a single card from the hand.
	 * 
	 * @param index - The index of the card you would like to discard
	 * @return void
	 */
	public void discard(int index) {
		discardPile.addToDeck(hand.getCard(index));
		hand.removeFromDeck(index);
	}
	
	/**
	 * Discards the entire hand and puts it into the discard pile.
	 * 
	 * @return void
	 */
	public void discardHand() {
		for(int i = hand.getDeckSize(); i >= 0; i--) {
			discard(i);
		}
	}
	
	/**
	 * Takes a single card from the hand and throws it into the trash.
	 * 
	 * @param index - The index of the card to be trashed.
	 * @return void
	 */
	public void trashCard(int index) {
		
	}
	
	/**
	 * Resets all values for the player, including initialization of the hand.
	 * 
	 * @return void
	 */
	public void resetPlayer() {
		
	}
	
	/**
	 * Gets the name of the Player
	 * 
	 * @return - Name of the player
	 */
	public String getName() {
		return name;
	}

	/**
	 * Gets the name of the Player
	 * 
	 * @param name - The name to set the player to
	 * @return - Name of the player
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the amount of treasures the Player has.
	 * 
	 * @return - Name of the player
	 */
	public int getTreasure() {
		return treasure;
	}

	/**
	 * Sets the amount of treasures the Player has.
	 * 
	 * @param treasure - The value to set the treasures to.
	 * @return void
	 */	
	public void setTreasure(int treasure) {
		this.treasure = treasure;
	}

	/**
	 * Gets the amount of actions the Player has.
	 * 
	 * @return - Player's actions
	 */
	public int getActions() {
		return actions;
	}
	
	/**
	 * Sets the amount of actions the Player has.
	 * 
	 * @param actions - The value you want to set the actions to.
	 * @return void
	 */
	public void setActions(int actions) {
		this.actions = actions;
	}

	/**
	 * Gets the amount of buys the Player has.
	 * 
	 * @return - Player's buys
	 */
	public int getBuys() {
		return buys;
	}

	/**
	 * Sets the amount of buys the Player has.
	 * 
	 * @param buys - the value to set the buys to
	 * @return void
	 */
	public void setBuys(int buys) {
		this.buys = buys;
	}

	/**
	 * Gets the hand of the Player
	 * 
	 * @return - Player's hand
	 */
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

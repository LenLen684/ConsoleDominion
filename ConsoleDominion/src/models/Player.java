package models;

import java.util.ArrayList;
import java.util.Random;

import enums.SubType;
import lib.ConsoleIO;

public class Player {
	
	private final String name;
	private int treasure = 0;
	private int actions = 1;
	private int buys = 1;
	private int drawNumber = 0;
	private PlayerDeck drawPile = new PlayerDeck();
	private PlayerDeck hand = new PlayerDeck();
	private PlayerDeck discardPile = new PlayerDeck();
	private Random rng = new Random();
	
	public Player(String name) {
		super();
		this.name = name;
		for(int i = 0; i < 3; i++) {
			discardPile.addToDeck(new Estate());
		}
		for(int i = 0; i < 7; i++) {
			discardPile.addToDeck(new Gold());
		}
		shuffleDiscardPile();
	}
	
	/**
	 * Adds 5 cards to the hand from the draw pile.
	 * 
	 * @return void
	 */
	public void initializeHand() {
		if (drawPile.getDeckSize() > 5) {
			for(int i = 0; i < 5; i++) {
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
		hand.addToDeck(card);
	}
	
	/**
	 * Shuffles the discard pile into the draw pile.
	 * 
	 * @return void
	 */
	public void shuffleDiscardPile() {
		//For the specified sets of times, shuffle the cards
		int sets = rng.nextInt(8) + 5;
		for (int count = 0; count < sets; count++) {
			for (int index1 = 0; index1 < discardPile.getDeckSize(); index1++) {
				int index2 = rng.nextInt(discardPile.getDeckSize());

				Card temp1 = discardPile.getCard(index1);
				discardPile.removeFromDeck(index1);
				discardPile.addToDeck(rng.nextInt(discardPile.getDeckSize()),temp1);
				Card temp2 = discardPile.getCard(index2);
				discardPile.removeFromDeck(index2);
				discardPile.addToDeck(rng.nextInt(discardPile.getDeckSize()),temp2);
			}
		}
		for(int i = 0; i < discardPile.getDeckSize();i++) {
			drawPile.addToDeck(discardPile.getCard(i));
		}
		discardPile.clear();
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
		for(int i = hand.getDeckSize(); i > 0; i--) {
			discard(i - 1);
		}
	}
	
	/**
	 * Takes a single card from the hand and throws it into the trash.
	 * 
	 * @param index - The index of the card to be trashed.
	 * @return void
	 */
	public void trashCard(int index) {
		hand.removeFromDeck(index);
	}
	
	/**
	 * Resets all values for the player, including initialization of the hand.
	 * 
	 * @return void
	 */
	public void resetPlayer() {
		discardHand();
		initializeHand();
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
	
	public PlayerDeck getDrawPile() {
		return drawPile;
	}
	
	public void drawCards(int numOfCards) {
		for(int i = 0; i < numOfCards; i++) {
			addToHand(drawPile.drawCard());
			discard(hand.getDeckSize() - 1);
		}
	}
	
	public boolean revealReaction() {
		boolean reactionRevealed = false;
		ArrayList<Card> reactionCards = new ArrayList<>();
		for(Card card : hand.getDeck()) {
			if(card.getSecondayCardType() == SubType.REACTION) {
				reactionCards.add(card);
				
			}
		}
		
		if(ConsoleIO.promptForBool(getName() + " would you like to reveal a reaction card?(y/n): ", "y", "n")) {
			if(reactionCards.size() > 0) {
				System.out.println(reactionCards.get(0));
				reactionRevealed = true;
			} else {
				System.out.println("You don't have any reaction cards");
			}
		}
		
		return reactionRevealed;
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

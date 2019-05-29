package controllers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import enums.CardType;
import lib.ConsoleIO;
import lib.FileIO;
import models.Player;
import models.SupplyDeck;
import models.Treasure;

public class GameMaster implements Serializable {
	
	private static ArrayList<Player> players = new ArrayList<Player>();
	private static int turnCount;
	private static HashMap<String, SupplyDeck> supplies;
	private static ArrayList<String> cardsInHand = new ArrayList<>();

	/*
	 * initializes the game runs take turn until the game is over checks for winner
	 * asks if the user would like to play again, if so loops
	 */
	public static void run() {

		boolean stop = false;

		do {
			initializeGame();
			do {
				takeTurn();
				stop = checkForGameOver();
				if (stop) {
					checkForWinner();
				}

			} while (!stop);
		} while (ConsoleIO.promptForBool("would u like to play again. yes or no ", "yes", "no"));

	}

	/*
	 * prompts user for how many player there are between 2-4
	 * populates players with the given number of players
	 * randomly generates 5 action cards to be played with
	 * populates supplies with all victory, treasure, and action cards that will be used
	 */
	private static void initializeGame() {
		int playerAmount = ConsoleIO.promptForInt("How many players are there?", 2, 4);
		if(playerAmount == 2) { //With two players there are...
			//Victory Cards
			supplies.put("Estate", new SupplyDeck(8 - (playerAmount * 3))); //8 Victory Cards
			supplies.put("Duchy", new SupplyDeck(8));
			supplies.put("Province", new SupplyDeck(8));
			
		}
		else if (playerAmount > 2) { //With more than two players there are
			//Victory Cards
			supplies.put("Estate", new SupplyDeck(12)); //12 Victory Cards
			supplies.put("Duchy", new SupplyDeck(12));
			supplies.put("Province", new SupplyDeck(12));
		}
		
		//Money Cards for any amount of players
		supplies.put("Copper", new SupplyDeck(40));
		supplies.put("Silver", new SupplyDeck(30));
		supplies.put("Gold", new SupplyDeck(28));
		
		//Action cards - 10 of each
		selectActionCards();
		
		createPlayers(playerAmount);
		
	}
	
	private static void selectActionCards() {
		String[] cardsAvailable = {"Cellar", "Market", "Militia", "Market", "Mine", "Moat", "Remodel", "Smithy", "Village"};
		Random rng = new Random();
		int fiveCards = 0;
		
		while(fiveCards < 5) {
			int selectedCard = rng.nextInt(cardsAvailable.length);
			if(!supplies.containsKey(cardsAvailable[selectedCard])) {
				supplies.put(cardsAvailable[selectedCard], new SupplyDeck(10));
				fiveCards ++;
			}
		}
		
	}

	/*
	 * when given a number of players populate players with that many player objects
	 * make sure when player is created that their draw deck is shuffled
	 */
	private static void createPlayers(int playerAmount) {
		for(int i = 0; i<playerAmount; i++) {
			String name = ConsoleIO.promptForInput("What is the player's name?", false, false);
			Player createdPlayer = new Player(name);
			
			players.add(createdPlayer);
		}
		

	}

	/*
	 * player starts by drawing if they have any action cards enter the action phase
	 * prompt them for if they would like to buy anything if yes enter the buy phase
	 * if no end turn clean up after turn is done
	 */
	private static void takeTurn() {
		Player currentPlayer = players.get(turnCount % players.size());
		if(currentPlayer.getHand().getDeckSize() == 0) {
			currentPlayer.initializeHand();
		}
		for(int i = 0; i < currentPlayer.getHand().getDeckSize(); i++) {
			cardsInHand.add(currentPlayer.getHand().getCard(i).toString() + "\n\n");
		}
		int actionCards = 0;
		for(int i = 0; i < currentPlayer.getHand().getDeckSize(); i++) {
			if(currentPlayer.getHand().getCard(i).getCardType() == CardType.ACTION) {
				actionCards++;
			}
		}
		if(actionCards > 0) {
			actionPhase();
		}
		if(ConsoleIO.promptForBool("Would you like to buy anything?(y/n): ", "y", "n")) {
			buyPhase();
		}
		cleanUpPhase();
		turnCount++;
		
	}

	/*
	 * prompt user for if they would like to play an action if they would prompt
	 * them for what card they would like to play but only allow action cards play
	 * the cards action loop until they want to stop, are out of action, or are out
	 * of action cards
	 */
	private static void actionPhase() {

	}

	/*
	 * open the shop for them to see what to buy prompt them to select the card they
	 * want to buy if they don't have enough tell them it is too expensive if they
	 * have any more buys and more money prompt them if they would like to buy again
	 * note re-open the shop each time so they can see their options again loop
	 * until they run out of buys, money, or want to end
	 */
	private static void buyPhase() {
		ArrayList<Integer> treasureIndexes = new ArrayList<>();
		for(int i = 0; i < players.get(turnCount % players.size()).getHand().getDeckSize(); i++) {
			if(players.get(turnCount % players.size()).getHand().getCard(i).getCardType() == CardType.TREASURE) {
				treasureIndexes.add(i);
			}
		}
		if(treasureIndexes.size() > 0 && ConsoleIO.promptForBool("Do you want to play a treasure card?(y/n): ", "y", "n")) {
			do {
				String[] options = new String[cardsInHand.size()];
				cardsInHand.toArray(options);
				int choice = 0;
				do {
					choice = ConsoleIO.promptForMenuSelection("Select a treasure card to play: ", options, "Quit", false);
					if(!treasureIndexes.contains(choice)) {
						System.out.println("That is not a treasure card.");
					}
				} while(!(treasureIndexes.contains(choice)));
				players.get(turnCount % players.size()).setTreasure(players.get(turnCount % players.size()).getTreasure() + ((Treasure) players.get(turnCount % players.size()).getHand().getCard(choice)).getTreasureValue());
				treasureIndexes.remove(treasureIndexes.indexOf(choice));
			} while(treasureIndexes.size() > 0 && ConsoleIO.promptForBool("Do you want to play another treasure card?(y/n): ", "y", "n"));
		}
		int treasure = players.get(turnCount % players.size()).getTreasure();
		do {
			players.get(turnCount % players.size()).setTreasure(openShop(treasure, null));
		} while(players.get(turnCount % players.size()).getBuys() > 0 && ConsoleIO.promptForBool("Do you want to buy something else?(y/n): ", "y", "n"));
		
	}

	/*
	 * When ran, opens the shop and manages what they player gets from the shop
	 * based on how much money is passed in and the type of cards wanted printed if null prints everything.
	 * Exit the shop when something equal or
	 * less money is selected. This adds the selected card into the hand and then
	 * discard card.
	 */
	public static int openShop(int money, CardType wantedCards) {
		ArrayList<String> shopStrings = new ArrayList<>();
		ArrayList<String> keys = new ArrayList<>();
		for(String key : supplies.keySet()) {
			keys.add(key);
		}
		for(int i = 0; i < supplies.size(); i++) {
			if(supplies.get(keys.get(i)).getAmount() > 0 && wantedCards == null) {
				shopStrings.add(supplies.get(keys.get(i)).getCard().toString() + "\n\n");
				keys.add(keys.get(i));
			} else if(supplies.get(keys.get(i)).getAmount() > 0 && supplies.get(keys.get(i)).getCard().getCardType() == wantedCards) {
				shopStrings.add(supplies.get(keys.get(i)).getCard().toString() + "\n\n");
				keys.add(keys.get(i));
			}
		}
		for(int i = 0; i < supplies.size(); i++) {
			keys.remove(0);
		}
		int choice = 0;
		String[] options = new String[shopStrings.size()];
		shopStrings.toArray(options);
		do {
			choice = ConsoleIO.promptForMenuSelection("Select the card you would like to get: ", options, "Quit", false);
			if(supplies.get(keys.get(choice)).getCard().getCost() > money) {
				System.out.println("That card is too expensive. Please pick one that is " + money + " or less");
			}
		} while(!(supplies.get(keys.get(choice)).getCard().getCost() > money));
		players.get(turnCount % players.size()).addToHand(supplies.get(keys.get(choice)).drawCard());
		players.get(turnCount % players.size()).discard(players.get(turnCount % players.size()).getHand().getDeckSize() - 1);
		players.get(turnCount % players.size()).setTreasure((players.get(turnCount % players.size())).getTreasure() - supplies.get(keys.get(choice)).getCard().getCost());
		
		return money;
	}

	/*
	 * make sure everything from the players hand is put in discard reset all of the
	 * players values print a few blank lines to break this turn from the next
	 */
	private static void cleanUpPhase() {

	}

	/*
	 * check if provinces (slot 3) is empty or if any 3 other slots are empty
	 */
	private static boolean checkForGameOver() {
		boolean gameOver = false;

		return gameOver;
	}

	/*
	 * winning player is determined by the turn math need to return a boolean
	 */
	private static void checkForWinner() {

	}
	
	/**
	 * Saves the gamemaster class and puts it in "autoSave.png"
	 * 
	 */
	private static void autoSave() {
		FileIO.write(GameMaster.class, "autoSave.png");
	}
	
	/*
	 * will save the GameMaster class to a file as specified by the user with the
	 * extension of .dom
	 */
	private static void saveGame(String filePath) {
		FileIO.write(GameMaster.class, filePath);
	}

	/*
	 * prompt the user for the file path of the file they want to load and overwrite
	 * the current GameMaster class
	 */
	private static GameMaster loadGame(String filePath) {
		GameMaster loadedGame = (GameMaster) FileIO.read(filePath);
		return loadedGame;
	}

}

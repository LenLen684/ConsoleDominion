package controllers;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Random;
import enums.CardType;
import lib.ConsoleIO;
import lib.FileIO;
import models.*;

public class GameMaster {

	private static ArrayList<Player> players;
	private static int turnCount;
	private static HashMap<String, SupplyDeck> supplies;
	private static Player currentPlayer;
	private static ArrayList<String> cardsInHand = new ArrayList<>();
	private static String filePath;
	private static Save loadedGame;

	/*
	 * initializes the game runs take turn until the game is over checks for winner
	 * asks if the user would like to play again, if so loops
	 */
	public static void run() {

		boolean stop = false;
// must check to see in load is null first be for the opptions
		do {
			System.out.println("Welcome to Console Dominion!");
			boolean load = ConsoleIO.promptForBool("Do you have a save file you would like to load? (y/n) ", "y", "n");
			if (load) {
				loadGame();
				turnCount = loadedGame.getTurnCount();
				currentPlayer = loadedGame.getCurrentPlayer();
				supplies = loadedGame.getSupplies();
				cardsInHand = loadedGame.getCardsInHand();
				players = loadedGame.getPlayers();
			} else {
				initializeGame();
				currentPlayer = players.get(turnCount % players.size());
				saveGame();
			}
			do {
				takeTurn();
				stop = checkForGameOver();
				if (stop) {
					checkForWinner();
				}

			} while (!stop);

		} while (ConsoleIO.promptForBool("Would you like to play again? Yes or No ", "Yes", "No"));

	}

	/*
	 * prompts user for how many player there are between 2-4 populates players with
	 * the given number of players randomly generates 5 action cards to be played
	 * with populates supplies with all victory, treasure, and action cards that
	 * will be used
	 */
	private static void initializeGame() {
		supplies = new HashMap<>();
		players = new ArrayList<>();
		turnCount = 0;
		int playerAmount = ConsoleIO.promptForInt("How many players are there(2-4)?: ", 2, 4);
		if (playerAmount == 2) { // With two players there are...
			// Victory Cards
			supplies.put("Estate", new SupplyDeck(8, new Estate())); // 8 Victory Cards
			supplies.put("Duchy", new SupplyDeck(8, new Duchy()));
			supplies.put("Province", new SupplyDeck(8, new Province()));

		} else if (playerAmount > 2) { // With more than two players there are
			// Victory Cards
			supplies.put("Estate", new SupplyDeck(12, new Estate())); // 12 Victory Cards
			supplies.put("Duchy", new SupplyDeck(12, new Duchy()));
			supplies.put("Province", new SupplyDeck(12, new Province()));
		}

		// Money Cards for any amount of players
		supplies.put("Copper", new SupplyDeck(40, new Copper()));
		supplies.put("Silver", new SupplyDeck(30, new Silver()));
		supplies.put("Gold", new SupplyDeck(28, new Gold()));

		// Action cards - 10 of each
		selectActionCards();
//		System.out.println("Test");
		createPlayers(playerAmount);

	}

	private static void selectActionCards() {
		Card[] cardsAvailable = { new Cellar(), new Market(), new Militia(), new Market(), new Mine(), new Moat(),
				new Remodel(), new Smithy(), new Village(), new Workshop() };
		Random rng = new Random();
		int fiveCards = 0;
		while (fiveCards < 5) {
			int selectedCard = rng.nextInt(cardsAvailable.length);
			if (!supplies.containsKey(cardsAvailable[selectedCard].getName())) {
				supplies.put(cardsAvailable[selectedCard].getName(), new SupplyDeck(10, cardsAvailable[selectedCard]));
				fiveCards++;
			}
		}

	}

	/*
	 * when given a number of players populate players with that many player objects
	 * make sure when player is created that their draw deck is shuffled
	 */
	private static void createPlayers(int playerAmount) {
		for (int i = 0; i < playerAmount; i++) {
			String name = ConsoleIO.promptForInput("What is player " + (i + 1) + "'s name?: ", false, false);
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
		currentPlayer = players.get(turnCount % players.size());
		autoSave();
		System.out.println("\nIt is " + currentPlayer.getName() + "'s turn.");
		System.out.println(currentPlayer.getName() + "'s hand: ");
		if (currentPlayer.getHand().getDeckSize() == 0) {
			currentPlayer.initializeHand();
		}
		for (Card card : currentPlayer.getHand().getDeck()) {
			cardsInHand.add(card.toString() + "\n\n");
		}
		for (String card : cardsInHand) {
			System.out.println(card);
		}
		int actionCards = 0;
		for (int i = 0; i < currentPlayer.getHand().getDeckSize(); i++) {
			if (currentPlayer.getHand().getCard(i).getCardType() == CardType.ACTION) {
				actionCards++;
			}
		}
		if (actionCards > 0) {
			actionPhase();
		}
		if (ConsoleIO.promptForBool("Would you like to buy anything?(y/n): ", "y", "n")) {
			buyPhase();
		}
		cleanUpPhase();

		System.out.println("Here is your next turn's hand");
		currentPlayer.initializeHand();
		for (Card card : currentPlayer.getHand().getDeck()) {
			cardsInHand.add(card.toString() + "\n\n");
		}
		for (String card : cardsInHand) {
			System.out.println(card);
		}
		cardsInHand.clear();
		turnCount++;
		ConsoleIO.promptForInput("Press the enter key to end turn.", true, false);
		System.out.println(
				"\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"
						+ "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		ConsoleIO.promptForInput("Press the enter key to start the next player's turn.", true, false);
		System.out.println("\n\n\n\n\n\n\n");
	}

	/*
	 * prompt user for if they would like to play an action if they would prompt
	 * them for what card they would like to play but only allow action cards play
	 * the cards action loop until they want to stop, are out of action, or are out
	 * of action cards
	 */
	private static void actionPhase() {
		/*
		 * Take in the player and check if the players hand has any action cards, then
		 * check for which card they want to play if they want to take the next action,
		 * do so, if not, exit the phase. for every action taken, reduce the amount aof
		 * available actions by 1 for every card that the player plays to increase the
		 * amount of actions, decrease the amount of actions, then add the amount of
		 * actions
		 */
		int actionsAvailable = currentPlayer.getActions();
		boolean takeAction = false;
		do {
			takeAction = ConsoleIO.promptForBool("Would you like to play an action? (y/n) ", "y", "n");
			if (takeAction) {
				// Check the player's hand for an action card
				int selection = 0;
				ArrayList<Integer> placement = new ArrayList<>();
				ArrayList<Card> actions = new ArrayList<>();
				for (int i = 0; i < currentPlayer.getHand().getDeckSize(); i++) {
					Card card = currentPlayer.getHand().getCard(i);
					if (card.getCardType() == CardType.ACTION) {
						placement.add(i);
						actions.add(card);
					}
				}
				String[] options = new String[actions.size()];
				for (int j = 0; j < actions.size(); j++) {

					// Assign each value to String array
					options[j] = actions.get(j).toString();
				}
				selection = ConsoleIO.promptForMenuSelection("Which card would you like to play? ", options, null, true)
						- 1;
				if (selection >= 0) { //This needs to be >=
					actions.get(selection).action(currentPlayer);
					currentPlayer.discard(placement.get(selection));
					currentPlayer.setActions(currentPlayer.getActions() - 1);
					placement.clear();
					actions.clear();
				}
			} else {
				currentPlayer.setActions(0);
			}
		} while (takeAction && actionsAvailable > 0);

	}

	/*
	 * open the shop for them to see what to buy prompt them to select the card they
	 * want to buy if they don't have enough tell them it is too expensive if they
	 * have any more buys and more money prompt them if they would like to buy again
	 * note re-open the shop each time so they can see their options again loop
	 * until they run out of buys, money, or want to end
	 */
	private static void buyPhase() {
		int money = currentPlayer.getTreasure();
		for (int i = 0; i < currentPlayer.getHand().getDeckSize(); i++) {
			if (currentPlayer.getHand().getCard(i).getCardType() == CardType.TREASURE) {
				Treasure treasuremon = (Treasure) currentPlayer.getHand().getCard(i);
				money += treasuremon.getTreasureValue();
			}
		}
		System.out.println("You have " + money + " money.");
		int treasure = money;
		do {
			currentPlayer.setTreasure(openShop(treasure, null));
			treasure = currentPlayer.getTreasure();
			currentPlayer.setBuys(currentPlayer.getBuys() - 1);
		} while (currentPlayer.getBuys() > 0
				&& ConsoleIO.promptForBool("Do you want to buy something else?(y/n): ", "y", "n"));

	}

	/*
	 * When ran, opens the shop and manages what they player gets from the shop
	 * based on how much money is passed in and the type of cards wanted printed if
	 * null prints everything. Exit the shop when something equal or less money is
	 * selected. This adds the selected card into the hand and then discard card.
	 */
	public static int openShop(int money, CardType wantedCards) {
		ArrayList<String> shopStrings = new ArrayList<>();
		ArrayList<String> keys = new ArrayList<>();
		for (String key : supplies.keySet()) {
			keys.add(key);
		}
		for (int i = 0; i < supplies.size(); i++) {
			if (supplies.get(keys.get(i)).getAmount() > 0 && wantedCards == null) {
				shopStrings.add(supplies.get(keys.get(i)).getCard().toString() + "\n\n");
				keys.add(keys.get(i));
			} else if (supplies.get(keys.get(i)).getAmount() > 0
					&& supplies.get(keys.get(i)).getCard().getCardType() == wantedCards) {
				shopStrings.add(supplies.get(keys.get(i)).getCard().toString() + "\n\n");
				keys.add(keys.get(i));
			}
		}
		for (int i = 0; i < supplies.size(); i++) {
			keys.remove(0);
		}
		int choice = 0;
		String[] options = new String[shopStrings.size()];
		shopStrings.toArray(options);
		do {
			choice = ConsoleIO.promptForMenuSelection("Select the card you would like to get: ", options, "Quit", false)
					- 1;
			if ((supplies.get(keys.get(choice)).getCard().getCost() > money)) {
				System.out.println("That card is too expensive. Please pick one that is " + money + " or less");
			}
		} while ((supplies.get(keys.get(choice)).getCard().getCost() > money));
		currentPlayer.addToHand(supplies.get(keys.get(choice)).drawCard());
		currentPlayer.discard(players.get(turnCount % players.size()).getHand().getDeckSize() - 1);
		currentPlayer.setTreasure(currentPlayer.getTreasure() - supplies.get(keys.get(choice)).getCard().getCost());

		return money;
	}

	/*
	 * make sure everything from the players hand is put in discard reset all of the
	 * players values print a few blank lines to break this turn from the next
	 */
	private static void cleanUpPhase() {
		currentPlayer.discardHand();
		currentPlayer.setBuys(1);
		currentPlayer.setActions(1);
		currentPlayer.setTreasure(0);
		cardsInHand.clear();
		System.out.println(" \n\n\n\n\n");

	}

	/*
	 * check if provinces (slot 2) is empty or if any 3 other slots are empty
	 */
	private static boolean checkForGameOver() {
		boolean gameOver = false;

		if (supplies.get("Province").getAmount() == 0) {
			gameOver = true;
			return gameOver;
		} else {
			int emptyCount = 0;
			ArrayList<String> keys = new ArrayList<>();
			// where the names of the cards are not province, duchy, estate, copper, silver,
			// or gold,
			// check whether or not they have any cards left.
			for (String key : supplies.keySet()) {
				keys.add(key);
			}
			for (int i = 0; i < keys.size(); i++) {
				if (supplies.get(keys.get(i)).getAmount() == 0) {
					emptyCount++;
				}
			}
			if (emptyCount >= 3) {
				gameOver = true;
				return gameOver;
			}
		}

		// string type from set type that is keyset in the hashmap
		// boolean statment if condishen is meet
		return gameOver;

	}

	/*
	 * winning player is determined by the turn math need to return a boolean
	 */
	private static void checkForWinner() {
		String[][] sortingPlays = new String[players.size()][2]; // [0] name [1] points

		for (int playerIndex = 0; playerIndex < players.size(); playerIndex++) { // To put all the scores and players
																					// together
			int victoryPoints = 0;

			Player tempPlay = players.get(playerIndex);
			tempPlay.discardHand();
			tempPlay.shuffleDiscardPile(); // Putting all in draw pile
			ArrayList<Card> tempDraw = tempPlay.getDrawPile().getDeck(); // Getting draw pile
			for (int cardIndex = 0; cardIndex < tempDraw.size(); cardIndex++) {
				Card tempCard = tempDraw.get(cardIndex);
				if (tempCard.getName().equalsIgnoreCase("Duchy") || tempCard.getName().equalsIgnoreCase("Estate")
						|| tempCard.getName().equalsIgnoreCase("Province")) {
					victoryPoints += (((Victory) tempCard).getVictoryPoints());
				}
			}
			sortingPlays[playerIndex][0] = tempPlay.getName();
			sortingPlays[playerIndex][1] = String.valueOf(victoryPoints);
		}

		Arrays.sort(sortingPlays, new Comparator<String[]>() { // Sorts the array

			@Override
			public int compare(final String[] entry1, final String[] entry2) {
				return (Double.valueOf(entry1[1]).compareTo(Double.valueOf((entry2[1])))) * -1;
			}
		});

		System.out.println("The Winner is: " + sortingPlays[0][0]);
		System.out.println("The scores:");
		for (int i = 0; i < sortingPlays.length; i++) {
			System.out.println((i + 1) + ". " + sortingPlays[i][0] + "... " + sortingPlays[i][1]);
		}
	}

	/**
	 * Saves the files able to be saved and saves it at the current filePath.
	 * 
	 */
	private static void autoSave() {
		Save auto = new Save(players, currentPlayer, turnCount, supplies, cardsInHand);
		FileIO.write(auto, filePath);
	}

	/*
	 * will save the GameMaster class to a file as specified by the user with the
	 * extension of .dom
	 */
	private static void saveGame() {
		filePath = ConsoleIO.promptForInput("What name do you want your save file under?  ", false, false);
		filePath += ".dom";
		autoSave();
	}

	/*
	 * prompt the user for the file path of the file they want to load and overwrite
	 * the current GameMaster class
	 */
	private static Save loadGame() {
		boolean invalidLoad = true;
		do {
			String[] options = { "Load the game", "Change the name of a file" };
			int selection = ConsoleIO.promptForMenuSelection("", options, null, true);
			if(selection == 0) {
				invalidLoad = false;
			}else {
				
			filePath = ConsoleIO.promptForInput("What is your file under? ", false, false);
			filePath += ".dom";
			try {
				loadedGame = (Save) FileIO.read(filePath);
				invalidLoad = false;
			} catch (NullPointerException npe) {
				System.out.println("There is no file by that name");
			}
			if (selection == 2) {
				saveGame();
				loadedGame = (Save) FileIO.read(filePath);
			}
			}
		} while (invalidLoad);
		return loadedGame;
	}

	public static ArrayList<Player> getPlayers() {
		return players;
	}

}

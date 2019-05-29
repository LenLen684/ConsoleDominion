package controllers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import lib.ConsoleIO;
import models.Player;
import models.SupplyDeck;

public class GameMaster implements Serializable {

	private static ArrayList<Player> players;
	private static int turnCount;
	private static HashMap<String, SupplyDeck> supplies;

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
				if (stop = checkForGameOver())
					checkForWinner();

			} while (!stop);
		} while (ConsoleIO.promptForBool("would you like to play again. yes or no ", "yes", "no"));

	}

	/*
	 * prompts user for how many player there are between 2-4 populates players with
	 * the given number of players randomly generates 5 action cards to be played
	 * with populates supplies with all victory, treasure, and action cards that
	 * will be used make sure victory's are in slots 0 1 2 in order of value
	 * ascending same for treasures in 3 4 5
	 */
	private static void initializeGame() {

	}

	/*
	 * when given a number of players populate players with that many player objects
	 * make sure when player is created that their draw deck is shuffled
	 */
	private static void createPlayers(int players) {

	}

	/*
	 * player starts by drawing if they have any action cards enter the action phase
	 * prompt them for if they would like to buy anything if yes enter the buy phase
	 * if no end turn clean up after turn is done
	 */
	private static void takeTurn() {

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

	}

	/*
	 * When ran, opens the shop and manages what they player gets from the shop
	 * based on how much money is passed in. Exit the shop when something equal or
	 * less money is selected. This adds the selected card into the hand and then
	 * discard card.
	 */
	public static void openShop(int money) {

	}

	/*
	 * make sure everything from the players hand is put in discard reset all of the
	 * players values print a few blank lines to break this turn from the next
	 */
	private static void cleanUpPhase() {

	}

	/*
	 * check if provinces (slot 2) is empty or if any 3 other slots are empty
	 */
	private static boolean checkForGameOver() {
		boolean gameOver = false;

		if (supplies.get("province").getAmount() == 0) {
			gameOver = true;
			return gameOver;
		} else {
			int emptyCount = 0;
			ArrayList<String> keys = new ArrayList<>();
			//where the names of the cards are not province, duchy, estate, copper, silver, or gold,
			//check whether or not they have any cards left.
			for(String key : supplies.keySet()) {
				keys.add(key);
			}
			for(int i = 0; i < keys.size(); i++) {
				if(supplies.get(keys.get(i)).getDeckSize() == 0) {
					emptyCount++;
				}
			}
			if(emptyCount >= 3) {
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

	}

	/*
	 * will save the GameMaster class to a file as specified by the user with the
	 * extension of .dom
	 */
	private static void saveGame(String filePath) {

	}

	/*
	 * prompt the user for the file path of the file they want to load and overwrite
	 * the current GameMaster class
	 */
	private static GameMaster loadGame(String filePath) {
		GameMaster loadedGame = null;

		return loadedGame;
	}

}

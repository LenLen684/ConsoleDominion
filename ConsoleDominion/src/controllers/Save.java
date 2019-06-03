package controllers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

import models.Player;
import models.SupplyDeck;

public class Save implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2548086231478460896L;
	private static ArrayList<Player> players = new ArrayList<>();
	private static int turnCount;
	private static HashMap<String, SupplyDeck> supplies = new HashMap<>();
	private static ArrayList<String> cardsInHand = new ArrayList<>();
	private static Player currentPlayer;

	public Save(ArrayList<Player> players,Player currentPlayer, int turnCount, HashMap<String, SupplyDeck> supplies,
			ArrayList<String> cardsInHand) {
		setCardsInHand(cardsInHand);
		setCurrentPlayer(currentPlayer);
		setPlayers(players);
		setSupplies(supplies);
		setTurnCount(turnCount);
	}

	public static Player getCurrentPlayer() {
		return currentPlayer;
	}

	public static void setCurrentPlayer(Player currentPlayer) {
		Save.currentPlayer = currentPlayer;
	}

	public static ArrayList<Player> getPlayers() {
		return players;
	}

	public static void setPlayers(ArrayList<Player> players) {
		Save.players = players;
	}

	public static int getTurnCount() {
		return turnCount;
	}

	public static void setTurnCount(int turnCount) {
		Save.turnCount = turnCount;
	}

	public static HashMap<String, SupplyDeck> getSupplies() {
		return supplies;
	}

	public static void setSupplies(HashMap<String, SupplyDeck> supplies) {
		Save.supplies = supplies;
	}

	public static ArrayList<String> getCardsInHand() {
		return cardsInHand;
	}

	public static void setCardsInHand(ArrayList<String> cardsInHand) {
		Save.cardsInHand = cardsInHand;
	}

}
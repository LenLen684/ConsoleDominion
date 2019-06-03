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
	private static final long serialVersionUID = 1L;
	ArrayList<Player> players = new ArrayList<>();
	int turnCount;
	HashMap<String, SupplyDeck> supplies = new HashMap<>();
	ArrayList<String> cardsInHand = new ArrayList<>();
	Player currentPlayer;

	public Save(ArrayList<Player> players,Player currentPlayer, int turnCount, HashMap<String, SupplyDeck> supplies,
			ArrayList<String> cardsInHand) {
		setCardsInHand(cardsInHand);
		setCurrentPlayer(currentPlayer);
		setPlayers(players);
		setSupplies(supplies);
		setTurnCount(turnCount);
	}

	public Player getCurrentPlayer() {
		return currentPlayer;
	}

	public void setCurrentPlayer(Player currentPlayer) {
		this.currentPlayer = currentPlayer;
	}

	public ArrayList<Player> getPlayers() {
		return players;
	}

	public void setPlayers(ArrayList<Player> players) {
		this.players = players;
	}

	public int getTurnCount() {
		return turnCount;
	}

	public void setTurnCount(int turnCount) {
		this.turnCount = turnCount;
	}

	public HashMap<String, SupplyDeck> getSupplies() {
		return supplies;
	}

	public void setSupplies(HashMap<String, SupplyDeck> supplies) {
		this.supplies = supplies;
	}

	public ArrayList<String> getCardsInHand() {
		return cardsInHand;
	}

	public void setCardsInHand(ArrayList<String> cardsInHand) {
		this.cardsInHand = cardsInHand;
	}

	@Override
	public String toString() {
		return "Save [players=" + players + ", turnCount=" + turnCount + ", supplies=" + supplies + ", cardsInHand="
				+ cardsInHand + ", currentPlayer=" + currentPlayer + "]";
	}

	
}
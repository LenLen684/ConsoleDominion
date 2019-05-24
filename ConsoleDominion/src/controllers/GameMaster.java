package controllers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

import models.Player;
import models.SupplyDeck;

public class GameMaster implements Serializable{
	
	private static ArrayList<Player> players;
	private static int turnCount;
	private static HashMap<String, SupplyDeck> supplies;
	
	public static void run() {
		
	}
	
	private static void initializeGame() {
		
	}
	
	private static void createPlayers(int players) {
		
	}
	
	private static void takeTurn() {
		
	}
	
	private static void actionPhase() {
		
	}
	
	private static void buyPhase() {
		
	}
	
	private static void openShop() {
		
	}
	
	private static void cleanUpPhase() {
		
	}
	
	private static boolean checkForGameOver() {
		boolean gameOver = false;
		
		return gameOver;
	}
	
	private static Player checkForWinner() {
		Player winningPlayer = null;
		
		return winningPlayer;
	}
	
	private static void saveGame(String filePath) {
		
	}
	
	private static GameMaster loadGame(String filePath) {
		GameMaster loadedGame = null;
		
		return loadedGame;
	}
	
}

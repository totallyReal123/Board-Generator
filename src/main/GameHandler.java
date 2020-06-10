package main;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

import board.Board;
import board.Hex;

public class GameHandler {
	private Game game;
	private Board gameBoard;

	public void setupGame(Game game) {
		// Initialize Variables
		this.gameBoard = new Board();
		this.game = game;
	}

	public void render(Graphics graphics) {
		this.gameBoard.render(graphics);
	}
	

}

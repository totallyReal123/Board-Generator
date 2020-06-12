package main;

import java.awt.Graphics;

import board.Board;
import gui.GUI;

public class GameHandler {
	private Game game;
	private Board gameBoard;
	private GUI randomizeMenu;

	public void setupGame(Game game) {
		// Initialize Variables
		this.gameBoard = new Board();
		this.game = game;
		this.randomizeMenu = new GUI(this.game.getWidth() / 2 - 470 / 2, 580, 470, 70);
		this.randomizeMenu.setBackgroundImage(ImageHandler.loadImage("/images/RegenButton.png"));
	}

	public void render(Graphics graphics) {
		this.gameBoard.render(graphics);
		this.randomizeMenu.render(graphics);
	}

	public void update(Game game) {
		this.gameBoard.update(game);
		if(this.randomizeMenu.isClicked(game)) {
			this.gameBoard.initializeBoard();
		}
	}

}

package gui;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import main.Game;

public class GUI {
	private BufferedImage backgroundImage;
	private int x, y, width, height;

	// Constructors
	public GUI(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	public GUI(int x, int y, int width, int height, BufferedImage background) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.backgroundImage = background;
	}

	// Render and Update
	public void render(Graphics graphics) {
		graphics.drawImage(backgroundImage, x, y, width, height, null);
	}

	// Methods
	public boolean isClicked(Game game) {
		if (game.mouseListener.keys[1]) {
			int mouseX = game.mouseListener.x;
			int mouseY = game.mouseListener.y;
			if (mouseX >= this.x && mouseX <= this.x + this.width && mouseY >= this.y
					&& mouseY <= this.y + this.height) {
				return true;
			}

		}
		return false;
	}

	// Getters and Setters
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public BufferedImage getBackgroundImage() {
		return this.backgroundImage;
	}

	public void setBackgroundImage(BufferedImage backgroundImage) {
		this.backgroundImage = backgroundImage;
	}

}

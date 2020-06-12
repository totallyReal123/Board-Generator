package board;

import java.awt.Graphics;

import main.Game;

public abstract class GameObject {
	int x = 0, y = 0;

	abstract void render(Graphics graphics);

	abstract void update(Game game);

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
}

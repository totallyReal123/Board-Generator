package board;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import main.ImageHandler;
import utils.Utils;

public class Board extends GameObject {
	// Setup storage for things
	private ArrayList<Hex> hexes;

	// Declare static variables
	// Positions of Hexes on the board
	private final double[][] hexPositions = { { 1.26, 0.00 }, { 0.63, 0.36 }, { 1.26, 0.71 }, { 1.89, 0.36 },
			{ 0.00, 0.71 }, { 0.63, 1.07 }, { 1.26, 1.42 }, { 1.89, 1.07 }, { 2.52, 0.71 }, { 0.00, 1.42 },
			{ 0.63, 1.78 }, { 1.26, 2.13 }, { 1.89, 1.78 }, { 2.52, 1.42 }, { 0.00, 2.13 }, { 0.63, 2.49 },
			{ 1.26, 2.84 }, { 1.89, 2.49 }, { 2.52, 2.13 } };

	public Board() {
		this.hexes = new ArrayList<Hex>();

		this.initializeBoard();
	}

	public void initializeBoard() {
		// Random for future use
		Random ran = new Random();

		// Setup the Hexes
		double scale = 161;
		int[] typeAmounts = { 0, 3, 3, 4, 4, 4 };
		ArrayList<Integer> numbers = Utils
				.intArraytoArrayList(new int[] { 2, 3, 3, 4, 4, 5, 5, 6, 6, 8, 8, 9, 9, 10, 10, 11, 11, 12 });
		String[] fileNameKey = { "desert", "bricks", "ore", "sheep", "timber", "wheat" };

		for (int i = 0; i < this.hexPositions.length; i++) {
			if (i != 6) {
				// Get X and Y Coordinates
				int x = (int) (hexPositions[i][0] * scale) + 0;
				int y = (int) (hexPositions[i][1] * scale) + 0;

				// Get type
				int type = 0;
				int amount = typeAmounts[type];
				while (amount <= 0) {
					type = ran.nextInt(typeAmounts.length);
					amount = typeAmounts[type];
				}

				// Get Number
				Integer number = numbers.get(ran.nextInt(numbers.size()));

				// Get Image
				BufferedImage hexImage = ImageHandler.loadImage("/images/hex" + fileNameKey[type] + ".png");

				// Modify image with number
				Graphics imageGraphics = hexImage.getGraphics();

				imageGraphics.setColor(Color.MAGENTA);
				imageGraphics.setFont(new Font("Carlito", Font.BOLD, 120));
				String drawString = "" + number;
				imageGraphics.drawString(drawString, hexImage.getWidth() / 2 - drawString.length() * 30,
						hexImage.getHeight() / 2 + 30);

				// Add the object
				hexes.add(new Hex(x, y, type, number, hexImage));

				// Clean up
				numbers.remove(number);
				typeAmounts[type]--;
			} else {
				// Get X and Y Coordinates
				int x = (int) (hexPositions[i][0] * scale) + 0;
				int y = (int) (hexPositions[i][1] * scale) + 0;

				// Set Image
				BufferedImage hexImage = ImageHandler.loadImage("/images/hex" + fileNameKey[0] + ".png");

				hexes.add(new Hex(x, y, 0, 0, hexImage));
			}
		}
	}

	// Basic rendering and updating methods
	@Override
	public void render(Graphics graphics) {
		// Render all of the hexes
		for (Hex value : hexes) {
			value.render(graphics);
		}
	}

	@Override
	public void update() {

	}

	// Getters and Setters
	public ArrayList<Hex> getHexes() {
		return hexes;
	}
}

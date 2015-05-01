package friedman.snake;

import java.util.LinkedList;
import java.util.Random;

public class Food {
	private SnakeBodyPiece food;
	private int height;
	private int width;
	private int size;
	private Random r;

	public Food(int height, int width, int big, LinkedList<SnakeBodyPiece> snake) {
		r = new Random();
		this.height = height;
		this.width = width;
		this.size = big;
		int randomX = r.nextInt(width) + 1;
		int randomY = r.nextInt(height) + 1;
		SnakeBodyPiece seg = new SnakeBodyPiece(randomX * size, randomY * size, size);

		for (SnakeBodyPiece p : snake) {
			if (p.equals(seg)) {
				randomX = r.nextInt(width) + 1;
				randomY = r.nextInt(height) + 1;
				seg = new SnakeBodyPiece(randomX * size, randomY * size, size);
			}
		}
		food = seg;
	}

	public SnakeBodyPiece getFood() {
		return food;
	}

	public void setFood() {
		int randomX = r.nextInt(width) + 1;
		int randomY = r.nextInt(height) + 1;
		food = new SnakeBodyPiece(randomX * size, randomY * size, size);
	}

}
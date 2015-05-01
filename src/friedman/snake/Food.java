package friedman.snake;

import java.util.LinkedList;
import java.util.Random;

public class Food {
	private SnakeBodyPiece fruit;
	private int height;
	private int width;
	private int size;
	private Random randomGenerator;
//	private Random x;
//	private Random y;

	// private LinkedList<Segmant> list;

	public Food(int height, int width, int big, LinkedList<SnakeBodyPiece> list) {
		// this.list = list;
	//	x = new Random();
	//	y = new Random();
		randomGenerator = new Random();
		this.height = height;
		this.width = width;
		this.size = big;
		int randomX = randomGenerator.nextInt(width) + 1;
		int randomY = randomGenerator.nextInt(height) + 1;
		SnakeBodyPiece seg = new SnakeBodyPiece(randomX * size, randomY * size, size);

		for (SnakeBodyPiece p : list) {
			if (p.equals(seg)) {
				randomX = randomGenerator.nextInt(width) + 1;
				randomY = randomGenerator.nextInt(height) + 1;
				seg = new SnakeBodyPiece(randomX * size, randomY * size, size);
			}
		}
		fruit = seg;
	}

	public SnakeBodyPiece getFood() {
		return fruit;
	}

	public void setFruit() {
		int randomX = randomGenerator.nextInt(width) + 1;
		int randomY = randomGenerator.nextInt(height) + 1;
		fruit = new SnakeBodyPiece(randomX * size, randomY * size, size);
	}

}
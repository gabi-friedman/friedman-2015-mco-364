package friedman.snake;

import java.util.LinkedList;

public class Snake {

	private LinkedList<SnakeBodyPiece> snake;

	public Snake(int boxSize) {
		snake = new LinkedList<SnakeBodyPiece>();

		snake.add(new SnakeBodyPiece(45, 15, boxSize));
		snake.add(new SnakeBodyPiece(30, 15, boxSize));
		snake.add(new SnakeBodyPiece(15, 15, boxSize));
	}

	public LinkedList<SnakeBodyPiece> getSnake() {
		return snake;
	}

	public boolean contains(SnakeBodyPiece sbp) {
		boolean contains = false;
		for (SnakeBodyPiece p : snake) {
			if (p.equals(sbp)) {
				contains = true;
				break;
			}
		}
		return contains;
	}

	public void clear() {
		snake.clear();
	}

	public SnakeBodyPiece getHead() {
		return snake.peekFirst();
	}

	public void removeLast() {
		snake.removeLast();
	}

	public void pushHead(SnakeBodyPiece sbp) {
		snake.push(sbp);
	}

	public int getSize() {
		return snake.size();
	}

}
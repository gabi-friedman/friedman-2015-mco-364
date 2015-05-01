package friedman.snake;

import java.awt.Color;
import java.awt.Graphics;

public class World {

	private final int boxSize = 15;
	private final int gridW = 40;
	private final int gridH = 40;

	private Snake s;
	private Food f;
	private Direction dir;

	private boolean gameOver;
	private boolean gameWon;

	public World() {
		dir = Direction.NO_DIRECTION;
		s = new Snake(boxSize);
		f = new Food(gridW, gridH, boxSize, s.getSnake());
		gameOver = false;
		gameWon = false;
	}

	public void makeSnake() {
		s.clear();
		s = new Snake(boxSize);
		dir = Direction.NO_DIRECTION;
	}

	public void makeFood() {
		f = new Food(gridW, gridH, boxSize, s.getSnake());
	}

	public void draw(Graphics g) {
		if (gameOver) {
			g.drawString("Game Over!", 150, 150);
			g.drawString("Press ENTER to restart", 150, 170);
		} 
		else if (gameWon) {
			g.drawString("Woohoo!!!! U win!!!", 150, 150);
			g.drawString("Press ENTER to restart", 150, 170);

		} 
		else {
			g.setColor(Color.CYAN);
			g.fillRect(boxSize, boxSize, gridW * boxSize, gridH * boxSize);

			g.setColor(Color.GREEN);
			for (SnakeBodyPiece p : s.getSnake()) {
				g.fillRect(p.getX(), p.getY(), p.getDirection(), p.getDirection());
			}
			g.setColor(Color.RED);

			g.fillRect(f.getFood().getX(), f.getFood().getY(), boxSize, boxSize);
		}

	}

	public void move() {
		SnakeBodyPiece head = s.getHead();
		SnakeBodyPiece newPoint = head;
		switch (dir) {
		case NO_DIRECTION:{
			return;
		}
		case NORTH:{
			newPoint = new SnakeBodyPiece(head.getX(), head.getY() - boxSize, boxSize);
			break;
		}
		case SOUTH:{
			newPoint = new SnakeBodyPiece(head.getX(), head.getY() + boxSize, boxSize);
			break;
		}
		case WEST:{
			newPoint = new SnakeBodyPiece(head.getX() - boxSize, head.getY(), boxSize);
			break;
		}
		case EAST:{
			newPoint = new SnakeBodyPiece(head.getX() + boxSize, head.getY(), boxSize);
			break;
		}
		}
		s.removeLast();
		if (newPoint.equals(f.getFood())) {
			SnakeBodyPiece addPoint = new SnakeBodyPiece(newPoint.getX(), newPoint.getY(), newPoint.getDirection());// newPoint;
			s.pushHead(addPoint);
			makeFood();

		} 
		else if (newPoint.getX() < boxSize
				|| newPoint.getX() > gridW * boxSize) {
			gameOver = true;
			makeSnake();
			return;
		} 
		else if (newPoint.getY() < boxSize
				|| newPoint.getY() > gridH * boxSize) {
			gameOver = true;
			makeSnake();
			return;

		} 
		else if (s.contains(newPoint)) {
			gameOver = true;
			makeSnake();
			return;
		} 
		else if (s.getSize() == gridH * gridW) {
			gameWon = true;
			return;
		}

		s.pushHead(newPoint);
	}

	public void setDirection(Direction dir) {
		this.dir = dir;
	}

	public boolean getGameOver() {
		return gameOver;
	}

	public void setGameOver(boolean gameOver) {
		this.gameOver = gameOver;
	}

	public boolean getGameWon() {
		return gameWon;
	}

	public void setGameWon(boolean gameWon) {
		this.gameWon = gameWon;
	}

}
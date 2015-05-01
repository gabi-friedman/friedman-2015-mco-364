package friedman.snake;

public class SnakeBodyPiece {

	private int x;
	private int y;
	private int direction;

	public SnakeBodyPiece(int x, int y, int direction) {
		this.x = x;
		this.y = y;
		this.direction = direction;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getDirection() {
		return direction;
	}

	public void setDirection(int d) {
		this.direction = d;
	}

	public boolean equals(SnakeBodyPiece s) {
		if (x == s.getX() && y == s.getY()) {
			return true;
		} 
		else {
			return false;
		}
	}
}
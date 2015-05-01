package friedman.snake;

public enum Direction {

	NO_DIRECTION(0), NORTH(1), SOUTH(2), WEST(3), EAST(4);
	private int num;

	private Direction(int num) {
		this.num = num;
	}

	public int getDirection() {
		return num;
	}
}
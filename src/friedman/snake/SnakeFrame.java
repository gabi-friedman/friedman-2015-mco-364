package friedman.snake;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class SnakeFrame extends JFrame implements KeyListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Direction dir;
	private World w;
	private WorldComponent wc;

	public SnakeFrame() {
		setSize(645, 670);
		setTitle("Snake Game!! :)__--__--");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());
		
		w = new World();
		wc = new WorldComponent(w);
		wc.addKeyListener(this);
		wc.setFocusable(true);
		contentPane.add(wc);
		
		dir = Direction.NO_DIRECTION;
	}

	public Direction getDirection() {
		return dir;
	}

	public WorldComponent getWorldComponent() {
		return wc;
	}

	public static void main(String[] args) {
		final SnakeFrame snake = new SnakeFrame();
		snake.setVisible(true);
		GameLoopThread t = new GameLoopThread(snake);
		t.start();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case (KeyEvent.VK_UP):
		case (KeyEvent.VK_8):
			if (dir != Direction.SOUTH) {
				dir = Direction.NORTH;
			}
			break;
		case (KeyEvent.VK_DOWN):
		case (KeyEvent.VK_2):
			if (dir != Direction.NORTH) {
				dir = Direction.SOUTH;
			}
			break;
		case (KeyEvent.VK_RIGHT):
		case (KeyEvent.VK_6):
			if (dir != Direction.WEST) {
				dir = Direction.EAST;
			}
			break;
		case (KeyEvent.VK_LEFT):
		case (KeyEvent.VK_4):
			if (dir != Direction.EAST) {
				dir = Direction.WEST;
			}
			break;
		case (KeyEvent.VK_ENTER):
			if (w.isGameOver()) {
				w.setGameOver(false);
				dir = Direction.NO_DIRECTION;
				w.makeSnake();
			}
			if (w.isWonGame()) {
				w.setWonGame(false);
				dir = Direction.NO_DIRECTION;
				w.makeSnake();
			}
			break;

		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		//not needed
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		//not needed
	}
}
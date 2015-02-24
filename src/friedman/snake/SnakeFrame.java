package friedman.snake;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class SnakeFrame extends JFrame implements KeyListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int direction;
	private World w;
	private WorldComponant wc;
	GameLoopThread glt;

	public SnakeFrame(){
		setSize(420,440);
		setTitle("Snake");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container c = getContentPane();
		c.setLayout(new BorderLayout());

		w = new World();
		wc = new WorldComponant(w);
		glt = new GameLoopThread(wc);
		direction = Direction.SOUTH;

		
		wc.addKeyListener(this);
		wc.setFocusable(true);
		c.add(wc);
	}

	public static void main(String[] args){
		SnakeFrame s = new SnakeFrame();
		s.setVisible(true);
	}

	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()){
		case (KeyEvent.VK_UP):{
			System.out.println("up");
			if(direction!=Direction.SOUTH){
				direction = Direction.NORTH;
				wc.move(direction);
			}
			break;
		}
		case (KeyEvent.VK_DOWN):{
			System.out.println("down");
			if(direction!=Direction.NORTH){
				direction = Direction.SOUTH;
				wc.move(direction);
			}
			break;
		}
		case (KeyEvent.VK_RIGHT):{
			System.out.println("right");
			if(direction!=Direction.WEST){
				direction = Direction.EAST;
				wc.move(direction);
			}
			break;
		}
		case (KeyEvent.VK_LEFT):{
			System.out.println("left");
			if(direction!=Direction.EAST){
				direction = Direction.WEST;
				wc.move(direction);
			}
			break;
		}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
	
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}


}

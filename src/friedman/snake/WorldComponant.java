package friedman.snake;

import java.awt.Graphics;

import javax.swing.JComponent;

public class WorldComponant extends JComponent {
	
	//responsible for drawing all stuff to screen 

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private World world;
	
	public WorldComponant(World world){
		this.world = world;
	}
	
	public World getWorld(){
		return this.world;
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);		
		world.drawFood(g);
		world.drawGrid(g);
		world.drawSnake(g);
		world.drawScore(g);
	}
	
	public void move(int direction){
		world.move(direction);
	}
	
}

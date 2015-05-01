package friedman.snake;

import java.awt.Graphics;

import javax.swing.JComponent;

public class WorldComponent extends JComponent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private World world;

	public WorldComponent(World world) {
		this.world = world;
	}

	public World getWorld() {
		return world;
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		world.draw(g);
	}

}
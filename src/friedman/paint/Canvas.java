package friedman.paint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class Canvas extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BufferedImage image;
	private Point mousePressed;
	private Point mouseDragged;
	private Color color;

	public Canvas(int width, int height) {
		image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		image.getGraphics().setColor(Color.WHITE);
		image.getGraphics().fillRect(0, 0, width, height);

	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, 0, 0, null);

		if (mousePressed != null && mouseDragged != null) {
			int x = Math.min(mousePressed.x, mouseDragged.x);
			int y = Math.min(mousePressed.y, mouseDragged.y);
			int width = Math.abs(mousePressed.x - mouseDragged.x);
			int height = Math.abs(mousePressed.y - mouseDragged.y);
			int location = x+ width;
			if (location > 600){
				int over = location - 600;
				width -=over;
			}
			location = y + height;
			if (location > 600){
				int over = location - 600;
				height -=over;
			}
			
			
			g.setColor(color);
			g.drawRect(x, y, width, height);
		}

	}

	public BufferedImage getImage() {
		return image;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public void setMousePressed(Point mousePressed) {
		this.mousePressed = mousePressed;
	}

	public void setMouseDragged(Point mouseDragged) {
		this.mouseDragged = mouseDragged;
	}
}
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
	public static final int WIDTH = 600;
	public static final int HEIGHT = 600;
	
	private BufferedImage image;
	private Point mousePressed;
	private Point mouseDragged;
	private Color color;
	private BrushListener listener;

	public Canvas(int width, int height) {
		image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		image.getGraphics().setColor(Color.WHITE);
		image.getGraphics().fillRect(0, 0, width, height);
	}

	@Override
	protected void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);
		graphics.drawImage(image, 0, 0, null);
		if (listener != null && mousePressed != null) {
			listener.draw(graphics);
		}
	}
	
	public void setMousePressed(Point mousePressed) {
		this.mousePressed = mousePressed;
	}

	public void setMouseDragged(Point mouseDragged) {
		this.mouseDragged = mouseDragged;
	}

	public BrushListener getListener() {
		return listener;
	}

	public BufferedImage getImage() {
		return image;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public void setBrushListener(BrushListener brushListener) {
		this.listener = brushListener;
	}
}
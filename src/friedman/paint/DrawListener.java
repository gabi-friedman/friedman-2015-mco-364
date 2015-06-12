package friedman.paint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class DrawListener implements MouseListener, MouseMotionListener {

	private Canvas canvas;
	
	private Color color;
	private int number;
	
	private Point mousePressed;
	private Point mouseDragged;
	
	private int prevX;
	private int prevY;
	private int endX;
	private int endY;
	private int draggedX;
	private int draggedY;

	public DrawListener(Canvas canvas) {
		this.canvas = canvas;
		this.color = Color.BLACK;
		canvas.setColor(color);
		this.number = 1;
	}
	
	@Override
	public void mousePressed(MouseEvent event) {
		mousePressed = event.getPoint();

		int x = event.getX();
		int y = event.getY();

		Graphics graphics = canvas.getImage().getGraphics();
		graphics.setColor(color);
		canvas.setColor(color);
		graphics.drawLine(x, y, x, y);
		prevX = x;
		prevY = y;
		canvas.repaint();
	}

	@Override
	public void mouseReleased(MouseEvent event) {
		if (number != 1) {
			
			Graphics graphics = canvas.getImage().getGraphics();
			graphics.setColor(color);
			
			int x = Math.min(mousePressed.x, mouseDragged.x);
			int y = Math.min(mousePressed.y, mouseDragged.y);
			int width = Math.abs(mousePressed.x - mouseDragged.x);
			int height = Math.abs(mousePressed.y - mouseDragged.y);
			
			graphics.drawRect(x, y, width, height);
			canvas.setMouseDragged(null);
		}
		canvas.repaint();
	}

	@Override
	public void mouseDragged(MouseEvent event) {

		mouseDragged = event.getPoint();
		canvas.setMouseDragged(mouseDragged);
		
		int x = event.getX();
		int y = event.getY();
		draggedX = event.getX();
		draggedY = event.getY();
		endX = x - prevX;
		endY = y - prevY;
		
		Graphics graphics = canvas.getImage().getGraphics();
		graphics.setColor(color);
		
		if (number == 1) {
			canvas.setMouseDragged(null);
			graphics.drawLine(prevX, prevY, x, y);
			prevX = x;
			prevY = y;
			
			canvas.repaint();
		} 
		else {
			canvas.setMousePressed(mousePressed);
		}
		canvas.repaint();
	}

	public Point getMousePressed() {
		return mousePressed;
	}

	public Point getMouseDragged() {
		return mouseDragged;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
	
	@Override
	public void mouseClicked(MouseEvent event) {}
	@Override
	public void mouseEntered(MouseEvent event) {}
	@Override
	public void mouseExited(MouseEvent event) {}
	@Override
	public void mouseMoved(MouseEvent arg0) {}

}
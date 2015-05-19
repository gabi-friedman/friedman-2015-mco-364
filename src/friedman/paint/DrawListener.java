package friedman.paint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class DrawListener implements MouseListener, MouseMotionListener {

	private Canvas canvas;
	private int prevX;
	private int prevY;
	private int endX;
	private int endY;
	private int draggedX;
	private int draggedY;
	private Point mousePressed;
	private Point mouseDragged;
	
	private Mode mode;
	private Color color;

	public DrawListener(Canvas canvas) {
		this.canvas = canvas;
		this.color = Color.BLACK;
		canvas.setColor(color);
		this.mode = Mode.LINE;
	}

	@Override
	public void mouseClicked(MouseEvent event) {

	}
	@Override
	public void mouseEntered(MouseEvent arg0) {

	}
	@Override
	public void mouseExited(MouseEvent arg0) {

	}
	public Point getMousePressed() {
		return mousePressed;
	}
	public Point getMouseDragged() {
		return mouseDragged;
	}
	@Override
	public void mouseMoved(MouseEvent arg0) {

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
	public void mouseReleased(MouseEvent arg0) {
		if (mode.equals(Mode.RECTANGLE)) {
			Graphics graphics = canvas.getImage().getGraphics();
			graphics.setColor(color);
			int x = Math.min(mousePressed.x, mouseDragged.x);
			int y = Math.min(mousePressed.y, mouseDragged.y);
			int width = Math.abs(mousePressed.x - mouseDragged.x);
			int height = Math.abs(mousePressed.y - mouseDragged.y);
			graphics.drawRect(x, y, width, height);
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
		
		if(mode.equals(Mode.RECTANGLE)) {
			canvas.setMousePressed(mousePressed);
		}
		
		else if (mode.equals(Mode.LINE)) {
			canvas.setMouseDragged(null);
			graphics.drawLine(prevX, prevY, x, y);

			prevX = x;
			prevY = y;
			canvas.repaint();
		} 
		
		
		canvas.repaint();
	}

	
	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public String getMode() {
		return mode.toString();
	}

	public void setMode(Mode modes) {
		this.mode = modes;
	}

}
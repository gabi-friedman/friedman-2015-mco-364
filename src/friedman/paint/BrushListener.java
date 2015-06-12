package friedman.paint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public abstract class BrushListener implements MouseListener, MouseMotionListener {

	protected Canvas canvas;
	
	protected int startX;
	protected int startY;
	protected int endX;
	protected int endY;
	
	protected Point mousePressed;
	protected Point mouseDragged;
	
	protected Graphics graphics;
	
	private boolean pressed;

	public BrushListener(Canvas canvas) {
		this.canvas = canvas;
		graphics = this.canvas.getImage().getGraphics();
		graphics.setColor(Color.BLACK);
	}

	@Override
	public void mouseDragged(MouseEvent event) {
		mouseDragged = event.getPoint();
		canvas.repaint();
	}
	
	@Override
	public void mousePressed(MouseEvent event) {
		mousePressed = event.getPoint();
		canvas.setMousePressed(mousePressed);
		setPressed(true);
		startX = mousePressed.x;
		startY = mousePressed.y;
	}

	@Override
	public void mouseReleased(MouseEvent event) {		
		canvas.getListener().draw(graphics);
		setPressed(false);
		canvas.setMousePressed(null);
		canvas.setMouseDragged(null);
		mousePressed =null;
		mouseDragged = null;
	}
	
	public boolean isPressed() {
		return pressed;
	}

	public void setPressed(boolean pressed) {
		this.pressed = pressed;
	}
	
	public abstract void draw(Graphics g);

	@Override
	public void mouseMoved(MouseEvent event) {}
	@Override
	public void mouseClicked(MouseEvent event) {}
	@Override
	public void mouseEntered(MouseEvent event) {}
	@Override
	public void mouseExited(MouseEvent event) {}
}
package friedman.finalpaint;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public abstract class BrushListener implements MouseListener, MouseMotionListener {
	
	private Canvas canvas;
	
	protected int startX;
	protected int startY;
	protected int lastX;
	protected int lastY;
	
	public BrushListener(Canvas canvas) {
		this.canvas = canvas;
	}
	
	@Override
	public void mouseDragged(MouseEvent event) {
		int lastX = event.getX();
		int lastY = event.getY();
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		int startX = e.getX();
		int startY = e.getY();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		draw(canvas.getImage().getGraphics());
	}

	abstract public void draw(Graphics g);

}

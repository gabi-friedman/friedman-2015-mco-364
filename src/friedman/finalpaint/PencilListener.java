package friedman.finalpaint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class PencilListener implements MouseListener, MouseMotionListener {
	
	private Canvas canvas;
	private int lastX;
	private int lastY;
	
	public PencilListener(Canvas canvas) {
		this.canvas = canvas;
	}
	
	@Override
	public void mouseDragged(MouseEvent event) {
		int x = event.getX();
		int y = event.getY();
		
		Graphics graphics = canvas.getImage().getGraphics();
		graphics.setColor(Color.BLACK);
		graphics.drawLine(lastX,lastY,x,y);
		lastX = x;
		lastY = y;
		canvas.repaint();
	}
	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent event) {
		int x = event.getX();
		int y = event.getY();
		
		Graphics graphics = canvas.getImage().getGraphics();
		graphics.setColor(Color.BLACK);
		graphics.drawLine(x,y,x,y);
		lastX = x;
		lastY = y;
		canvas.repaint();		
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}

package friedman.finalpaint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class Canvas extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BufferedImage image;
	private BrushListener listener;
	
	public Canvas(int width, int height){
		image = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
		Graphics graphics = image.getGraphics();
		graphics.setColor(Color.WHITE);
		graphics.fillRect(0, 0, width, height);
	}
	
	@Override
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(image, 0, 0, null);
		listener.draw(g);
	}
	
	public BufferedImage getImage() {
		return image;
	}
	
	public void setBrushListener(BrushListener listener) {
		this.listener = listener;
	}

}

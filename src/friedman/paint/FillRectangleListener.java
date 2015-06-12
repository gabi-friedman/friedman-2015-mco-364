package friedman.paint;

import java.awt.Graphics;

public class FillRectangleListener extends BrushListener{

	public FillRectangleListener(Canvas canvas) {
		super(canvas);
	}

	@Override
	public void draw(Graphics g) {
		int x = Math.min(mousePressed.x, mouseDragged.x);
		int y = Math.min(mousePressed.y, mouseDragged.y);
		int width = Math.abs(mousePressed.x - mouseDragged.x);
		int height = Math.abs(mousePressed.y - mouseDragged.y);
		
		int location = x + width;
		if (location > 600){
			int offCanvas = location -600;
			width -= offCanvas;
		}
		location = y + height;
		if (location > 600){
			int offCanvas = location - 600;
			height -= offCanvas;
		}
		
		g.fillRect(x, y, width, height);
		
	}

}
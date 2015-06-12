package friedman.finalpaint;

import java.awt.Graphics;

public class RectangleListener extends BrushListener {
	
	public RectangleListener(Canvas canvas) {
		super(canvas);
	}

	@Override
	public void draw(Graphics g) {
		g.drawRect(startX, startY, lastX-startX, lastY-startY);
	}

}

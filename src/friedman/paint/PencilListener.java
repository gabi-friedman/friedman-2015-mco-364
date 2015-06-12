package friedman.paint;

import java.awt.Graphics;

public class PencilListener extends BrushListener{

	public PencilListener(Canvas canvas) {
		super(canvas);
	}

	@Override
	public void draw(Graphics g) {

		if (mouseDragged != null){
			graphics.drawLine(startX, startY,  mouseDragged.x, mouseDragged.y);
			startX = mouseDragged.x;
			startY = mouseDragged.y;
		}


	}

}
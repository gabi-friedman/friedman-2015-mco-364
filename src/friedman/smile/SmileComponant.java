package friedman.smile;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

public class SmileComponant extends JComponent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//private boolean wink = false;
	boolean wink = false;
	private double x;
	private int w;
	private int h;
	private boolean firstRound = true;


	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		w = getWidth();
		h = getHeight();
		if(firstRound){
			firstRound = false;
			x = h * .08;
		}

		g.setColor(Color.YELLOW);
		g.fillOval((int) (w * .01), (int) (h * .01), (int) (w * .98), (int) (h * .98));
		g.setColor(Color.RED);
		g.drawArc((int) ((w * .3)), (int) ((h * .02)), (int) ((w * .4)), (int) ((h * .7)), 190, 160);
		g.setColor(Color.GREEN);
		g.fillOval((int) (w * .38), (int) (h * .18), (int) (w * .1), (int) (h * .1));
		g.fillOval((int) (w * .58), (int) (h * .18), (int) (w * .1), (int) (h * .1));

		if(!wink){
			g.setColor(Color.YELLOW);
			g.fillOval((int) (w*.58), (int) x++, (int) (w*.1), (int) (h*.1));
			if(x >= h*.18){
				x = h*.08;
			}
			wink = false;	
		}

		/*if (!wink) {
			g.setColor(Color.PINK);
			g.fillOval((int) (w * .58), (int) (h * x), (int) (w * .1), (int) (w * .1));
			// g.setColor(Color.BLACK);
			// g.drawArc((int)(w*.58), x, 50, 50, 180, 180);

			if (x >= (int) (h *.18)) {
				g.setColor(Color.BLUE);
				x = .01;
			}
			x = x + 1;
		}

		wink = !wink;
		 */

		/*
		 * if(!wink){ g.fillOval(330,205, 50, 50); wink=true; } else{
		 * g.setColor(Color.black); g.drawArc(325, 195, 60, 60, 175, 190);
		 * wink=false; }
		 */

	}

}

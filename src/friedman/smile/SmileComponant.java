package friedman.smile;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

public class SmileComponant extends JComponent {

	boolean wink = false;
	int x = 167;
	

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);

		g.setColor(Color.YELLOW);
		g.fillOval(200, 100, 400, 400);
		g.setColor(Color.RED);
		g.drawArc(250, 150, 300, 300, 190, 160);
		g.setColor(Color.GREEN);
		g.fillOval(430,205, 50, 50);
		g.fillOval(330,205, 50, 50);
		if(!wink){
			g.setColor(Color.YELLOW);
			g.fillOval(430, x++, 50, 50);
			g.setColor(Color.BLACK);
			g.drawArc(430, x, 50, 50, 180, 180);
		if(x == 207){
			x= 167;
			g.setColor(Color.RED);
			g.drawLine(285, 327, 225, 327);
			g.drawLine(575, 327, 515, 327);		
		}
		wink = false;
	}
		/*if(!wink){
			g.fillOval(330,205, 50, 50);
			wink=true;
		}
		else{
			g.setColor(Color.black);
			g.drawArc(325, 195, 60, 60, 175, 190);
			wink=false;
		}*/




	}




}

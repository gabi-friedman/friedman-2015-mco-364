package friedman.snake;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Random;

import javax.swing.JComponent;
import javax.swing.JOptionPane;

public class World extends JComponent{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Snake snake;
	private Food food;
	
	private final int boxh = 15;
	private final int boxw = 15;
	private final int gridh = 25;
	private final int gridw = 25;
	
	private int score = 0;
	
	public World(){
		
		food = new Food();
		snake = new Snake();
		generateDefaultSnake();
		placeFood();
		
		
	}
	
	public void drawScore(Graphics g){
		g.drawString("Score: " + score, 0, boxh*gridh + 10);
	}

	public void drawGrid(Graphics g){
		g.drawRect(0,0,gridw * boxw, gridh*boxh);
		for(int i = boxw; i < gridw* boxw; i+=boxw){
			g.drawLine(i, 0, i, boxh*gridh);
		}
		for(int i = boxh; i < gridh* boxh; i+=boxh){
			g.drawLine(0, i, gridw*boxw, i);
		}
	}

	public void drawSnake(Graphics g){
		g.setColor(Color.GREEN);
		Point p;
		for(int i = 0; i < snake.size(); i++){
			p = snake.get(i);
			g.fillRect(p.x * boxw, p.y * boxh, boxw, boxh);
		}
		g.setColor(Color.BLACK);
	}

	public void drawFood(Graphics g){
		g.setColor(Color.RED);
		int x = food.getX();
		int y = food.getY();
		g.fillOval(x * boxw, y * boxh, boxw, boxh);
		g.setColor(Color.BLACK);
	}

	public void generateDefaultSnake(){
		score = 0;
		snake.clear();

		snake.add(new Point(2,3));
		snake.add(new Point(2,2));
		snake.add(new Point(2,1));
	}

	public void placeFood(){

		Random num = new Random();

		int xRand = num.nextInt(gridw);
		int yRand = num.nextInt(gridh);
		Point random = new Point(xRand,yRand);
		while(snake.contains(random)){
			xRand = num.nextInt(gridw);
			yRand = num.nextInt(gridh);
			random = new Point(xRand,yRand);
		}
		food.setLocation(random);
	}
	

	public void move(int direction) {
		Point head = snake.peekFirst();
		Point newPt = new Point();
		switch(direction){
		case (Direction.NORTH):{
			newPt = new Point(head.x, head.y+1);
			break;
		}
		case (Direction.SOUTH):{
			newPt = new Point(head.x, head.y-1);
			break;
		}
		case (Direction.WEST):{
			newPt = new Point(head.x-1, head.y);
			break;
		}
		case (Direction.EAST):{
			newPt = new Point(head.x+1, head.y);
			break;
		}

		}

		snake.removeLast();

		if(newPt.equals(food)){
			Point addPt = (Point) newPt.clone(); 

			switch(direction){
			case (Direction.NORTH):{
				newPt = new Point(head.x, head.y+1);
				break;
			}
			case (Direction.SOUTH):{
				newPt = new Point(head.x, head.y-1);
				break;
			}
			case (Direction.WEST):{
				newPt = new Point(head.x-1, head.y);
				break;
			}
			case (Direction.EAST):{
				newPt = new Point(head.x+1, head.y);
				break;
			}

			}
			score++;
			snake.add(addPt);
			placeFood();

		}
		else if(newPt.x < 0 || newPt.x > gridw - 1){
			generateDefaultSnake();
			JOptionPane.showMessageDialog(null, "YOU LOST! :(", "Loser!", JOptionPane.ERROR_MESSAGE);
			return;
		}
		else if(newPt.y < 0 || newPt.y > gridh - 1){
			generateDefaultSnake();
			JOptionPane.showMessageDialog(null, "YOU LOST! :(", "Loser!", JOptionPane.ERROR_MESSAGE);
			return;
		}
		else if(snake.contains(newPt)){
			generateDefaultSnake();
			JOptionPane.showMessageDialog(null, "YOU LOST! :(", "Loser!", JOptionPane.ERROR_MESSAGE);
			return;
		}

		snake.add(newPt);

	}
}

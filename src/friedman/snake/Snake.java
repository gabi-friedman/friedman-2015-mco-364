package friedman.snake;

import java.awt.Point;
import java.util.LinkedList;

public class Snake {
	
	private LinkedList<Point> snake;
	
	public Snake(){
		snake = new LinkedList<Point>();
	}
	
	public void add(Point p){
		snake.push(p);
	}
	
	public boolean contains(Point p){
		return snake.contains(p);		
	}
	
	public Point peekFirst(){
		return snake.peekFirst();
	}
	
	public Point peekLast(){
		return snake.peekLast();
	}
	
	public Point get(int index){
		return snake.get(index);
	}
	
	
	public void remove(Point p){
		snake.remove(p);
	}
	
	public void removeLast(){
		snake.remove(snake.peekLast());
	}
	
	public void clear(){
		snake.clear();
	}
	
	public int size(){
		return snake.size();
	}

}

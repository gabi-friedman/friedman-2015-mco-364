package friedman.snake;

public class GameLoopThread extends Thread{

	private WorldComponant sc;
	
	public GameLoopThread(WorldComponant sc){
		this.sc = sc;
	}
	
	
	
	public void run(){
		while(true){
			sc.repaint();
			try{
				Thread.sleep(100);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
}

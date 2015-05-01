package friedman.snake;

public class GameLoopThread extends Thread {

	private SnakeFrame comp;

	public GameLoopThread(SnakeFrame component) {
		comp = component;
	}

	public void run() {
		while (true) {
			comp.getWorldComponent().getWorld()
					.setDirection(comp.getDirection());
			comp.getWorldComponent().getWorld().move();
			comp.repaint();
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
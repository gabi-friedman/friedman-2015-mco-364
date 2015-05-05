package friedman.multichat;

import java.io.IOException;

public class Main {
	
	//private int numFrames = 3;

	public static void main(String[] args) {

		Thread thread1 = new Thread() {
			@Override
			public void run() {
				try {
					new Server();
				}
				catch (IOException e) {
					e.printStackTrace();
				}
			}
		};
		thread1.start();

		for (int i = 0; i < 3; i++) {
			Thread thread2 = new Thread() {
				@Override
				public void run() {
					try {
						new Client();
					}
					catch (IOException e) {
						e.printStackTrace();
					}
				}
			};
			thread2.start();
		}

	}

}
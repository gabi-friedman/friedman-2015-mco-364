package friedman.smile;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;

public class Smile extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Smile(){
		setSize(400,400); //width then height
		setTitle("SMILE :)");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container  contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());
		SmileComponant sc = new SmileComponant();
		
		contentPane.add(sc,BorderLayout.CENTER);
	}

	public static void main(String[] args){
		Smile smile = new Smile();
		smile.setVisible(true);
		//animation thread 
		Thread t = new Thread(){
			public void run(){
				while(true){
					smile.repaint();
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
			}
		};

		t.start();
	}
}

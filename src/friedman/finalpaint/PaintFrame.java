package friedman.finalpaint;

import java.awt.BorderLayout;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class PaintFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ModeButton pencilButton;
	private ModeButton rectangleButton;
	
	public PaintFrame() {
		setSize(800,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setLayout(new BorderLayout());
		Canvas canvas = new Canvas(600,600);
		add(canvas, BorderLayout.CENTER);
		
		BrushListener listener = new RectangleListener(canvas);
		canvas.addMouseListener(listener);
		canvas.addMouseMotionListener(listener);
		
		ActionListener actionListener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent event) {
				ModeButton button = (ModeButton) event.getSource();
				BrushListener listener = button.getListener();
				canvas.setBrushListener(listener);
				canvas.addMouseListener(listener);
				canvas.addMouseMotionListener(listener);				
			}
		};
		
		rectangleButton = new ModeButton(new RectangleListener(canvas));
		rectangleButton.addActionListener(actionListener);
		
		rectangleButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				RectangleListener listener = new RectangleListener(canvas);
				canvas.setBrushListener(listener);
				canvas.addMouseListener(listener);
				canvas.addMouseMotionListener(listener);
				
			}
			
		});
	}
	
	public static void main(String[] args){
		new PaintFrame().setVisible(true);
	}
}

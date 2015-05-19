package friedman.paint;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PaintFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	public static final int WIDTH = 600;
	public static final int HEIGHT = 600;
	private Canvas canvas;
	private DrawListener dl;

	private Colors[] colors;
	private JButton[] colorBtns;
	private Mode[] modes;
	private JButton[] modeBtns;
	
	private JPanel modeLayout;
	private JPanel colorLayout;

	public PaintFrame() {

		setSize(700, 700);
		setTitle("Paint!");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		colors = Colors.values();

		colorBtns = new JButton[colors.length];
		for(int i = 0; i < colors.length; i++){
			colorBtns[i] = new JButton();
			colorBtns[i].setBackground(colors[i].getColor());
			colorBtns[i].addActionListener(colorButtonListener);
		}

		modes = Mode.values();
		modeBtns = new JButton[Mode.values().length];
		for(int i = 0; i < modeBtns.length; i++){
			modeBtns[i] = new JButton();
			modeBtns[i].setText(modes[i].toString());
			modeBtns[i].addActionListener(changeMode);
		}		

		setLayout(new BorderLayout());
		canvas = new Canvas(WIDTH, HEIGHT);
		dl = new DrawListener(canvas);
		canvas.addMouseListener(dl);
		canvas.addMouseMotionListener(dl);


		add(canvas, BorderLayout.CENTER);

		colorLayout = new JPanel();
		modeLayout = new JPanel();
		colorLayout.setLayout(new GridLayout(1,13));
		modeLayout.setLayout(new GridLayout(1,2));
		putButtonsInLayout();
		
		Container north = new Container();
		north.setLayout(new GridLayout(2,1));
		north.add(colorLayout);
		north.add(modeLayout);
		add(north, BorderLayout.NORTH);


	}

	ActionListener colorButtonListener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			for (int i = 0; i < colors.length; i++) {
				if (e.getSource().equals(colors[i])) {
					dl.setColor(colorBtns[i].getBackground());
					System.out.println(dl.getColor());
					System.out.println("In AL");
				}
			}
		}
	};

	ActionListener changeMode = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton clicked = (JButton) e.getSource();
			for(int i = 0; i < modes.length; i++){
				if (clicked.getText().equals(modes[i])){
					dl.setMode(modes[i]);

					System.out.println("In AL");
				}
			}
		}

	};

	
	public void putButtonsInLayout(){
		for(int i = 0; i < colors.length; i++){
			colorLayout.add(colorBtns[i]);
		}

		for(int i = 0; i < modeBtns.length; i++){
			modeLayout.add(modeBtns[i]); 
		}
	}

}
package friedman.paint;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class PaintFrame extends JFrame {

	public static final int WIDTH = 600;
	public static final int HEIGHT = 600;
	private Canvas canvas;
	private DrawListener dl;

	private JPanel modeLayout;
	private JPanel colorLayout;

	private ModeButton pencil;
	private ModeButton fillRect;
	private ModeButton emptyRect;
	private JButton refresh;

	public PaintFrame() {

		setSize(700, 700);
		setTitle("Paint!");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setLayout(new BorderLayout());
		canvas = new Canvas(600, 600);
		add(canvas, BorderLayout.CENTER);

		ColorButton[] colors = {new ColorButton(Color.RED),
				new ColorButton(Color.ORANGE),
				new ColorButton(Color.YELLOW),
				new ColorButton(Color.GREEN),
				new ColorButton(Color.CYAN),
				new ColorButton(Color.BLUE),
				new ColorButton(Color.MAGENTA),
				new ColorButton(Color.PINK),
				new ColorButton(Color.LIGHT_GRAY),
				new ColorButton(Color.GRAY),
				new ColorButton(Color.DARK_GRAY),
				new ColorButton(Color.BLACK),
				new ColorButton(Color.WHITE)};

		refresh = new JButton("Refresh");
		refresh.addActionListener(refreshListener);
		

		pencil = new ModeButton("Pencil", new PencilListener(canvas));
		pencil.addActionListener(genericListener);
		fillRect = new ModeButton("Fill Rect", new FillRectangleListener(canvas));
		fillRect.addActionListener(genericListener);
		emptyRect = new ModeButton("Empty Rect", new EmptyRectangleListener(canvas));
		emptyRect.addActionListener(genericListener);
		
		colorLayout = new JPanel();
		modeLayout = new JPanel();
		
		colorLayout.setLayout(new GridLayout(1,13));
		modeLayout.setLayout(new GridLayout(1,4));
		
		for(int i = 0; i < colors.length; i++){
			colors[i].addActionListener(colorButtonListener);
			colorLayout.add(colors[i]);
		}
		
		modeLayout.add(refresh);
		modeLayout.add(pencil);
		modeLayout.add(fillRect);
		modeLayout.add(emptyRect);		

		setLayout(new BorderLayout());
		
		canvas = new Canvas(WIDTH, HEIGHT);
		dl = new DrawListener(canvas);
		canvas.addMouseListener(dl);
		canvas.addMouseMotionListener(dl);
		add(canvas, BorderLayout.CENTER);
		
		Container north = new Container();
		north.setLayout(new GridLayout(2,1));
		north.add(colorLayout);
		north.add(modeLayout);
		add(north, BorderLayout.NORTH);

	}

	ActionListener colorButtonListener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			ColorButton clicked = (ColorButton) e.getSource();
			dl.setColor(clicked.getColor());
		}
	};

	ActionListener refreshListener = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {

			JButton button = (JButton) e.getSource();

			if (button.equals(refresh)) {
				canvas.getImage().getGraphics().fillRect(0, 0, 600, 600);
				canvas.repaint();
			}
		}

	};

	ActionListener genericListener = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent event) {
			ModeButton button = (ModeButton) event.getSource();
			BrushListener brushListener = button.getListener();
			canvas.setBrushListener(brushListener);
			canvas.addMouseListener(brushListener);
			canvas.addMouseMotionListener(brushListener);
		}
	};

	public static void main(String[] args) {
		new PaintFrame().setVisible(true);
	}
}
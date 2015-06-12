package friedman.paint;

import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class ColorButton extends JButton{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Color color;

	public ColorButton (Color color){
		this.color = color;
		setBackground(color);
	}

	public Color getColor(){
		return color;
	}

}
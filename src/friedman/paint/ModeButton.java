package friedman.paint;

import javax.swing.JButton;

public class ModeButton extends JButton{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private BrushListener listener;

	public ModeButton (String text, BrushListener listener){
		this.listener = listener;
		setText(text);
	}
	
	public BrushListener getListener() {
		return listener;
	}

}
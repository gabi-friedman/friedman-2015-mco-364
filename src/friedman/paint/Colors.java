package friedman.paint;

import java.awt.Color;

public enum Colors {

	RED(Color.RED),
	ORANGE(Color.ORANGE),
	YELLOW(Color.YELLOW),
	GREEN(Color.GREEN),
	CYAN(Color.CYAN),
	BLUE(Color.BLUE),
	MAGENTA(Color.MAGENTA),
	PINK(Color.PINK),
	LIGHT_GRAY(Color.LIGHT_GRAY),
	GRAY(Color.GRAY),
	DARK_GRAY(Color.DARK_GRAY),
	BLACK(Color.BLACK),
	WHITE(Color.WHITE);


	Color c;

	private Colors(Color c){
		this.c = c;
	}

	public Color getColor(){
		return this.c;
	}


	public String toString(){
		StringBuilder info = new StringBuilder();
		info.append(this.c.toString());
		return info.toString();
	}
}

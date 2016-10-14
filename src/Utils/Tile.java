package Utils;

public class Tile {
	
	private boolean wall = false;
	private int block = 0;
	
	// pre-built list
	private int BLANK = 0;
	private int DOT = 1;
	private int LSD = 2;
	private int WALL = 3;
	private int BLINKY = 4;
	private int PINKY = 5;
	private int INKY = 6;
	private int CLYDE = 7;
	private int PACMAN = 8;
	private int TELE = 9;
	
	public Tile(int number) {
		block = number;
		if(number >= 3 && number <= 7) wall = true;
	}
	
	public boolean isWall() {
		return wall;
	}
	
	public void setBlock(int i) {
		block = i;
		if(i >= 3 && i <= 7) wall = true;
	}
	
	public int getBlock() {
		return block;
	}
	
	public int getTele() {
		return TELE;
	}
	
	public int getPacman() {
		return PACMAN;
	}
	
	public int getClyde() {
		return CLYDE;
	}
	
	public int getInky() {
		return INKY;
	}
	
	public int getPinky() {
		return PINKY;
	}
	
	public int getBlinky() {
		return BLINKY;
	}
	
	public int getWall() {
		return WALL;
	}
	
	public int getLSD() {
		return LSD;
	}
	
	public int getDot() {
		return DOT;
	}
	
	public int getBlank() {
		return BLANK;
	}

}

package Utils;

public abstract class Movement {
	
	public Tile[][] tiles;
	
	protected int x;
	protected int y;
	
	protected boolean up = false;
	protected boolean down = false;
	protected boolean right = false;
	protected boolean left = false;
	
	private boolean won = false;
	
	protected int previousCharacter;
	
	public Movement(Tile[][] tiles) {
		if(tiles == null) return;
		this.tiles = tiles;
	}
	
	// predicts next tile (pass this before actual increment!
	// dx and dy don't have to be future
	public boolean nextIsWall(int dy, int dx) {
		return tiles[dy][dx].isWall();
	}
	
	public void grabUpcomingCharacter(int y, int x) {
		previousCharacter = tiles[y][x].getBlock();
	}
	
	public int getUpcomingValue(int y, int x) {
		return tiles[y][x].getBlock();
	}
	
	public void replacePreviousCharacter(int y, int x) {
		tiles[y][x].setBlock(previousCharacter);
	}
	
	public int getX() { return x; }
	public int getY() { return y; }
	
	public void initPos(int yourCharacter) {
		for(int i = 0; i < tiles.length; i++) {
			for(int j = 0; j < tiles[0].length; j++) {
				if(tiles[i][j].getBlock() == yourCharacter) {
					x = j;
					y = i;
					break;
				}
			}
		}
	}
	
	public void checkWin() {
		for(int i = 0; i < tiles.length; i++) {
			for(int j = 0; j < tiles[0].length; j++) {
				if(tiles[i][j].getBlock() == tiles[0][0].getDot()) return;
			}
		}
		won = true;
	}
	
	public void resetWin() {
		won = false;
	}
	
	public boolean didProgress() {
		return won;
	}
	
	public void goLeft() { 
		left = true;
		right = false;
		down = false;
		up = false;
	}
	public void goRight() { 
		right = true;
		left = false;
		down = false;
		up = false;
	}
	public void goUp() {
		up = true;
		left = false;
		right = false;
		down = false;
	}
	public void goDown() {
		down = true;
		up = false;
		right = false;
		left = false;
	}
}

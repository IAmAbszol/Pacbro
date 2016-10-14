package Utils;

import java.awt.Graphics2D;

public abstract class Ghost extends Movement {

	protected String ghostName;
	protected boolean alive;
	protected boolean scared;
	
	protected int buffer;
	
	private int previousCharacter = 0;			// the program translates the ints
	
	public Ghost(Tile[][] tiles, int buffer, int startingX, int startingY) {
		super(tiles);
		this.tiles = tiles;
		this.buffer = buffer;
	}
	
	public abstract void movingAlgorithm();
	public abstract void update();
	public abstract void draw(Graphics2D g);
	
}

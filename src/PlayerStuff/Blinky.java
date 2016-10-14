package PlayerStuff;

import java.awt.Graphics2D;

import Utils.Ghost;
import Utils.Tile;

public class Blinky extends Ghost {

	public Blinky(Tile[][] tiles, int buffer, int startingX, int startingY) {
		super(tiles, buffer, startingX, startingY);
		alive = true;
		scared = false;
		x = startingX;
		y = startingY;
	}

	@Override
	public void movingAlgorithm() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void draw(Graphics2D g) {
		// TODO Auto-generated method stub
		
	}

}

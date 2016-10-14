package PlayerStuff;

import Utils.Ghost;
import Utils.Movement;
import Utils.ScoreScreen;
import Utils.Tile;

public class Pacbro extends Movement {
	
	private static boolean trip = false;
	private long tripTimer = 0;
	private final long tripTime = 5000;
	
	public Pacbro(Tile[][] tiles, Ghost[] ghosts, int buffer) {
		super(tiles);
		initPos(tiles[0][0].getPacman());
		previousCharacter = tiles[0][0].getDot();
	}
	
	public void update() {
		if(left) {
			goLeft();
		}
		if(right) {
			 goRight();
		}
		if(down) {
			goDown();
		}
		if(up) {
			goUp();
		}
		if(trip) tripTimer++;
		if(tripTimer > tripTime) {
			trip = false;
			tripTimer = 0;
		}
		
	}
	
	public boolean checkTele(int dy, int dx) {
		if(getUpcomingValue(dy, dx) == tiles[0][0].getTele()) {
			return true;
		}
		return false;
	}
	
	public void goLeft() {
		int tmpx = x;
		int tmpy = y;

		int dx = tmpx - 1;
		if(nextIsWall(y, dx)) return;
		else {
			if(checkTele(y, dx)) {
				// teleport
				tiles[y][x].setBlock(tiles[0][0].getBlank());
				x = tiles[0].length - 2;
				tiles[y][x].setBlock(tiles[0][0].getPacman());
				return;
			}
			tiles[y][x].setBlock(tiles[0][0].getBlank());
			x--;
			if(tiles[y][x].getBlock() == tiles[y][x].getDot()) {
				ScoreScreen.increaseScores(1);
			}
			if(tiles[y][x].getBlock() == tiles[y][x].getLSD()) {
				ScoreScreen.increaseScores(50);
				trip = true;
			}
			tiles[y][x].setBlock(tiles[0][0].getPacman());
			
		}
		
	}
	
	public void goRight() {
		int tmpx = x;
		int tmpy = y;

		int dx = tmpx + 1;
		if(nextIsWall(y, dx)) return;
		else {
			
			grabUpcomingCharacter(y, dx);
			if(checkTele(y, dx)) {
				// teleport
				tiles[y][x].setBlock(tiles[0][0].getBlank());
				x = 1;
				tiles[y][x].setBlock(tiles[0][0].getPacman());
				return;
			}
			tiles[y][x].setBlock(tiles[0][0].getBlank());
			x++;
			if(tiles[y][x].getBlock() == tiles[y][x].getDot()) {
				ScoreScreen.increaseScores(1);
			}
			if(tiles[y][x].getBlock() == tiles[y][x].getLSD()) {
				ScoreScreen.increaseScores(50);
				trip = true;
			}
			tiles[y][x].setBlock(tiles[0][0].getPacman());
			
		}
	}
	
	public void goDown() {
		int tmpx = x;
		int tmpy = y;

		int dy = tmpy + 1;
		if(nextIsWall(dy, x)) return;
		else {
			
			grabUpcomingCharacter(dy, x);
			tiles[y][x].setBlock(tiles[0][0].getBlank());
			y++;
			if(tiles[y][x].getBlock() == tiles[y][x].getDot()) {
				ScoreScreen.increaseScores(1);
			}
			if(tiles[y][x].getBlock() == tiles[y][x].getLSD()) {
				ScoreScreen.increaseScores(50);
				trip = true;
			}
			tiles[y][x].setBlock(tiles[0][0].getPacman());
			
		}
	}
	
	public void goUp() {
		int tmpx = x;
		int tmpy = y;

		int dy = tmpy - 1;
		if(nextIsWall(dy, x)) return;
		else {
			
			grabUpcomingCharacter(dy, x);
			tiles[y][x].setBlock(tiles[0][0].getBlank());
			y--;
			if(tiles[y][x].getBlock() == tiles[y][x].getDot()) {
				ScoreScreen.increaseScores(1);
			}
			if(tiles[y][x].getBlock() == tiles[y][x].getLSD()) {
				ScoreScreen.increaseScores(50);
				trip = true;
			}
			tiles[y][x].setBlock(tiles[0][0].getPacman());
			
		}
	}
	
	public static boolean isHeCray() { return trip; }
	
}

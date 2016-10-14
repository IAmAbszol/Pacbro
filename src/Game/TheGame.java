package Game;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import Main.GamePanel;
import Main.MainFrame;
import PlayerStuff.Pacbro;
import Utils.Ghost;
import Utils.Overlord;
import Utils.ScoreScreen;

public class TheGame extends Overlord {
	
	private MapCreation mpCreate;
	private ScoreScreen ss;
	private Ghost[] ghost;
	private Pacbro pb;
	
	private int level = 1;
	private int lives = 0;
	private int score = 0;
	
	public TheGame() {
		
		mpCreate = new MapCreation(null, "/map/pacman.map");
		mpCreate.loadMap();
		
		ss = new ScoreScreen(mpCreate.getTiles(), lives, score, level);
		
		ghost = new Ghost[4];
		// create ghosts
		
		pb = new Pacbro(mpCreate.getTiles(), ghost, mpCreate.getBuffer());
		
	}
	
	public void update() {
		if(lives > 0) {
			pb.checkWin();
			if(pb.didProgress()) {
				level++;
				lives++;
				
				pb.resetWin();
	
				mpCreate = new MapCreation(null, "/map/pacman.map");
				mpCreate.loadMap();
				
				ss = new ScoreScreen(mpCreate.getTiles(), lives, score, level);
				
				ghost = new Ghost[4];
				setGhosts(level);
				
				pb = new Pacbro(mpCreate.getTiles(), ghost, mpCreate.getBuffer());
				
			}
			pb.update();
			score = ss.getScore();
			MainFrame.setTitle(MainFrame.gameName + " - Level " + level + ", Score " + score + ", and Lives Left " + lives);
		} else {
			MainFrame.setTitle(MainFrame.gameName + " -> You Lose! Final Scores Level " + level + ", Score " + score + ", and Lives Left " + lives);
		}
		
	}
	
	public void setGhosts(int level) {
		
	}
	
	public void draw(Graphics2D g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, GamePanel.WIDTH, GamePanel.HEIGHT);
		mpCreate.drawMap(g);
		ss.draw(g);
	}
	
	public void keyPress(int i) {
		if(i == KeyEvent.VK_LEFT) pb.goLeft();
		if(i == KeyEvent.VK_RIGHT) pb.goRight();
		if(i == KeyEvent.VK_UP) pb.goUp(); 
		if(i == KeyEvent.VK_DOWN) pb.goDown();
	}

}

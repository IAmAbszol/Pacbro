package Utils;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import Main.MainFrame;

public class ScoreScreen {
	
	private static int score = 0;
	private static int lives = 0;
	private static int level = 0;
	
	private int tmpy = 10;
	private int startx = 0;
	
	public ScoreScreen(Tile[][] tiles, int lives, int score, int level) {
		
		ScoreScreen.lives = lives;
		ScoreScreen.score = score;
		ScoreScreen.level = level;
		startx = tiles[0].length * 12;
		
	}
	
	public static void increaseScores(int i) { score += i; }
	public static void decreaseScores(int i) { score -= i; }
	public static void increaseLives(int i) { lives += i; }
	public static void decreaseLives(int i) { lives -= i; }
	public int getScore() { return score; }
	
	public void draw(Graphics2D g) {
		
		tmpy = g.getFontMetrics().getHeight();
		
		// set title
		g.setColor(Color.yellow);
		g.setFont(new Font("Lucida Console", Font.PLAIN, 5));
		for(int i = 0; i < mainTitle().size(); i++) {
			g.drawString(mainTitle().get(i), startx + 12, tmpy);
			tmpy += g.getFontMetrics().getHeight();
		}

		// set everything else
		g.setFont(new Font("Arial", Font.BOLD, 16));
		g.drawString("Scores", startx + 50, (tmpy += g.getFontMetrics().getHeight()));
		
		g.setFont(new Font("Arial", Font.PLAIN, 12));
		tmpy += g.getFontMetrics().getHeight();
		g.drawString("Score: " + score, startx + 12, tmpy);
		tmpy += g.getFontMetrics().getHeight();
		g.drawString("Lives: " + lives, startx + 12, tmpy);
		tmpy += g.getFontMetrics().getHeight();
		g.drawString("Level: " + level, startx + 12, tmpy);
		
		if(lives <= 0) {
			g.setFont(new Font("Lucida Console", Font.PLAIN, 5));
			for(int i = 0; i < loseTitle().size(); i++) {
				tmpy += g.getFontMetrics().getHeight();
				g.drawString(loseTitle().get(i), startx + 6, tmpy);
				tmpy += g.getFontMetrics().getHeight();
			}
		}
		
		tmpy = 10;
		
	}
	
	private ArrayList<String> mainTitle() {
		ArrayList<String> title = new ArrayList<String>();
		try {
			String line = null;
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					this.getClass().getResourceAsStream("/Title.txt")));
			while((line = reader.readLine()) != null) {
				title.add(line);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return title;
	}
	
	private ArrayList<String> loseTitle() {
		ArrayList<String> title = new ArrayList<String>();
		try {
			String line = null;
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					this.getClass().getResourceAsStream("/Lose.txt")));
			while((line = reader.readLine()) != null) {
				title.add(line);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return title;
	}
	
}

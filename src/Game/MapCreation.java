package Game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;

import Utils.Movement;
import Utils.Tile;
import PlayerStuff.Pacbro;

public class MapCreation extends Movement {

	private int 			rows = 0;
	private int				cols = 0;
	
	private BufferedReader 	reader;
	private int				buffer = 12; // space between stuff
	
	private String type = "Arial";
	private int size = 12;
	
	public MapCreation(Tile[][] tiles, String map) {
		super(tiles);
		try {
			reader = new BufferedReader(new InputStreamReader(
					this.getClass().getResourceAsStream(map)));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public Tile[][] getTiles() { return tiles; }
	public int getWidth() { return cols; }
	public int getHeight() { return rows; }
	public int getBuffer() { return buffer; }
	
	public void drawMap(Graphics2D g) {
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				char character = 0;
				Color color = null;
				Font font = null;
				if(tiles[i][j].getBlock() == 0) { 
					character = ' ';
					color = Color.black;
					font = new Font(type, Font.PLAIN, size);
				}
				if(tiles[i][j].getBlock() == 1) {
					character = '.';
					color = Color.white;
					font = new Font(type, Font.BOLD, size);
				}
				if(tiles[i][j].getBlock() == 2) {
					character = '@';
					color = Color.white;
					font = new Font(type, Font.BOLD, size);
				}
				if(tiles[i][j].getBlock() == 3) {
					character = '#';
					color = Color.blue;
					font = new Font(type, Font.BOLD, size);
				}
				if(tiles[i][j].getBlock() == 4) {
					character = '&';
					color = Color.red;
					font = new Font(type, Font.BOLD, size);
				}
				if(tiles[i][j].getBlock() == 5) {
					character = '&';
					color = Color.pink;
					font = new Font(type, Font.BOLD, size);
				}
				if(tiles[i][j].getBlock() == 6) {
					character = '&';
					color = Color.cyan;
					font = new Font(type, Font.BOLD, size);
				}
				if(tiles[i][j].getBlock() == 7) {
					character = '&';
					color = Color.orange;
					font = new Font(type, Font.BOLD, size);
				}
				if(tiles[i][j].getBlock() == 8) {
					character = 'O';
					if(Pacbro.isHeCray()) color = Color.ORANGE;
					else
						color = Color.yellow;
					font = new Font(type, Font.BOLD, size);
				}
				if(tiles[i][j].getBlock() == 9) {
					character = ' ';
					color = Color.black;
					font = new Font(type, Font.BOLD, size);
				}
				
				// actual drawing - 
				//should be good by being based off of the spacing with buffer
				int posx = buffer * j;
				int posy = (buffer * i) + size;
				g.setColor(color);
				g.setFont(font);
				g.drawString(""+character, posx, posy);
			}
		}
	}
	
	public void loadMap() {
		try {
			// new up the map
			String line = null;
			// grab # of rows
			rows = Integer.parseInt((line = reader.readLine()));
			// grab # of cols
			cols = Integer.parseInt((line = reader.readLine()));
			tiles = new Tile[rows][cols];
			for(int i = 0; i < rows; i++) {
				line = reader.readLine();
				for(int j = 0; j < cols; j++) {
					tiles[i][j] = new Tile(Integer.parseInt(""+line.charAt(j)));
				}
			}
		} catch (Exception e) {}
	}
	
}

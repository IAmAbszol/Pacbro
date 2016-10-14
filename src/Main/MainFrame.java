package Main;

import javax.swing.JFrame;

public class MainFrame {
	
	public static final String gameName = "Pac-Bro";
	private static JFrame frame;
	
	
	public static void main(String[] args) {
		
		frame = new JFrame("Pacbro by Kyle Darling");
		frame.setContentPane(new GamePanel());
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		
	}
	
	public static void setTitle(String title) {
		frame.setTitle(title);
	}
	
}

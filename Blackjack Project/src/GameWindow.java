import java.awt.BorderLayout;

import javax.swing.JFrame;


public class GameWindow extends JFrame{
	
	public GameWindow() {
		super("Blackjack");
		Blackjack blackjack = new Blackjack();
		GameControl gameControl = new GameControl();
		
		this.add(blackjack, BorderLayout.NORTH);
		this.add(gameControl, BorderLayout.SOUTH);
		
		this.pack();
		this.setVisible(true);
	}
	public static void main(String[] args) {
		GameWindow a = new GameWindow();
	}

}

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class GameWindow extends JFrame implements ActionListener{

	public GameWindow() {
		super("Blackjack");
		Blackjack blackjack = new Blackjack();
		GameControl gameControl = new GameControl(blackjack);
		
		this.add(gameControl, BorderLayout.SOUTH);
		this.add(blackjack, BorderLayout.NORTH);

		this.pack();
		this.setResizable(false);
		this.setVisible(true);
	}



	public static void main(String[] args) {

		int panelle=JOptionPane.showOptionDialog(null, "¿Empezar nueva partida?", "Bienvenido", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, JOptionPane.UNINITIALIZED_VALUE);
		if(panelle==0){
			GameWindow a= new GameWindow();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;


public class GameControl extends JPanel{
	private JButton hit, stay;
	private Blackjack juego;

	public GameControl(Blackjack blackjack) {
		super();
		setBackground(Color.BLACK);
		this.setPreferredSize(new Dimension(800, 100));
		
		this.juego=blackjack;
		this.hit= new JButton("Otra carta");
		this.stay= new JButton("Quedarse así");
		
		this.add(this.hit);
		this.add(this.stay);
		
		this.hit.addActionListener(this.juego);
		this.stay.addActionListener(this.juego);
		
		
		
	}	
}

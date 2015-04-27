import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;


public class Blackjack extends JPanel {	

	Baraja baraja;
	Jugador[] jugadores;

	public Blackjack() {
		super();
		this.setPreferredSize(new Dimension(800,600));

		this.baraja = new Baraja();
		this.jugadores=new Jugador[4];

		this.jugadores[0]= new Jugador(100, "Samantha");
		this.jugadores[0].tomaCarta(this.baraja.next());
		this.jugadores[0].tomaCarta(this.baraja.next());
		
		this.jugadores[1]=new Jugador(100, "Poncho");
		this.jugadores[1].tomaCarta(this.baraja.next());
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.paintTable(g);

		for(int i=0; jugadores[i]!=null; i++){
			this.paintPlayer(g,i);			
		}

		Naipe a = new Naipe(1,1);
		System.out.println(a);
		g.drawImage(a.getDorso(), 0, 0, null);
	}

	public void paintPlayer(Graphics g, int jug){
		for(int i=0; this.jugadores[jug].getJuego(i)!=null; i++){
			g.drawImage(this.jugadores[jug].getJuego(i).getImage(),this.getWidth()*(jug+1)/5-42+20*i, (int) (this.getHeight()*0.5)+20*i, null);
		}
	}

	public void paintTable(Graphics g) {
		g.setColor(Color.GREEN);
		g.fillRect(0, 0, this.getWidth(), (int) (this.getHeight()*0.75));
		g.fillOval(0, (int) (this.getHeight()*0.75 - this.getHeight()/12), this.getWidth(), this.getHeight()/6);

		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(3));
		g2.setColor(Color.RED);
		g2.drawRect(this.getWidth()/5-42, (int) (this.getHeight()*0.5), 85, 108);
		g2.drawRect(this.getWidth()*2/5-42, (int) (this.getHeight()*0.5), 85, 108);
		g2.drawRect(this.getWidth()*3/5-42, (int) (this.getHeight()*0.5), 85, 108);
		g2.drawRect(this.getWidth()*4/5-42, (int) (this.getHeight()*0.5), 85, 108);		
	}

}

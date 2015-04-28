import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class Blackjack extends JPanel implements ActionListener, Runnable{	

	private Baraja baraja;
	private Jugador[] jugadores;
	private Dealer dealer;
	private int	numJ;

	public Blackjack() {
		super();
		this.setPreferredSize(new Dimension(800,550));

		this.numJ=0;
		do{		
			try{
				this.numJ=Integer.parseInt(JOptionPane.showInputDialog(this, "¿Cuántos jugadores serán?"));
				if(this.numJ<1 || this.numJ>4){
					throw new IllegalArgumentException();
				}
			}
			catch(IllegalArgumentException e){
				JOptionPane.showMessageDialog(null, "Sólo pueden ser de 1 a 4 jugadores");
			}
		}while(this.numJ<1 || this.numJ>4);

		this.baraja = new Baraja();
		this.jugadores=new Jugador[this.numJ];
		for(int j=0; j<this.numJ; j++){
			String nombre=(JOptionPane.showInputDialog(this, "¿Cual es el nombre del jugador "+ (j+1) + "?"));
			boolean error;
			int saldo = 0;
			do{
				try{
					saldo=Integer.parseInt(JOptionPane.showInputDialog(this, "¿Cuál será el saldo de este jugador?"));
					error=false;
				}
				catch(IllegalArgumentException e){
					error=true;
				}
			}while(error);
			jugadores[j]= new Jugador(saldo, nombre);
		}
		this.dealer= new Dealer("casa");
		
		Thread hilo = new Thread(this);
		hilo.start();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.paintTable(g);

		for(int i=0; i<this.numJ; i++){
			this.paintPlayer(g, i);
		}
		
		this.paintDealer(g);

		Naipe a = new Naipe(1,1);
		g.drawImage(a.getDorso(), 0, 0, null);
	}
	
	public void paintDealer(Graphics g){
		g.setColor(Color.BLACK);
		g.drawString(this.dealer.getName(), this.getWidth()/2-42, 35);
		for(int i=0; this.dealer.getJuego(i)!=null; i++){
			g.drawImage(this.dealer.getJuego(i).getImage(),this.getWidth()/2-42+20*i, 50+20*i, null);
		}
	}

	public void paintPlayer(Graphics g, int jug){
		g.setColor(Color.BLACK);
		g.drawString(this.jugadores[jug].getName(), this.getWidth()*(jug+1)/5-45, (int) (this.getHeight()*0.5+120));
		g.drawString("$ "+this.jugadores[jug].getSaldo(), this.getWidth()*(jug+1)/5-42, (int) (this.getHeight()*0.5+140));
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

	@Override
	public void actionPerformed(ActionEvent e) {

	}

	@Override
	public void run() {
		for(int j=0; j<2; j++){
			for(int i=0; i<this.numJ; i++){
				try {
					Thread.sleep(1200);
					this.jugadores[i].tomaCarta(baraja.next());
					System.out.println(jugadores[i].getJuego(j));
					this.repaint();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			try {
				Thread.sleep(1200);
				this.dealer.tomaCarta(baraja.next());
				System.out.println(this.dealer.getJuego(j));
				this.repaint();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}

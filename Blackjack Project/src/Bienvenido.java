import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;


public class Bienvenido extends JPanel implements ActionListener{
	private JButton btNueva,btCargar;
	
	private boolean nueva;
	
	public Bienvenido(GameWindow ventana){
		super();
		this.setPreferredSize(new Dimension(400,50));
		
		this.nueva=false;
		
		this.btNueva= new JButton("Nueva Partida");
		this.btCargar= new JButton("Cargar partida");
		
		this.btNueva.addActionListener(ventana);
		this.btCargar.addActionListener(ventana);
		
		this.add(this.btNueva);
		this.add(this.btCargar);
		
	}
	
	public boolean getPartida(){
		return this.nueva;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btNueva){
			this.nueva=true;
			try {
				this.finalize();
			} catch (Throwable e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	}
	
	
	
	
}

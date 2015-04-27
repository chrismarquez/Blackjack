import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.text.StyledEditorKit.ForegroundAction;


public class Naipe {
	
	private static final Image[] naipesImg = fillImage();
	private static final String[]  valores = fillValores(),
								   figuras = fillFiguras();
	private static final Image dorsoImg = new ImageIcon("Cartas//Fondo_carta.png").getImage();
	private int figura,
				valor;
	
	public static Image[] fillImage() {
		Image[] images = new Image[52];
		for(int i = 0; i < 4; i++) {
			for (int j = 0; j < 13; j++) {
				String route = "";
				switch (i) {
				case 0:
					route = "Cartas//Corazones//" + (j + 1) + ".png";
					break;
				case 1:
					route = "Cartas//Diamante//" + (j + 1) + ".png"; 
					break;
				case 2:
					route = "Cartas//Picas//" + (j + 1) + ".png";
					break;
				case 3:
					route = "Cartas//Trebol//" + (j + 1) + ".png";
					break;
				default:
					break;
				}
				images[j + i*13] = new ImageIcon(route).getImage();
			}
		}
		return images;		
	}
	
	public static String[] fillValores() {
		String[] string = new String[13];
		String valor = "";
		for (int i = 0; i < 13; i++) {
			if (i == 0) {
				valor = "As";
			} else if (i > 0 && i < 10) {
				valor = "" + (i + 1);
			} else if (i == 10){
				valor = "Joto";
			} else if (i == 11) {
				valor = "Reina";
			} else {
				valor = "Rey";
			}
			
			string[i] = valor;
		}
		
		return string;
	}
	
	
	public static String[] fillFiguras() {
		String[] string = {"Corazones", "Diamantes", "Picas", "Treboles"};
		return string;
	}
	
	public Naipe(int figura, int valor) {
		if(figura>3){
			figura=0;
		}
		if(valor>12){
			figura=0;
		}
		this.figura = figura;
		this.valor = valor;
	}
	
	public String toString() {
		return this.valores[this.valor] + " de " + this.figuras[this.figura];
	}
	
	public Image getImage() {
		return this.naipesImg[this.valor + this.figura * 13];
	}
	
	public Image getDorso(){
		return this.dorsoImg;
	}
	
	public int getValor() {
		if (this.valor > 0 && this.valor < 10) {
			return this.valor + 1; //Cards between 2 and 10
		} else if (this.valor == 0) {
			return 11; //A
		} else {
			return 10; //J, K, Q
		}
	}
}

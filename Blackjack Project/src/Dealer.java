
public class Dealer extends Jugador {
	
	public Dealer(String nombre) {
		super((int) Double.POSITIVE_INFINITY, nombre);
	}
	
	public boolean otraCarta() {
		if(this.getTotal() < 16) {
			return true;
		} else {
			return false;
		}
	}
	
}

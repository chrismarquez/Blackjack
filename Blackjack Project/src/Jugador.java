public class Jugador {
	
	private int saldo;
	private String nombre;
	private boolean perdio;
	private Naipe[] juego;
	private int cartas;
	
	public Jugador(int saldo, String nombre) {
		this.saldo = saldo;
		this.nombre = nombre;
		this.perdio = false;
		this.juego = new Naipe[10];
		this.cartas=0;
	}
	
	public int getSaldo() {
		return this.saldo;
	}
	
	public String getName() {
		return this.nombre;
	}
	
	public boolean perdio() {
		return this.perdio;
	}
	
	public int getTotal() {
		int total = 0;
		for (int i = 0; i < this.juego.length; i++) {
			if(this.juego[i] != null) {
				total += this.juego[i].getValor();
			}
		}
		return total;
	}
	
	public void tomaCarta(Naipe carta) {
		this.juego[cartas]=carta;
		cartas++;       
	}
	
	public int getCartas(){
		return this.cartas;
	}
	
	public Naipe getJuego(int i){
		return this.juego[i];
	}
	
	public void ganoPartida(int cantidad) {
		this.saldo += cantidad; 
	}
	
	public void perdioPartida(int cantidad) {
		this.saldo -= cantidad;
	} 	
	
	public void empatoPartida(int cantidad) {
		
	}
	
	public boolean otraCarta(boolean decision) {
		return decision;
	}
	
	public boolean isBlackjack() {
		if((this.juego[0].getValor() == 11 && this.juego[1].getValor() == 10) ||
				(this.juego[0].getValor() == 10 && this.juego[1].getValor() == 11)) {
			return true;
		} else {
			return false;
		}
	}
	
	
}

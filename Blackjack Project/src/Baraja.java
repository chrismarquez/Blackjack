import java.util.Random;


public class Baraja{
	
	private Naipe[] baraja;
	private int posicion;
	
	public Baraja() {
		this.baraja = new Naipe[52];
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 13; j++) {
				Naipe naipe = new Naipe(i, j);
				this.baraja[j + i * 13] = naipe;
				System.out.println(naipe);
			}
		}
		
		this.mezclar();
	}
	
	public void mezclar() {
		int index;
		int[] usedIndexes = new int[52];
		Naipe[] sustBaraja = new Naipe[52];
		Random random = new Random();
		for (int i = 0; i < usedIndexes.length; i++) {
			usedIndexes[i] = -1;
		}
		for (int i = 0; i < this.baraja.length; i++) {
			do {
				index = random.nextInt(52);
			} while (find(index, usedIndexes));
			usedIndexes[i] = index;
			sustBaraja[i] = this.baraja[index];
		}
		
		this.baraja = sustBaraja;
	}
	
	public boolean find(int index, int[] array) {
		for (int i = 0; i < array.length; i++) {
			if (index == array[i]) {
				return true;
			}
		}
		return false;
	}
	
	public Naipe next() {
		try {
			return this.baraja[posicion++];
		} catch (ArrayIndexOutOfBoundsException e) {
			this.posicion = 0;
			return this.next();
		}
		
	}
	
}

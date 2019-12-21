public class Counter {

	private int x;

	public synchronized void incrementX() {
		x++;
	}

	public synchronized void decrementX() {
		x--;
	}

	public int getX() {
		return x;
	}

}
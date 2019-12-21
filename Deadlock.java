import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class Deadlock {
	private final BlockingQueue<Integer> queue = new LinkedBlockingDeque<Integer>();

	public synchronized Integer take() throws InterruptedException {
		return queue.take();
	}

	public synchronized void add(int x) {
		queue.add(x);
	}

}

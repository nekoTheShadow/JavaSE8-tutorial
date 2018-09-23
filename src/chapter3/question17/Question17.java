package chapter3.question17;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

public class Question17 {
	
	public static void main(String[] args) {
		Runnable r1 = () -> {
			sleep(8);
			System.out.println("r1: ERROR END");
			throw new NullPointerException();
		};
		Runnable r2 = () -> {
			sleep(5);
			System.out.println("r2: NORMAL END");
		};
		
		doInParallelAsync(r1, r2, t -> t.printStackTrace(System.out));
	}

	
	public static void doInParallelAsync(Runnable first, Runnable second, Consumer<Throwable> handler) {
		try {
			var service = Executors.newCachedThreadPool();
			service.submit(() -> handle(first, handler));
			service.submit(() -> handle(second, handler));
			service.shutdown();
			service.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private static void handle(Runnable runnable, Consumer<Throwable> handler) {
		try {
			runnable.run();
		} catch(Throwable t) {
			handler.accept(t);
		}
	}
	
	private static void sleep(long seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			// PASS
		}
	}
}

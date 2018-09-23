package chapter3.question2;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

public class Question2 {
	public static void withLock(ReentrantLock lock, Runnable function) {
		lock.lock();
		try {
			function.run();
		} finally {
			lock.unlock();
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		System.out.println("ReetrantLockを利用しない場合:");
		var threadPool1 = Executors.newCachedThreadPool();
		IntStream.range(0, 5).forEach(i -> {
			threadPool1.submit(() -> lazyPrint(i));
		});
		threadPool1.shutdown();
		threadPool1.awaitTermination(Integer.MAX_VALUE, TimeUnit.DAYS);

		System.out.println("ReetrantLockを利用する場合:");
		var threadPool2 = Executors.newCachedThreadPool();
		var lock = new ReentrantLock(true);
		IntStream.range(0, 5).forEach(i -> {
			threadPool2.submit(() -> {
				withLock(lock, () -> lazyPrint(i));
			});
		});
		threadPool2.shutdown();
		threadPool2.awaitTermination(Integer.MAX_VALUE, TimeUnit.DAYS);
	}
		
	private static void lazyPrint(int i) {
		try {
			System.out.println("START: " + i);
			Thread.sleep(1000);
			System.out.println("END: " + i);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}
}

/*
ReetrantLockを利用しない場合:
START: 0
START: 3
START: 4
START: 1
START: 2
END: 3
END: 0
END: 2
END: 4
END: 1
ReetrantLockを利用する場合:
START: 1
END: 1
START: 0
END: 0
START: 3
END: 3
START: 2
END: 2
START: 4
END: 4
*/

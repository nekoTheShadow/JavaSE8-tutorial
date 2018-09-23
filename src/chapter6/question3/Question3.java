package chapter6.question3;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;
import java.util.stream.IntStream;

public class Question3 {
	public static void main(String[] args) throws InterruptedException {
		var t1 = time(() -> usingAtomicLong());
		var t2 = time(() -> usingLongAddr());
		System.out.printf("usingAtomicLong() ---> %d msec.%n", t1); // usingAtomicLong() ---> 2091 msec.
		System.out.printf("usingLongAddr() ---> %d msec.%n", t2);   // usingLongAddr() ---> 466 msec.

	}
	
	private static long usingAtomicLong() throws InterruptedException {
		var counter = new AtomicLong();
		var executor = Executors.newCachedThreadPool();
		IntStream.range(0, 1000).forEach(x -> {
			executor.submit(() -> IntStream.range(0, 100000).forEach(y -> counter.incrementAndGet()));
		});
		executor.shutdown();
		executor.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);
		return counter.get();
	}
	
	private static long usingLongAddr() throws InterruptedException {
		var counter = new LongAdder();
		var executor = Executors.newCachedThreadPool();
		IntStream.range(0, 1000).forEach(x -> {
			executor.submit(() -> IntStream.range(0, 100000).forEach(y -> counter.increment()));
		});
		executor.shutdown();
		executor.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);
		return counter.sum();
	}
	
	private static long time(Callable<Long> method) {
		try {
			var start = System.currentTimeMillis();
			method.call();
			return System.currentTimeMillis() - start;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}

//

package chapter3.question21;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.function.Function;

public class Question21 {
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		var service = Executors.newCachedThreadPool();
		var future1 = service.submit(() ->{
			sleep(10);
			return 1;
		});
		service.shutdown();
		service.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);
		
		var future2 = map(future1, integer -> "A" + integer);
		System.out.println(future2.get()); //=> A1
	}
	
	public static <T, U> Future<U> map(Future<T> future, Function<T, U> function) {
		return new Future<U>() {
			@Override
			public boolean cancel(boolean mayInterruptIfRunning) {
				return future.cancel(mayInterruptIfRunning);
			}

			@Override
			public boolean isCancelled() {
				return future.isCancelled();
			}

			@Override
			public boolean isDone() {
				return future.isDone();
			}

			@Override
			public U get() throws InterruptedException, ExecutionException {
				return function.apply(future.get());
			}

			@Override
			public U get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
				return function.apply(future.get(timeout, unit));
			}
		};
	}
	
	public static void sleep(long seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			// PASS
		}
	}
}

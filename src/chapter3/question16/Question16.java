package chapter3.question16;

import java.util.function.BiConsumer;
import java.util.function.Supplier;

public class Question16 {
	public static <T> void doInOrderAsync(Supplier<T> first, BiConsumer<T, Throwable> second) {
		var thread = new Thread(() -> {
			T t = null;
			try {
				t = first.get();
				second.accept(t, null);
			} catch (Throwable e) {
				second.accept(t, e);
			}
		});
		thread.start();
	}
}

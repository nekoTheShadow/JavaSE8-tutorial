package chapter3.question18;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.Callable;
import java.util.function.Function;
import java.util.function.Supplier;

public class Question18 {

	public static void main(String[] args) {
		// ↓のふたつは無事コンパイルが通る!!!
		unchecked(() -> new String(Files.readAllBytes(Paths.get("unknown"))));
		unchecked((String filename) -> new String(Files.readAllBytes(Paths.get(filename))));
	}

	public static <T> Supplier<T> unchecked(Callable<T> f) {
		return () -> {
			try {
				return f.call();
			} catch (Throwable t) {
				t.printStackTrace();
				throw new RuntimeException(t);
			}
		};
	}
	
	public static <T, U> Function<T, U> unchecked(ThrowableFunction<T, U> f) {
		return (t) -> {
			try {
				return f.apply(t);
			} catch (Throwable e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		};
	}
}

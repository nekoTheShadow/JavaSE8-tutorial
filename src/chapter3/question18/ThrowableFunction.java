package chapter3.question18;

@FunctionalInterface
public interface ThrowableFunction<T, U> {
	U apply(T t) throws Exception;
}

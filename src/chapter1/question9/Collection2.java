package chapter1.question9;

import java.util.Collection;
import java.util.function.Consumer;
import java.util.function.Predicate;

public interface Collection2<E> extends Collection<E> {
	default void forEachIF(Consumer<E> action, Predicate<E> predicate) {
		this.stream().filter(predicate).forEach(action);
	}
}

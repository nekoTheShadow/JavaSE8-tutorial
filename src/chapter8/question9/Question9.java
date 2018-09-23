package chapter8.question9;

import java.io.ByteArrayInputStream;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.BooleanSupplier;
import java.util.function.Supplier;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class Question9 {
	public static void main(String[] args) {
		var words = scanner("a b c d");
		stream(words::next, words::hasNext).forEach(System.out::println);
		// a
		// b
		// c
		// d
		
		var lines = scanner("a b\nc d");
		stream(lines::nextLine, lines::hasNextLine).forEach(System.out::println);
		// a b
		// c d
		
		var integers = scanner("1 2 \n 3 4");
		stream(integers::nextInt, integers::hasNextInt).map(i -> i * 2).forEach(System.out::println);
		// 2
		// 4
		// 6
		// 8
		
		var doubles = scanner("1.1 2.2 \n 3.3 4.4");
		stream(doubles::nextDouble, doubles::hasNextDouble).map(i -> i * 2).forEach(System.out::println);
		// 2.2
		// 4.4
		// 6.6
		// 8.8
	}
	
	private static <T> Stream<T> stream(Supplier<T> next, BooleanSupplier has) {
		var iterator = new Iterator<T>() {
			@Override
			public boolean hasNext() {
				return has.getAsBoolean();
			}

			@Override
			public T next() {
				return next.get();
			}
		};
		var spliterator = Spliterators.spliteratorUnknownSize(iterator, Spliterator.ORDERED);
		return StreamSupport.stream(spliterator, false);
	}
	
	private static <T> Scanner scanner(String in) {
		return new Scanner(new ByteArrayInputStream(in.getBytes()));
	}
}

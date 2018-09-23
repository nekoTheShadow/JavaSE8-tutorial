package chapter8.question12;

import java.util.stream.IntStream;

public class Calculation {
	@TestCase(param=3, expected=6)
	@TestCase(param=4, expected=6)
	public static int factorial(int n) {
		return IntStream.rangeClosed(1, n).reduce(1, (a, b) -> a * b);
	}
	
	@TestCase(param=2, expected=4)
	public static int twice(int n) {
		return n * 2;
	}
}

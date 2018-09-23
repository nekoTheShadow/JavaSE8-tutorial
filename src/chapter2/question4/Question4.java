package chapter2.question4;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Question4 {
	public static void main(String[] args) {
		int[] values = {1, 4, 9, 16};
		Stream<int[]> a = Stream.of(values);
		IntStream b = Arrays.stream(values);
	}
}

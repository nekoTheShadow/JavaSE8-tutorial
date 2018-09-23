package chapter6.question7;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Question7 {
	public static void main(String[] args) {
		for (int len = 0; ; len += 1000) {
			var shuffled = IntStream.range(0, len).boxed().collect(Collectors.toList());
			Collections.shuffle(shuffled);
			
			var t1 = time(shuffled, Arrays::sort);
			var t2 = time(shuffled, Arrays::parallelSort);
			System.out.printf("%d %d %d%n", len, t1, t2);
		}
	}
	
	private static long time(List<Integer> shuffled, Consumer<int[]> sort) {
		int len = shuffled.size();
		var digits = new int[len];
		IntStream.range(0, len).forEach(i -> digits[i] = shuffled.get(i));
		
		var start = System.currentTimeMillis();
		sort.accept(digits);
		return System.currentTimeMillis() - start;
	}
}

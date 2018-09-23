package chapter6.question4;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.LongAccumulator;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class Question4 {
	public static void main(String[] args) {
		var digits = LongStream.range(0, 10000000).boxed().collect(Collectors.toList());
		Collections.shuffle(digits);
		
		System.out.println(max(digits)); //=> 9999999
		System.out.println(min(digits)); //=> 0
	}
	
	private static long max(List<Long> digits) {
		var accumlator = new LongAccumulator(Long::max, Long.MIN_VALUE);
		digits.parallelStream().forEach(accumlator::accumulate);
		return accumlator.get();
	}
	
	private static long min(List<Long> digits) {
		var accumlator = new LongAccumulator(Long::min, Long.MAX_VALUE);
		digits.parallelStream().forEach(accumlator::accumulate);
		return accumlator.get();
	}
}

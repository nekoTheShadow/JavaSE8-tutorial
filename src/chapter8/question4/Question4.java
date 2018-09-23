package chapter8.question4;

import java.util.Random;
import java.util.stream.LongStream;

public class Question4 {
	private static final long a = 11L;
	private static final long v = 246154705703781L;
	private static final long N = 1L << 48;
	private static final long m = 25214903917L;
	private static final long TRIAL = 1000000L;
	
	public static void main(String[] args) {
		long seed = LongStream
					.iterate(prev(0), s-> prev(prev(s)))
					.limit(TRIAL)
					.map(s -> s ^ m)
					.min()
					.getAsLong();
		
		var generator = new Random(seed);
		for (long i = 0; i < TRIAL; i++) {
			if (generator.nextDouble() == 0.0) {
				System.out.println(i + 1);
				break;
			}
		}
	}

	private static long prev(long s) {
		return Math.floorMod((s - a) * v, N);
	}
}

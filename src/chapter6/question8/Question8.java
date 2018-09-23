package chapter6.question8;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Question8 {
	
	/**
	 * http://hg.openjdk.java.net/jdk8u/jdk8u/jdk/file/be44bff34df4/src/share/classes/java/util/Arrays.java
	 * ↑のコードによると、parallelSortは配列長が1<<13より大きいときに初めてsortをマルチスレッドする。
	 * ---> 配列長が15KぐらいになるとparallelSortのほうが早い。
	 * @param args
	 */
	public static void main(String[] args) {
		for (int len = 1 << 13 + 1; ; len += 1) {
			var digits = IntStream.range(0, len).boxed().collect(Collectors.toList());
			Collections.shuffle(digits);
			
			var a1 = new int[len];
			var a2 = new int[len];
			for (int i = 0; i < len; i++) {
				a1[i] = a2[i] = digits.get(i);
			}
			
			var t1 = time(() -> Arrays.sort(a1));
			var t2 = time(() -> Arrays.parallelSort(a2));
			if (t1 > t2) {
				System.out.printf("%d %d %d%n", len, t1, t2); //=> 16395 1989400 1897300
				break;
			}
		}
	}
	
	public static long time(Runnable f) {
		long start = System.nanoTime();
		f.run();
		return System.nanoTime() - start;
	}
}

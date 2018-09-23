package chapter2.question10;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class Question10 {
	public static double avg(Stream<Double> dbls) {
		var counter = new AtomicInteger();
		var total = dbls.reduce(0d, (sum, dbl) -> {
			counter.getAndIncrement();
			return sum + dbl;
		});
		return counter.intValue() == 0 ? 0.0d : total / counter.intValue();
	}
	
	public static void main(String[] args) {
		var avarage = avg(DoubleStream.of(1.1, 2.2, 3.3).boxed());
		System.out.println(avarage); //=> 2.1999999999999997
	}
}

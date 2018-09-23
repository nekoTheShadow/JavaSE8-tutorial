package chapter2.question5;

import java.math.BigInteger;
import java.util.stream.Stream;

public class Question5 {
	public static void main(String[] args) {
		var seed = new BigInteger("1");
		var a = new BigInteger("25214903917");
		var c = new BigInteger("11");
		var m = new BigInteger("2").pow(48);
		
		rands(seed, a, c, m).limit(10).forEach(System.out::println);
	}
	
	public static Stream<BigInteger> rands(BigInteger seed, BigInteger a, BigInteger c, BigInteger m) {
		return Stream.iterate(seed, x -> a.multiply(x).add(c).mod(m));
	}
}

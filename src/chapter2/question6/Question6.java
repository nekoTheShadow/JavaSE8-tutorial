package chapter2.question6;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Question6 {
	public static Stream<Character> characterStream(String s) {
		return IntStream.range(0, s.length()).mapToObj(s::charAt);
	}
	
	public static void main(String[] args) throws IOException  {
		var contents = new String(Files.readAllBytes(Paths.get("alice.txt")));
		characterStream(contents).forEach(System.out::println);
	}
}

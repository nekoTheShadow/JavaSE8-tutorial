package chapter2.question13;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Question13 {
	public static String countShortWord(Stream<String> words) {
		var shortWords = new long[12];
		words
			.filter(word -> word.length() < 12)
			.collect(Collectors.groupingBy(String::length, Collectors.counting()))
			.entrySet()
			.stream()
			.forEach(e -> shortWords[e.getKey()] = e.getValue());
		return Arrays.toString(shortWords);
	}
	
	public static void main(String[] args) throws IOException, URISyntaxException {
		var contents = new String(Files.readAllBytes(Paths.get("alice.txt")));
		var words = contents.split("[\\P{L}]+");
		System.out.println(countShortWord(Arrays.stream(words)));
		//=> [1, 1826, 4999, 7637, 6166, 3589, 2203, 1867, 831, 697, 358, 149]
	}
}

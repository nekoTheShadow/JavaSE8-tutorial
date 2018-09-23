package chapter2.question12;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class Quesion12 {
	public static String countShortWord(Stream<String> words) {
		var shortWords = new AtomicInteger[12];
		Arrays.setAll(shortWords, i -> new AtomicInteger());
		words.parallel().forEach(word -> {
			int len = word.length();
			if (len < 12) {
				shortWords[len].getAndIncrement();
			}
		});
		return Arrays.toString(shortWords);
	}
	
	public static void main(String[] args) throws IOException, URISyntaxException {
		var contents = new String(Files.readAllBytes(Paths.get("alice.txt")));
		var words = contents.split("[\\P{L}]+");
		System.out.println(countShortWord(Arrays.stream(words)));
		//=> [1, 1826, 4999, 7637, 6166, 3589, 2203, 1867, 831, 697, 358, 149]
	}
}

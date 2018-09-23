package chapter2.question1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;


public class Question1 {
	public static void main(String[] args) throws IOException  {
		var contents = new String(Files.readAllBytes(Paths.get("alice.txt")));
		var words = contents.split("[\\P{L}]+");
		countLongWordsAsync(words);
	}
	
	public static long countLongWordsAsync(String[] words) throws IOException {
		return Arrays.stream(words).parallel().filter(line -> {
			System.out.printf("ThreadID=%d%n", Thread.currentThread().getId());
			return line.length() > 12;
		}).count();
	}

	public static long countLongWordsSync(String[] words) {
		 return Arrays.stream(words).filter(line -> line.length() > 12).count();
	}
}

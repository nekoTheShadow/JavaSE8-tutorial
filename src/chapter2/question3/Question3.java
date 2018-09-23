package chapter2.question3;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

import chapter2.question1.Question1;

public class Question3 {
	public static void main(String[] args) throws URISyntaxException, IOException {
		var contents = new String(Files.readAllBytes(Paths.get("alice.txt")));
		var words = contents.split("[\\P{L}]+");
		
		var s1 = System.nanoTime();
		Question1.countLongWordsAsync(words);
		var e1 = System.nanoTime();
		System.out.println(e1 - s1); //=> 603476700
		
		var s2 = System.nanoTime();
		Question1.countLongWordsSync(words);
		var e2 = System.nanoTime();
		System.out.println(e2 - s2); //=> 16103000
	}
}

package chapter2.question2;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Question2 {
	public static void main(String[] args) {
		var words = Stream.of("1", "12", "123", "1234", "12345", "123456", "1234567", "12345678");
		System.out.println(getFiveLongWords(words));
	}
	
	public static List<String> getFiveLongWords(Stream<String> words) {
		return words.filter(word -> {
			System.out.printf("word=%s%n", word);
			return word.length() > 2;
		}).limit(5).collect(Collectors.toList());
	}
}

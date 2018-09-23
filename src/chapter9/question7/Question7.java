package chapter9.question7;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Question7 {	
	public static void main(String[] args) {
		try (var in = new URL("https://www.google.co.jp/").openStream()) {
			var out = Paths.get("chapter9.question7.txt");
			Files.copy(in, out);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

package chapter9.question5;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Question5 {	
	public static void main(String[] args) throws IOException {
		var in = Paths.get("war-and-peace.txt");
		var out = Paths.get("chapter9.question4.txt");
		
		var bytes = Files.readAllBytes(in);
		int len = bytes.length;
		var reversed = new byte[len];
		for (int i = 0; i < len; i++) {
			reversed[len - i - 1] = bytes[i];
		}

		Files.write(out, reversed);
	}
}

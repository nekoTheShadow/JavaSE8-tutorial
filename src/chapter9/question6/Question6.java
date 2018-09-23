package chapter9.question6;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;

public class Question6 {	
	public static void main(String[] args) throws IOException {
		var in = Paths.get("war-and-peace.txt");
		var out = Paths.get("chapter9.question5.txt");
		
		var lines = Files.readAllLines(in);
		Collections.reverse(lines);
		Files.write(out, lines);
	}
}

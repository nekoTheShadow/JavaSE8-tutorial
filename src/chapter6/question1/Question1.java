package chapter6.question1;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;

public class Question1 {
	public static void main(String[] args) throws IOException, URISyntaxException {
		var contents = new String(Files.readAllBytes(Paths.get("war-and-peace.txt")));
		var words = contents.split("[\\P{L}]+");
		
		var max = new AtomicReference<String>("");
		Arrays.stream(words).parallel().forEach(w -> max.accumulateAndGet(w, (w1, w2) -> w1.length() < w2.length() ? w2 : w1));
		System.out.println(max.get()); //=> characteristically
	}
}

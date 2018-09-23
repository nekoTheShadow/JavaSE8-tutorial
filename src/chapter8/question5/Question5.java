package chapter8.question5;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Question5 {
	public static void main(String[] args) throws IOException {
		var t1 = time(Paths.get("alice.txt"), (words) -> countByNotUsingStream(words));
		var t2 = time(Paths.get("alice.txt"), (words) -> countByUsingStream(words));
		var t3 = time(Paths.get("war-and-peace.txt"), (words) -> countByNotUsingStream(words));
		var t4 = time(Paths.get("war-and-peace.txt"), (words) -> countByUsingStream(words));
		
		System.out.printf("alice.txt countByNotUsingStream %d msec.%n", t1);
		System.out.printf("alice.txt countByUsingStream %d msec.%n", t2);
		System.out.printf("war-and-peace.txt countByNotUsingStream %d msec.%n", t3);
		System.out.printf("war-and-peace.txt countByUsingStream %d msec.%n", t4);
		
		// 当たり前であるが、streamを利用する方が高速。とくにリストサイズが大きいとそれが顕著にわかる。
		// alice.txt countByNotUsingStream 17 msec.
		// alice.txt countByUsingStream 10 msec.
		// war-and-peace.txt countByNotUsingStream 28 msec.
		// war-and-peace.txt countByUsingStream 7 msec.
	}
	
	public static long countByUsingStream(List<String> words) {
		return words.stream().filter(w -> w.length() > 12).count();
	}
	
	public static long countByNotUsingStream(List<String> words) {
		var lst = new ArrayList<>(words);
		lst.removeIf(w -> w.length() <= 12);
		return lst.size();
	}
	
	public static long time(Path path, Consumer<List<String>> method) throws IOException {
		var contents = new String(Files.readAllBytes(path));
		var words = Arrays.asList(contents.split("[\\P{L}]+"));
		
		var start = System.currentTimeMillis();
		method.accept(words);
		return System.currentTimeMillis() - start;
	}
}

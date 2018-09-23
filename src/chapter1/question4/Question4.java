package chapter1.question4;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Function;

public class Question4 {
	public static void sort(File[] files) {
		Arrays.sort(files, Comparator.comparing(File::isDirectory).reversed().thenComparing(Function.identity()));
	}
}

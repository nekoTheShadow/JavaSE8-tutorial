package chapter1.question3;

import java.io.File;

public class Question3 {
	public static String[] getFilesByExt(File directory, String ext) {
		return directory.list((dir, name) -> name.endsWith(ext));
	}
}

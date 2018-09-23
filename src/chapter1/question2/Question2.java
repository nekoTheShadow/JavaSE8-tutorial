package chapter1.question2;

import java.io.File;

public class Question2 {
	public static File[] getSubDirectoriesByLambda(File dir) {
		return dir.listFiles(file -> file.isDirectory());
	}
	
	public static File[] getSubDirectoriesByReference(File dir) {
		return dir.listFiles(File::isDirectory);		
	}
}

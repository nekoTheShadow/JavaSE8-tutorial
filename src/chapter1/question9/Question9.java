package chapter1.question9;

import java.util.ArrayList;

public class Question9 {
	public static void main(String[] args) {
		var names = new ArrayList2<String>();
		names.add("Peter");
		names.add("Paul");
		names.add("Mary");
		
		names.forEachIF(System.out::println, name -> name.startsWith("P"));
	}
	
	public static class ArrayList2<E> extends ArrayList<E> implements Collection2<E> {}
}

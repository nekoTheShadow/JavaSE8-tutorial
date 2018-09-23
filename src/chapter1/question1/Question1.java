package chapter1.question1;

import java.util.Arrays;
import java.util.Comparator;

public class Question1 {
	public static void main(String[] args) {
		System.out.printf("out ouf lambda. ThreadID=%d%n", Thread.currentThread().getId());
		
		var strs = new String[] {"2", "1", "21", "10", "3"};
		Arrays.sort(strs, Comparator.comparing(str -> {
			System.out.printf("in lambda. ThreadID=%d%n", Thread.currentThread().getId());
			return Integer.valueOf(str);
		}));
	}
}

//out ouf lambda. ThreadID=1
//in lambda. ThreadID=1
//in lambda. ThreadID=1
//in lambda. ThreadID=1
//in lambda. ThreadID=1
//in lambda. ThreadID=1
//in lambda. ThreadID=1
//in lambda. ThreadID=1
//in lambda. ThreadID=1
//in lambda. ThreadID=1
//in lambda. ThreadID=1
//in lambda. ThreadID=1
//in lambda. ThreadID=1
//in lambda. ThreadID=1
//in lambda. ThreadID=1


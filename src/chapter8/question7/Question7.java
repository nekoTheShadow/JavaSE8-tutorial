package chapter8.question7;

import java.util.Arrays;
import java.util.Comparator;

public class Question7 {
	public static void main(String[] args) {
		var lst1 = Arrays.asList("a", null, "b", null, "c");
		Comparator<String> c1 = Comparator.nullsFirst(Comparator.naturalOrder());
		lst1.sort(c1.reversed());
		
		var lst2 = Arrays.asList("a", null, "b", null, "c");
		Comparator<String> c2 = Comparator.nullsLast(Comparator.reverseOrder());
		lst2.sort(c2);
		
		System.out.println(lst1); //=> [c, b, a, null, null]
		System.out.println(lst2); //=> [c, b, a, null, null]
	}
}

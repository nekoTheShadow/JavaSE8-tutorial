package chapter2.question9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class Question9 {
	public static void main(String[] args) {
		var lsts = List.of(List.of("A"), List.of("B", "C"), List.of("D", "E", "F"));
		System.out.println(flatten1(lsts.stream())); //=> [A, B, C, D, E, F]
		System.out.println(flatten2(lsts.stream())); //=> [A, B, C, D, E, F]
		System.out.println(flatten3(lsts.stream())); //=> [A, B, C, D, E, F]
	}
	
	public static <T> List<T> flatten1(Stream<List<T>> lsts) {
		return lsts.reduce((sum, lst) -> concat(sum, lst)).orElse(Collections.emptyList());
	}
	
	public static <T> List<T> flatten2(Stream<List<T>> lsts) {
		return lsts.reduce(List.of(), (sum, lst) -> concat(sum, lst));
	}
	
	public static <T> List<T> flatten3(Stream<List<T>> lsts) {
		return lsts.reduce(List.of(), (sum, lst) -> concat(sum, lst), (sum, lst) -> concat(sum, lst));
	}
	
	private static <T> List<T> concat(List<T> lst1, List<T> lst2) {
		var lst = new ArrayList<T>();
		lst.addAll(lst1);
		lst.addAll(lst2);
		return lst;
	}
	
}

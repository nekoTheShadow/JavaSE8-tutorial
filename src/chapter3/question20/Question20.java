package chapter3.question20;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Question20 {
	public static void main(String[] args) {
		var list1 = List.of(1, 2, 3);
		var list2 = map(list1, x -> "x=" + x);
		System.out.println(list1); //=> [1, 2, 3]
		System.out.println(list2); //=> [x=1, x=2, x=3]
	}
	
	public static <T, U> List<U> map(List<T> list, Function<T, U> function) {
		return list.stream().map(function).collect(Collectors.toList());
	}
}

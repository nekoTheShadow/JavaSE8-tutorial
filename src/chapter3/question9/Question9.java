package chapter3.question9;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class Question9 {
	public static <T> Comparator<T> lexicographicComparator(String ... fieldNames) {
		return (a, b) -> {
			for (String fieldName : fieldNames) {
				var x = getFieldValue(a, fieldName);
				var y = getFieldValue(b, fieldName);
				if (Objects.equals(x, y)) {
					continue;
				}
				return ((Comparable)x).compareTo((Comparable)y);
			}
			return 0;
		};
	}
	
	private static Object getFieldValue(Object o, String fieldName) {
		try {
			var field = o.getClass().getDeclaredField(fieldName);
			field.setAccessible(true);
			return field.get(o);
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static void main(String[] args) {
		var p1 = new Person("a", "A");
		var p2 = new Person("b", "A");
		var p3 = new Person("a", "B");
		var persons = List.of(p1, p2, p3);
		
		var c1 = lexicographicComparator("firstname", "lastname");
		persons.stream().sorted(c1).forEach(System.out::println);
		// firstname=a, lastname=A
		// firstname=a, lastname=B
		// firstname=b, lastname=A
		
		var c2 = lexicographicComparator("lastname", "firstname");
		persons.stream().sorted(c2).forEach(System.out::println);
		// firstname=a, lastname=A
		// firstname=b, lastname=A
		// firstname=a, lastname=B
	}
}

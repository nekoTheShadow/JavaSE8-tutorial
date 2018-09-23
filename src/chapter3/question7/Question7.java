package chapter3.question7;

import java.util.Comparator;

public class Question7 {
	public static void main(String[] args) {
		// reverseのテスト
		System.out.println(createComparator(true, false, false).compare("A", "B")); //=> 1
		System.out.println(createComparator(false, false, false).compare("B", "A")); //=> 1
		
		// ignoreCaseのテスト
		System.out.println(createComparator(false, true, false).compare("a", "B")); //=> -1
		System.out.println(createComparator(false, false, false).compare("a", "B")); //=> 31
		
		// ignoreWhiteSpaceのテスト
		System.out.println(createComparator(false, false, true).compare("a a", "aa")); //=> 0
		System.out.println(createComparator(false, false, false).compare("a a", "aa")); //=> -65
	}
	
	public static Comparator<String> createComparator(boolean reverse, boolean ignoreCase, boolean ignoreWhiteSpace) {
		return (s1, s2) -> {
			if (ignoreCase) {
				s1 = s1.toLowerCase();
				s2 = s2.toLowerCase();
			}
			
			if (ignoreWhiteSpace) {
				s1 = removeWhiteSpace(s1);
				s2 = removeWhiteSpace(s2);
			}
			
			return reverse ? s2.compareTo(s1) : s1.compareTo(s2);
		};
	}
	
	private static String removeWhiteSpace(String s) {
		var buffer = new StringBuilder();
		for (char c : s.toCharArray()) {
			if (!Character.isWhitespace(c)) {
				buffer.append(c);
			}
		}
		return buffer.toString();
	}
}

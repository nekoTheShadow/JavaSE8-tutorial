package chapter8.question12;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {		
		for (var method : Calculation.class.getMethods()) {
			for (var testCase : getTestCases(method)) {
				var param = testCase.param();
				var actual = (int) method.invoke(null, param); // static methodのみ
				var expected = testCase.expected();
				var result = actual == expected ? "OK" : "NG";
				
				var line = String.format("%s(%d): expected=%d actual=%d ---> %s", method.getName(), param, expected, actual, result);
				System.out.println(line);
			}
		}
	}
	
	private static List<TestCase> getTestCases(Method method) {
		var testCase = method.getAnnotation(TestCase.class);
		if (testCase != null) {
			return Arrays.asList(testCase);
		}
		
		var testCases = method.getAnnotation(TestCases.class);
		if (testCases != null) {
			return Arrays.asList(testCases.value());
		}
		
		return Collections.emptyList();
	}
}

// twice(2): expected=4 actual=4 ---> OK
// factorial(3): expected=6 actual=6 ---> OK
// factorial(4): expected=6 actual=24 ---> NG

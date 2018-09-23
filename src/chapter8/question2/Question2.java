package chapter8.question2;

public class Question2 {
	public static void main(String[] args) {
		Math.negateExact(Integer.MIN_VALUE);
	}
}

// Exception in thread "main" java.lang.ArithmeticException: integer overflow
//     at java.base/java.lang.Math.negateExact(Math.java:1036)
//     at chapter8.question2.Question2.main(Question2.java:5)

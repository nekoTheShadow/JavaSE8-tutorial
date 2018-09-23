package chapter3.question3;

import java.util.function.BooleanSupplier;

public class Question3 {
	public static void main(String[] args) {
		// argsが空配列でも以下のコードはエラーにならない。
		// Boolean.getBoolean("java.enable.assertions")がTrueになるまで、condは評価されない。
		assertion(() -> args[0] == null);
	}
	
	public static void assertion(BooleanSupplier cond) {
		if (Boolean.getBoolean("java.enable.assertions") && !cond.getAsBoolean()) {
			throw new AssertionError();
		}
	}
}

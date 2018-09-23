package chapter3.question1;

import java.util.function.BooleanSupplier;
import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Question1 {
	public static void main(String[] args) {
		logIf(Level.INFO, () -> true, () -> "TRUE!!!");
		logIf(Level.INFO, () -> false, () -> "FALSE!!!");
		logIf(Level.INFO, () -> false, () -> {
			System.out.println("これは出力されない");
			return "";
		});
	}
	
	public static void logIf(Level level, BooleanSupplier cond, Supplier<String> message) {
		var logger = Logger.getGlobal();
		if (cond.getAsBoolean()) {
			logger.log(level, message.get());
		}
	}
}

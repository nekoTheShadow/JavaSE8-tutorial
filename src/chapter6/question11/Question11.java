package chapter6.question11;

import java.net.PasswordAuthentication;
import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;
import java.util.function.Supplier;


public class Question11 {
	public static <T> CompletableFuture<T> repeat(Supplier<T> action, Predicate<T> until) {
		return CompletableFuture
			.supplyAsync(action)
			.thenComposeAsync(t -> until.test(t) ? CompletableFuture.completedFuture(t) : repeat(action, until));
	}
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		var stdin = new Scanner(System.in);
		Supplier<PasswordAuthentication> action = () -> {
			System.out.println("username");
			var username = stdin.nextLine();
			System.out.println("password");
			var password = stdin.nextLine();
			return new PasswordAuthentication(username, password.toCharArray());
		};
		Predicate<PasswordAuthentication> until = (auth) -> {
			sleep(3000);
			return Arrays.equals(auth.getPassword(), "secret".toCharArray());
		};
		
		var result = repeat(action, until);
		result.thenAccept(auth -> System.out.println("***" + auth.getUserName() + "***"));
		ForkJoinPool.commonPool().awaitQuiescence(Long.MAX_VALUE, TimeUnit.MINUTES); 
		
	}
	
	private static void sleep(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			// PASS
		}
	}
}

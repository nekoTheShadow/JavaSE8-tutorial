package chapter3.question22;

import java.util.concurrent.CompletableFuture;

public class Question22 {
	public static void main(String[] args) {
		CompletableFuture
			.supplyAsync(() -> 100)
			.thenCompose(x -> CompletableFuture.runAsync(() -> System.out.println(x)));
		//-> CompleetableFuturenに対するflatMapは? ... thenCompose
	}
}

package chapter1.question7;

public class Question7 {
	public static void main(String[] args) {
		var r = andThen(() -> {
			System.out.println("1-A");
			System.out.println("1-B");
		}, () -> {
			System.out.println("2-A");
			System.out.println("2-B");
		});
		r.run();
		// 1-A
		// 1-B
		// 2-A
		// 2-B
	}
	
	public static Runnable andThen(Runnable r1, Runnable r2) {
		return () -> {
			r1.run();
			r2.run();
		};
	}
}

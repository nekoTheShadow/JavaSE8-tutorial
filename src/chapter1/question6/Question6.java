package chapter1.question6;

public class Question6 {
	public static Runnable uncheck(RunnableEx r) {
		return () -> {
			try {
				r.run();
			} catch (Throwable e) {
				new RuntimeException(e);
			}
		};
	}
	
	public static void main(String[] args) {
		var t = new Thread(uncheck(() -> {
			System.out.println("zzz");
			Thread.sleep(1000);
		}));
		
		t.start();
	}
	
	@FunctionalInterface
	public static interface RunnableEx {
		void run() throws Exception;
	}
}
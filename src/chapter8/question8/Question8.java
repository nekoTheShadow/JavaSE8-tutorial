package chapter8.question8;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Question8 {
	public static void main(String[] args) {
		test1();
		test2();
	}
	
	// キャストエラーは本来挿入時に検出できるはずだが、実際には
	// キューから値を取り出したタイミングで、キャストエラーになる。
	public static void test1() {
		var q = new LinkedList<String>();
		addValue(q);
		q.forEach(v -> v.length());
	}
	
	// キューに値を挿入するタイミングでキャストエラーになる。
	public static void test2() {
		Queue<String> q = new LinkedList<>();
		q = Collections.checkedQueue(q, String.class);
		addValue(q);
		q.forEach(v -> v.length());
	}
	
	private static void addValue(Queue q) {
		q.add("aaa");
		q.add(1);
	}
}

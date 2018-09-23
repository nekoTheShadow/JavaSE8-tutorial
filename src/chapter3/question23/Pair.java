package chapter3.question23;

import java.util.function.Function;

public class Pair<T> {
	private T t1;
	private T t2;
	
	private Pair(T t1, T t2) {
		this.t1 = t1;
		this.t2 = t2;
	}
	
	@Override
	public String toString() {
		return String.format("Pair[%s, %s]", this.t1, this.t2);
	}
	
	// Question23
	public <U> Pair<U> map(Function<T, U> mapper) {
		return new Pair<U>(mapper.apply(this.t1), mapper.apply(this.t2));
	}
	
	// Question24
	// 2つのPairから1つのPairを生成できない。

	public static void main(String[] args) {
		var p1 = new Pair<>(1, 2);
		var p2 = p1.map(i -> "P" + i);
		
		System.out.println(p1); //=> Pair[1, 2]
		System.out.println(p2); //=> Pair[P1, P2]
	}
}

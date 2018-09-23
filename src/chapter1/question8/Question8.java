package chapter1.question8;

import java.util.ArrayList;

public class Question8 {

	public static void main(String[] args) {
		var names = new String[] {"Peter", "Paul", "Mary"};
		var runners = new ArrayList<Runnable>();
		
		// コンパイルがとおる。
		for (String name : names) {
			runners.add(() -> System.out.println(name));
		}
		
		// 以下はコンパイルが通らない ... 変数iがfinal宣言されていないため。
		// for (int i = 0; i < names.length; i++) {
		// 	runners.add(() -> System.out.println(names[i]));
		// }
		
		runners.forEach(Runnable::run);
	}

}

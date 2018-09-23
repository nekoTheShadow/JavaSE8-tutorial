package chapter6.question2;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.LongAdder;

public class Question2 {
	public static void main(String[] args) throws InterruptedException {
		var digit = new LongAdder();
		
		var service = Executors.newCachedThreadPool();
		for (int i = 0; i < 100; i++) {
			service.submit(() ->{
				System.out.println(digit.sum());
				digit.increment();
			});
		}
		service.shutdown();
		service.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);
	}
}

/*
上述のコードは「LongAdderインスタンスの現在の値を表示して、そのあとに1を加える」という操作を100個のスレッドから行う。
想定では0から99までの整数が重複なく表示されるはずだが、LongAdder#sumメソッドがsynchronizedされていないため、実際の結果はそうならない。
0
0
0
2
2
5
6
2
8
9
9
2
12
13
3
15
3
3
15
19
20
21
22
23
24
25
26
27
28
29
30
31
32
33
34
35
36
26
38
38
37
37
36
30
30
27
27
41
41
41
41
41
41
41
41
41
41
41
41
41
41
41
41
41
41
41
41
41
41
41
41
41
41
41
41
41
41
41
41
41
41
41
41
41
41
41
41
41
41
41
41
41
41
41
41
41
41
41
41
41
*/

package chapter5.question7;

import java.time.LocalDate;
import java.time.LocalTime;

public class Main {

	public static void main(String[] args) {
		var t1 = new TimeInterval(LocalDate.now(), LocalTime.of(1, 1), LocalTime.of(1, 2));
		var t2 = new TimeInterval(LocalDate.now(), LocalTime.of(1, 1), LocalTime.of(1, 3));
		System.out.println(t1.isOverlap(t2)); //=> true
		
		var t3 = new TimeInterval(LocalDate.now(), LocalTime.of(1, 1), LocalTime.of(1, 1));
		var t4 = new TimeInterval(LocalDate.now(), LocalTime.of(1, 2), LocalTime.of(1, 3));
		System.out.println(t3.isOverlap(t4)); //=> false
	}

}

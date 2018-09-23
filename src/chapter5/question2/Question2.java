package chapter5.question2;

import java.time.LocalDate;

public class Question2 {

	public static void main(String[] args) {
		var w = LocalDate.of(2000, 2, 29);
		System.out.println(w.plusYears(1)); //=> 2001-02-28
		System.out.println(w.plusYears(1).plusYears(1).plusYears(1).plusYears(1).plusYears(1)); //=> 2005-02-28
	}

}

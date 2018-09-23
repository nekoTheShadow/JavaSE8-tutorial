package chapter5.question5;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Question5 {
	public static long countDays(LocalDate date1, LocalDate date2) {
		return Math.abs(ChronoUnit.DAYS.between(date1, date2));
	}
	
	public static void main(String[] args) {
		System.out.println(countDays(LocalDate.of(1992, 9, 3), LocalDate.now())); //=> 9481
	}
}

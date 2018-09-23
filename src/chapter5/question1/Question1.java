package chapter5.question1;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Question1 {
	public static LocalDate getProgrammersDay(int year) {
		return LocalDate.of(year, 1, 1).plus(256, ChronoUnit.DAYS);
	}
	
	public static void main(String[] args) {
		System.out.println(getProgrammersDay(2018)); //=> 2018-09-14
	}
}

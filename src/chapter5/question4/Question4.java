package chapter5.question4;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Question4 {
	public static String cal(int year, int month) {
		var first = LocalDate.of(year, month, 1).with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));
		var last = LocalDate.of(year, month, 1).with(TemporalAdjusters.lastDayOfMonth()).plusDays(1);
		
		var cells = Stream
			.iterate(first, date -> date.isBefore(last), date -> date.plusDays(1))
			.map(date -> date.getMonthValue() == month ? String.format("%2s", date.getDayOfMonth()) : "  ")
			.collect(Collectors.toList());
		return IntStream.iterate(0, x -> x < cells.size(), x -> x + 7)
			.mapToObj(x -> String.join(" ", cells.subList(x, Math.min(x + 7, cells.size()))))
			.collect(Collectors.joining(System.lineSeparator()));
	}
	
	public static void main(String[] args) {
		System.out.println(cal(2018, 8));
		//        1  2  3  4  5
		//  6  7  8  9 10 11 12
		// 13 14 15 16 17 18 19
		// 20 21 22 23 24 25 26
		// 27 28 29 30 31

	}
}



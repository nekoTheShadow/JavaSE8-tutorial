package chapter5.question3;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.function.Predicate;

public class Question3 {
	public static TemporalAdjuster next(Predicate<LocalDate> predicate) {
		return TemporalAdjusters.ofDateAdjuster(w -> {
			while (true) {
				w = w.plusDays(1);
				if (predicate.test(w)) {
					break;
				}
			}
			return w;
		});
	}
	
	public static void main(String[] args) {
		var today = LocalDate.of(2018, 8, 17); //=> 金曜日
		var weekday = today.with(next(w -> w.getDayOfWeek().getValue() < 6));
		System.out.println(weekday); //=> 2018-08-20 (月曜日)
	}
}

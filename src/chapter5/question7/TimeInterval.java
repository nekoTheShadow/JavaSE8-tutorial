package chapter5.question7;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

public class TimeInterval {
	private LocalDate date;
	private LocalTime from;
	private LocalTime to;
	
	public TimeInterval(LocalDate date, LocalTime from, LocalTime to) {
		this.date = Objects.requireNonNull(date);
		this.from = Objects.requireNonNull(from);
		this.to= Objects.requireNonNull(to);
		
		if (from.isAfter(to)) {
			throw new RuntimeException();
		}
	}
	
	// 比較開始日付 <= 対象終了日付 AND 対象開始日付 <= 比較終了日付
	public boolean isOverlap(TimeInterval other) {
		return this.date.isEqual(other.date) 
				&& (other.from.equals(this.to) || other.from.isBefore(this.to))
				&& (this.from.equals(other.to) || this.from.isBefore(other.to));
	}
}

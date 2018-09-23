package chapter5.question11;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Question11 {

	public static void main(String[] args) {
		var from = ZonedDateTime.of(LocalDateTime.of(2018, 8, 13, 14, 5), ZoneId.of("CET"));
		var to = ZonedDateTime.of(LocalDateTime.of(2018, 8, 13, 16, 40), ZoneId.of("America/Los_Angeles"));
		var duration = Duration.between(from, to);
		System.out.printf("%d:%d%n", duration.toHoursPart(), duration.toMinutesPart());
	}

}

package chapter5.question10;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Question10 {
	public static void main(String[] args) {
		var from = ZonedDateTime.of(LocalDateTime.of(2018, 8, 13, 15, 5), ZoneId.of("America/Los_Angeles"));
		var to = from.plusHours(10).plusMinutes(50).withZoneSameInstant(ZoneId.of("CET"));
		System.out.println(from);
		System.out.println(to);
	}
}

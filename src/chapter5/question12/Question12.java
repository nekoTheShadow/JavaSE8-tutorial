package chapter5.question12;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Question12 {
	public static void main(String[] args) {
		var callAtNewYork = ZonedDateTime.of(2018, 8, 13, 8 ,0 ,0 ,0, ZoneId.of("America/New_York"));
		var callAtTokio1HourBefore = callAtNewYork.plusHours(-1).withZoneSameInstant(ZoneId.systemDefault());
		System.out.println(callAtNewYork);
		System.out.println(callAtTokio1HourBefore);
	}
}

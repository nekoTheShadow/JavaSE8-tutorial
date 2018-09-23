package chapter5.question9;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class Questioin9 {
	public static void main(String[] args) {
		var now = LocalDateTime.now();
		var formatter = DateTimeFormatter.ofPattern("VV=xxxxx");
		ZoneId.getAvailableZoneIds()
			.stream()
			.map(ZoneId::of)
			.map(zone -> ZonedDateTime.of(now, zone))
			.map(formatter::format)
			.filter(fmt -> !fmt.substring(fmt.lastIndexOf(":") + 1, fmt.length()).equals("00"))
			.forEach(System.out::println);
	}
}

/*
America/St_Johns=-02:30
NZ-CHAT=+12:45
Pacific/Chatham=+12:45
Australia/Eucla=+08:45
Australia/North=+09:30
Australia/Yancowinna=+09:30
Australia/Adelaide=+09:30
Asia/Pyongyang=+08:30
Canada/Newfoundland=-02:30
Asia/Kolkata=+05:30
Australia/Broken_Hill=+09:30
Australia/Lord_Howe=+10:30
Pacific/Marquesas=-09:30
Asia/Yangon=+06:30
Australia/South=+09:30
Asia/Kathmandu=+05:45
Australia/LHI=+10:30
Asia/Colombo=+05:30
Iran=+04:30
Asia/Tehran=+04:30
Asia/Katmandu=+05:45
Australia/Darwin=+09:30
Asia/Rangoon=+06:30
Asia/Calcutta=+05:30
Asia/Kabul=+04:30
Indian/Cocos=+06:30
*/
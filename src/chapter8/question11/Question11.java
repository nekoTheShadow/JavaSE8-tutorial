package chapter8.question11;

import java.io.IOException;
import java.net.URL;
import java.util.Base64;

public class Question11 {
	public static void main(String[] args) {
		
		try {
			var username = "username";
			var password = "password";
			var auth = username + ":" + password;
			var encoder = Base64.getEncoder();
			var encoded = encoder.encodeToString(auth.getBytes());
			
			var url = new URL("hogehoge");
			var connection = url.openConnection();
			connection.setRequestProperty("Authorization", encoded);
			connection.connect();
			
			try (var in = connection.getInputStream()) {
				var bytes = in.readAllBytes();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}

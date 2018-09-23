package chapter9.question11;

import java.io.IOException;

/**
 * WINDOWSのため動作未確認(´・ω・｀)
 */
public class Question11 {
	public static void main(String[] args) throws IOException, InterruptedException {
		var home = System.getProperty("user.home");
		var builder = new ProcessBuilder("grep", "-r", "[0-9]{14,16}", home);
		var process = builder.start();
		process.waitFor();
	}
}

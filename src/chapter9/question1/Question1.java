package chapter9.question1;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.Scanner;

public class Question1 {
	public static void main(String[] args) {
		Scanner in = null;
		PrintWriter out = null;
		try {
			in = new Scanner(Paths.get("war-and-peace.txt"));
			out = new PrintWriter("chapter9.question1.txt");
			while (in.hasNext()) {
				out.println(in.next().toLowerCase());
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (in != null) {
				in.close();
			}
			if (out != null) {
				out.close();
			}
		}
	}
}

package chapter8.question14;

import java.util.Objects;

public class Question14 {
	public static void main(String[] args) {
		try {
			new Question14(null, "");
		} catch (NullPointerException e) {
			e.printStackTrace();
			// 以下のメッセージではどの変数がnullなのかよくわからない。
			// java.lang.NullPointerException
			//     at java.base/java.util.Objects.requireNonNull(Objects.java:221)
			//     at chapter8.question14.Question14.<init>(Question14.java:23)
			//     at chapter8.question14.Question14.main(Question14.java:8)
			
		}
		
		try {
			new Question14("", null);
		} catch (NullPointerException e) {
			e.printStackTrace();
			// 以下のメッセージではnullになった変数が一目瞭然。
			// java.lang.NullPointerException: text2 is null.
			//     at java.base/java.util.Objects.requireNonNull(Objects.java:246)
			//     at chapter8.question14.Question14.<init>(Question14.java:24)
			//     at chapter8.question14.Question14.main(Question14.java:14)
		}
	}
	
	private String text1;
	private String text2;
	public Question14(String text1, String text2) {
		this.text1 = Objects.requireNonNull(text1);
		this.text2 = Objects.requireNonNull(text2, "text2 is null.");
	}
}

package chapter6.question10;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UncheckedIOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

import javax.swing.text.MutableAttributeSet;
import javax.swing.text.html.HTML;
import javax.swing.text.html.HTML.Tag;
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.html.parser.ParserDelegator;

public class Question10 {
	public static void main(String[] args) {
		var future = CompletableFuture.supplyAsync(() -> {
			System.out.println("URLを入力してください。");
			var stdin = new Scanner(System.in);
			return stdin.nextLine();
		}).thenApplyAsync(url -> {
			var hrefs = new ArrayList<String>();
			var callback = new HTMLEditorKit.ParserCallback() {
				@Override
				public void handleStartTag(Tag t, MutableAttributeSet a, int pos) {
					if (t.equals(Tag.A)) {
						var href = (String) a.getAttribute(HTML.Attribute.HREF);
						if (href != null) {
							hrefs.add(href);
						}
					}
					super.handleStartTag(t, a, pos);
				}
			};
			
			var parser = new ParserDelegator();
			try (var reader = new InputStreamReader(new URL(url).openStream())) {
				parser.parse(reader, callback, true);
			} catch (IOException e) {
				throw new UncheckedIOException(e);
			}
			
			return hrefs;
		}).thenAcceptAsync(hrefs -> {
			hrefs.forEach(System.out::println);
		});
		
		ForkJoinPool.commonPool().awaitQuiescence(10, TimeUnit.SECONDS);
	}
}

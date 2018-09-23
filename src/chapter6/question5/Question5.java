package chapter6.question5;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

public class Question5 {
	public static void main(String[] args) throws IOException, InterruptedException {
		var texts = new ArrayList<Path>();
		try(var stream = Files.newDirectoryStream(Paths.get("."), "*.txt")) {
			stream.forEach(texts::add);
		}
		
		var pool = Executors.newCachedThreadPool();
		var map = new ConcurrentHashMap<String, Set<String>>();
		texts.parallelStream().forEach(filePath -> {
			var fileName = filePath.toString();
			try (var lines = Files.lines(filePath)) {
				lines.forEach(line -> pool.submit(new CountThread(map, line, fileName)));
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		});
		pool.shutdown();
		pool.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);
		
		try (var writer = Files.newBufferedWriter(Paths.get("chapter6.question5.txt"))) {
			map.forEach((key, set) -> {
				try {
					var line = String.format("%s:%s", key, String.join(",", set));
					writer.write(line);
					writer.newLine();
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			});
		}
	}
	
	private static class CountThread implements Runnable {
		private static Pattern pattern = Pattern.compile("[\\P{L}]+");
		
		private ConcurrentHashMap<String, Set<String>> map;
		private String line;
		private String fileName;
		
		public CountThread(ConcurrentHashMap<String, Set<String>> map, String line, String fileName) {
			this.map = map;
			this.line = line;
			this.fileName = fileName;
		}
		
		@Override
		public void run() {
			Arrays.stream(pattern.split(line)).forEach(word -> {
				var set = new HashSet<String>();
				set.add(this.fileName);
				
				map.merge(word, set, (set1, set2) -> {
					set1.addAll(set2);
					return set1;
				});
			});
		}
	}
}

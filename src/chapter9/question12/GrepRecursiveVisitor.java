package chapter9.question12;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class GrepRecursiveVisitor extends SimpleFileVisitor<Path> {
	private Pattern pattern;
	private List<MatchData> matchDatum = new ArrayList<>();
	
	public GrepRecursiveVisitor(Pattern pattern) {
		this.pattern = pattern;
	}
	
	@Override
	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
		Files.lines(file).forEach(line -> {
			var matcher = pattern.matcher(line);
			while (matcher.find()) {
				matchDatum.add(new MatchData(file, matcher.group()));
			}
		});
		return FileVisitResult.CONTINUE;
	}
	
	public List<MatchData> getMatchDatum() {
		return matchDatum;
	}
}

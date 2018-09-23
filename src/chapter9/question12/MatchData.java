package chapter9.question12;

import java.nio.file.Path;

public class MatchData {
	private Path file;
	private String matching;
	
	public MatchData(Path file, String matching) {
		this.file = file;
		this.matching = matching;
	}
	
	public Path getFile() {
		return file;
	}
	public String getMatching() {
		return matching;
	}
	public void setFile(Path file) {
		this.file = file;
	}
	public void setMatching(String matching) {
		this.matching = matching;
	}
	
	@Override
	public String toString() {
		return "MatchData [file=" + file + ", matching=" + matching + "]";
	}
}

package chapter9.question2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Stream;

public class Question2 {
	public static void main(String[] args) {
		var exceptions = new ArrayList<Exception>();
		
		BufferedReader in = null;
		BufferedWriter out = null;
		try {
			in = Files.newBufferedReader(Paths.get("war-and-peace.txt"));
			out = Files.newBufferedWriter(Paths.get("war-and-peace.txt"));
			String line;
			while ((line = in.readLine()) != null) {
				out.write(line);
				out.newLine();
			}
		} catch (IOException e) {
			exceptions.forEach(e::addSuppressed);
			e.printStackTrace();
		} finally {
			Stream.of(in, out).map(Question2::close).filter(Optional::isPresent).map(Optional::get).forEach(exceptions::add);
		}
	}
	
	public static Optional<IOException> close(Closeable c) {
		try {
			c.close();
		} catch (IOException e) {
			return Optional.of(e);
		}
		return Optional.empty();
	}
}

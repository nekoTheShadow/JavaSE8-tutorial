package chapter8.question10;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class Question10 {
	public static void main(String[] args) throws IOException, InterruptedException {
		var root = Files.createTempDirectory(null);		
		var target = Paths.get("C:\\Program Files\\Java\\jdk-10\\lib\\src.zip");
		try (var in = new ZipInputStream(Files.newInputStream(target))) {
			ZipEntry e;
			while ((e = in.getNextEntry()) != null) {
				var dst = Paths.get(root.toString(), e.getName());
				Files.createDirectories(dst.getParent());
				var bytes = in.readAllBytes();
				Files.write(dst, bytes);
				System.out.println(dst);
			}
		}
		
		// transientもしくはvolatileを含むファイルのパスをchapter8.question10.txtに記録する。
		// 条件を満たすファイルは1035個あるそうです。
		try (var entries = Files.walk(root);
			 var result = Files.newBufferedWriter(Paths.get("chapter8.question10.txt"))) {
			entries.filter(Files::isRegularFile).forEach(path -> {
				try (var lines = Files.lines(path)) {
					if (lines.anyMatch(line -> line.contains("transient") || line.contains("volatile"))) {
						result.write(path.toString());
						result.newLine();
					}
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			});
		}
	}
}

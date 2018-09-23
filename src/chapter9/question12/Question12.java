package chapter9.question12;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Pattern;

/**
 * ./src以下にあるすべてのファイルを再帰的に探索して
 * 正規表現「"^import.*$"」にマッチする行とそのファイル名を出力する。
 */
public class Question12 {
	public static void main(String[] args) throws IOException {
		var dir = Paths.get("./src");
		var pattern = Pattern.compile("^import.*$");
		var visitor = new GrepRecursiveVisitor(pattern);
		Files.walkFileTree(dir, visitor);
		visitor.getMatchDatum().forEach(System.out::println);
		// ---> 出力を一部抜粋 <---
		// MatchData [file=.\src\chapter9\question6\Question6.java, matching=import java.nio.file.Files;]
		// MatchData [file=.\src\chapter9\question6\Question6.java, matching=import java.nio.file.Paths;]
		// MatchData [file=.\src\chapter9\question6\Question6.java, matching=import java.util.Collection;]
		// MatchData [file=.\src\chapter9\question6\Question6.java, matching=import java.util.Collections;]
		// MatchData [file=.\src\chapter9\question7\Question7.java, matching=import java.io.IOException;]
		// MatchData [file=.\src\chapter9\question7\Question7.java, matching=import java.net.URL;]
		// MatchData [file=.\src\chapter9\question7\Question7.java, matching=import java.nio.file.Files;]
		// MatchData [file=.\src\chapter9\question7\Question7.java, matching=import java.nio.file.Paths;]
		// MatchData [file=.\src\chapter9\question9\LabeledPoint.java, matching=import java.util.Comparator;]
		// MatchData [file=.\src\chapter9\question9\LabeledPoint.java, matching=import java.util.HashMap;]
		// MatchData [file=.\src\chapter9\question9\LabeledPoint.java, matching=import java.util.Objects;]
	}
}

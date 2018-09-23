package chapter8.question13;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Stream;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.TypeElement;

import chapter8.question12.TestCase;

/**
 * javac chapter8/question13/TestCaseProcessor.java 
 * javac -processor chapter8.question13.TestCaseProcessor chapter8/question12/*.java
 * java chapter8.question13.Test
 *
 */
@SupportedAnnotationTypes({"chapter8.question12.TestCase", "chapter8.question12.TestCases"})
@SupportedSourceVersion(SourceVersion.RELEASE_10)
public class TestCaseProcessor extends AbstractProcessor {
	private int count = 0;
	
	@Override
	public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
		// This process create chapter8.question13.Test.
		// So, this file is processed in the 2nd Round.
		if (count++ != 0) {
			return true;
		}

		var stmts = annotations
				.stream()
				.flatMap(annotation -> roundEnv.getElementsAnnotatedWith(annotation).stream())
				.flatMap(element -> {
					
			var methodName = element.getEnclosingElement() + "." + element.getSimpleName();
			return Arrays.stream(element.getAnnotationsByType(TestCase.class)).flatMap(testCase -> {
				int param = testCase.param();
				int expected = testCase.expected();
				var stmt1 = String.format("System.out.println(\"%s(%d) ---> %d\");", methodName, param, expected);
				var stmt2 = String.format("System.out.println(%s(%d) == %d ? \"OK\" : \"NG\");", methodName, param, expected);
				return Stream.of(stmt1, stmt2);
			});
		});
		
		var lines = new ArrayList<String>();
		lines.add("package chapter8.question13;");
		lines.add("import chapter8.question12.*;");
		lines.add("public class Test {");
		lines.add("    public static void main(String[] args) {");
		stmts.map(stmt -> "        " + stmt).forEach(lines::add);
		lines.add("    }");
		lines.add("}");
		
		var filer = processingEnv.getFiler();
		try (var writer = filer.createSourceFile("chapter8.question13.Test").openWriter()) {
			for (var line : lines) {
				writer.write(line);
				writer.write(System.lineSeparator());
			}
		} catch (IOException e) {
			throw new UncheckedIOException(e);
		}
		return true;
	}
}

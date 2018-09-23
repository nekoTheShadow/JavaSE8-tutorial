package chapter3.question11;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.function.UnaryOperator;

import javax.imageio.ImageIO;

import chapter3.question5.ColorTransformer;
import chapter3.question5.Question5;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class Question11 {
	public static ColorTransformer compose(ColorTransformer c1, ColorTransformer c2) {		
		return (x, y, colorAtXY) -> c2.apply(x, y, c1.apply(x, y, colorAtXY));
	}
	
	public static ColorTransformer toColorTransformer(UnaryOperator<Color> op) {
		return (x, y, colorAtXY) -> op.apply(colorAtXY);
	}
	
	public static void main(String[] args) {
		var transformer = compose(toColorTransformer(Color::brighter), toColorTransformer(Color::grayscale));
		try (var is = Files.newInputStream(Paths.get("queen-mary.png"))) {
			var in = new Image(is);
			var out = Question5.transform(in, transformer);
			ImageIO.write(SwingFXUtils.fromFXImage(out, null), "png", new File("chapter3.question11.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

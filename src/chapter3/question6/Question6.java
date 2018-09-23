package chapter3.question6;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.function.BiFunction;

import javax.imageio.ImageIO;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

public class Question6 {
	public static void main(String[] args) {
		try (var is = Files.newInputStream(Paths.get("queen-mary.png"))) {
			var in = new Image(is);
			var out = transform(in, (c, arg) -> Color.color(c.getRed() / arg, c.getGreen() / arg, c.getBlue() / arg), 10);
			ImageIO.write(SwingFXUtils.fromFXImage(out, null), "png", new File("chapter3.question6.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static <T> Image transform(Image in, BiFunction<Color, T, Color> t, T arg) {
		int width = (int) in.getWidth();
		int height = (int) in.getHeight();
		var out = new WritableImage(width, height);
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				out.getPixelWriter().setColor(x, y, t.apply(in.getPixelReader().getColor(x, y), arg));
			}
		}
		return out;
	}
}

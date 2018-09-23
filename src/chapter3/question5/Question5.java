package chapter3.question5;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.imageio.ImageIO;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

public class Question5 {
	public static void main(String[] args) {
		try (var is = Files.newInputStream(Paths.get("queen-mary.png"))) {
			var in = new Image(is);
			var out = transform(in, (x, y, color) -> 10 <= x && x < in.getWidth() - 10 && 10 <= y && y < in.getHeight() - 10 ? color : Color.BLACK);
			ImageIO.write(SwingFXUtils.fromFXImage(out, null), "png", new File("chapter.question5.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static Image transform(Image in, ColorTransformer t) {
		int width = (int) in.getWidth();
		int height = (int) in.getHeight();
		var out = new WritableImage(width, height);
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				out.getPixelWriter().setColor(x, y, t.apply(x, y, in.getPixelReader().getColor(x, y)));
			}
		}
		return out;
	}
}

package chapter3.question12;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.imageio.ImageIO;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class Question12 {
	public static void main(String[] args) {	
		try (var is = Files.newInputStream(Paths.get("queen-mary.png"))) {
			var in = new Image(is);
			var out = LatentImage.from(in)
					.transform((x, y, c) -> x % 100 == 0 || y % 100 == 0 ? Color.BLACK : c)
					.transform(Color::brighter)
					.toImage();
			ImageIO.write(SwingFXUtils.fromFXImage(out, null), "png", new File("chapter3.question12.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

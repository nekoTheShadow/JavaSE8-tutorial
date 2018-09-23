package chapter3.question13;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Collectors;

import javax.imageio.ImageIO;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class Question13 {
	public static void main(String[] args) {
		try (var is = Files.newInputStream(Paths.get("queen-mary.png"))) {
			var in = new Image(is);
			var out = LatentImage.from(in)
				.transform((image, x, y) -> {
					var colors = new ArrayList<Color>();
					for (int i = -1; i < 2; i++) {
						for (int j = -1; j < 2; j++) {
							if (0 <= x + i && x + i < in.getWidth() && 0 <= y + j && y + j < in.getHeight()) {
								colors.add(image.getPixelReader().getColor(x + i, y + j));
							}
						}
					}
					var red = colors.stream().collect(Collectors.averagingDouble(Color::getRed));
					var green = colors.stream().collect(Collectors.averagingDouble(Color::getGreen));
					var blue = colors.stream().collect(Collectors.averagingDouble(Color::getBlue));
					return Color.color(red, green, blue);
				})
				.transform((image, x, y) -> x % 100 == 0 || y % 100 == 0 ? Color.BLACK : image.getPixelReader().getColor(x, y))
				.toImage();
			ImageIO.write(SwingFXUtils.fromFXImage(out, null), "png", new File("chapter3.question13.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

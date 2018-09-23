package chapter3.question8;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.imageio.ImageIO;

import chapter3.question5.ColorTransformer;
import chapter3.question5.Question5;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class Question8 {
	public static ColorTransformer createFrame(int width, int height, int margin, Color color) {
		return (x, y, c) -> (margin <= x && x < width - margin && margin <= y && y < height - margin) ? c : color;
	}
	
	public static void main(String[] args) {
		try (var is = Files.newInputStream(Paths.get("queen-mary.png"))) {
			var in = new Image(is);
			var out = Question5.transform(in, createFrame((int) in.getWidth(), (int) in.getHeight(), 20, Color.PINK));
			ImageIO.write(SwingFXUtils.fromFXImage(out, null), "png", new File("chapter3.question8.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

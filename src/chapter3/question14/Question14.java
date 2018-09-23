package chapter3.question14;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import javafx.scene.image.Image;

/**
 * この問題はとにかく日本語が意味不明なので、「lamdaにより鏡像操作ができればOK」とする。
 */
public class Question14 {
	public static void main(String[] args) {
		List<PixelImageFilter> filters = List.of(
			(image, x, y) -> image.getColor(image.getWidth() - (x + 1) , y),
			(image, x, y) -> image.getColor(x, y).brighter()
		);
				
		try (var is = Files.newInputStream(Paths.get("queen-mary.png"))) {
			var image = new PixelImage(new Image(is));
			
			for (int x = 0; x < image.getWidth(); x++) {
				for (int y = 0; y < image.getHeight(); y++) {
					for (var filter : filters) {
						image.setColor(x, y, filter.apply(image, x, y));
					}
				}
			}
			
			image.write(Paths.get("chapter3.question14.png"), "png");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

package chapter3.question13;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;


@FunctionalInterface
public interface ImageFilter {
	Color apply(Image image, int x, int y);
}

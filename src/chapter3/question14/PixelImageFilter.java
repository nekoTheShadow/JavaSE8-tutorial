package chapter3.question14;

import javafx.scene.paint.Color;

@FunctionalInterface
public interface PixelImageFilter {
	Color apply(PixelImage image, int x, int y);
}

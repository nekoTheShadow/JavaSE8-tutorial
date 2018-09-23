package chapter3.question5;

import javafx.scene.paint.Color;

@FunctionalInterface
public interface ColorTransformer {
	Color apply(int x, int y, Color colorAtXY);
}

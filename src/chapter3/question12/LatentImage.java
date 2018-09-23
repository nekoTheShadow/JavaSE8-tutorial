package chapter3.question12;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.function.UnaryOperator;

import chapter3.question5.ColorTransformer;
import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

public class LatentImage {
	private Image in;
	private List<ColorTransformer> pendingOperations = new ArrayList<>();

	public static LatentImage from(Image in) {
		var latentImange = new LatentImage();
		latentImange.in = in;
		return latentImange;
	}
	
	public LatentImage transform(UnaryOperator<Color> op) {
		pendingOperations.add((x, y, c) -> op.apply(c));
		return this;
	}
	
	public Image toImage() {
		int width = (int) in.getWidth();
		int height = (int) in.getHeight();
		
		var out = new WritableImage(width, height);
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				var c = in.getPixelReader().getColor(x, y);
				for (var op : pendingOperations) {
					c = op.apply(x, y, c);
				}
				out.getPixelWriter().setColor(x, y, c);
			}
		}
		return out;
	}
	
	// Question12
	public LatentImage transform(ColorTransformer transformer) {
		pendingOperations.add(transformer);
		return this;
	}
	
	// Question15
	public Image toImageByParallel() throws InterruptedException {
		int width = (int) in.getWidth();
		int height = (int) in.getHeight();
		var out = new WritableImage(width, height);
		var pool = Executors.newCachedThreadPool();
		
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				final int i = x;
				final int j = y;
				pool.submit(() -> {
					var c = in.getPixelReader().getColor(i, j);
					for (var op : pendingOperations) {
						c = op.apply(i, j, c);
					}
					out.getPixelWriter().setColor(i, j, c);
				});
			}
		}
		
		pool.shutdown();
		pool.awaitTermination(1, TimeUnit.HOURS);
		return out;
	}
}

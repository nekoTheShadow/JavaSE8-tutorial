package chapter3.question13;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;

public class LatentImage {
	private Image in;
	private List<ImageFilter> filters = new ArrayList<>();

	public static LatentImage from(Image in) {
		var latentImange = new LatentImage();
		latentImange.in = in;
		return latentImange;
	}
	
	public LatentImage transform(ImageFilter filter) {
		this.filters.add(filter);
		return this;
	}
	
	public Image toImage() {
		int width = (int) in.getWidth();
		int height = (int) in.getHeight();
		
		var image = in;
		for (var filter : filters) {
			var out = new WritableImage(width, height);
			for (int x = 0; x < width; x++) {
				for (int y = 0; y < height; y++) {
					out.getPixelWriter().setColor(x, y, filter.apply(image, x, y));
				}
			}
			image = out;
		}
		return image;
	}
}

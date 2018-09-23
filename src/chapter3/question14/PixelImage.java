package chapter3.question14;

import java.io.IOException;
import java.nio.file.Path;

import javax.imageio.ImageIO;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

public class PixelImage {
	private Color[][] colors;
	private int width;
	private int height;
	
	public PixelImage(Image image) {
		this.width = (int) image.getWidth();
		this.height = (int) image.getHeight();
		this.colors = new Color[this.width][this.height];
		for (int x = 0; x < this.width; x++) {
			for (int y = 0; y < this.height; y++) {
				this.colors[x][y] = image.getPixelReader().getColor(x, y);
			}
		}
	}
	
	public Color getColor(int x, int y) {
		return this.colors[x][y];
	}
	
	public void setColor(int x, int y, Color color) {
		this.colors[x][y] = Color.color(color.getRed(), color.getGreen(), color.getBlue());
	}
	
	public int getWidth() {
		return this.width;
	}

	public int getHeight() {
		return this.height;
	}
	
	public void write(Path path, String formatName) throws IOException {
		var writer = new WritableImage(width, height);
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				writer.getPixelWriter().setColor(i, j, colors[i][j]);
			}
		}
		ImageIO.write(SwingFXUtils.fromFXImage(writer, null), formatName, path.toFile());
	}
}

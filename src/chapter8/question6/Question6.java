package chapter8.question6;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.Comparator;

public class Question6 {
	public static void main(String[] args) {
		System.out.println(comparePoint2D().compare(new Point(0, 0), new Point(0, 0))); //=> 0
		System.out.println(compareRectangle2D().compare(new Rectangle(1, 1), new Rectangle(1, 1))); //=> 0
	}
	
	public static Comparator<Point2D> comparePoint2D() {
		return Comparator.comparingDouble(Point2D::getX).thenComparing(Point2D::getY);
	}
	
	public static Comparator<Rectangle2D> compareRectangle2D() {
		return Comparator
			.comparing(Rectangle2D::getMinX)
			.thenComparing(Rectangle2D::getMinY)
			.thenComparing(Rectangle2D::getMaxX)
			.thenComparing(Rectangle2D::getMaxY);
	}

}

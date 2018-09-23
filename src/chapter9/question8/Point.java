package chapter9.question8;

public class Point implements Comparable<Point> {
	private int x;
	private int y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	@Override
	public int compareTo(Point other) {
		int diff = compare(this.x, other.x);
		if (diff != 0) {
			return diff;
		}
		return compare(this.y, other.y);
	}
	
	private int compare(int a, int b) {
		return Integer.valueOf(a).compareTo(b);
	}
	
	public static void main(String[] args) {
		System.out.println(new Point(1, 1).compareTo(new Point(1, 1))); //=> 0
		System.out.println(new Point(1, 1).compareTo(new Point(1, 2))); //=> -1
		System.out.println(new Point(1, 1).compareTo(new Point(2, 1))); //=> -1
		System.out.println(new Point(1, 2).compareTo(new Point(1, 1))); //=> 1
		System.out.println(new Point(2, 1).compareTo(new Point(1, 1))); //=> 1
	}
}

package chapter9.question9;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Objects;

public class LabeledPoint implements Comparable<LabeledPoint>{
	public static void main(String[] args) {
		var p1 = new LabeledPoint("Alice", 0, 0);
		var p2 = new LabeledPoint("Alice", 0, 0);
		var p3 = new LabeledPoint("Bobby", 0, 0);
		
		// question9
		System.out.println(p1.equals(p2)); //=> true
		System.out.println(p1.equals(p3)); //=> false
		
		// question9
		var variables = new HashMap<LabeledPoint, String>();
		variables.put(p1, "p1");
		variables.put(p2, "p2");
		variables.put(p3, "p3");
		System.out.println(variables); //=> {<label=Bobby, x=0, y=0>=p2, <label=Alice, x=0, y=0>=p3}
		
		// question10
		System.out.println(p1.compareTo(p2)); //=> 0
		System.out.println(p1.compareTo(p3)); //=> -1
		System.out.println(p3.compareTo(p1)); //=> 1
	}
	
	private String label;
	private int x;
	private int y;
	
	public String getLabel() { return label; }
	public int getX() { return x; }
	public int getY() { return y; }
	public void setLabel(String label) { this.label = label; }
	public void setX(int x) { this.x = x; }
	public void setY(int y) { this.y = y; }
	
	// question9
	@Override
	public boolean equals(Object object) {
		if (object == null || !(object instanceof LabeledPoint)) {
			return false;
		}
		
		var other = (LabeledPoint) object;
		return Objects.deepEquals(this.label, other.label) 
				&& Objects.deepEquals(this.x, other.y) 
				&& Objects.deepEquals(this.x, other.y);
	}
	
	// question9
	@Override
	public int hashCode() {
		return Objects.hash(label, x, y);
	}

	// question10
	@Override
	public int compareTo(LabeledPoint other) {
		var c = Comparator.comparing(LabeledPoint::getLabel).thenComparing(LabeledPoint::getX).thenComparing(LabeledPoint::getY);
		return c.compare(this, other);
	}
	
	
	public LabeledPoint(String label, int x, int y) {
		this.label = label;
		this.x = x;
		this.y = y;
	}
	
	@Override
	public String toString() {
		return String.format("<label=%s, x=%d, y=%d>", label, x, y);
	}
}

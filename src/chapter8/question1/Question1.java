package chapter8.question1;

public class Question1 {
	public static void main(String[] args) {
		System.out.println(plus(-1, -1)); //=> -2
		System.out.println(sub(1, -1));   //=> 2
		
		// 4294967294 / 4294967293 = 1 ... 1
		System.out.println(div(-2, -3)); //=> 1
		System.out.println(mod(-2, -3)); //=> 1
		
		// 4294967294 > 4294967293 ---> 1
		System.out.println(comp(-2, -3)); //=> 1
	}
	
	public static int plus(int a, int b) {
		return a + b;
	}
	
	public static int sub(int a, int b) {
		return a - b;
	}
	
	public static int div(int a, int b) {
		return Integer.divideUnsigned(a, b);
	}
	
	public static int mod(int a, int b) {
		return Integer.remainderUnsigned(a, b);
	}
	
	public static int comp(int a, int b) {
		return Integer.compareUnsigned(a, b);
	}
}

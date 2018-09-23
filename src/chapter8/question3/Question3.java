package chapter8.question3;


public class Question3 {
	
	public static void main(String[] args) {
		System.out.println(gcdByPercent(100, 48));
		System.out.println(gcdByFloorMod(100, 48));
		System.out.println(gcdByRem(100, 48));
	}

	public static int gcdByPercent (int a, int b) {
		if (b == 0) {
			return a < 0 ? Math.negateExact(a): a;
		}
		return gcdByPercent(b, a % b);
	}
	
	public static int gcdByFloorMod (int a, int b) {
		if (b == 0) {
			return a < 0? Math.negateExact(a): a;
		}
		return gcdByFloorMod(b, Math.floorMod(a, b));
	}
	
	public static int gcdByRem (int a, int b) {
		if (b == 0) {
			return a < 0? Math.negateExact(a): a;
		}
		return gcdByRem(b, rem(a, b));
	}
	
	private static int rem(int a, int b) {
		int remainder = a % b;
		return remainder < 0 ? Math.negateExact(remainder): remainder;
	}

}

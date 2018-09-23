package chapter6.question9;

public class Matrix {
	private long[][] matrix = new long[2][2];
	
	public Matrix mutiply(Matrix other) {
		var answer = new Matrix();
		for (int x = 0; x < 2; x++) {
			for (int y = 0; y < 2; y++) {
				for (int i = 0; i < 2; i++) {
					answer.matrix[x][y] += this.matrix[x][i] * other.matrix[i][y];
				}
			}
		}
		return answer;
	}
	
	public String toString() {
		return String.format("[%d, %d], [%d, %d]", matrix[0][0], matrix[0][1], matrix[1][0], matrix[1][1]);
	}
	
	public static Matrix FIB1 = new Matrix();
	
	static {
		FIB1.matrix[0][0] = 1;
		FIB1.matrix[0][1] = 1;
		FIB1.matrix[1][0] = 1;
		FIB1.matrix[1][1] = 0;
	}
}

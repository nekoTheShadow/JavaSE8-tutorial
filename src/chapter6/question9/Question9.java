package chapter6.question9;

import java.util.Arrays;

public class Question9 {
	public static void main(String[] args) {
		var matrixs = new Matrix[30];
		Arrays.parallelSetAll(matrixs, i -> Matrix.FIB1);
		Arrays.parallelPrefix(matrixs, Matrix::mutiply);
		
		Arrays.stream(matrixs).forEach(System.out::println);
	}
}

/*
[1, 1], [1, 0]
[2, 1], [1, 1]
[3, 2], [2, 1]
[5, 3], [3, 2]
[8, 5], [5, 3]
[13, 8], [8, 5]
[21, 13], [13, 8]
[34, 21], [21, 13]
[55, 34], [34, 21]
[89, 55], [55, 34]
[144, 89], [89, 55]
[233, 144], [144, 89]
[377, 233], [233, 144]
[610, 377], [377, 233]
[987, 610], [610, 377]
[1597, 987], [987, 610]
[2584, 1597], [1597, 987]
[4181, 2584], [2584, 1597]
[6765, 4181], [4181, 2584]
[10946, 6765], [6765, 4181]
[17711, 10946], [10946, 6765]
[28657, 17711], [17711, 10946]
[46368, 28657], [28657, 17711]
[75025, 46368], [46368, 28657]
[121393, 75025], [75025, 46368]
[196418, 121393], [121393, 75025]
[317811, 196418], [196418, 121393]
[514229, 317811], [317811, 196418]
[832040, 514229], [514229, 317811]
[1346269, 832040], [832040, 514229]
*/
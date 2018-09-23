package chapter3.question10;

import javafx.scene.image.Image;

public class Question10 {
	public static void main(String[] args) {
		Image in = null;
		
		// ↓のコードはコンパイルに失敗する。
		// UnaryOperator::composeの戻り値はUnaryOperatorだが、transformの第2引数はFunctionのため。
		// UnaryOperator<Color> op = Color::brighter;
		// Image finalImage = Question5.transform(in, op.compose(Color::grascale));
	}
}

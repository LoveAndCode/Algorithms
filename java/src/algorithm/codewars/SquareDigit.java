package algorithm.codewars;

public class SquareDigit {

	public static void main(String[] args) {
		SquareDigit squareDigit = new SquareDigit();
		System.out.println(squareDigit.squareDigits(9199));
	}

	public int squareDigits(int n) {
		StringBuilder sb = new StringBuilder();
		for (char ch : String.valueOf(n).toCharArray()) {
			int value = ch - '0';
			sb.append(value * value);
		}
		return Integer.parseInt(sb.toString());
	}
}
package algorithm.recursion;

public class Code09 {
	public static void main(String[] args) {
		printInBinary(5);
	}

	public static void printInBinary(int n) {
		if (n < 2) {
			System.out.print(n);
		} else {
			printInBinary(n / 2);
			System.out.print(n % 2);
		}
	}
}

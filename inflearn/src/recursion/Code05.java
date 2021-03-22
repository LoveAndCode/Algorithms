package recursion;

public class Code05 {
	public static void main(String[] args) {
		int result = fibonacci(4);
		System.out.println("result = " + result);
	}

	public static int fibonacci(int n) {
		if (n < 2) {
			return n;
		}
		return fibonacci(n - 1) + fibonacci(n - 2);
	}
}

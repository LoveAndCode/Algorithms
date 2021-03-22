package recursion;

public class Code10 {
	public static void main(String[] args) {
		int result = sum(5, new int[] {1, 2, 3, 4, 5, 6, 7, 8, 10});
		System.out.println(result);
	}

	public static int sum(int n, int[] data) {
		if (n <= 0) {
			return 0;
		}
		return sum(n - 1, data) + data[n - 1];
	}
}

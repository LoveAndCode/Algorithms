package algorithm.nf;

public class Problem2 {
	public static void main(String[] args) {
		Problem2 problem2 = new Problem2();
		System.out.println(problem2.solution(1, 3, new int[] {0, 1, 2, -2, 3}, new int[] {0, 1, 4, 1, 0}));
		System.out.println(problem2.solution(2, 4, new int[] {4, 0, 1, -2}, new int[] {-4, 4, 3, 0}));

	}

	public int solution(int inner, int outer, int[] points_x, int[] points_y) {
		// write your code in Java SE 8
		int count = 0;

		for (int i = 0; i < points_x.length; i++) {
			int nx = points_x[i];
			int ny = points_y[i];
			System.out.printf("(%d,%d) is processing...\n", nx, ny);
			// check whole circle
			if (Math.pow(outer, 2) > Math.pow(-nx, 2) + Math.pow(-ny, 2)) {
				System.out.printf("(%d,%d) is inside whole circle...\n", nx, ny);
				if (!(Math.pow(inner, 2) >= Math.pow(-nx, 2) + Math.pow(-ny, 2))) {
					System.out.printf("(%d,%d) is inside target circle\n", nx, ny);
					count++;
				}
			}
		}

		return count;
	}
}

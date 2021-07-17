package algorithm.nf;

public class Problem1 {
	public static void main(String[] args) {
		Problem1 problem1 = new Problem1();

		System.out.println(problem1.solution(7, 42, new int[] {6, 42, 11, 7, 1, 42}));
		System.out.println(problem1.solution(6, 13, new int[] {13, 13, 1, 6}));
		System.out.println(problem1.solution(100, 63, new int[] {100, 63, 1, 6, 2, 13}));
		System.out.println(problem1.solution(10, 10, new int[] {10, 1, 2, 3, 10, 1, 10, 2, 13}));

	}

	int solutionOrigin(int X, int Y, int[] A) {
		int N = A.length;
		int result = -1;
		int nX = 0;
		int nY = 0;
		for (int i = 0; i < N; i++) {
			if (A[i] == X)
				nX += 1;
			else if (A[i] == Y)
				nY += 1;
			if (nX == nY)
				result = i;
		}
		return result;
	}

	int solution(int X, int Y, int[] A) {
		int N = A.length;
		int result = -1;
		int nX = 0;
		int nY = 0;
		for (int i = 0; i < N; i++) {
			if (A[i] == X)
				nX += 1;
			if (A[i] == Y)
				nY += 1;
			if (nX == nY && nX != 0 && nY != 0)
				result = i;
		}
		return result;
	}
}

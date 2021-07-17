package algorithm.nf;

public class Problem3 {
	public static void main(String[] args) {
		Problem3 problem3 = new Problem3();

		System.out.println("9 -> " + problem3.solution(new int[] {1, 2, -3, 4, 5, -6}));
		System.out.println("12 -> " + problem3.solution(new int[] {-8, 3, 0, 5, -3, 12}));
		System.out.println("8 -> " + problem3.solution(new int[] {-1, 2, 1, 2, 0, 2, 1, -3, 4, 3, 0, -1}));
		System.out.println("2 -> " + problem3.solution(new int[] {-1, 1, 1, -1}));
		System.out.println("29 -> " + problem3.solution(new int[] {1, 2, -1, 5, 7, -12, 29}));
		System.out.println("-1 -> " + problem3.solution(new int[] {-1, -2, -3}));
	}

	public int solution(int[] A) {
		// write your code in Java SE 8
		int max = 0;
		int beginIndex = 0;
		int positiveCount = 0;

		for (int i = 0; i < A.length; i++) {
			if (A[i] < 0) {
				int subSum = rageSum(A, beginIndex, i);
				if (max < subSum) {
					max = subSum;
				}
				beginIndex = i + 1;
			} else {
				positiveCount++;
			}
		}
		if (positiveCount == 0) {
			return -1;
		}

		int lastSum = rageSum(A, beginIndex, A.length);
		if (lastSum > max) {
			max = lastSum;
		}
		return max;
	}

	public int rageSum(int[] array, int start, int end) {
		int sum = 0;
		for (int i = start; i < end; i++) {
			sum += array[i];
		}
		return sum;
	}
}

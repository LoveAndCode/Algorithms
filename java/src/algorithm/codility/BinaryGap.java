package algorithm.codility;

import java.util.Stack;

public class BinaryGap {
	public static void main(String[] args) {
		int[] inputs = {1041, 32};
		int[] answers = {5, 0};
		BinaryGap binaryGap = new BinaryGap();
		for (int index = 0; index < inputs.length; index++) {
			int guess = binaryGap.solution(inputs[index]);
			boolean result = guess == answers[index];
			System.out.printf("Guess: %d -> Answer = %d : Result => %b \n", guess, answers[index], result);
		}
	}

	private int solution(int N) {
		String binaryString = Integer.toBinaryString(N);
		Stack<Character> stack = new Stack<>();

		int max = 0;
		// N
		for (char ch : binaryString.toCharArray()) {
			if (ch == '0') {
				stack.push(ch);
			} else {
				while (!stack.isEmpty()) {
					int numberOfZero = stack.size();
					if (numberOfZero > max) {
						max = numberOfZero;
					}
					stack.clear();
				}
			}
		}
		return max;
	}

}

package programers.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.stream.IntStream;

public class FeatureDevelopment {

	public static void main(String[] args) {
		int[][] progresses = {{93, 30, 55}, {95, 90, 99, 99, 80, 99}};
		int[][] speeds = {{1, 30, 5}, {1, 1, 1, 1, 1, 1}};
		int[][] answer = {{2, 1}, {1, 3, 2}};

		FeatureDevelopment featureDevelopment = new FeatureDevelopment();
		for (int i = 0; i < progresses.length; i++) {
			int[] result = featureDevelopment.solution(progresses[i], speeds[i]);
			boolean isRight = featureDevelopment.isRight(answer[i], result);
			System.out.printf("%d 번쨰 정답 input: %s , answer: %s , result: %s  ==> %s \n", i + 1,
				Arrays.toString(progresses[i]), Arrays.toString(answer[i]), Arrays.toString(result), isRight
			);
		}
	}

	public int[] solution(int[] progresses, int[] speeds) {
		Queue<Integer> deployQueue = new ConcurrentLinkedQueue<>();

		for (int i = 0; i < progresses.length; i++) {
			deployQueue.add(getWorkingDay(progresses[i], speeds[i]));
		}

		ArrayList<Integer> answerList = new ArrayList<>();
		int first = deployQueue.poll();
		int count = 1;
		while (!deployQueue.isEmpty()) {
			int next = deployQueue.poll();
			if (first >= next) {
				count++;
			} else {
				answerList.add(count);
				count = 1;
				first = next;
			}
		}
		answerList.add(count);

		return answerList.stream().flatMapToInt(IntStream::of).toArray();
	}

	public int getWorkingDay(int progress, int speed) {
		int quotient = (100 - progress) / speed;
		int remain = (100 - progress) % speed;
		if (remain == 0) {
			return quotient;
		}
		return quotient + 1;
	}

	public boolean isRight(int[] answer, int[] result) {
		for (int i = 0; i < answer.length; i++) {
			if (answer[i] != result[i]) {
				return false;
			}
		}
		return true;
	}
}

package programers.queue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class PrintProblem {

	public static void main(String[] args) {
		int[][] priority = {{2, 1, 3, 2}, {1, 1, 9, 1, 1, 1}};
		int[] location = {2, 0};
		int[] answer = {1, 5};

		PrintProblem printProblem = new PrintProblem();
		for (int i = 0; i < priority.length; i++) {
			int result = printProblem.solution(priority[i], location[i]);
			boolean isRight = printProblem.isRight(answer[i], result);
			System.out.printf("%d 번쨰 정답 input: %s , answer: %s , result: %s  ==> %s \n", i + 1,
				Arrays.toString(priority[i]), answer[i], result, isRight
			);
		}
	}

	public int solution(int[] priorities, int location) {
		Queue<Integer> queue = new LinkedList<>();
		int count = 1;

		for (int i = 0; i < priorities.length; i++) {
			queue.offer(i);
		}

		while (true) {
			int target = queue.peek();
			if (isBiggerExist(target, queue, priorities)) {
				queue.poll();
				queue.offer(target);
			} else if (target == location) {
				return count;
			} else {
				break;
			}
		}

		for (int target : queue) {
			if (location == target) {
				return count;
			}
			count++;
		}
		return 0;
	}

	private boolean isBiggerExist(int target, Queue<Integer> compare, int[] priorites) {
		for (int value : compare) {
			if (priorites[target] < priorites[value]) {
				return true;
			}
		}
		return false;
	}

	public boolean isRight(int answer, int result) {
		return answer == result;
	}
}

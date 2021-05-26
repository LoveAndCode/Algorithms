package programers.queue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.IntStream;

public class StockPriceProblem {

	public static void main(String[] args) {
		int[] prices = {1, 2, 3, 2, 3};
		int[] answer = {4, 3, 1, 1, 0};

		StockPriceProblem printProblem = new StockPriceProblem();
		int[] result = printProblem.solution(prices);
		boolean isRight = printProblem.isRight(answer, result);
		System.out.printf("정답 input: %s , answer: %s , result: %s  ==> %s \n",
			Arrays.toString(prices), Arrays.toString(answer), Arrays.toString(result), isRight
		);
	}

	public int[] solution(int[] prices) {
		List<Integer> answer = new ArrayList<>();
		Queue<Integer> queue = new LinkedList<>();

		// save all price in queue
		for (int price : prices) {
			queue.offer(price);
		}

		// count
		int seconds = 0;

		while (!queue.isEmpty()) {
			if (queue.size() == 1) {
				answer.add(0);
				break;
			}

			int currentPrice = queue.poll();

			for (int value : queue) {
				seconds++;
				if (currentPrice > value) {
					break;
				}
			}
			answer.add(seconds);
			seconds = 0;
		}

		return answer.stream().flatMapToInt(IntStream::of).toArray();
	}

	private boolean isBiggerExist(int target, Queue<Integer> compare, int[] priorites) {
		for (int value : compare) {
			if (priorites[target] < priorites[value]) {
				return true;
			}
		}
		return false;
	}

	public boolean isRight(int[] answer, int[] result) {
		return Arrays.equals(answer, result);
	}
}

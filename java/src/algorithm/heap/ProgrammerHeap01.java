package algorithm.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class ProgrammerHeap01 {
	public static void main(String[] args) {
		// scoville : [1,2,3] K : 11
		int[][] input = {
			// {1, 2, 3, 9, 10, 12},
			{1, 2, 3}
		};
		int[] k = {11};
		ProgrammerHeap01 heap01 = new ProgrammerHeap01();
		for (int i = 0; i < input.length; i++) {
			int guess = heap01.solution(input[i], k[i]);
			System.out.printf("input: %s , k: %d --> %d\n", Arrays.toString(input[i]), k[i], guess);
		}
	}

	public int solution(int[] scoville, int K) {
		int answer = 0;
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();

		for (int i : scoville) {
			minHeap.add(Integer.valueOf(i));
		}

		while (true) {
			if (minHeap.peek() >= K) {
				return answer;
			}

			if (minHeap.size() == 2) {
				int first = minHeap.poll();
				int second = minHeap.poll();
				if (first + (second * 2) < K) {
					return -1;
				} else {
					return ++answer;
				}
			}

			int first = minHeap.poll();
			int second = minHeap.poll();
			int newFood = first + (second * 2);
			minHeap.add(newFood);
			answer++;
		}
	}
}
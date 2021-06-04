package inflearn.sort;

import java.util.PriorityQueue;

public class SortTest3WithPriorityQueue {

	public static void main(String[] args) {
		int[] sticks = {1, 8, 2, 5};
		SortTest3WithPriorityQueue a = new SortTest3WithPriorityQueue();
		System.out.println(a.pqStick(sticks));
	}

	public int pqStick(int[] sticks) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i : sticks) {
			pq.offer(i);
		}

		int sum = 0;
		while (pq.size() > 1) {
			int towSum = pq.poll() + pq.poll();
			pq.offer(towSum);
			sum += towSum;
		}

		return sum;
	}
}

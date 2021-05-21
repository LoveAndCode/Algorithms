package programers.queue;

import java.util.LinkedList;
import java.util.Queue;

public class Queue1 {
	class Truck {
		int weight;
		int move;

		public Truck(int weight) {
			this.weight = weight;
			this.move = 1;
		}

		public void moving() {
			move++;
		}
	}

	public static void main(String[] args) {
		int[] bridge_length = {2, 100, 100};
		int[] weights = {10, 100, 100};
		int[][] trucks = {
			{7, 4, 5, 6},
			{10},
			{10, 10, 10, 10, 10, 10, 10, 10, 10, 10}
		};
		int[] expectation = {8, 101, 110};

		for (int i = 0; i < bridge_length.length; i++) {
			int answer = new Queue1().solution(bridge_length[i], weights[i], trucks[i]);
			System.out.printf("expect %d => answer : %s \n", expectation[i], answer);
		}
	}

	public int solution(int bridgeLength, int weight, int[] truckWeights) {
		Queue<Truck> waitQ = new LinkedList<>();
		Queue<Truck> moveQ = new LinkedList<>();

		for (int t : truckWeights) {
			waitQ.offer(new Truck(t));
		}

		int answer = 0;
		int curWeight = 0;

		while (!waitQ.isEmpty() || !moveQ.isEmpty()) {
			answer++;

			if (moveQ.isEmpty()) {
				Truck t = waitQ.poll();
				curWeight += t.weight;
				moveQ.offer(t);
				continue;
			}

			for (Truck t : moveQ) {
				t.moving();
			}

			if (moveQ.peek().move > bridgeLength) {
				Truck t = moveQ.poll();
				curWeight -= t.weight;
			}

			if (!waitQ.isEmpty() && curWeight + waitQ.peek().weight <= weight) {
				Truck t = waitQ.poll();
				curWeight += t.weight;
				moveQ.offer(t);
			}
		}

		return answer;
	}
}

package algorithm.queue;

import java.util.ArrayDeque;
import java.util.Deque;

public class DequeTest {
	public static void main(String[] args) {
		Deque<Integer> dq = new ArrayDeque<>();
		dq.offer(5);
		dq.offer(2);
		dq.offer(3);
		dq.offer(7);
		System.out.println(dq.peekFirst());
		System.out.println(dq.peekLast());
		System.out.println(dq);
		System.out.println("reverse");

	}
}

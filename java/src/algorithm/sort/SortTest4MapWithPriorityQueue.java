package algorithm.sort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class SortTest4MapWithPriorityQueue {
	public static void main(String[] args) {
		String[] input = {"i", "study", "algorithm", "i", "study", "coding"};
		String[] answer = {"i", "study"};
		int k = 2;

		SortTest4MapWithPriorityQueue a = new SortTest4MapWithPriorityQueue();
		String[] guess = a.solve(input, k);
		for (int i = 0; i < guess.length; i++) {
			boolean isSame = guess[i].equals(answer[i]);
			System.out.println(guess[i] + " == " + answer[i] + " ? => " + isSame);
		}
	}

	public String[] solve(String[] words, int k) {
		Map<String, Integer> map = new HashMap<>();
		List<String> answer = new ArrayList<>();

		// set frequency of word
		for (String word : words) {
			map.put(word, map.getOrDefault(word, 0) + 1);
		}

		PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(
			(a, b) -> !a.getValue().equals(b.getValue()) ? b.getValue() - a.getValue() :
				a.getKey().compareTo(b.getKey()));

		for (Map.Entry<String, Integer> node : map.entrySet()) {
			pq.offer(node);
		}

		for (int i = 0; i < k; i++) {
			answer.add(pq.poll().getKey());
		}

		System.out.println(map);
		System.out.println(answer);

		return answer.toArray(new String[2]);
	}
}

package algorithm.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapTest2 {

	public static void main(String[] args) {
		int[] array = {1, 1, 2, 2, 2, 3, 5, 5, 5, 5};
		int k = 2;
		System.out.println(new MapTest2().topFrequent(array, k));
	}

	public List<Integer> topFrequent(int[] numbers, int k) {
		// 1. 담을 그릇
		Map<Integer, Integer> map = new HashMap<>();
		List<Integer>[] list = new List[numbers.length + 1];
		List<Integer> result = new ArrayList<>();

		// 2. map에다가 getOrDefault
		for (int num : numbers) {
			map.put(num, map.getOrDefault(num, 0) + 1);
		}

		// 3. list
		for (int key : map.keySet()) {
			int topFrequent = map.get(key);
			if (list[topFrequent] == null) {
				list[topFrequent] = new ArrayList<>();
			}
			list[topFrequent].add(key);
		}

		// 4. fetch top k
		for (int lastIndex = list.length - 1; lastIndex >= 0; lastIndex--) {
			if (list[lastIndex] != null) {
				for (int i = 0; i < list[lastIndex].size() && result.size() < k; i++) {
					result.add(list[lastIndex].get(i));
				}
			}
		}
		return result;
	}
}

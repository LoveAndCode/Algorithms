package algorithm.array;

import java.util.HashMap;
import java.util.Map;

public class SubArraySum {
	public static void main(String[] args) {
		int[] numbers = {3, 4, 7, 2, -3, 1, 4, 2};
		int k = 7;
		System.out.println(subArraySumByLoop(numbers, k));
		System.out.println(subArraySumByMap(numbers, k));
	}

	private static int subArraySumByMap(int[] numbers, int k) {
		int count = 0;
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, 1);
		int sum = 0;

		for (int num : numbers) {
			sum += num;

			if (map.containsKey(sum - k)) {
				count += map.get(sum - k);
			}

			map.put(sum, map.getOrDefault(sum, 0) + 1);
		}

		return count;
	}

	private static int subArraySumByLoop(int[] nums, int k) {
		int count = 0;
		for (int i = 0; i < nums.length; i++) {
			int sum = 0;
			for (int j = i; j < nums.length; j++) {
				sum = sum + nums[j];
				if (sum == k) {
					count++;
				}
			}
		}
		return count;
	}
}

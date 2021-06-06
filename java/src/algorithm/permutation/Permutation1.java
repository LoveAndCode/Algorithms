package algorithm.permutation;

import java.util.ArrayList;
import java.util.List;

public class Permutation1 {
	public static void main(String[] args) {
		int[] nums = {1, 2, 3};
		Permutation1 permutation1 = new Permutation1();
		System.out.println(permutation1.solve(nums));
	}

	public List<List<Integer>> solve(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> tempList = new ArrayList<>();
		backTrace(result, tempList, nums);
		return result;
	}

	private void backTrace(List<List<Integer>> result, List<Integer> tempList, int[] nums) {
		if (tempList.size() == nums.length) {
			System.out.println("[debug] tempList = " + tempList);
			result.add(new ArrayList<>(tempList));
		} else {
			for (int i = 0; i < nums.length; i++) {
				if (tempList.contains(nums[i])) {
					continue;
				}
				tempList.add(nums[i]);
				backTrace(result, tempList, nums);
				tempList.remove(tempList.size() - 1);
			}
		}
	}
}

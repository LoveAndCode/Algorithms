package inflearn.combination;

import java.util.ArrayList;
import java.util.List;

public class Combination1 {
	public static void main(String[] args) {
		int n = 3;
		int k = 2;
		Combination1 combination1 = new Combination1();
		System.out.println(combination1.solve(n, k));
	}

	public List<List<Integer>> solve(int n, int k) {
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> tempList = new ArrayList<>();
		backTrace(result, tempList, n, k, 1);
		return result;
	}

	private void backTrace(List<List<Integer>> result, List<Integer> tempList, int n, int k, int start) {
		if (tempList.size() == k) {
			System.out.println("[DEBUG] tempList = " + tempList);
			result.add(new ArrayList<>(tempList));
		} else {
			for (int i = start; i <= n; i++) {
				tempList.add(i);
				backTrace(result, tempList, n, k, i + 1);
				System.out.println("[Before] tempList = " + tempList);
				tempList.remove(tempList.size() - 1);
				System.out.println("[After] tempList = " + tempList);
			}
		}
	}
}

package algorithm.array;

import java.util.ArrayList;
import java.util.List;

public class Convert2DArrayToList {

	public static void main(String[] args) {
		int[][] array = {
			{1, 2, 3},
			{4, 5, 6},
			{7, 8, 9}
		};

		List<List<Integer>> listList = convert2DArrayToList(array);
		System.out.println("listList = " + listList);

		int[][] ints = convertSubListToArray(listList);

		for (int i = 0; i < ints.length; i++) {
			for (int j = 0; j < ints[i].length; j++) {
				System.out.printf("[%d],",ints[i][j]);
			}
			System.out.println();
		}
	}

	public static List<List<Integer>> convert2DArrayToList(int[][] array) {
		List<List<Integer>> result = new ArrayList<>();

		for (int i = 0; i < array.length; i++) {
			List<Integer> integerList = new ArrayList<>();
			for (int j = 0; j < array[i].length; j++) {
				integerList.add(array[i][j]);
			}
			result.add(integerList);
		}

		return result;
	}

	public static int[][] convertSubListToArray(List<List<Integer>> subList) {
		int[][] result = new int[subList.size()][];

		for (int i = 0; i < result.length; i++) {
			result[i] = new int[subList.get(i).size()];
			for (int j = 0; j < result[i].length; j++) {
				result[i][j] = subList.get(i).get(j);
			}
		}

		return result;
	}
}

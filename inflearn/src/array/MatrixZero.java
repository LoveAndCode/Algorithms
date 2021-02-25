package array;

import java.util.HashSet;
import java.util.Set;

public class MatrixZero {
	public static void main(String[] args) {
		int[][] grid = {
			{1, 1, 1},
			{1, 0, 1},
			{1, 1, 1}
		};

		int[][] answer = {
			{1, 0, 1},
			{0, 0, 0},
			{1, 0, 1}
		};

		solve(grid);
	}

	public static void solve(int[][] grid) {
		print(grid);

		Set<Integer> rowSet = new HashSet<>();
		Set<Integer> colSet = new HashSet<>();

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == 0) {
					rowSet.add(i);
					colSet.add(j);
					System.out.print("[" + i + "]" + "[" + j + "]" + " => " + grid[i][j] + " ");
				}
			}
			System.out.println();
		}

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (rowSet.contains(i) || colSet.contains(j)) {
					grid[i][j] = 0;
				}
			}
		}

		print(grid);
	}

	public static void print(int[][] grid) {
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				System.out.print("[" + i + "]" + "[" + j + "]" + " => " + grid[i][j] + " ");
			}
			System.out.println();
		}
	}
}

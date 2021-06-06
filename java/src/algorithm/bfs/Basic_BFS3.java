package algorithm.bfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Basic_BFS3 {
	int[][] direction = {
		{1, 0}, {-1, 0}, {0, 1}, {0, -1}
	};
	int m, n = 0;

	public static void main(String[] args) {
		int[][] grid = {
			{0, 0, 3, 3},
			{1, 4, 0, 1},
			{1, 0, 0, 1},
			{1, 0, 0, 1},
			{1, 2, 2, 0},
			{1, 1, 0, 0}
		};

		Basic_BFS3 basic_bfs3 = new Basic_BFS3();
		System.out.println(Arrays.toString(basic_bfs3.solve(grid)));
	}

	public int[] solve(int[][] grid) {
		if (grid == null || grid.length == 0) {
			return new int[] {0, 0};
		}

		int count = 0;
		int maxSize = 1;
		m = grid.length;
		n = grid[0].length;
		boolean[][] visited = new boolean[m][n];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (visited[i][j] || grid[i][j] == 0) {
					continue;
				}
				count++;
				int thisAreaSize = bfs(grid, i, j, visited);
				maxSize = Math.max(maxSize, thisAreaSize);
			}
		}
		return new int[] {count, maxSize};
	}

	public int bfs(int[][] grid, int i, int j, boolean[][] visited) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {i, j});
		visited[i][j] = true;
		int thisNumAreaSize = 0;

		while (!queue.isEmpty()) {
			int[] point = queue.poll();
			thisNumAreaSize++;
			visited[i][j] = true;

			for (int[] dir : direction) {
				int x1 = point[0] + dir[0];
				int y1 = point[1] + dir[1];

				if (x1 < m && y1 < n && x1 >= 0 && y1 >= 0) {
					if (!visited[x1][y1] && grid[i][j] == grid[x1][y1]) {
						visited[x1][y1] = true;
						queue.offer(new int[] {x1, y1});
					}
				}
			}
		}

		return thisNumAreaSize;
	}
}

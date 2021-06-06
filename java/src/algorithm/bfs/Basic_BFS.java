package algorithm.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class Basic_BFS {
	int[][] direction = {
		{1, 0}, {-1, 0}, {0, 1}, {0, -1}
	};
	int m, n = 0;

	public static void main(String[] args) {
		char[][] grid = {
			{'1', '1', '0', '0', '1'},
			{'1', '1', '0', '0', '0'},
			{'0', '0', '0', '0', '0'},
			{'0', '0', '0', '0', '1'},
		};

		Basic_BFS basic_bfs = new Basic_BFS();
		System.out.println(basic_bfs.bfs(grid));
	}

	public int bfs(char[][] grid) {
		int count = 0;
		if (grid == null || grid.length == 0) {
			return 0;
		}
		m = grid.length; // row length
		n = grid[0].length; // column length

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == '1') {
					count++;
					bfs(grid, i, j);
				}
			}
		}

		return count;
	}

	public void bfs(char[][] grid, int x, int y) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {x, y});
		// System.out.printf("[debug][start] - [%d,%d]\n", x, y);

		while (!queue.isEmpty()) {
			int[] point = queue.poll();
			for (int[] dir : direction) {
				int x1 = point[0] + dir[0];
				int y1 = point[1] + dir[1];
				// System.out.printf("[debug][move] - [%d,%d]\n", x1, y1);
				if ((x1 >= 0 && y1 >= 0) && (x1 < m && y1 < n) && grid[x1][y1] == '1') {
					// System.out.printf("[debug][found] - [%d,%d]\n", x1, y1);
					grid[x1][y1] = '0';
					queue.offer(new int[] {x1, y1});
				}
			}
		}
	}
}

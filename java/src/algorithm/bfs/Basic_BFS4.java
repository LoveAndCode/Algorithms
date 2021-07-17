package algorithm.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class Basic_BFS4 {
	int[][] direction = {
		{1, 0}, {-1, 0}, {0, 1}, {0, -1}
	};
	int m, n = 0;

	public static void main(String[] args) {
		char[][] grid = {
			{'1', '1', '0', '0', '0'},
			{'1', '1', '0', '0', '0'},
			{'1', '1', '0', '0', '0'},
			{'0', '0', '0', '1', '1'},
		};

		Basic_BFS4 basic_bfs = new Basic_BFS4();
		System.out.println(basic_bfs.bfs(grid));
	}

	public int bfs(char[][] grid) {
		if (grid == null || grid.length == 0 || grid[0].length == 0) {
			return 0;
		}
		int count = 0;
		m = grid.length;
		n = grid[0].length;

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
		grid[x][y] = 'X'; // visited
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {x, y});

		while (!queue.isEmpty()) {
			int[] curr = queue.poll();

			for (int[] dir : direction) {
				int x1 = curr[0] + dir[0];
				int y1 = curr[1] + dir[1];

				if (x1 >= 0 && y1 >= 0 && x1 < m && y1 < n && grid[x1][y1] == '1') {
					grid[x1][y1] = 'X';
					queue.offer(new int[] {x1, y1});
				}
			}
		}
	}
}

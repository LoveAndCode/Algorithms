package algorithm.dfs;

public class Basic_DFS {
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

		Basic_DFS basic_dfs = new Basic_DFS();
		System.out.println(basic_dfs.dfs(grid));

	}

	public int dfs(char[][] grid) {
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
					dfs(grid, i, j);
				}
			}
		}

		return count;
	}

	public void dfs(char[][] grid, int x, int y) {
		if (x < 0 || x >= m || y < 0 || y >= n || grid[x][y] != '1') {
			return;
		}
		grid[x][y] = '0';
		for (int[] dir : direction) {
			dfs(grid, x + dir[0], y + dir[1]);
		}
	}

}

package algorithm.dfs;

public class Basic_DFS2 {
	int[][] direction = {
		{1, 0}, {-1, 0}, {0, 1}, {0, -1}
	};
	int m, n = 0;

	public static void main(String[] args) {
		int[][] matrix = {
			{9, 8, 3},
			{6, 5, 7},
			{2, 1, 1}
		};
		Basic_DFS2 basic_dfs2 = new Basic_DFS2();
		System.out.println(basic_dfs2.solve(matrix));
	}

	public int solve(int[][] matrix) {
		int max = 1;
		m = matrix.length;
		n = matrix[0].length;
		int[][] result = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				int len = dfs(matrix, i, j, m, n, result);
				max = Math.max(len, max);
			}
		}

		return max;
	}

	public int dfs(int[][] matrix, int i, int j, int m, int n, int[][] result) {
		if (result[i][j] != 0) {
			return result[i][j];
		}
		int max = 1;

		for (int[] dir : direction) {
			int x = i + dir[0];
			int y = j + dir[1];

			if (x < 0 || y < 0 || x >= m || y >= n || matrix[x][y] <= matrix[i][j]) {
				continue;
			}
			int len = 1 + dfs(matrix, x, y, m, n, result);
			max = Math.max(max, len);
		}
		result[i][j] = max;

		return max;
	}
}

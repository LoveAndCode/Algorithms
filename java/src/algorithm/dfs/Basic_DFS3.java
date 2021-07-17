package algorithm.dfs;

public class Basic_DFS3 {
	int[][] direction = {
		{1, 0}, {-1, 0}, {0, 1}, {0, -1}
	};
	int m, n = 0;

	public static void main(String[] args) {
		char[][] matrix = {
			{'1', '1', '0', '0', '0'},
			{'1', '1', '0', '0', '0'},
			{'1', '1', '0', '0', '0'},
			{'0', '0', '0', '1', '1'},
		};
		Basic_DFS3 basic_dfs3 = new Basic_DFS3();
		System.out.println(basic_dfs3.solve(matrix));
	}

	public int solve(char[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return 0;
		}

		m = matrix.length;
		n = matrix[0].length;
		int count = 0;

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == '1') {
					count++;
					dfs(matrix, i, j);
				}
			}
		}
		return count;
	}

	private void dfs(char[][] matrix, int i, int j) {
		if (i < 0 || i >= m || j < 0 || j >= n || matrix[i][j] != '1') {
			return;
		}

		matrix[i][j] = 'X';
		for (int[] dir : direction) {
			dfs(matrix, i + dir[0], j + dir[1]);
		}
	}

}

package inflearn.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode {
	int val;
	TreeNode left, right;

	TreeNode(int x) {
		this.val = x;
	}
}

public class Basic_BFS2 {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);

		Basic_BFS2 basic_bfs2 = new Basic_BFS2();
		System.out.println(basic_bfs2.solve(root));
	}

	public List<List<Integer>> solve(TreeNode root) {
		//1. ds
		List<List<Integer>> result = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		boolean isNotReverse = true;

		//2. for or while
		while (!queue.isEmpty()) {
			List<Integer> list = new ArrayList<>();
			int size = queue.size();

			for (int i = 0; i < size; i++) {
				TreeNode node = queue.poll();

				if (isNotReverse) {
					list.add(node.val);
				} else {
					list.add(0, node.val);
				}

				if (node.left != null) {
					queue.offer(node.left);
				}
				if (node.right != null) {
					queue.offer(node.right);
				}
			}
			isNotReverse = !isNotReverse;
			result.add(list);
		}

		return result;
	}
}

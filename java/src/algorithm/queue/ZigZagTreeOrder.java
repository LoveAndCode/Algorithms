package algorithm.queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode {
	public int val;
	public TreeNode left;
	public TreeNode right;

	public TreeNode(int val) {
		this.val = val;
	}
}

public class ZigZagTreeOrder {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);

		ZigZagTreeOrder zigZagTreeOrder = new ZigZagTreeOrder();
		System.out.println(zigZagTreeOrder.solve(root));
	}

	public List<List<Integer>> solve(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<>();
		List<List<Integer>> result = new ArrayList<>();
		boolean normalProcessing = true;
		queue.offer(root);

		while (!queue.isEmpty()) {
			List<Integer> list = new ArrayList<>();
			int size = queue.size();

			for (int i = 0; i < size; i++) {
				TreeNode node = queue.poll();
				if (normalProcessing) {
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
			normalProcessing = !normalProcessing;
			result.add(list);
		}

		return result;
	}
}

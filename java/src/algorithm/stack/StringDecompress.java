package algorithm.stack;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class StringDecompress {

	public static void main(String[] args) {
		String s = "12[a]2[bc]2[d]";
		String asnwer = "aaaaaaaaaaaabcbcdd";

		StringDecompress stringDecompress = new StringDecompress();
		String expect = stringDecompress.solve(s);
		String expect2 = stringDecompress.solve2(s);
		System.out.printf("%s == %s ? => %s\n", asnwer, expect, asnwer.equals(expect));
		System.out.printf("%s == %s ? => %s\n", asnwer, expect2, asnwer.equals(expect2));

	}

	public String solve(String input) {
		Stack<Integer> numberStack = new Stack<>();
		Stack<StringBuilder> alphaStack = new Stack<>();

		StringBuilder result = new StringBuilder();

		int k = 0;
		for (char ch : input.toCharArray()) {
			if (Character.isDigit(ch)) {
				k = k * 10 + ch - '0'; // 1,12
			} else if (ch == '[') {
				numberStack.push(k);
				alphaStack.push(result);
				k = 0;
				result = new StringBuilder();
			} else if (ch == ']') {
				StringBuilder sb = alphaStack.pop();
				for (int i = numberStack.pop(); i > 0; i--) {
					sb.append(result);
				}
				result = sb;
			} else {
				result.append(ch);
			}
		}
		return result.toString();
	}

	public String solve2(String input) {
		Queue<Character> queue = new LinkedList<>();
		Stack<Integer> stack = new Stack<>();
		StringBuilder result = new StringBuilder();
		int k = 0;

		for (char ch : input.toCharArray()) {
			if (Character.isDigit(ch)) {
				k = k * 10 + ch - '0';
			} else if (ch == '[') {
				stack.push(k);
				k = 0;
			} else if (ch == ']') {
				StringBuilder sb = new StringBuilder();
				while (!queue.isEmpty()) {
					sb.append(queue.poll());
				}
				String word = sb.toString();
				for (int i = stack.pop(); i > 0; i--) {
					result.append(word);
				}
			} else {
				queue.offer(ch);
			}
		}

		return result.toString();
	}
}

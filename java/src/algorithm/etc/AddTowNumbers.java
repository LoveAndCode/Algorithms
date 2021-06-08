package algorithm.etc;

import java.util.Stack;

class ListNode {
	int val;
	ListNode next;

	ListNode() {
	}

	ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}

	@Override
	public String toString() {
		return "ListNode{" +
			"val=" + val +
			", next=" + next +
			'}';
	}
}

public class AddTowNumbers {

	public static void main(String[] args) {
		ListNode l1 = new ListNode(2);
		l1.next = new ListNode(4);
		l1.next.next = new ListNode(3);

		ListNode l2 = new ListNode(5);
		l2.next = new ListNode(6);
		l2.next.next = new ListNode(4);

		AddTowNumbers addTowNumbers = new AddTowNumbers();
		System.out.println(addTowNumbers.addTwoNumbers(l1, l2));
		System.out.println(addTowNumbers.addTwoNumbers2(l1, l2));

	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		// 담을 그룻
		ListNode answer;
		ListNode l1Head = l1;
		ListNode l2Head = l2;
		int sumL1 = 0;
		int sumL2 = 0;
		Stack<Integer> l1Stack = new Stack<>();
		Stack<Integer> l2Stack = new Stack<>();

		while (l1Head != null) {
			l1Stack.push(l1Head.val);
			l1Head = l1Head.next;
		}

		while (l2Head != null) {
			l2Stack.push(l2Head.val);
			l2Head = l2Head.next;
		}

		while (!l1Stack.isEmpty()) {
			sumL1 = sumL1 * 10 + l1Stack.pop();
		}
		while (!l2Stack.isEmpty()) {
			sumL2 = sumL2 * 10 + l2Stack.pop();
		}

		String result = String.valueOf(sumL1 + sumL2);

		System.out.println(result);
		answer = new ListNode(result.charAt(result.length() - 1) - '0');
		ListNode target = answer;
		for (int i = result.length() - 2; i >= 0; i--) {
			System.out.println(result.charAt(i) - '0');
			target.next = new ListNode(result.charAt(i) - '0');
			target = target.next;
		}

		return answer;
	}

	public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
		ListNode answer = new ListNode();
		ListNode current = answer;

		ListNode l1Head = l1;
		ListNode l2Head = l2;
		int carry = 0;

		while (l1Head != null || l2Head != null) {
			int x = (l1Head != null) ? l1Head.val : 0;
			int y = (l2Head != null) ? l2Head.val : 0;
			int sum = carry + x + y;
			carry = sum / 10;
			current.next = new ListNode(sum % 10);
			current = current.next;
			if (l1Head != null) {
				l1Head = l1Head.next;
			}
			if (l2Head != null) {
				l2Head = l2Head.next;
			}
		}

		if (carry > 0) {
			current.next = new ListNode(carry);
		}

		return answer.next;
	}
}

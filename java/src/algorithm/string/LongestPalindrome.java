package algorithm.string;

public class LongestPalindrome {
	int end = 0;
	int start = 0;

	public static void main(String[] args) {
		String[] input = {"banana", "babad", "ac", "abba", "bbbb"};
		// String[] input = {"banana"};
		String[] answer = {"anana", "bab", "a", "abba", "bbbb"};
		// String[] answer = {"anana"};
		LongestPalindrome longestPalindrome = new LongestPalindrome();

		for (int i = 0; i < input.length; i++) {
			String s = input[i];
			String expect = longestPalindrome.solve(s);
			System.out.printf("input = %s , answer = %s , expect = %s , result = %s\n",
				s, answer[i], expect, answer[i].equals(expect)
			);
		}
	}

	public String solve(String s) {
		int len = s.length();
		// skip one letter
		if (len < 2) {
			return s;
		}

		for (int i = 0; i < len; i++) {
			System.out.println("i = " + i);
			findSubString(s, i, i);
		}

		String answer = s.substring(start, end + start);
		start = 0;
		end = 0;
		return answer;
	}

	private void findSubString(String s, int left, int right) {
		while (left >= 0 && right < s.length() &&
			s.charAt(left) == s.charAt(right)
		) {
			left--;
			right++;
		}
		if (end < right - left - 1) {
			start = left + 1;
			end = right - left - 1;
		}
	}
}

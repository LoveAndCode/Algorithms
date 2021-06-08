package algorithm.etc;

public class PalindromeInteger {

	public static void main(String[] args) {
		int[] innput = {121, -121, 10, -101};
		boolean[] result = {true, false, false, false};

		PalindromeInteger palindromeInteger = new PalindromeInteger();

		for (int i = 0; i < innput.length; i++) {
			System.out.printf("expect: %s answer: %s\n", palindromeInteger.isPalindrome(innput[i]), result[i]);
		}
	}

	public boolean isPalindrome(int x) {
		String s = String.valueOf(x);

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
				return false;
			}
		}

		return true;
	}
}

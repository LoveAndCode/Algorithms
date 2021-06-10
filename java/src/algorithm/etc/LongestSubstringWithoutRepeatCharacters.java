package algorithm.etc;

public class LongestSubstringWithoutRepeatCharacters {

	public static void main(String[] args) {
		String[] input = {"abcabcbb", "bbbbb", "pwwkew", ""};
		int[] answer = {3, 1, 3, 0};
		LongestSubstringWithoutRepeatCharacters a = new LongestSubstringWithoutRepeatCharacters();

		for (int i = 0; i < input.length; i++) {
			int expect = a.lengthOfLongestSubstring(input[i]);
			System.out.printf("expect: %d answer: %d result: %s", expect, answer[i], expect == answer[i]);
		}
	}

	public int lengthOfLongestSubstring(String s) {

		return 0;
	}
}

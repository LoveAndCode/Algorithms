package algorithm.etc;

public class ReverseInteger {

	public static void main(String[] args) {
		int[] input = {123, -123, 120, 0};
		int[] answer = {321, -321, 21, 0};

		ReverseInteger reverseInteger = new ReverseInteger();

		for (int i = 0; i < input.length; i++) {
			int expect = reverseInteger.reverse(input[i]);
			System.out.printf("answer: %d expect: %d result: %s\n",
				answer[i], expect, answer[i] == expect
			);
		}
		System.out.println("-------------------------------------------------");
		for (int i = 0; i < input.length; i++) {
			int expect = reverseInteger.reverse2(input[i]);
			System.out.printf("answer: %d expect: %d result: %s\n",
				answer[i], expect, answer[i] == expect
			);
		}
	}

	public int reverse(int x) {
		StringBuilder sb = new StringBuilder();
		String digitString = String.valueOf(x);
		boolean isMinus = false;

		for (int i = digitString.length() - 1; i >= 0; i--) {
			if (Character.isDigit(digitString.charAt(i))) {
				sb.append(digitString.charAt(i));
			} else if (digitString.charAt(i) == '-') {
				isMinus = true;
			}
		}

		Long result = Long.valueOf(sb.toString());

		if (isMinus) {
			result *= -1L;
		}

		if (Integer.MAX_VALUE >= result && result >= Integer.MIN_VALUE) {
			return result.intValue();
		}

		return 0;
	}


	public int reverse2(int x){
		int rev = 0;

		while(x != 0){
			int pop = x % 10;
			x /= 10;
			if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
			if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
			rev = rev * 10 + pop;
		}
		return rev;
	}
}

package recursion;

public class Code07 {
	public static void main(String[] args) {
		int result = lengthOfString("abcd");
		System.out.println("result = " + result);
	}

	public static int lengthOfString(String str) {
		if (str.length() == 0) {
			return 0;
		}
		return 1 + lengthOfString(str.substring(1));
	}
}

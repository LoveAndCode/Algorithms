package recursion;

public class Code08 {
	public static void main(String[] args) {
		printCharsReverse("abcd");
	}

	public static void printCharsReverse(String s) {
		if(s.length() == 0) {
			return;
		}else {
			printCharsReverse(s.substring(1));
			System.out.println(s.charAt(0));
		}
	}
}

package algorithm.sort;

public class SortTest1 {
	public static void main(String[] args) {
		// String version1 = "8.5.2.4";
		// String version2 = "8.5.3";
		String version1 = "1.2";
		String version2 = "1";

		System.out.printf("Version Compare: %s and %s is %d", version1, version2, solution(version1, version2));
	}

	public static int solution(String version1, String version2) {
		// 1
		String[] v1 = version1.split("\\.");
		String[] v2 = version2.split("\\.");

		int length = Math.max(v1.length, v2.length);

		for (int i = 0; i < length; i++) {
			Integer a = i < v1.length ? Integer.parseInt(v1[i]) : 0;
			Integer b = i < v2.length ? Integer.parseInt(v2[i]) : 0;

			int comp = a.compareTo(b);

			if (comp != 0) {
				return comp;
			}
		}
		return 0;
	}

	public static void compareToTest() {
		Integer a = 1, b = 3; // 오름 차순 -1, 오른쪽이 큰값
		System.out.println(a.compareTo(3));
	}
}

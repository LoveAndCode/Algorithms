package map;

import java.util.HashMap;
import java.util.Map;

public class MapTest1 {
	public static void main(String[] args) {
		String s = "inflearninlove";
		System.out.println(solution(s));
	}

	public static int solution(String s) {
		// 1. error check
		if (s == null || s.length() == 0) {
			return -1;
		}
		Map<Character, Integer> map = new HashMap<>();
		for (char x : s.toCharArray()) {
			// if (map.containsKey(x)) {
			// 	map.put(x, map.get(x) + 1);
			// } else {
			// 	map.put(x, 1);
			// }
			map.put(x, map.getOrDefault(x, 0) + 1);
		}

		printMap(map);

		for (int i = 0; i < s.length(); i++) {
			if (map.get(s.charAt(i)) == 1) {
				return i;
			}
		}
		return -1;
	}

	public static void printMap(Map<Character, Integer> map) {
		System.out.println(">> Print By Key Set");
		for (char key : map.keySet()) {
			System.out.println("key = " + key + " value = " + map.get(key));
		}

	}
}

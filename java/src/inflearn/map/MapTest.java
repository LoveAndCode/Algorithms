package inflearn.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MapTest {
	public static void main(String[] args) {
		Map<Integer, String> map = new HashMap<>();
		map.put(1, "A");
		map.put(2, "B");
		map.put(3, "C");

		System.out.println(">> Print By Key Set");
		for (int key : map.keySet()) {
			System.out.println("key = " + key + " value = " + map.get(key));
		}

		System.out.println();

		System.out.println(">> Print By Entry Set");

		for (Map.Entry<Integer, String> entry : map.entrySet()) {
			System.out.println("entry = { key = " + entry.getKey() + " , value = " + entry.getValue() + "}");
		}

		System.out.println();

		System.out.println(">> Print By iterator");
		Iterator<Integer> iterator = map.keySet().iterator();

		while (iterator.hasNext()) {
			Integer key = iterator.next();
			System.out.println("entry = { key = " + key + " , value = " + map.get(key) + "}");
		}
	}
}

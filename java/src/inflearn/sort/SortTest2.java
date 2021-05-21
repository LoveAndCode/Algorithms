package inflearn.sort;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Interval {
	int start;
	int end;

	public Interval(int start, int end) {
		this.start = start;
		this.end = end;
	}

	@Override
	public String toString() {
		return "{" +
			"start=" + start +
			", end=" + end +
			'}';
	}
}

public class SortTest2 {
	public static void main(String[] args) {
		Interval interval1 = new Interval(1, 3);
		Interval interval2 = new Interval(8, 10);
		Interval interval3 = new Interval(2, 6);
		Interval interval4 = new Interval(15, 18);

		List<Interval> intervals = new ArrayList<>();
		intervals.add(interval1);
		intervals.add(interval2);
		intervals.add(interval3);
		intervals.add(interval4);

		SortTest2 test2 = new SortTest2();
		test2.print(intervals);
		System.out.println("----------------------------Sorting----------------------------");
		test2.merge(intervals);
		System.out.println("----------------------------Done----------------------------");
		test2.print(intervals);

		List<Interval> result = new ArrayList<>();
		Interval before = intervals.get(0);

		for (int i = 1; i < intervals.size(); i++) {

		}
	}

	public List<Interval> merge(List<Interval> intervals) {
		if (intervals.isEmpty()) {
			return intervals;
		}

		// 1. sorting
		intervals.sort(Comparator.comparingInt(a -> a.start));
		return intervals;
	}

	public void print(List<Interval> intervals) {
		for (Interval interval : intervals) {
			System.out.println("interval = " + interval);
		}
	}
}

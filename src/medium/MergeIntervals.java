package medium;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

class Interval {
	int start;

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	public Interval(int start, int end) {
		this.start = start;
		this.end = end;
	}

	int end;
}

public class MergeIntervals {

	public static void main(String[] args) {
		MergeIntervals mergeIntervals = new MergeIntervals();
		int[][] merge = mergeIntervals.merge(new int[][]{{1,3}, {4,6}, {7, 10}, {11, 18}});
		for (int[] interval : merge) {
			for (int i : interval) {
				System.out.print(i + " ");
			}
		}
	}
	
	public int[][] merge(int[][] intervals) {
		if (intervals.length == 0)
			return intervals;
		List<Interval> intervalList = new ArrayList<>();
		for (int[] interval : intervals) {
			Interval newInterval = new Interval(interval[0], interval[1]);
			intervalList.add(newInterval);
		}
		intervalList.sort(Comparator.comparingInt(Interval::getStart));
		LinkedList<Interval> stack = new LinkedList<>();
		stack.addLast(intervalList.get(0));
		
		for (int i = 1 ; i < intervalList.size(); i++) {
			Interval lastInterval = stack.peekLast();
			Interval currentInterval = intervalList.get(i);
			if (lastInterval.getEnd() >= currentInterval.getStart()) {
				lastInterval.setEnd(Math.max(currentInterval.getEnd(), lastInterval.getEnd()));
			} else {
				stack.addLast(currentInterval);
			}
		}
		
		return convertToIntArr(stack);
	}

	private int[][] convertToIntArr(List<Interval> intervalList) {
		int[][] ints = new int[intervalList.size()][2];
		for (int i = 0; i < intervalList.size(); i++) {
			ints[i] = new int[]{intervalList.get(i).start, intervalList.get(i).end};
		}
		return ints;
	}
}

package medium;

import java.util.LinkedList;

public class InsertInterval {

	public static void main(String[] args) {
		InsertInterval insertInterval = new InsertInterval();
		
		int[][] insert = insertInterval.insert(new int[][]{{2, 3}, {5, 5}, {6, 6}, {7, 7}, {8, 11}}, new int[]{6, 13});
		
		for (int[] arr : insert) {
			for (int i : arr) {
				System.out.println(i);
			}
		}
	}
	public int[][] insert(int[][] intervals, int[] newInterval) {
		int low = 0, high = intervals.length - 1;
		int idxToInsert = -1;
		if (intervals.length == 0)
			idxToInsert = 0;
		else {
			while (low <= high) {
				int mid = low + ((high - low) / 2);
				if (intervals[mid][0] == newInterval[0]) {
					idxToInsert = mid;
					break;
				} else if (intervals[mid][0] > newInterval[0]) {
					high = mid - 1;
				} else {
					low = mid + 1;
				}
			}
			
			if (idxToInsert == -1)
				idxToInsert = low;
		}

		int[][] ints = new int[intervals.length + 1][];
		for (int i = 0; i < idxToInsert; i++) {
			ints[i] = intervals[i];
		}
		ints[idxToInsert] = newInterval;
		for (int i = idxToInsert + 1; i < intervals.length + 1; i++) {
			ints[i] = intervals[i - 1];
		}
		
		return mergeIntervals(ints);
	}

	private int[][] mergeIntervals(int[][] ints) {
		LinkedList<int[]> ll = new LinkedList<>();
		ll.addLast(ints[0]);
		for (int i = 1; i < ints.length; i++) {
			int[] last = ll.peekLast();
			if (last[1] >= ints[i][0]) {
				last[1] = Math.max(last[1], ints[i][1]);
			} else {
				ll.addLast(ints[i]);
			}
		}

		int[][] ints1 = new int[ll.size()][2];
		for (int i = 0; i < ints1.length; i++) {
			ints1[i] = ll.removeFirst();
		}
		return ints1;
	}
}

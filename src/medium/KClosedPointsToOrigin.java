package medium;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class KClosedPointsToOrigin {
	
	class Point implements Comparable<Point>{
		int x;
		int y;
		int distance;

		public Point(int x, int y, int distance) {
			this.x = x;
			this.y = y;
			this.distance = distance;
		}

		@Override
		public int compareTo(Point o) {
			return this.distance - o.distance;
		}
	}
	
	public int[][] kClosest(int[][] points, int k) {
		int[][] result = new int[k][2];
		List<Point> list = new ArrayList<>();
		for (int i = 0; i < points.length; i++) {
			list.add(new Point(points[i][0], points[i][1], points[i][0] * points[i][0] + points[i][1] * points[i][1]));
		}
		// heapify - O(n)
		PriorityQueue<Point> minHeap = new PriorityQueue<>(list);
		// remove K elements - O(klogn)
		for (int i = 0; i < k; i++) {
			Point remove = minHeap.remove();
			result[i] = new int[]{remove.x, remove.y};
		}
		return result;
	}

	public static void main(String[] args) {
		KClosedPointsToOrigin kClosedPointsToOrigin = new KClosedPointsToOrigin();
		int[][] ints = kClosedPointsToOrigin.kClosest(new int[][]{{1, 3}, {-2, 2}}, 1);
		for (int[] arr : ints) {
			for (int i : arr) {
				System.out.println(i);
			}
		}
	}
}

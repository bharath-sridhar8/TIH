package hard;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianFinder {
	private PriorityQueue<Integer> minQueue;
	private PriorityQueue<Integer> maxQueue;
	private int size;

	public MedianFinder() {
		minQueue = new PriorityQueue<>();
		maxQueue = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
		});
		size = 0;
	}

	public void addNum(int num) {
		if (size % 2 == 0) {
			if (maxQueue.isEmpty()) {
				maxQueue.add(num);
			} else if (num > maxQueue.peek()) {
				minQueue.add(num);
				maxQueue.add(minQueue.poll());
			} else {
				maxQueue.add(num);
			}
		} else {
			if (num > maxQueue.peek()) {
				minQueue.add(num);
			} else {
				maxQueue.add(num);
				minQueue.add(maxQueue.poll());
			}
		}
		size++;
	}

	public double findMedian() {
		if (size == 0)
			return 0;
		if (size % 2 == 1)
			return maxQueue.peek();
		else
			return ((minQueue.peek()  == null ? 0.0 : minQueue.peek()) + maxQueue.peek()) / 2.0;
	}

	public static void main(String[] args) {
		MedianFinder medianFinder = new MedianFinder();
		System.out.println(medianFinder.findMedian());
		medianFinder.addNum(3);
		System.out.println(medianFinder.findMedian());
		medianFinder.addNum(4);
		System.out.println(medianFinder.findMedian());
		medianFinder.addNum(5);
		System.out.println(medianFinder.findMedian());
		medianFinder.addNum(2);
		System.out.println(medianFinder.findMedian());
		medianFinder.addNum(1);
		System.out.println(medianFinder.findMedian());
	}
}

package hard;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class HistogramLargestRectangle {
	public int largestRectangleArea(int[] heights) {
		// insert -1 into stack
		LinkedList<List<Integer>> stack = new LinkedList<>();
		stack.push(Arrays.asList(-1, -1));
		
		int maxArea = 0;

		for (int i = 0; i < heights.length; i++) {
			int height = heights[i];
			// keep adding while the values are non-decreasing (value, idx)
			if (height >= stack.peek().get(1))
				stack.push(Arrays.asList(i, height));
			else {
				// Once we see a value < top of stack -> (i) is the right limit for the top of the stack.
				// while top of stack is > h(i), pop it out.
				while (stack.peek().get(1) > height) {
					List<Integer> integers = stack.pop();
					Integer barHeight = integers.get(1);
					Integer leftLimit = getLeftLimit(stack, barHeight);
//				// update maxArea
					maxArea = Math.max(maxArea, barHeight * (i - leftLimit - 1));
				}
				// push h(i) into stack
				stack.push(Arrays.asList(i, height));
			}
		}
		
		// there are bars on the stack - right limit = heights.length.
		while (stack.size() > 1) {
			List<Integer> integers = stack.pop();
			Integer barHeight = integers.get(1);
			Integer leftLimit = getLeftLimit(stack, barHeight);
			maxArea = Math.max(maxArea, barHeight * (heights.length - leftLimit - 1));
		}
		
		return maxArea;
	}

	private Integer getLeftLimit(LinkedList<List<Integer>> stack, Integer barHeight) {
		while (stack.peek().get(1) == barHeight) {
			// pop from the stack until top of stack is < popped value
			stack.pop();
		}
		Integer leftLimit = stack.peek().get(0);
		return leftLimit;
	}

	public static void main(String[] args) {
		HistogramLargestRectangle histogramLargestRectangle = new HistogramLargestRectangle();
		System.out.println(histogramLargestRectangle.largestRectangleArea(new int[]{2,4}));
	}
}

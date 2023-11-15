package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class CourseSchedule {

	public static void main(String[] args) {
		CourseSchedule courseSchedule = new CourseSchedule();
		System.out.println(courseSchedule.canFinish(5, new int[][]{{2,0}, {0,4}, {1,0}, {3,0}}));
	}
	
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		// We need to know the count of incoming edges & know the outgoing edges as well.
		// Map of node to outgoing edges `nodeEdgeMap`
		// Map of node to incoming edge Count `incomingEdgeCountMap`
		// start with the set of nodes whose incoming edge count = 0 -> O(N)
		// remove node from queue, add to topological order
		// for each outgoing edge, reduce incoming count of destination node, if 0, add to set.
		// if we exit the loop with length of topological order < num of nodes -> there is a cycle & topological order is not possible.

		Map<Integer, List<Integer>> nodeEdgeMap = new HashMap<>();
		int[] incomingEdgeCounts = new int[numCourses];
		List<Integer> topologicalOrder = new ArrayList<>();

		for (int[] prereq : prerequisites) {
			int source = prereq[0];
			int dest = prereq[1];
			if (!nodeEdgeMap.containsKey(source)) {
				nodeEdgeMap.put(source, new ArrayList<>());
			}
			nodeEdgeMap.get(source).add(dest);
			incomingEdgeCounts[dest]++;
		}

		LinkedList<Integer> queue = new LinkedList<>();
		for (int i = 0; i < incomingEdgeCounts.length; i++) {
			if (incomingEdgeCounts[i] == 0)
				queue.addLast(i);
		}

		while (!queue.isEmpty()) {
			int i = queue.removeFirst();
			topologicalOrder.add(i);
			List<Integer> nodes = nodeEdgeMap.get(i);
			if (nodes != null) {
				for (int j : nodes) {
					incomingEdgeCounts[j] = incomingEdgeCounts[j] - 1;
					if (incomingEdgeCounts[j] == 0) {
						queue.addLast(j);
					}
				}	
			}
			nodeEdgeMap.remove(i);
		}

//		System.out.println(topologicalOrder);
		return topologicalOrder.size() == numCourses;
	}
}

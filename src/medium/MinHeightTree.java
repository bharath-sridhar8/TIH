package medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MinHeightTree {
	public List<Integer> findMinHeightTrees(int n, int[][] edges) {
		if (n < 3) {
			List<Integer> nodes = new ArrayList<>();
			for (int i = 0; i < n; i++)
				nodes.add(i);
			return nodes;
		}
		// init adjacency list.
		List<Set<Integer>> adjList = new ArrayList<>();
		for (int i = 0; i < n; i++)
			adjList.add(new HashSet<>());
		
		// add nodes to adjacency list.
		for (int[] indices : edges) {
			int src = indices[0];
			int dest = indices[1];
			adjList.get(src).add(dest);
			adjList.get(dest).add(src);
		}
		
		List<Integer> leafNodes = new ArrayList<>();
		for (int i = 0; i < adjList.size(); i++) {
			if (adjList.get(i).size() == 1)
				leafNodes.add(i);
		}
		
		int remainingNodes = n;
		while (remainingNodes > 2) {
			List<Integer> newLeafNodes = new ArrayList<>();
			for (int i = 0; i < leafNodes.size(); i++) {
				int node = leafNodes.get(i);
				Set<Integer> integers = adjList.get(node);
				Integer adjNode = integers.iterator().next();
				adjList.get(adjNode).remove(node);
				if (adjList.get(adjNode).size() == 1)
					newLeafNodes.add(adjNode);
			}
			remainingNodes -= leafNodes.size();
			leafNodes = newLeafNodes;
		}
		return leafNodes;
	}

	public static void main(String[] args) {
		MinHeightTree minHeightTree = new MinHeightTree();
		System.out.println(minHeightTree.findMinHeightTrees(6, new int[][]{{0,1},{0,2},{0,3},{3,4},{4,5}}));
	}
}

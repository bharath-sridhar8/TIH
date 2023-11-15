package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class Node {
	public int val;
	public List<Node> neighbors;
	public Node() {
		val = 0;
		neighbors = new ArrayList<Node>();
	}
	public Node(int _val) {
		val = _val;
		neighbors = new ArrayList<Node>();
	}
	public Node(int _val, ArrayList<Node> _neighbors) {
		val = _val;
		neighbors = _neighbors;
	}
}

public class CloneGraphDFS {

	public static void main(String[] args) {
		CloneGraphDFS cloneGraph = new CloneGraphDFS();
		Node one = new Node(1);
		Node two = new Node(2);
		Node three = new Node(3);
		Node four = new Node(4);
		one.neighbors = Arrays.asList(two, four);
		two.neighbors = Arrays.asList(one, three);
		three.neighbors = Arrays.asList(two, four);
		four.neighbors = Arrays.asList(one, three);
		Node clone = cloneGraph.cloneGraph(one);

		System.out.println("Before Clone");
		printAdjList(one, 4);

		System.out.println("After Clone");
		printAdjList(clone, 4);
	}

	private static void printAdjList(Node clone, int num) {
		boolean[] visited = new boolean[num + 1];
		visited[1] = true;
		LinkedList<Node> queue = new LinkedList<>();
		queue.addLast(clone);
		while (!queue.isEmpty()) {
			Node node = queue.removeFirst();
			StringBuilder sb = new StringBuilder(node + "-" + node.val + " : ");
			for (Node neighbour : node.neighbors) {
				sb.append(neighbour.val + ", ");
				if (!visited[neighbour.val]) {
					visited[neighbour.val] = true;
					queue.add(neighbour);	
				}
			}
			System.out.println(sb);
		}
	}

	public Node cloneGraph(Node node) {
		if (node == null)
			return null;
		Map<Integer, Node> visited = new HashMap<>();
		cloneGraph(node, visited);
		return visited.get(node.val);
	}

	private void cloneGraph(Node node, Map<Integer, Node> visited) {
		Node clonedNode = new Node(node.val);
		visited.put(node.val, clonedNode);
		clonedNode.neighbors = new ArrayList<>();
		for (Node neighbour : node.neighbors) {
			if (!visited.containsKey(neighbour.val)) {
				cloneGraph(neighbour, visited);
			}
			// should now exist in map, add to neighbour set.
			clonedNode.neighbors.add(visited.get(neighbour.val));
		}
	}
}

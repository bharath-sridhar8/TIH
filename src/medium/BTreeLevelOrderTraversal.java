package medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class BTreeLevelOrderTraversal {

	public static void main(String[] args) {
		BTreeLevelOrderTraversal bTreeLevelOrderTraversal = new BTreeLevelOrderTraversal();
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
//		root = null;
		List<List<Integer>> lists = bTreeLevelOrderTraversal.levelOrder(root);
		if (lists != null) {
			for (List<Integer> nums : lists) {
				System.out.println(nums);
			}
		}
	}

	public List<List<Integer>> levelOrder(TreeNode root) {
		if (root == null)
			return Collections.emptyList();
		
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> level = new ArrayList<>();
		
		LinkedList<TreeNode> queue = new LinkedList<>();
		queue.addLast(root);
		queue.addLast(null);
		
		while (!queue.isEmpty()) {
			TreeNode node = queue.removeFirst();
			if (node != null) {
				level.add(node.val);
				if (node.left != null)
					queue.addLast(node.left);
				if (node.right != null)
					queue.addLast(node.right);
			} else {
				result.add(new ArrayList<>(level));
				level = new ArrayList<>();
				// to prevent `null` loop
				if (!queue.isEmpty())
					queue.addLast(null);
			}
		}
		return result;
	}

}

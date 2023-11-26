package medium;

import java.util.ArrayList;
import java.util.List;

public class KthSmallestInBST {
	public int kthSmallest(TreeNode root, int k) {
		List<Integer> values = new ArrayList<>();
		inorder(root, values);
		return values.get(k - 1);
	}

	private void inorder(TreeNode node, List<Integer> values) {
		if (node.left != null)
			inorder(node.left, values);
		values.add(node.val);
		if (node.right != null)
			inorder(node.right, values);
	}

	public static void main(String[] args) {
		KthSmallestInBST kthSmallestInBST = new KthSmallestInBST();
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(3);
		root.right = new TreeNode(6);
		root.left.left = new TreeNode(2);
		root.left.right = new TreeNode(4);
		root.left.left.left = new TreeNode(1);
		System.out.println(kthSmallestInBST.kthSmallest(root, 5));
	}
}

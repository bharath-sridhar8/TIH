package medium;

import java.util.List;

public class BTreeFromPreOrderAndInOrder {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		int rootVal = preorder[0];
		TreeNode root = new TreeNode(rootVal);
		int idx = -1;
		int n = inorder.length;
		for (int i = 0; i < n; i++) {
			if (inorder[i] == rootVal) {
				idx = i;
				break;
			}
		}

		if (idx == 0) {
			root.left = null;
		} else {
			int[] leftinorder = new int[idx];
			for (int i = 0; i < idx; i++)
				leftinorder[i] = inorder[i];
			int m = leftinorder.length;
			int[] leftpreorder = new int[leftinorder.length];
			for (int i = 0; i < m; i++)
				leftpreorder[i] = preorder[1+i];
			root.left = buildTree(leftpreorder, leftinorder);
		}

		if (idx == n - 1) {
			root.right = null;
		} else {
			int[] rightinorder = new int[n - idx - 1];
			for (int i = 0; i < n-idx-1; i++) {
				rightinorder[i] = inorder[idx+1+i];
			}
			int m = n - idx - 1;
			int[] rightpreorder = new int[m];
			for (int i = 0; i < m; i++) {
				rightpreorder[i] = preorder[n-m+i];
			}
			root.right = buildTree(rightpreorder, rightinorder);
		}

		return root;
	}

	public static void main(String[] args) {
		BTreeFromPreOrderAndInOrder bTreeFromPreOrderAndInOrder = new BTreeFromPreOrderAndInOrder();
		TreeNode root = bTreeFromPreOrderAndInOrder.buildTree(new int[]{1,2,3}, new int[]{3,2,1});
		BTreeLevelOrderTraversal bTreeLevelOrderTraversal = new BTreeLevelOrderTraversal();
		List<List<Integer>> lists = bTreeLevelOrderTraversal.levelOrder(root);
		if (lists != null) {
			for (List<Integer> nums : lists) {
				System.out.println(nums);
			}
		}
	}
}

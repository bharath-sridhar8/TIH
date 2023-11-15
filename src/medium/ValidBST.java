package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ValidBST {
	public boolean isValidBST(TreeNode root) {
		List<Integer> inorder = new ArrayList<>();
		inorder.add(null);
		return isValidBST(root, inorder);
	}

	private boolean isValidBST(TreeNode node, List<Integer> inorder) {
		if (node == null)
			return true;
		boolean b = isValidBST(node.left, inorder);
		if (!b)
			return false;
		if (inorder.get(0) == null || (inorder.get(0) < node.val)) {
			inorder.set(0, node.val);
			return isValidBST(node.right, inorder);
		} else {
			return false;
		} 
	}

	public static void main(String[] args) {
		ValidBST validBST = new ValidBST();
		TreeNode root = new TreeNode(-2147483648);
//		root.left = new TreeNode(1);
//		root.right = new TreeNode(4);
//		root.right.left = new TreeNode(3);
//		root.right.right = new TreeNode(6);
		System.out.println(validBST.isValidBST(root));
	}
}

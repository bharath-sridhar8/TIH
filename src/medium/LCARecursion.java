package medium;

public class LCARecursion {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null)
			return null;
		if (root.val == p.val || root.val == q.val)
			return root;
		TreeNode left = lowestCommonAncestor(root.left, p, q);
		TreeNode right = lowestCommonAncestor(root.right, p, q);
		if (left != null && right != null)
			return root;
		else if (left != null)
			return left;
		else
			return right;
	}

	public static void main(String[] args) {
		LCARecursion lcaRecursion = new LCARecursion();
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(5);
		root.left.left = new TreeNode(6);
		root.left.right = new TreeNode(2);
		root.left.right.left = new TreeNode(7);
		root.left.right.right = new TreeNode(4);
		root.right = new TreeNode(1);
		root.right.left = new TreeNode(0);
		root.right.right = new TreeNode(8);
		TreeNode treeNode = lcaRecursion.lowestCommonAncestor(root, root.left, root.left.right.right);
		System.out.println(treeNode == null ? null : treeNode.val);
	}
}

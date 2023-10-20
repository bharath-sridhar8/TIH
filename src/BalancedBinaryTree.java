public class BalancedBinaryTree {

	public static void main(String[] args) {
		BalancedBinaryTree balancedBinaryTree = new BalancedBinaryTree();
		TreeNode root = new TreeNode(1);
		TreeNode l = new TreeNode(2);
		TreeNode r = new TreeNode(2);
		root.left = l;
		root.right = r;
		TreeNode ll = new TreeNode(3);
		TreeNode lr = new TreeNode(3);
		l.left = ll;
		l.right = lr;
		TreeNode lll = new TreeNode(4);
		TreeNode llr = new TreeNode(4);
		ll.left = lll;
		ll.right = llr;
		System.out.println(balancedBinaryTree.isBalanced(root));
	}

	public boolean isBalanced(TreeNode root) {
		int balanced = getHeight(root);
		if (balanced != -1)
			return true;
		return false;
	}

	public int getHeight(TreeNode node) {
		if (node == null)
			return 0;
		int lHeight = getHeight(node.left);
		int rHeight = getHeight(node.right);
		// are subtrees balanced ?
		if (lHeight == -1 || rHeight == -1)
			return -1;
		else if (Math.abs(lHeight - rHeight) <= 1) // is the tree balanced ?
			return Math.max(lHeight, rHeight) + 1;
		else
			return -1;
	}
}

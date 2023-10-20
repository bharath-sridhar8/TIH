public class BTreeLCA {

	public static void main(String[] args) {
		BTreeLCA bTreeLCA = new BTreeLCA();
		TreeNode root = new TreeNode(6);
		TreeNode l1 = new TreeNode(2);
		TreeNode r1 = new TreeNode(8);
		TreeNode l2 = new TreeNode(0);
		TreeNode r2 = new TreeNode(4);
		TreeNode l3 = new TreeNode(7);
		TreeNode r3 = new TreeNode(9);
		TreeNode l4 = new TreeNode(3);
		TreeNode r4 = new TreeNode(5);
		root.left = l1; root.right = r1;
		l1.left = l2; l1.right = r2;
		r1.left = l3; r1.right = r3;
		r2.left = l4; r2.right = r4;
		System.out.println(bTreeLCA.lowestCommonAncestor(root, r4, r2));
	}

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root.val == p.val || root.val == q.val)
			return root;
		else if (root.val < p.val) {
			if (root.val < q.val)
				return lowestCommonAncestor(root.right, p, q);
			else
				return root;
		} else {
			if (root.val > q.val)
				return lowestCommonAncestor(root.left, p, q);
			else
				return root;
		}
	}
}

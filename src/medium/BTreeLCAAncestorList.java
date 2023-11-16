package medium;

import java.util.LinkedList;

public class BTreeLCAAncestorList {

	public static void main(String[] args) {
		BTreeLCAAncestorList bTreeLCA = new BTreeLCAAncestorList();
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(5);
		root.left.left = new TreeNode(6);
		root.left.right = new TreeNode(2);
		root.left.right.left = new TreeNode(7);
		root.left.right.right = new TreeNode(4);
		root.right = new TreeNode(1);
		root.right.left = new TreeNode(0);
		root.right.right = new TreeNode(8);
		TreeNode lca = bTreeLCA.lowestCommonAncestor(root, root.left, root.left.right.right);
		if (lca != null) {
			System.out.println(lca.val);
		} else {
			System.out.println("Null");
		}
	}
	
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		LinkedList<TreeNode> pAncestors = new LinkedList<>();
		LinkedList<TreeNode> qAncestors = new LinkedList<>();
		getAncestors(p, root, pAncestors);
		getAncestors(q, root, qAncestors);
		TreeNode lastAncestor = null;
		while (!pAncestors.isEmpty() && !qAncestors.isEmpty()) {
			if (pAncestors.peekLast() == qAncestors.peekLast()) {
				lastAncestor = pAncestors.peekLast();
				pAncestors.removeLast();
				qAncestors.removeLast();
			} else break;
		}
		return lastAncestor;
	}

	private void getAncestors(TreeNode node, TreeNode root, LinkedList<TreeNode> ancestors) {
		if (root == null)
			return;
		if (node.val == root.val) {
			ancestors.addLast(root);
			return;
		}
		getAncestors(node, root.left, ancestors);
		if (!ancestors.isEmpty())
			ancestors.addLast(root);
		if (ancestors.isEmpty()) {
			getAncestors(node, root.right, ancestors);
			if (!ancestors.isEmpty())
				ancestors.addLast(root);
		}
	}
}

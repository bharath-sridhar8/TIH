package medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BTreeRightView {
	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		if (root == null)
			return result;
		LinkedList<TreeNode> queue = new LinkedList<>();
		queue.addLast(root);
		queue.addLast(null);
		TreeNode last = null;
		while (!queue.isEmpty()) {
			TreeNode treeNode = queue.removeFirst();
			if (treeNode != null) {
				last = treeNode;
				if (treeNode.left != null)
					queue.addLast(treeNode.left);
				if (treeNode.right != null)
					queue.addLast(treeNode.right);
			} else {
				result.add(last.val);
				if (!queue.isEmpty())
					queue.addLast(null);
			}
		}
		return result;
	}

	public static void main(String[] args) {
		BTreeRightView bTreeRightView = new BTreeRightView();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.right.right = new TreeNode(4);
		root.left.right = new TreeNode(5);
		System.out.println(bTreeRightView.rightSideView(root));
	}
	
}

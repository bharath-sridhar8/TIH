import java.util.LinkedList;

public class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }

	@Override
	public String toString() {
		return "TreeNode{" +
				"val=" + val;
	}

	public static void printTree(TreeNode root) {
		LinkedList<TreeNode> nodes = new LinkedList<>();
		nodes.add(root);

		while(!nodes.isEmpty()) {
			TreeNode node = nodes.removeFirst();
			System.out.println(node.val);
			if (node.left != null)
				nodes.add(node.left);
			if(node.right != null)
				nodes.add(node.right);
		}

	}
	
	
}


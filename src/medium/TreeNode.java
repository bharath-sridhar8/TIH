package medium;

public class TreeNode {

	int val;
	TreeNode left;

	public void setVal(int val) {
		this.val = val;
	}

	public void setLeft(TreeNode left) {
		this.left = left;
	}

	public void setRight(TreeNode right) {
		this.right = right;
	}

	TreeNode right;

	TreeNode() {
	}

	public TreeNode getLeft() {
		return left;
	}

	public TreeNode getRight() {
		return right;
	}

	public int getVal() {
		return val;
	}

	public TreeNode(int val) {
		this.val = val;
	}

	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}

	public void printInOrder(TreeNode node) {
		if (node == null) {
			System.out.println("null");
			return;
		}
		System.out.println(node.val);
		printInOrder(node.left);
		printInOrder(node.right);
	}
}

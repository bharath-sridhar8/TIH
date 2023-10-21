public class TreeMaxDepth {

  public static void main(String[] args) {
    TreeMaxDepth treeMaxDepth = new TreeMaxDepth();
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.left = new TreeNode(4);
    root.left.right = new TreeNode(5);
    System.out.println(treeMaxDepth.maxDepth(root));
  }

  public int maxDepth(TreeNode root) {
    if (root == null)
      return 0;
    return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
  }
}

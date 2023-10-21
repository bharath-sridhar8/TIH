public class TreeDiameter {

  public static void main(String[] args) {
    TreeDiameter treeDiameter = new TreeDiameter();
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
//    root.right = new TreeNode(3);
//    root.left.left = new TreeNode(4);
//    root.left.right = new TreeNode(5);
    System.out.println(treeDiameter.diameterOfBinaryTree(root));
  }

  public int diameterOfBinaryTree(TreeNode root) {
    int[] maxDia = new int[1];
    getHeight(root, maxDia);
    return maxDia[0];
  }

  public int getHeight(TreeNode node, int[] maxDia) {
    if (node == null)
      return 0;
    int lHeight = getHeight(node.left, maxDia);
    int rHeight = getHeight(node.right, maxDia);

    maxDia[0] = Math.max(maxDia[0], lHeight + rHeight);
    return Math.max(lHeight, rHeight) + 1;
  }

}

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
    int[] metrics = getMetrics(root);
    return metrics[2] - 1;
  }

  public int[] getMetrics(TreeNode node) {
    if (node == null)
      return new int[]{0,0,0};
    int[] lMetrics = getMetrics(node.left);
    int[] rMetrics = getMetrics(node.right);

    int llHeight = lMetrics[0];
    int lrHeight = lMetrics[1];
    int lDia = lMetrics[2];

    int rlHeight = rMetrics[0];
    int rrHeight = rMetrics[1];
    int rDia = rMetrics[2];

    int lHeight = Math.max(llHeight, lrHeight) + (lDia > 0 ? 1 : 0);
    int rHeight = Math.max(rlHeight, rrHeight) + (rDia > 0 ? 1 : 0);
    int dia = Math.max(Math.max(lDia, rDia), lHeight + rHeight + 1);
    return new int[] {lHeight, rHeight, dia};
  }

}

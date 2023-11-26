package hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import medium.TreeNode;

public class SerDeSerBTree {
	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		ArrayList<String> integers = new ArrayList<>();
		dfs(root, integers);
		String join = String.join(",", integers);
//		System.out.println(join);
		return join;
	}

	private void dfs(TreeNode root, ArrayList<String> integers) {
		if (root == null) {
			integers.add("null");
			return;
		}

		integers.add(String.valueOf(root.getVal()));
		dfs(root.getLeft(), integers);
		dfs(root.getRight(), integers);
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		String[] split = data.split(",");
		List<String> strings = new ArrayList<>(Arrays.asList(split));
		if (strings.size() == 0)
			return null;
		return deserialize(strings);
	}

	private TreeNode deserialize(List<String> strings) {
		String remove = strings.remove(0);
		if (remove.equals("null")) {
			return null;
		}
		TreeNode treeNode = new TreeNode(Integer.parseInt(remove));
		treeNode.setLeft(deserialize(strings));
		treeNode.setRight(deserialize(strings));
		return treeNode;
	}

	public static void main(String[] args) {
		SerDeSerBTree serDeSerBTree = new SerDeSerBTree();
		TreeNode root = new TreeNode(1);
		root.setLeft(new TreeNode(2));
		root.getLeft().setLeft(new TreeNode(3));
		root.getLeft().setRight(new TreeNode(4));
		root.setRight(new TreeNode(5));
		String serialize = serDeSerBTree.serialize(root);
		System.out.println("Serialize result");
		System.out.println(serialize);
		TreeNode deserialize = serDeSerBTree.deserialize(serialize);
		String serDesString = serDeSerBTree.serialize(deserialize);
		System.out.println(serDesString);
		System.out.println(serialize.equals(serDesString));
	}
}

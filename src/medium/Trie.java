package medium;

class TrieNode {
	TrieNode[] children;
	boolean isEoW = false;

	public TrieNode() {
		children = new TrieNode[26];
	}
}

public class Trie {
	
	TrieNode root;
	
	public Trie() {
		root = new TrieNode();
	}

	public static void main(String[] args) {
		Trie trie = new Trie();
		trie.insert("apple");
		System.out.println(trie.search("apple"));
		System.out.println(trie.search("app"));
		System.out.println(trie.startsWith("app"));
		trie.insert("app");
		System.out.println(trie.search("app"));
	}

	public void insert(String word) {
		if (word == null || word.isEmpty())
			return;
		insert(word, 0, root);
	}
	
	private void insert(String word, int idx, TrieNode node) {

		char c = word.charAt(idx);
//		System.out.println(c + " : " + (c - 97));
		// init specific child.
		if (node.children[c - 97] == null) {
			node.children[c - 97] = new TrieNode();
		}

		if (idx < word.length() - 1)
			insert(word, idx + 1, node.children[c - 97]);
		else if (idx == word.length() - 1)
			node.children[c - 97].isEoW = true;
	}

	public boolean search(String word) {
		if (word == null || word.isEmpty())
			return false;
		return search(word, 0, root, true);
	}

	private boolean search(String word, int idx, TrieNode node, boolean isWord) {
		if (idx == word.length() - 1) {
			return node.children[word.charAt(idx) - 97] != null &&
					(!isWord || node.children[word.charAt(idx) - 97].isEoW); 
		} else {
			return node.children[word.charAt(idx) - 97] != null &&
					search(word, idx + 1, node.children[word.charAt(idx) - 97], isWord);
		}
	}

	public boolean startsWith(String prefix) {
		return search(prefix, 0, root, false);
	}
}

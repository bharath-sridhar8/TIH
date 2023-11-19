package medium;

public class LongestPalindromicSubstring {
	public String longestPalindrome(String s) {
		int n = s.length();
		for (int length = n; length > 1; length--) {
			for (int i = 0; i <= n - length; i++) {
				if (check(s, i, i+length-1))
					return s.substring(i, i + length);
			}
		}
		return "";
	}

	private boolean check(String s, int i, int length) {
		int l = i;
		int r = length;
		while (l < r) {
			if (s.charAt(l) != s.charAt(r))
				return false;
			l++;
			r--;
		}
		return true;
	}

	public static void main(String[] args) {
		LongestPalindromicSubstring longestPalindromicSubstring = new LongestPalindromicSubstring();
		System.out.println(longestPalindromicSubstring.longestPalindrome("babad"));
	}
}

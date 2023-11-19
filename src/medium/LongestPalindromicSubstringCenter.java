package medium;

public class LongestPalindromicSubstringCenter {
	public String longestPalindrome(String s) {
		// odd length center - expand - note widest palindrome.
		// even length center - expand - note widest palindrome.
		int l = 0;
		int r = 0;
		for (int i = 0; i < s.length(); i++) {
			int oddLength = expand(s, i, i);
			int spread = oddLength / 2;
			if (oddLength > r - l + 1) {
				l = i - spread;
				r = i + spread;
			}

			int evenLength = expand(s, i, i+1);
			spread = (evenLength -1 )/ 2;
			if (evenLength > r - l + 1) {
				l = i - spread;
				r = i + 1 + spread;
			}
		}
		
		return s.substring(l, r+1);
	}

	private int expand(String s, int i, int j) {
		int n = s.length();
		while (i >= 0 && j < n && s.charAt(i) == s.charAt(j)) {
			i--;
			j++;
		}
		return j - i - 1;
	}

	public static void main(String[] args) {
		LongestPalindromicSubstringCenter longestPalindromicSubstringCenter = new LongestPalindromicSubstringCenter();
		System.out.println(longestPalindromicSubstringCenter.longestPalindrome("cbbd"));
	}
}

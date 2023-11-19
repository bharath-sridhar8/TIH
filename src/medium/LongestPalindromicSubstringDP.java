package medium;

public class LongestPalindromicSubstringDP {
	public String longestPalindrome(String s) {
		int n = s.length();
		boolean[][] dp = new boolean[n][n];
		// single chars are palindromic.
		for (int i = 0; i < n; i++)
			dp[i][i] = true;
		
		int l = 0;
		int r = 0;
		// substring of length 2 are palindromic if the chars are the same.
		for (int i = 0; i < n - 1; i++) {
			dp[i][i+1] = s.charAt(i) == s.charAt(i+1);
			if (dp[i][i+1]) {
				l = i;
				r = i+1;
			} 
		}
		
		for (int diff = 2; diff <= n; diff++) {
			for (int i = 0; i < n - diff; i++) {
				dp[i][i+diff] = s.charAt(i) == s.charAt(i+diff) && dp[i+1][i+diff-1];
				if (dp[i][i+diff]) {
					l = i;
					r = i+diff;
				}
			}
		}
		return s.substring(l, r+1);
	}

	public static void main(String[] args) {
		LongestPalindromicSubstringDP longestPalindromicSubstringDP = new LongestPalindromicSubstringDP();
		System.out.println(longestPalindromicSubstringDP.longestPalindrome("babab"));
	}
}

package medium;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringNonRepeatingChars {
	public int lengthOfLongestSubstring(String s) {
		if (s.length() == 0)
			return 0;
		// base values of variables.
		int l = 1;
		int start = 0;
		int end = 0;
		int maxL = 1;
		String longest = s.substring(0,1);
		Set<Character> windowChars = new HashSet<>();
		windowChars.add(s.charAt(0));
		for (int i = 1; i < s.length(); i++) {
			char c = s.charAt(i);
			// shrink while c is in window
			while (windowChars.contains(c)) {
				windowChars.remove(s.charAt(start++));
				l--;
			}
			// expand if c not in window
			windowChars.add(c);
			l++;
			end++;
			if (l > maxL) {
				maxL = l;
				longest = s.substring(start, end + 1);
			}
		}
//		System.out.println(longest);
		return maxL;
	}

	public static void main(String[] args) {
		LongestSubstringNonRepeatingChars longestSubstringNonRepeatingChars = new LongestSubstringNonRepeatingChars();
		System.out.println(longestSubstringNonRepeatingChars.lengthOfLongestSubstring("pwwkew"));
	}
}

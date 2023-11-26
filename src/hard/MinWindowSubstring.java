package hard;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class MinWindowSubstring {
	public String minWindow(String s, String t) {
		// maintain global minWindowString
		String minWindowString = "";
		
		// base conditions
		int n = t.length();
		if (s.length() < n || n == 0)
			return minWindowString;
		
		// prepare `tmap` counting number of occurrences of characters in `t`
		Map<Character, Integer> tmap = new HashMap<>();
		for (int i = 0; i < n; i++) {
			if (!tmap.containsKey(t.charAt(i)))
				tmap.put(t.charAt(i), 1);
			else
				tmap.put(t.charAt(i), tmap.get(t.charAt(i)) + 1);
		}

		Map<Character, Integer> smap = new HashMap<>();
		boolean expand = true;

		int m = s.length();
		// window variables
		int start = 0, end = -1;
		while(end < m - 1) {
			// expand window adding characters of `s` into a smap until smap.equals(tmap)
			end++;
			addToSMap(s.charAt(end), smap);
			// once smap.equals(tmap) => if new window length < minWindowString.length => set minWindowString to new window string.
			while (windowContains(smap, tmap)) {

				if ( minWindowString.equals("") || (end - start + 1 < minWindowString.length())) {
					int windowSize = end - start + 1;
					minWindowString = s.substring(start, end + 1);
					// cannot get a smaller substring.
					if (windowSize == n)
						break;
				}
				
				// after a find, stop shrinking till the 2nd required character / count.
				if (!tmap.containsKey(s.charAt(start))) {
					while (!tmap.containsKey(s.charAt(start))) {
						if (smap.get(s.charAt(start)) > 1) {
							smap.put(s.charAt(start), smap.get(s.charAt(start)) - 1);
						} else
							smap.remove(s.charAt(start));
						start++;
					}
				} else {
					// remove the first required character, this resumes window expansion
					if (smap.get(s.charAt(start)) > 1) {
						smap.put(s.charAt(start), smap.get(s.charAt(start)) - 1);
					} else
						smap.remove(s.charAt(start));
					start++;
				}
			}
		}
		return minWindowString;
	}

	private boolean windowContains(Map<Character, Integer> smap, Map<Character, Integer> tmap) {
		for (Entry<Character, Integer> entry : tmap.entrySet()) {
			if (!smap.containsKey(entry.getKey()) || smap.get(entry.getKey()) < tmap.get(entry.getKey()))
				return false;
		}
		return true;
	}

	private void addToSMap(char charAt, Map<Character, Integer> smap) {
		if (smap.containsKey(charAt))
			smap.put(charAt, smap.get(charAt) + 1);
		else
			smap.put(charAt, 1);
	}

	public static void main(String[] args) {
		MinWindowSubstring minWindowSubstring = new MinWindowSubstring();
		System.out.println(minWindowSubstring.minWindow("a", "aa"));
	}
}

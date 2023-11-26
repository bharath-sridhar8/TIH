package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnagramsInAString {
	public List<Integer> findAnagrams(String s, String p) {

		int n = s.length();
		int pLength = p.length();
		List<Integer> result = new ArrayList<>();
		if (n < pLength)
			return result;
		
		Map<Character, Integer> charCountMap = new HashMap<>();
		for (Character ch : p.toCharArray()) {
			if (!charCountMap.containsKey(ch))
				charCountMap.put(ch, 1);
			else
				charCountMap.put(ch, charCountMap.get(ch) + 1);
		}

		Map<Character, Integer> windowCountMap = new HashMap<>();
		for (int i  = 0; i < n; i++) {
			// add char to map.
			char ch = s.charAt(i);
			if (!windowCountMap.containsKey(ch))
				windowCountMap.put(ch, 1);
			else
				windowCountMap.put(ch, windowCountMap.get(ch) + 1);
			
			// start removing char from map when i >= pLength
			if (i >= pLength) {
				if (windowCountMap.get(s.charAt(i - pLength)) == 1)
					windowCountMap.remove(s.charAt(i - pLength));
				else
					windowCountMap.put(s.charAt(i - pLength), windowCountMap.get(s.charAt(i - pLength)) - 1);
			}
			
			if (i >= pLength - 1 && charCountMap.equals(windowCountMap))
				result.add(i - pLength + 1);
		}
		return result;
	}

	public static void main(String[] args) {
		AnagramsInAString anagramsInAString = new AnagramsInAString();
		System.out.println(anagramsInAString.findAnagrams("abab", "ab"));
	}
}

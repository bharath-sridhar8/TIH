import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {

	public static void main(String[] args) {
		ValidAnagram validAnagram = new ValidAnagram();
		System.out.println(validAnagram.isAnagram("rat", "car"));
	}

	public boolean isAnagram(String s, String t) {
		Map<Character, Integer> charCountMap = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (charCountMap.containsKey(c))
				charCountMap.put(c, charCountMap.get(c) + 1);
			else
				charCountMap.put(c, 1);
		}
		
		for (int i = 0; i < t.length(); i++) {
			char c = t.charAt(i);
			if (charCountMap.containsKey(c)) {
				int newCount = charCountMap.get(c) - 1;
				if (newCount == 0)
					charCountMap.remove(c);
				else
					charCountMap.put(c, newCount);
			} else {
				return false;
			}
		}
		
		return charCountMap.isEmpty();
	}
}

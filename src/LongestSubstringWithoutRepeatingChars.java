import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingChars {

	public static void main(String[] args) {
		String input = "cdbaefabcab";
		Map<Character, Integer> map = new HashMap<>();

		if (input.length() <= 1) {
			System.out.println(input);
			return;
		}
		
		int start = 0, end = 0, windowSize = 1, maxWindowSize = 1;
		String longestSubstring = input.substring(start, end + 1);
		map.put((input.charAt(0)), 1);
		
		while (end < input.length() - 1) {
			char c = input.charAt(end + 1);
			//  shrink window from left till `c` is removed from window.
			while (map.containsKey(c)) {
				map.remove(input.charAt(start));
				start++;
				windowSize--;
			}

			// add `c` to window
			map.put(c, 1);
			end++;
			windowSize++;
			
			if (windowSize > maxWindowSize) {
				maxWindowSize = windowSize;
				longestSubstring = input.substring(start, end + 1);
			}
		}

		System.out.println(longestSubstring);
	}

}

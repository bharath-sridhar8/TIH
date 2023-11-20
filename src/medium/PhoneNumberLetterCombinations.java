package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PhoneNumberLetterCombinations {
	private static final Map<String, Set<String>> numberCharMap = new HashMap<>();
	static {
		numberCharMap.put("2", new HashSet<>(Arrays.asList("a","b","c")));
		numberCharMap.put("3", new HashSet<>(Arrays.asList("d","e","f")));
		numberCharMap.put("4", new HashSet<>(Arrays.asList("g","h","i")));
		numberCharMap.put("5", new HashSet<>(Arrays.asList("j","k","l")));
		numberCharMap.put("6", new HashSet<>(Arrays.asList("m","n","o")));
		numberCharMap.put("7", new HashSet<>(Arrays.asList("p","q","r","s")));
		numberCharMap.put("8", new HashSet<>(Arrays.asList("t","u","v")));
		numberCharMap.put("9", new HashSet<>(Arrays.asList("w","x","y","z")));
	}
	public List<String> letterCombinations(String digits) {
		return letterCombinations(digits, digits.length());
	}

	private List<String> letterCombinations(String digits, int length) {
		if (length == 0)
			return new ArrayList<>();
		List<String> strings = letterCombinations(digits, length - 1);
		List<String> newCombinations = new ArrayList<>();
		String substring = digits.substring(digits.length() - length, digits.length() - length + 1);
		if (strings.isEmpty())
			newCombinations = new ArrayList<>(numberCharMap.get(substring));
		else {
			for (String ch : numberCharMap.get(substring)) {
				for (String s : strings) {
					newCombinations.add(ch + s);
				}
			}
		}
		return newCombinations;
	}

	public static void main(String[] args) {
		PhoneNumberLetterCombinations phoneNumberLetterCombinations = new PhoneNumberLetterCombinations();
		System.out.println(phoneNumberLetterCombinations.letterCombinations("2"));
	}
}

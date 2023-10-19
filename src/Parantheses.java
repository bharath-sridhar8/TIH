import java.util.HashMap;
import java.util.LinkedList;
import java.util.Set;
import java.util.stream.Collectors;

public class Parantheses {

	public static void main(String[] args) {
		System.out.println(isValid("()()[][["));
	}
	
	public static boolean isValid(String s) {
		String openBraces = "({[";
		String closedBraces = ")}]";
		HashMap<Character, Character> map = new HashMap<>();
		for (int i = 0; i  < closedBraces.length(); i++) {
			map.put(closedBraces.charAt(i), openBraces.charAt(i));
		}

		LinkedList<Character> stack = new LinkedList<>();

		Set<Character> openBraceSet = openBraces.chars().mapToObj(c -> (char) c).collect(Collectors.toSet());

		for (int i = 0; i < s.length(); i++) {
			if (openBraceSet.contains(s.charAt(i))) {
				stack.push(s.charAt(i));
			} else {
				if (stack.size() == 0 || !stack.pop().equals(map.get(s.charAt(i)))) {
					return false;
				}
			}
		}

		return stack.size() == 0;
	}

}

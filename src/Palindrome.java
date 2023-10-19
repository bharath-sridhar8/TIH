import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Palindrome {

	public static void main(String[] args) {
		System.out.println(isPalindrome("race a car"));
	}

	public static boolean isPalindrome(String s) {
		String s1 = s.replaceAll("[^A-Za-z0-9]", "");
		return s1.equalsIgnoreCase(new StringBuilder((s1)).reverse().toString());
	}

}

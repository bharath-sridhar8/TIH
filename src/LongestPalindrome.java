import java.util.HashMap;
import java.util.Map;

public class LongestPalindrome {
  public int longestPalindrome(String s) {
    Map<Character, Boolean> map = new HashMap<>();
    int count = 0;
    for ( int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (map.containsKey(c)) {
        map.remove(c);
        count += 2;
      } else {
        map.put(c, true);
      }
    }
    if (!map.isEmpty())
      count++;
    return count;
  }

  public static void main(String[] args) {
    LongestPalindrome longestPalindrome = new LongestPalindrome();
    System.out.println(longestPalindrome.longestPalindrome("accccdda"));
  }
}

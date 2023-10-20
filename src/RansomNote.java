import java.util.HashMap;
import java.util.Map;

public class RansomNote {

  public static void main(String[] args) {
    RansomNote ransomNote = new RansomNote();
    System.out.println(ransomNote.canConstruct("aa", "aab"));
  }

  public boolean canConstruct(String ransomNote, String magazine) {
    Map<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < magazine.length(); i++) {
      char c = magazine.charAt(i);
      if (map.containsKey(c))
        map.put(c, map.get(c) + 1);
      else
        map.put(c, 1);
    }
    
    for (int j = 0; j < ransomNote.length(); j++) {
      char c = ransomNote.charAt(j);
      if (!map.containsKey(c))
        return false;
      else {
        Integer newValue = map.get(c) - 1;
        if (newValue == 0)
          map.remove(c);
        else
          map.put(c, newValue);
      }
    }
    return true;
  }
}

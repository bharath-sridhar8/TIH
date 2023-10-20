import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MapMajority {

  public static void main(String[] args) {
    MapMajority mapMajority = new MapMajority();
    System.out.println(mapMajority.majorityElement(new int[]{2,2,3,3,2}));
  }

  public int majorityElement(int[] nums) {
    int maxEl = Integer.MAX_VALUE;
    int leadBy = 1;
    for (int i : nums) {
      if (i != maxEl) {
        leadBy--;
        if (leadBy == 0) {
          leadBy = 1;
          maxEl = i;
        }
      } else {
        leadBy++;
      }
    }
    return maxEl;
  }
}

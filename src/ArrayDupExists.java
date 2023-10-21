import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ArrayDupExists {

  public static void main(String[] args) {
    ArrayDupExists arrayDupExists = new ArrayDupExists();
    System.out.println(arrayDupExists.containsDuplicate(new int[]{1,2,3,4}));
  }

  public boolean containsDuplicate(int[] nums) {
    Set<Integer> collect = IntStream.of(nums).boxed().collect(Collectors.toSet());
    return collect.size() != nums.length;
  }
}
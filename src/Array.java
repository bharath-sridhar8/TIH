import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Array {

	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4};
		Arrays.stream(arr).forEach(i -> System.out.println(i));
		List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
		System.out.println(list);
		
		list.add(5);
		System.out.println(list);
		
		list.remove((Integer) 3);
		System.out.println(list);

		System.out.println(list.indexOf(2));
		
		list.set(2, 3);
		System.out.println(list);
	}

}

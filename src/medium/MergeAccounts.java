package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class MergeAccounts {

	public List<List<String>> accountsMerge(List<List<String>> accounts) {
		Map<String, Set<String>> emailToSetMap = new HashMap<>();
		Map<String, String> emailToNameMap = new HashMap<>();
		
		for (List<String> account : accounts) {
			String name = account.get(0);
			Set<String> emailSet = account.stream().filter(val -> val != name).collect(Collectors.toSet());
			Set<String> existingEmail = new HashSet<>();
			for (String s: emailSet) {
				if (emailToSetMap.containsKey(s))
					existingEmail.add(s);
			}
			if (existingEmail.size() == 0) {
				for (String s: emailSet) {
					emailToSetMap.put(s, emailSet);
					emailToNameMap.put(s, name);
				}
			} else {
				String key = existingEmail.iterator().next();
				for (String s: existingEmail) {
					Set<String> otherKeys = emailToSetMap.get(s);
					emailToSetMap.get(key).addAll(otherKeys);
					for (String otherKey : otherKeys) {
						emailToSetMap.put(otherKey, emailToSetMap.get(key));
					}
				}
				emailSet.removeAll(existingEmail);
				for (String s : emailSet) {
					emailToSetMap.put(s, emailToSetMap.get(key));
					emailToNameMap.put(s, emailToNameMap.get(key));
				}
			}
		}

		Collection<Set<String>> values = emailToSetMap.values();
		for (Set<String> emails : values) {
			LinkedList<String> strings = new LinkedList<>(emails);
			strings.addFirst(emailToNameMap.get(strings.get(0)));
		}
		List<List<String>> collect = values.stream().map(ArrayList::new)
				.collect(Collectors.toList());
		return collect;
	}

	public static void main(String[] args) {
		MergeAccounts mergeAccounts = new MergeAccounts();
		List<List<String>> lists = mergeAccounts.accountsMerge(
				Arrays.asList(Arrays.asList("John", "johnsmith@mail.com", "john_newyork@mail.com"),
						Arrays.asList("John", "johnsmith@mail.com", "john00@mail.com"),
						Arrays.asList("Mary", "mary@mail.com"),
						Arrays.asList("John", "johnnybravo@mail.com")
				));
		for (List<String> list : lists) {
			System.out.println(list);
		}
	}

}

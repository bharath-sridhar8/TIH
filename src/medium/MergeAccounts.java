package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

class Account {
	private String name;

	public String getName() {
		return name;
	}

	public Set<String> getEmails() {
		return emails;
	}

	private Set<String> emails;

	public Account(String name, Set<String> emails) {
		this.name = name;
		this.emails = emails;
	}
}

public class MergeAccounts {

	public List<List<String>> accountsMerge(List<List<String>> accounts) {

		List<Account> accountList = new ArrayList<>();

		for (List<String> account : accounts) {
			String name = account.get(0);
			ArrayList<String> accountClone = new ArrayList<>(account);
			accountClone.remove(0);
			HashSet<String> emailSet = new HashSet<>(accountClone);
			
			Set<Account> accountsToMerge = new HashSet<>();
			// existing sets
			for (String email : emailSet) {
				for (Account account1 : accountList) {
					if (account1.getEmails().contains(email))
						accountsToMerge.add(account1);
				}
			}
			
			if (accountsToMerge.size() > 1) {
				Iterator<Account> iterator = accountsToMerge.iterator();
				Account firstAccount = iterator.next();
				while (iterator.hasNext()) {
					Account nextAccount = iterator.next();
					firstAccount.getEmails().addAll(nextAccount.getEmails());
					accountList.remove(nextAccount);
				}
				firstAccount.getEmails().addAll(emailSet);
			} else if (accountsToMerge.size() == 1) {
				accountsToMerge.iterator().next().getEmails().addAll(emailSet);
			} else {
				accountList.add(new Account(name, emailSet));
			}
		}
		
		List<List<String>> result = new ArrayList<>();
		for (Account account: accountList) {
			ArrayList<String> emails = new ArrayList<>(account.getEmails());
			Collections.sort(emails);
			emails.add(0, account.getName());
			result.add(emails);
		}
		return result;
	}

	public static void main(String[] args) {
		MergeAccounts mergeAccounts = new MergeAccounts();
		List<List<String>> lists = mergeAccounts.accountsMerge(
				Arrays.asList(Arrays.asList("Alex","Alex5@m.co","Alex4@m.co","Alex0@m.co"),
						Arrays.asList("Ethan","Ethan3@m.co","Ethan3@m.co","Ethan0@m.co"),
						Arrays.asList("Kevin","Kevin4@m.co","Kevin2@m.co","Kevin2@m.co"),
						Arrays.asList("Gabe","Gabe0@m.co","Gabe3@m.co","Gabe2@m.co"),
						Arrays.asList("Gabe","Gabe3@m.co","Gabe4@m.co","Gabe2@m.co")
				));
		for (List<String> list : lists) {
			System.out.println(list);
		}
	}

}

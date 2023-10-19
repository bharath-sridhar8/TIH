public class MergeSortedLists {

	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(2);
		l1.next.next = new ListNode(4);

		ListNode l2 = new ListNode(1);
		l2.next = new ListNode(3);
		l2.next.next = new ListNode(4);

		ListNode listNode = mergeTwoLists(l1, l2);
		while (listNode != null) {
			System.out.println(listNode.val);
			listNode = listNode.next;
		}
	}

	static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
     ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

	public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
		if (list1 == null )
			return list2;
		else if (list2 == null)
			return list1;

		ListNode head;
		
		if (list1.val <= list2.val) {
			head = list1;
			list1 = list1.next;
		} else {
			head = list2;
			list2 = list2.next;
		}
		
		ListNode tail = head;
		
		while (list1 != null && list2 !=  null) {
			if (list1.val <= list2.val) {
				tail.next = list1;
				tail = tail.next;
				list1 = list1.next;
			} else {
				tail.next = list2;
				tail = tail.next;
				list2 = list2.next;
			}
		}
		
		if (list1 != null) {
			tail.next = list1;
		} else {
			tail.next = list2;
		}
		
		return head;
	}

}

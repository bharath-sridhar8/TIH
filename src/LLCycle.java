public class LLCycle {

	public static void main(String[] args) {
		LLCycle llCycle = new LLCycle();
		ListNode head = new ListNode(3);
		ListNode second = new ListNode(2);
		head.next = second;
		head.next.next = new ListNode(0);
		head.next.next.next = new ListNode(-1);
//		head.next.next.next.next = second;
		System.out.println(llCycle.hasCycle(head));
	}

	public boolean hasCycle(ListNode head) {
		if (head == null || head.next == null)
			return false;
		ListNode slow = head;
		ListNode fast = head.next;
		while (fast != null && slow != fast) {
			slow = slow.next;
			fast = fast.next;
			if (fast != null)
				fast = fast.next;
		}
		return fast != null;
	}
}

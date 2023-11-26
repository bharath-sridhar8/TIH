package hard;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

class ListNode {
      int val;
      ListNode next;

	public int getVal() {
		return val;
	}

	ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
			public void print() {
				ListNode ref = this;
				while (ref != null) {
					System.out.println(ref.val);
					ref = ref.next;
				}
			}
}

public class MergeKSortedLists {
	public ListNode mergeKLists(ListNode[] lists) {
		// arr[k] -> as we iterate, lets push the first node of each list to a min-heap.
		// we could pop the first element from the min-heap.

		// While !heap.isEmpty()
		//		pop Node
		//		insert new node with value into result list
		//		set node -> node.next
		//		if node != null
		//		add node to heap

		PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>() {
			@Override
			public int compare(ListNode o1, ListNode o2) {
				return o1.val - o2.val;
			}
		});
		
		for (int i = 0; i < lists.length; i++) {
			if (lists[i] != null)
				pq.add(lists[i]);
		}
		
		ListNode result = new ListNode(-1);
		ListNode tail = result;
		
		while (!pq.isEmpty()) {
			ListNode remove = pq.remove();
			tail.next = new ListNode(remove.val);
			tail = tail.next;
			if (remove.next != null)
				pq.add(remove.next);
		}
		
		return result.next;
	}

	public static void main(String[] args) {
		MergeKSortedLists mergeKSortedLists = new MergeKSortedLists();

		ListNode list1 = new ListNode(1);
		list1.next = new ListNode(4);
		list1.next.next = new ListNode(5);

		ListNode list2 = new ListNode(1);
		list2.next = new ListNode(3);
		list2.next.next = new ListNode(4);

		ListNode list3 = new ListNode(2);
		list3.next = new ListNode(6);

		ListNode listNode = mergeKSortedLists.mergeKLists(
				new ListNode[]{list1, list2, list3});
		listNode.print();
	}
}

public class ReverseList {

  public static void main(String[] args) {
    ReverseList reverseList = new ReverseList();
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(4);
    head.next.next.next.next = new ListNode(5);
    head.printList();
    reverseList.reverseList(head).printList();
  }

  public ListNode reverseList(ListNode head) {
    if (head == null)
      return head;
    ListNode newHead = head;
    ListNode nextNode = head.next;
    newHead.next = null;
    while (nextNode != null) {
      ListNode temp = newHead;
      newHead = nextNode;
      nextNode = nextNode.next;
      newHead.next = temp;
    }
    return newHead;
  }
}

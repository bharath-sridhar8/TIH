public class LLMiddle {

  public static void main(String[] args) {
    LLMiddle llMiddle = new LLMiddle();
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(4);
//    head.next.next.next.next = new ListNode(5);
//    head.next.next.next.next.next = new ListNode(6);
    ListNode midNode = llMiddle.middleNode(head);
    System.out.println(midNode.val);
  }

  public ListNode middleNode(ListNode head) {
    if (head == null)
      return head;
    ListNode slow = head;
    ListNode fast = head;
    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;
    }
    return slow;
  }

}

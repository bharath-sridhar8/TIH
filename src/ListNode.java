public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
    
    public void printList() {
      ListNode ref = this;
      while (ref != null) {
        System.out.println(ref.val);
        ref = ref.next;
      }
    }
}
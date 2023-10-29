package lld;

import java.util.HashMap;

class DLLNode {
  public Integer value;
  public DLLNode next;
  public DLLNode prev;
  
  public DLLNode(){}
  
  public DLLNode(Integer value){
    this.value = value;
  }
  
  public void print() {
    DLLNode ref = this;
    while (ref != null) {
      System.out.println(ref.value);
      ref = ref.next;
    }
  }
}

public class LRU {
  private HashMap<Integer, DLLNode> map;
  private DLLNode head;
  private DLLNode tail;
  private final int capacity;

  public static void main(String[] args) {
    LRU lru = new LRU(1);
    lru.put(1, 1);
    lru.head.print();
    lru.tail.print();
    lru.put(2, 2);
    lru.head.print();
    lru.tail.print();
    lru.put(2, 2);
    lru.head.print();
    lru.tail.print();

    lru = new LRU(2);
    lru.put(1, 1);
    lru.head.print();
    lru.tail.print();
    lru.put(2, 2);
    lru.head.print();
    lru.tail.print();
    lru.put(1, 1);
    lru.head.print();
    lru.tail.print();
//
    lru = new LRU(3);
    lru.put(1, 1);
    lru.head.print();
    lru.tail.print();
    lru.put(2, 2);
    lru.head.print();
    lru.tail.print();
    lru.put(3, 3);
    lru.head.print();
    lru.tail.print();
    lru.put(2, 2);
    lru.head.print();
    lru.tail.print();
  }
  
  public LRU(int capacity) {
    this.capacity = capacity;
    this.map = new HashMap<>();
  }
  
  public void put(int k, int v) {
    synchronized (this) {
      // if k does not exist in map, create a new node & insert at head, if required, remove tail node.
      if (!map.containsKey(k)) {
        DLLNode newNode = new DLLNode(v);
        map.put(k, newNode);
        insertNodeAtHead(newNode);
        removeNodeIfRequired();
      } else {
        // update node value, move the node to head if required.
        DLLNode dllNode = map.get(k);
        dllNode.value = v;
        if (dllNode != head) {
          moveNodeToHead(dllNode);
        }
      }
    }
  }

  private void insertNodeAtHead(DLLNode newNode) {
    if (head == null) {
      head = newNode;
      tail = newNode;
    } else {
      newNode.next = head;
      head.prev = newNode;
      head = newNode;
    }
  }

  private void removeNodeIfRequired() {
    if (map.size() > capacity) {
      DLLNode lastButOne = tail.prev;
      lastButOne.next = null;
      tail.prev = null;
      tail = lastButOne;
    }
  }

  private void moveNodeToHead(DLLNode dllNode) {
    DLLNode next = dllNode.next;
    DLLNode prev = dllNode.prev;
    if (prev != null) {
      prev.next = next;
      if (next != null)
        next.prev = prev;
      else
        tail = prev;
      dllNode.prev = null;
      dllNode.next = null;
      insertNodeAtHead(dllNode);
    }
  }

  public int get(int k) {
    synchronized (this) {
      if (map.containsKey(k)) {
        DLLNode dllNode = map.get(k);
        moveNodeToHead(dllNode);
        return dllNode.value;
      }
      return -1;
    }
  }
}

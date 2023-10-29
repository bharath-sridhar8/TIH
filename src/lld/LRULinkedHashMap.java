package lld;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRULinkedHashMap extends LinkedHashMap<Integer, Integer>{
  private final int capacity;
  
  public LRULinkedHashMap(int maxElements) {
    super(maxElements, 0.75f, true);
    this.capacity = maxElements;
  }

  @Override
  protected boolean removeEldestEntry(Map.Entry eldest) {
    return size() > capacity;
  }
  
  public int get(int key) {
    return super.getOrDefault(key, -1);
  }
  
  public void put(int key, int value) {
    super.put(key, value);
  }

  public static void main(String[] args) {
    LRULinkedHashMap lruLinkedHashMap = new LRULinkedHashMap(1);
    lruLinkedHashMap.put(1, 1);
    System.out.println(lruLinkedHashMap.keySet());
    lruLinkedHashMap.put(2, 2);
    System.out.println(lruLinkedHashMap.keySet());
    lruLinkedHashMap.put(1, 1);
    System.out.println(lruLinkedHashMap.keySet());

    lruLinkedHashMap = new LRULinkedHashMap(2);
    lruLinkedHashMap.put(1, 1);
    System.out.println(lruLinkedHashMap.keySet());
    lruLinkedHashMap.put(2, 2);
    System.out.println(lruLinkedHashMap.keySet());
    lruLinkedHashMap.put(1, 1);
    System.out.println(lruLinkedHashMap.keySet());

    lruLinkedHashMap = new LRULinkedHashMap(3);
    lruLinkedHashMap.put(1, 1);
    System.out.println(lruLinkedHashMap.keySet());
    lruLinkedHashMap.put(2, 2);
    System.out.println(lruLinkedHashMap.keySet());
    lruLinkedHashMap.put(3, 3);
    System.out.println(lruLinkedHashMap.keySet());
    lruLinkedHashMap.put(2, 2);
    System.out.println(lruLinkedHashMap.keySet());
  }

}

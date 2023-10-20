import java.util.Random;

public class FirstBadVersion {
  
  int firstBad = 4;

  public static void main(String[] args) {
    FirstBadVersion firstBadVersion = new FirstBadVersion();
    System.out.println(firstBadVersion.firstBadVersion(10));
  }

  public int firstBadVersion(int n) {
    int low = 1;
    int high = n;
    int earliest = 0;
    while (low <= high) {
      int mid = low + ((high - low) / 2);
      if (isBadVersion(mid)) {
        earliest = mid;
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }
    if (earliest == 0)
      return -1;
    return earliest;
  }

  public boolean isBadVersion(int n) {
    return n >= firstBad;
  }
}

import java.math.BigDecimal;

public class AddBinary {

  public static void main(String[] args) {
    AddBinary addBinary = new AddBinary();
    System.out.println(addBinary.addBinary("1", "111"));
  }

  public String addBinary(String a, String b) {
    if (a.length() > b.length()) {
      int diff = a.length() - b.length();
      b = new StringBuilder(getZeroString(diff)).append(b).toString();
    } else if (a.length() < b.length()) {
      int diff = b.length() - a.length();
      a = new StringBuilder(getZeroString(diff)).append(a).toString();
    }
    
    int last = a.length() - 1;
    StringBuilder sb = new StringBuilder();
    boolean carry = false;
    for (int i = 0; i < a.length(); i++) {
      if (a.charAt(last) == '0') {
        if (b.charAt(last) == '0') {
          if (!carry)
            sb.append('0');
          else {
            sb.append('1');
            carry = false;
          }  
        } else {
          if (carry) {
            sb.append('0');
            carry = true;
          } else {
            sb.append('1');
          }
        }
      } else {
        if (b.charAt(last) == '0') {
          if (carry) {
            sb.append('0');
          } else {
            sb.append('1');
          }
        } else {
          if (carry) {
            sb.append('1');
          } else {
            sb.append('0');
          }
          carry = true;
        }
      }
      last--;
    }
    
    String prefix = "";
    if (carry)
      prefix = "1";
    
    return sb.append(prefix).reverse().toString();
  }

  private String getZeroString(int diff) {
    StringBuilder sb = new StringBuilder();
    while (diff > 0) {
      sb.append('0');
      diff--;
    }
    return sb.toString();
  }

}

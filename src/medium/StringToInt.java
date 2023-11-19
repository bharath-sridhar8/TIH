package medium;

import java.math.BigInteger;

public class StringToInt {
	public int myAtoi(String s) {
		// clear whitespaces.
		int whiteSpaceIdx = 0;
		while (whiteSpaceIdx < s.length() && s.charAt(whiteSpaceIdx) == ' ')
			whiteSpaceIdx++;
		s = s.substring(whiteSpaceIdx);
//		 check + or -
		if (s.isEmpty())
			return 0;
		char c = s.charAt(0);
		boolean negative = false;
		if (c == '-') {
			negative = true;
			s = s.substring(1);
		} 
		else if (c == '+') {
			s = s.substring(1);
		}
		// remove all non digit characters.
		int idx = 0;
		for(;idx < s.length(); idx++) {
			if (s.charAt(idx) < '0' || s.charAt(idx) > '9')
				break;
		}
		if (s.isEmpty())
			return 0;
		s = s.substring(0, idx);
		if (s.isEmpty())
			return 0;
		// add negative if required.
		if (negative)
			s = '-' + s;
		BigInteger big = new BigInteger(s);
		if (big.compareTo(BigInteger.ZERO) < 0) {
			if (big.compareTo(new BigInteger(String.valueOf(Integer.MIN_VALUE))) < 0)
				return Integer.MIN_VALUE;
			else
				return big.intValue();
		} else {
			if (big.compareTo(new BigInteger(String.valueOf(Integer.MAX_VALUE))) > 0) {
				return Integer.MAX_VALUE;
			} else
				return big.intValue();
		}
	}

	public static void main(String[] args) {
		StringToInt stringToInt = new StringToInt();
		System.out.println(stringToInt.myAtoi(" "));
	}
}

package lld;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashGen {

	public static void main(String[] args) throws NoSuchAlgorithmException {
		HashGen hashGen = new HashGen();
		System.out.println(hashGen.genMd5("hello"));
	}

	private String genMd5(String hello) throws NoSuchAlgorithmException {
		MessageDigest instance = MessageDigest.getInstance("MD5");
		byte[] digest = instance.digest(hello.getBytes(StandardCharsets.UTF_8));
		byte[] result = instance.digest();
		BigInteger bigInt = new BigInteger(1,result);
		return bigInt.toString(16);
	}

}

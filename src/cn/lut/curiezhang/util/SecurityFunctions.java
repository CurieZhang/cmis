package cn.lut.curiezhang.util;

import java.io.UnsupportedEncodingException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.bouncycastle.jcajce.provider.digest.SHA3;
import org.bouncycastle.util.encoders.Hex;

public class SecurityFunctions {

	private static final Logger log = LogManager.getLogger(SecurityFunctions.class);
	/** 
	 *  在 {@code input} 串上使用 SHA-3 哈希函数
	 * @param input 应用 SHA-3 哈希函数的串
	 * @param bitLength 应用 SHA-3 哈希函数的位数，如256、384、512等
	 * @return input 的哈希函数串
	 */
	public static String sha3(String input, int bitLength){
	  String hash="";
	  try {
	    SHA3.DigestSHA3 md=new SHA3.DigestSHA3(bitLength);
	    md.update(input.getBytes("UTF-8"));
	    hash = Hex.toHexString(md.digest());
	  }
	 catch (UnsupportedEncodingException e) {
	    log.error("cmis: SHA-3 错误 ",e);
	  }
	  return hash;
	}
	
	public static void main(String[] args) {
		System.out.println(sha3("111", 512));
	}

}

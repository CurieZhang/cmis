package cn.lut.curiezhang.util;

import java.io.UnsupportedEncodingException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.bouncycastle.jcajce.provider.digest.SHA3;
import org.bouncycastle.util.encoders.Hex;

public class SecurityFunctions {

	private static final Logger log = LogManager.getLogger(SecurityFunctions.class);
	/** 
	 *  �� {@code input} ����ʹ�� SHA-3 ��ϣ����
	 * @param input Ӧ�� SHA-3 ��ϣ�����Ĵ�
	 * @param bitLength Ӧ�� SHA-3 ��ϣ������λ������256��384��512��
	 * @return input �Ĺ�ϣ������
	 */
	public static String sha3(String input, int bitLength){
	  String hash="";
	  try {
	    SHA3.DigestSHA3 md=new SHA3.DigestSHA3(bitLength);
	    md.update(input.getBytes("UTF-8"));
	    hash = Hex.toHexString(md.digest());
	  }
	 catch (UnsupportedEncodingException e) {
	    log.error("cmis: SHA-3 ���� ",e);
	  }
	  return hash;
	}
	
	public static void main(String[] args) {
		System.out.println(sha3("111", 512));
	}

}

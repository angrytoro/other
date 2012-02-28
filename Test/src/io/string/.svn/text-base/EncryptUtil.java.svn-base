package io.string;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 用于给字符串加密的类
 * 
 * @author adullboy 2011.09.27
 */
public class EncryptUtil {
	private EncryptUtil() {
	}

	/**
	 * 加密传入的字符串，返回一个加密后的字符串(32位）
	 * 
	 * @param plainText
	 * @return
	 */
	public static String md5Encrypt(String plainText) {
		plainText = plainText + "yph67";// 往密码里面添加后缀，防止暴力破解
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("MD5");
			md.update(plainText.getBytes());
			byte[] b = md.digest();
			StringBuffer buf = new StringBuffer("");
			for (int offset = 0; offset < b.length; ++offset) {
				int i = b[offset];
				if (i < 0)
					i += 256;
				if (i < 16)
					buf.append("0");
				buf.append(Integer.toHexString(i));
			}
			return buf.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();// 该算法在J2EE下是存在的
		}
		return plainText;
	}

	public static void main(String args[]) {
		System.out.println(md5Encrypt("123456"));
	}
}

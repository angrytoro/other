package io.util;

import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import javax.crypto.spec.SecretKeySpec;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * 
 * @author FarmerLuo
 */
public class DESCoder {
	private static BASE64Encoder base64 = new BASE64Encoder();
//	 private static byte[] myIV = { 50, 51, 52, 53, 54, 55, 56, 57 };
//	 private static byte[] myIV = null;
//	 private static String strkey = "W9qPIzjaVGKUp7CKRk/qpCkg/SCMkQRu"; //
	// 字节数必须是8的倍数

	// 密钥
	private static String strkey = "MDMxODE4NDAyMzkyOTU0NDExNTg0NDQ0";// 由应用工厂提供

	public static String desEncrypt(String input) throws Exception {

		BASE64Decoder base64d = new BASE64Decoder();
		DESedeKeySpec p8ksp = null;
		p8ksp = new DESedeKeySpec(base64d.decodeBuffer(strkey));
		Key key = null;
		key = SecretKeyFactory.getInstance("DESede").generateSecret(p8ksp);

		byte[] plainBytes = (byte[]) null;
		Cipher cipher = null;
		byte[] cipherText = (byte[]) null;
		// “算法/模式/填充”
		plainBytes = input.getBytes("UTF8");
		cipher = Cipher.getInstance("DESede/ECB/PKCS5Padding");
		SecretKeySpec myKey = new SecretKeySpec(key.getEncoded(), "DESede");
		// IvParameterSpec ivspec = new IvParameterSpec(myIV);
		cipher.init(1, myKey);
		cipherText = cipher.doFinal(plainBytes);
		return removeBR(base64.encode(cipherText));

	}

	public static String desDecrypt(String cipherText) throws Exception {

		BASE64Decoder base64d = new BASE64Decoder();
		DESedeKeySpec p8ksp = null;
		p8ksp = new DESedeKeySpec(base64d.decodeBuffer(strkey));
		Key key = null;
		key = SecretKeyFactory.getInstance("DESede").generateSecret(p8ksp);

		Cipher cipher = null;
		byte[] inPut = base64d.decodeBuffer(cipherText);
		// “算法/模式/填充”
		cipher = Cipher.getInstance("DESede/ECB/PKCS5Padding");
		SecretKeySpec myKey = new SecretKeySpec(key.getEncoded(), "DESede");
		// IvParameterSpec ivspec = new IvParameterSpec(myIV);
		cipher.init(2, myKey);
		byte[] output = cipher.doFinal(inPut);
		return new String(output, "UTF8");
	}

	private static String removeBR(String str) {
		StringBuffer sf = new StringBuffer(str);

		for (int i = 0; i < sf.length(); ++i) {
			if (sf.charAt(i) == '\n') {
				sf = sf.deleteCharAt(i);
			}
		}
		for (int i = 0; i < sf.length(); ++i)
			if (sf.charAt(i) == '\r') {
				sf = sf.deleteCharAt(i);
			}

		return sf.toString();
	}
}

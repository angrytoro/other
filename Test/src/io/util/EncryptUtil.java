package io.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import javax.crypto.spec.SecretKeySpec;

import com.google.common.base.Preconditions;
import com.google.common.base.Throwables;

import date.DateCalculator;

/**
 * 用于给字符串加密的类
 * 
 * @author adullboy 2011.09.27
 * @author weefic 2011.11.21 BASE64 3DES
 */
public class EncryptUtil {
	static {
		KEY = "MDMxODE4NDAyMzkyOTU0NDExNTg0NDQ0";
	}
	public static final String KEY;

	private EncryptUtil() {
	}

	/**
	 * 加密传入的字符串，返回一个加密后的字符串(32位）
	 * 
	 * @param plainText
	 * @return
	 */
	public static String md5Encrypt(String plainText) {
		Preconditions.checkNotNull(plainText);
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
			Throwables.propagate(e);
		}
		return plainText;
	}

	/**
	 * BASE64加密
	 * 
	 * @param plainText
	 * @return
	 */
	public static String base64Encrypt(String plainText) {
		Preconditions.checkNotNull(plainText);
		return base64Encrypt(plainText.getBytes());
	}

	@SuppressWarnings("restriction")
	public static byte[] base64Decipher(String plainText) throws IOException {
		return new sun.misc.BASE64Decoder().decodeBuffer(plainText);
	}

	@SuppressWarnings("restriction")
	private static String base64Encrypt(byte[] plainText) {
		return new sun.misc.BASE64Encoder().encode(plainText);
	}

	/**
	 * DES加密
	 * 
	 * @param plainText
	 * @return
	 */
	public static String desEncrypt(String plainText) {
		try {
			byte[] base64Key = base64Decipher(KEY);
			DESedeKeySpec p8ksp = new DESedeKeySpec(base64Key);
			Key key = SecretKeyFactory.getInstance("DESede").generateSecret(
					p8ksp);
			Cipher cipher = Cipher.getInstance("DESede/ECB/PKCS5Padding");
			SecretKeySpec myKey = new SecretKeySpec(key.getEncoded(), "DESede");
			cipher.init(1, myKey);
			return base64Encrypt(cipher.doFinal(plainText.getBytes()));
		} catch (Exception e) {
			Throwables.propagate(e);
		}
		return null;
	}

	/**
	 * hmacsha1加密
	 * 
	 * @param data
	 * @param key
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @throws InvalidKeyException
	 */
	public static String hmacsha1(String data, String key)
			throws NoSuchAlgorithmException, InvalidKeyException {
		SecretKeySpec signingKey = new SecretKeySpec(key.getBytes(), "HmacSHA1");
		Mac mac = Mac.getInstance("HmacSHA1");
		mac.init(signingKey);
		byte[] rawHmac = mac.doFinal(data.getBytes());
		return base64Encrypt(rawHmac);
	}

	public static String urlEscape(String data) {
		try {
			return URLEncoder.encode(data, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			return null;
		}
	}

	public static void p(Object o) {
		System.out.println(o);
	}

	public static void main(String[] args) throws InvalidKeyException,
			NoSuchAlgorithmException {
		String mobile = "13429800004";
		String nickname = "czb";
		String authCode = "590859";
		Long now = DateCalculator.getNow();
		p(now);
		String hma = hmacsha1("timestamp=" + now.toString(),
				"i9\\Q}GJtrdePp37@\"'!O].tU");
		p(hma);
		p(urlEscape(hma));
		String lhma = hmacsha1("timestamp=" + now.toString()
				+ "&sid=a2f9ed8d6530fafcfc2e52bd613f64638&key=123",
				"i9\\Q}GJtrdePp37@\"'!O].tU");
		p(urlEscape(lhma));
		p("http://localhost:8080/DudCard/api/register?mobile=" + mobile + "&password=123456&nickname=" + nickname
				+ "&timestamp=" + now.toString() + "&auth=" + urlEscape(hma));
		p("http://localhost:8080/DudCard/api/activation?mobile=" + mobile + "&authCode=" + authCode + "&key=123&timestamp="
				+ now.toString() + "&auth=" + urlEscape(hma));
	}
}

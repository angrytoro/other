package com.pjxy.common.service.impl;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.inject.Singleton;

import com.pjxy.common.service.EncryptService;

@Singleton
public class EncryptServiceImpl implements EncryptService {
	@Override
	public String md5Encrypt(String plainText) {
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
	
	public static void main(String[] args){
		byte b = 1;
		System.out.println(Integer.toHexString(b&0xFF));
	}
}
package com.pjxy.common.service;

import com.google.inject.ImplementedBy;
import com.pjxy.common.service.impl.EncryptServiceImpl;

@ImplementedBy(EncryptServiceImpl.class)
public interface EncryptService {
	String md5Encrypt(String paramString);
}
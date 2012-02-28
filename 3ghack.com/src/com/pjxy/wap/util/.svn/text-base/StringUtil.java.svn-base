package com.pjxy.wap.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {
	
	public static boolean isMobile(String mobile){
		
		if(mobile != null){
			Matcher m = Pattern.compile("^((\\+86)|(86))?(1)\\d{10}$").matcher(mobile);
			if(m.find())
				return true;
			return false;
		}
		return false;
	}
}

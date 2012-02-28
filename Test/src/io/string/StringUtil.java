package io.string;

import java.util.Random;

public class StringUtil {

	private static final char[] NUMBER_SOURCE = new char[] { '1', '2', '3',
			'4', '5', '6', '7', '8', '9', '0' };
	private static final char[] CHAR_SOURCE = new char[] { '1', '2', '3', '4',
			'5', '6', '7', '8', '9', '0', 'a', 'b', 'c', 'd', 'e', 'f', 'a',
			'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n',
			'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A',
			'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N',
			'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
	private static final int SOURCE_LENGTH = NUMBER_SOURCE.length;
	private static final int CHAR_SOURCE_LENGTH = CHAR_SOURCE.length;

	public static String random(int length) {
		StringBuilder sb = new StringBuilder();
		Random r = new Random();
		for (int i = 0; i < length; i++) {
			sb.append(NUMBER_SOURCE[r.nextInt(SOURCE_LENGTH)]);
		}
		return sb.toString();
	}

	public static String randomString(int length) {
		StringBuilder sb = new StringBuilder();
		Random r = new Random();
		for (int i = 0; i < length; i++) {
			sb.append(CHAR_SOURCE[r.nextInt(CHAR_SOURCE_LENGTH)]);
		}
		return sb.toString();
	}

	public static String getLast(String src, String delim) {
		String result = src.substring(src.lastIndexOf(delim) + 1);
		return result;
	}

	/**
	 * 去除字符串src中包含的空格
	 * @param src
	 * @return 如果src为空的话，则返回""
	 * @author adullboy
	 * @since 2012.01.11
	 */
	public static String removeSpace(String src){
		if(src == null)
			return "";
		String array[] = src.split(" ");
		int length = array.length;
		if(length<=1)
			return src;
		StringBuilder result= new StringBuilder("");
		for(int i=0;i<length;i++)
			result.append(array[i]);
		return result.toString();
	}
	
	public static void p(Object o) {
		System.out.println(o.toString());
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// String userIdStr = "000000000" + 12;
		// userIdStr = userIdStr.substring(userIdStr.length() - 10);
		// System.out.println(userIdStr);
		// String s = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		// for (int i = 0; i < s.length(); i++)
		// System.out.print("'" + s.charAt(i) + "',");
		// System.out.println(" a b c ".trim());
		// System.out.println(s.length());
		// System.out.println(randomString(3));
		p(getLast("123;456;78910", ";"));
		p("abc"+(1+2)+"123");
		p("我是你大爷！".length());
		
		String str = "%' or CARD_NAME like '%";
		p(str.startsWith(str));
		p(removeSpace(str));
		p(removeSpace(null));
	}

}

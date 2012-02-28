package io.integer;

public class IntegerUtil {
	public static int getCaptcha(long l) {
		char[] charArray = String.valueOf(l).toCharArray();
		System.out.println(charArray[11]);
		int oddSum = charArray[11] + charArray[9] + charArray[7] + charArray[5]
				+ charArray[3] + charArray[1] - 6 * '0';
		int evenSum = charArray[10] + charArray[8] + charArray[6]
				+ charArray[4] + charArray[2] + charArray[0] - 6 * '0';
		int captcha = (10 - (oddSum * 3 + evenSum) % 10);
		if (captcha == 10)
			return 0;
		return captcha;
	}

	/**
	 * 截取一个long类型的子集，例如subLong(1234567890l,3,5)=45
	 * @param l 需要截取的数据 
	 * @param start 开始的index
	 * @param end 结束的index（不包括）end必须大于start并且不能大于或等于l的位数
	 * @return
	 */
	public static int subLong(long l, int start, int end) {
		char[] charArray = String.valueOf(l).toCharArray();
		if (start >= end || end > charArray.length)
			throw new IndexOutOfBoundsException();
		int sum = 0;
		for (int i = start; i < end; i++)
			sum = sum * 10 + charArray[i] - '0';
		return sum;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int i = getCaptcha(690123456789l);
		System.out.println("abcde".substring(1, 2));
		System.out.println(i);
		System.out.println(12345 / 1000);
		System.out.println(subLong(690123456789l, 1, 3));
	}

}

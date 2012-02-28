package io.integer;

import java.util.HashMap;
import java.util.Map;

public class LongUtil {

	/**
	 * 截取一个long类型的子集，例如subLong(1234567890l,3,5)=45
	 * 
	 * @param l
	 *            需要截取的数据
	 * @param start
	 *            开始的index
	 * @param end
	 *            结束的index（不包括）end必须大于start并且不能大于或等于l的位数
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

	public static void p(Object o) {
		System.out.println(o);
	}

	public static void main(String args[]) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("l1", new Long(1));
		map.put("l2", new Long(1));
		if (map.get("l1").equals(map.get("l2"))) {
			p("equal");
		}
		if ((Long) map.get("l1") > (Long) map.get("l2"))
			p("l1>l2");
		else
			p("l1 !> l2");
	}
}

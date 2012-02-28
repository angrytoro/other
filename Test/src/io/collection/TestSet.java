package io.collection;

import java.util.HashSet;
import java.util.Set;

public class TestSet {

	public static void p(Object o){
		System.out.println(o);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Set<Integer> test = new HashSet<Integer>();
		test.add(1);
		test.add(1);
		p(test.size());
	}

}

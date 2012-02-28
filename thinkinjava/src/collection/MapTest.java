package collection;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapTest {

	public static void main(String args[]){
//		Map hm = new HashMap<Integer,String>();
//		hm.put(0, "zero");
//		hm.put(1, "one");
//		hm.put(1, "one");
//		hm.put(2, "two");
//		hm.put(3, "three");
//		hm.put(6, "six");
//		hm.put(5, "five");
//		System.out.println(hm.size());
//		System.out.println(hm.keySet());
		
//		Map hm = new HashMap();
//		hm.put("zero", "zero");
//		hm.put("one", "one");
//		hm.put("one", "one");
//		hm.put("two", "two");
//		hm.put("three", "three");
//		hm.put("six", "six");
//		hm.put("five", "five");
//		System.out.println(hm.size());
//		System.out.println(hm.keySet());
//		System.out.println(hm.values());
//		System.out.println(hm.toString());
		
		Map hm = new TreeMap();
		hm.put("zero", "zero");
		hm.put("one", "one");
		hm.put("one", "one");
		hm.put("two", "two");
		hm.put("three", "three");
		hm.put("six", "six");
		hm.put("five", "five");
		System.out.println(hm.size());
		System.out.println(hm.keySet());
		System.out.println(hm.values());
		System.out.println(hm.toString());
	}
}

package collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class PrintingContainers {

	static Collection fill(Collection c){
		c.add("dog");
		c.add("dog");
		c.add("cat");
		return c;
	}
	static Map fill(Map m){
		m.put("dog","Bosco");
		m.put("dog", "spot");
		m.put("cat", "Rags");
		return m;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(fill(new ArrayList()));
		System.out.println(fill(new HashSet()));
		System.out.println(fill(new HashMap()));
		ArrayList a = (ArrayList) fill(new ArrayList());
		for(int i=0;i<a.size();i++)
			System.out.println(a.get(i));
	}

}

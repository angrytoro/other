package collection;

import java.util.LinkedList;

public class ListTest {

	public static void main(String args[]){
		LinkedList ll = new LinkedList();
		ll.addFirst("one");
		ll.addFirst("two");
		System.out.println(ll);
		System.out.println(ll.getFirst());
	}
	
	
}

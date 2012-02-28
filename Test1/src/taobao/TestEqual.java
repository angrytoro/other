package taobao;

abstract class B{
	private void print(){}
	public abstract  void println();
}

class A{
	int i = 0;
}

public class TestEqual {

	static int z = 1;
	int y = 1;
	public void add(final A a){
		z = 2;
		y = 2;
		a.i = 1;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int x = 3;
		x-=x-x--;
		System.out.println(x);
		Object o1 = new Object();
		Object o2 = new Object();
		final A a = new A();
		TestEqual te = new TestEqual();
		te.add(a);
		System.out.println(a.i);
		/* Êä³ö¶¼ÊÇnot equal
//		if(o1.equals(o2))
//			System.out.print("equal");
//		else
//			System.out.println("not equal");
		
		if(o1 == o2)
			System.out.print("equal");
		else
			System.out.println("not equal");
			
		A a1 = new A();
		A a2 = new A();
		
		if(a1 == a2)
			System.out.print("equal");
		else
			System.out.println("not equal");
		
		if(a1.equals(a2))
			System.out.print("equal");
		else
			System.out.println("not equal");
			*/
		A a1 = new A();
		A a2 = a1;
		
		if(a1 == a2)
			System.out.println("equal");
		else
			System.out.println("not equal");
		
		if(a1.equals(a2))
			System.out.println("equal");
		else
			System.out.println("not equal");
		
		String s = "HELLO";
		String t = s.toUpperCase();
		
		if(s == t)
			System.out.println("equal");
		else
			System.out.println("not equal");
		
		A test = (A)null;
		if(test == null)
			System.out.println("test is null");
	}

}

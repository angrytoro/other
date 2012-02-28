package otherTest;

import java.util.HashMap;

class Final{
	final static int i = 1;
	int j = 2;
	public final void test(){
		System.out.println("Final");
	}
}

class Final2{
	final int i;
	public Final2(int i){
		this.i = i;
	}
}
public class TestFinal extends Final{

	public static void main(String args[]){
		Class c = new TestFinal().getClass();
		Class c1 = c.getSuperclass();
		System.out.println(new TestFinal().getClass().getCanonicalName());
		System.out.println(c1);
		System.out.println("男".length());
		System.out.println(1<<2);
		
		System.out.println(new Final2(2).i);
		System.out.println(new Final2(4).i);
	}
}

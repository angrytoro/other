package otherTest;

abstract class test{
	private int i;
	public void setI(int i){
		this.i = i;
	}
	
	public int getI(){
		return this.i;
	}
}
class Test1 extends test{
	
}
class Test2 extends Test1{
	int j = 1;
}
public class TestAbstract {

	public static void main(String args[]){
		
		Test1 t1 = new Test2();
		Test2 t2 = (Test2) t1;
		System.out.println(t2.j);
		Test1 test1 = new Test1();
		Test2 test2 = new Test2();
		test1.setI(2);
		test2.setI(3);
		System.out.println(test1.getI());
		System.out.println(test2.getI());
	}
}

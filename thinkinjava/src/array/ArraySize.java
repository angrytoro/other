package array;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

class Weeble{}

public class ArraySize {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Weeble a[];
		Weeble b[] = new Weeble[5];
		Weeble c[] = {new Weeble()};
		c = b;
		int d[] = new int[2];
		int e[] = new int[3];
		System.out.println(c.length);
		e = d;
		System.out.println(e.length);
		Random r = new Random();
		System.out.println(r.nextBoolean());
		Weeble f[] = {new Weeble(),new Weeble()};
		Weeble g[] = new Weeble[2];
		System.arraycopy(f, 0, g, 0, 2);
		System.out.println(f[1]);
		System.out.println(g[1]);
		
		Arrays.fill(d, 3);
		/*asList()����������б�ĸ��Ļ�ֱ��д������
		 * �˷���ͬCollection.toArray()һ�𣬳䵱�˻��������api
		 * �����collection��api֮���������
		 * ���ص��б��ǿ����л���
		 */
		List<int[]> t = Arrays.asList(d);
		t.get(0)[0] = 1;
		System.out.println(d[0]);
		
		String h[] ={"1","bd","cx","x","d"};
		Arrays.sort(h);
		for(String s:h)
			System.out.println(s);
		/**
		 * reverseOrder(),ǿ����תʵ����Comparable��ڶ���collection����Ȼ˳��
		 * �˷�������������Ȼ˳���ʵ����Comparable��ڶ���collection��������
		 */
		Arrays.sort(h,Collections.reverseOrder());
		for(String s:h)
			System.out.println(s);
	}

}

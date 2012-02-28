package io.Float;

import java.text.DecimalFormat;

public class FloatTest {

	private float discount;
	public void setDiscount(String discount){
		this.discount = (float)Float.parseFloat(discount)/10;
	}
	
	public static void p(Object o){
		System.out.println(o);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		DecimalFormat df = new DecimalFormat("0.000");
		FloatTest ft = new FloatTest();
		ft.setDiscount("8.89");
		System.out.println(df.format(ft.discount));
		p((float)Math.round(ft.discount*1000)/1000);
	}

}

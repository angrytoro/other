package date;

import io.util.EncryptUtil;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateCalculator {
	private final static Calendar calendar = Calendar.getInstance();

	public Date getBeforeOrAfterDate(Date date, int days) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR)
				+ days);
		return calendar.getTime();
	}

	public static String dateFormat(Date date,String pattern){
		 SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		 return sdf.format(date);
	}
	
	public static long getNow(){
		calendar.setTime(new Date());
		return calendar.getTimeInMillis();
	}
	
	public static void p(Object o) {
		System.out.println(o.toString());
	}

	public static void main(String args[]) throws InvalidKeyException, NoSuchAlgorithmException {
		// Calendar calendar = Calendar.getInstance();
		// calendar.setTime(new Date());
		// calendar.set(Calendar.DAY_OF_YEAR,
		// calendar.get(Calendar.DAY_OF_YEAR) - 1);
		// System.out.println(calendar.getTime());
		// Date date = new Date();
		// System.out.println(new DateCalculator().getBeforeOrAfterDate(date,
		// 0).compareTo(date));
		// Date newDate = new Date(date.getTime());
		// System.out.println(date);
		// System.out.println(newDate);S
//		calendar.setTime(new Date());
//		p(calendar.get(Calendar.MILLISECOND));
//		calendar.setTime(new Date());
//		p(calendar.get(Calendar.MILLISECOND));
//		p(calendar.get(Calendar.DAY_OF_MONTH));
		Date date = new Date();
		p(date);
		calendar.setTime(date);
//		calendar.set(Calendar.HOUR_OF_DAY, 0);
//		calendar.set(Calendar.MINUTE, 0);
//		calendar.set(Calendar.SECOND, 0);
		p(calendar.getTimeInMillis());
		p(EncryptUtil.hmacsha1(((Long)calendar.getTimeInMillis()).toString(), "i9\\Q}GJtrdePp37@\"'!O].tU"));
		p(dateFormat(date, "yyyy年MM月dd日 HH时mm分"));
	}
}

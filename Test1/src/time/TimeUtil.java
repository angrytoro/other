package time;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 
 * @author adullboy
 * @version 1.0 2011.07.28
 */
public class TimeUtil {

	/**
	 * @param date 需要转成字符串的日期
	 * @param pattern 转成字符串的日期的格式
	 * @return 如果成功则返回一个以pattern为格式的date字符串，否则返回null
	 */
	public String formatDate(Date date,String pattern){
		if(date != null){
			try {
				SimpleDateFormat format = new SimpleDateFormat(pattern);
				return format.format(date);
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}
		return null;
	}
	
	/**
	 * 该函数主要将如期处理格式为yyyy-MM-dd HH:mm:ss的字符串
	 * @param date 需要处理的日期
	 * @return 成功则返回一个string，否则返回null
	 */
	public String formatDate(Date date){
		if(date != null)
			return formatDate(date,"yyyy-MM-dd HH:mm:ss");
		return null;
	}
	
	public static void main(String args[]){
		Calendar cal = Calendar.getInstance();
		System.out.println(cal.getTimeInMillis());
		System.out.println(new Date().getTime());
	}
}

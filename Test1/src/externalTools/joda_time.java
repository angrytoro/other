package externalTools;

import org.joda.time.DateTime;

public class joda_time {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DateTime dt = DateTime.now();
		System.out.println(dt.toString());
		System.out.println(dt.getCenturyOfEra()); //真是出错了，现在是21世纪
		System.out.println(dt.getDayOfMonth());
		System.out.println(dt.getDayOfWeek());
		System.out.println(dt.getDayOfYear());
		System.out.println(dt.getEra());
		System.out.println(dt.getMillisOfDay());
		System.out.println(dt.getHourOfDay());
		System.out.println(dt.dayOfMonth().get());
	}

}

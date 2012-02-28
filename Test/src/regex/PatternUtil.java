package regex;

import java.util.regex.Pattern;

public class PatternUtil {
	
	public static boolean matches(String regex, CharSequence input) {
		try {
			return Pattern.matches(regex, input);
		} catch (Exception e) {
			return false;
		}
	}

	public static void p(Object o){
		System.out.println(o);
	}
	public static void main(String args[]) {

		String regex = ".{0,20}";
		String input = null;
		if(matches(regex,input))
			p("sucess");
	}
}

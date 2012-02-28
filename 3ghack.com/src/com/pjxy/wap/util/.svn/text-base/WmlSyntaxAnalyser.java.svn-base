package com.pjxy.wap.util;

public class WmlSyntaxAnalyser {
	public static String plainTextFilter(String s) {
		int ln = s.length();
		for (int i = 0; i < ln; i++) {
			char c = s.charAt(i);
			if (c == '<' || c == '>' || c == '&' || c == '"' || c == '\''
					|| c == '$') {
				StringBuffer b = new StringBuffer(s.substring(0, i));
				switch (c) {
				case '<':
					b.append("&lt;");
					break;
				case '>':
					b.append("&gt;");
					break;
				case '&':
					b.append("&amp;");
					break;
				case '"':
					b.append("&quot;");
					break;
				case '\'':
					b.append("&apos;");
					break;
				case '$':
					b.append("$$");
					break;
				}
				i++;
				int next = i;
				while (i < ln) {
					c = s.charAt(i);
					if (c == '<' || c == '>' || c == '&' || c == '"'
							|| c == '\'' || c == '$') {
						b.append(s.substring(next, i));
						switch (c) {
						case '<':
							b.append("&lt;");
							break;
						case '>':
							b.append("&gt;");
							break;
						case '&':
							b.append("&amp;");
							break;
						case '"':
							b.append("&quot;");
							break;
						case '\'':
							b.append("&apos;");
							break;
						case '$':
							b.append("$$");
							break;
						}
						next = i + 1;
					}
					i++;
				}
				if (next < ln)
					b.append(s.substring(next));
				s = b.toString();
				break;
			} // if c ==
		} // for
		return s;
	}
}

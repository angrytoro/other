package com.pjxy.wap.ui;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.pjxy.wap.util.WmlSyntaxAnalyser;
import com.pjxy.wap.util.ubb.UbbParser;
import com.pjxy.wap.util.ubb.UbbTree;
import com.pjxy.wap.util.ubb.UbbType;

import freemarker.template.TemplateMethodModelEx;
import freemarker.template.TemplateModelException;

public class FtlUbbEscape implements TemplateMethodModelEx {
	@Override
	public Object exec(@SuppressWarnings("rawtypes") List args)
			throws TemplateModelException {
		String text = WmlSyntaxAnalyser.plainTextFilter(args.get(0).toString());
		text = ubbTextFilter(text);
		return text;
	}

	private String ubbTextFilter(String s) {
		if (s == null || s.isEmpty()) {
			return "";
		}
		try {
			InputStream is = new ByteArrayInputStream(s.getBytes());
			UbbParser parser = new UbbParser(is);
			UbbTree tree = parser.Exp();
			StringBuilder sb = new StringBuilder(s.length() + 100);
			analyseUbbTree(tree, sb);
			return sb.toString();
		} catch (Exception e) {
			return s;
		}
	}

	private void analyseUbbTree(UbbTree tree, StringBuilder sb) {
		if (tree.getType() == UbbType.B) {
			sb.append("<b>");
			for (UbbTree child : tree.getChildren()) {
				analyseUbbTree(child, sb);
			}
			sb.append("</b>");
		} else if (tree.getType() == UbbType.BR) {
			sb.append("<br />");
		} else if (tree.getType() == UbbType.CALL) {
			boolean flag = true;
			String s = (String) tree.getChildren().get(0).getArgs()[0];
			for (char c : s.toCharArray()) {
				if (!Character.isDigit(c)) {
					flag = false;
					break;
				}
			}
			if (flag)
				sb.append("<a href=\"wtai://wp/mc;" + s + "\">" + s + "</a>");
			else
				sb.append("(call)" + s + "(/call)");
		} else if (tree.getType() == UbbType.DATE) {
			sb.append(SimpleDateFormat.getDateInstance(DateFormat.MEDIUM)
					.format(new Date()));
		} else if (tree.getType() == UbbType.I) {
			sb.append("<i>");
			for (UbbTree child : tree.getChildren()) {
				analyseUbbTree(child, sb);
			}
			sb.append("<i>");
		} else if (tree.getType() == UbbType.IMG) {
			String s = (String) tree.getChildren().get(0).getArgs()[0];
			if (!s.startsWith("http://")) {
				s = "http://" + s;
			}
			try {
				URL url = new URL(s);
				sb.append("<img src=\"" + url.toString() + "\"/>");
			} catch (MalformedURLException e) {
				sb.append("(img/)" + s + "(/img)");
			}
		} else if (tree.getType() == UbbType.IP) {
			sb.append(ServletActionContext.getRequest().getRemoteAddr());
		} else if (tree.getType() == UbbType.ON) {
			if (ActionContext.getContext().getSession().get("user") == null) {
				sb.append("[此处需要登录查看]");
			} else {
				String s = (String) tree.getChildren().get(0).getArgs()[0];
				sb.append(s);
			}
		} else if (tree.getType() == UbbType.ROOT) {
			for (UbbTree child : tree.getChildren()) {
				analyseUbbTree(child, sb);
			}
		} else if (tree.getType() == UbbType.TEXT) {
			String s = (String) tree.getArgs()[0];
			sb.append(s);
		} else if (tree.getType() == UbbType.TIME) {
			sb.append(SimpleDateFormat.getTimeInstance(DateFormat.MEDIUM)
					.format(new Date()));
		} else if (tree.getType() == UbbType.U) {
			sb.append("<u>");
			for (UbbTree child : tree.getChildren()) {
				analyseUbbTree(child, sb);
			}
			sb.append("</u>");
		} else if (tree.getType() == UbbType.URL) {
			String preUrl = (String) tree.getArgs()[0];
			if (!preUrl.startsWith("http://")) {
				preUrl = "http://" + preUrl;
			}
			try {
				URL url = new URL(preUrl);
				sb.append("<a href=\"" + url.toString() + "\">");
				for (UbbTree child : tree.getChildren()) {
					analyseUbbTree(child, sb);
				}
				sb.append("</a>");
			} catch (MalformedURLException e) {
				sb.append("(url=" + preUrl + ")");
				for (UbbTree child : tree.getChildren()) {
					analyseUbbTree(child, sb);
				}
				sb.append("(/url)");
			}
		} else if (tree.getType() == UbbType.WEEK) {
			Calendar c = Calendar.getInstance();
			int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
			switch (dayOfWeek) {
			case 1:
				sb.append("星期日");
				break;
			case 2:
				sb.append("星期一");
				break;
			case 3:
				sb.append("星期二");
				break;
			case 4:
				sb.append("星期三");
				break;
			case 5:
				sb.append("星期四");
				break;
			case 6:
				sb.append("星期五");
				break;
			case 7:
				sb.append("星期六");
				break;
			}
		}
	}
}

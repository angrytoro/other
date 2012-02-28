package io.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;

public class SMSService {

	private static void closeIO(BufferedWriter writer, BufferedReader reader) {
		if (writer != null) {
			try {
				writer.close();
				writer = null;
			} catch (Exception e) {

			}
		}
		if (reader != null) {
			try {
				reader.close();
				reader = null;
			} catch (Exception e) {

			}
		}
	}

	private static String getTimestamp(String pattern) {
		Date now = new Date(System.currentTimeMillis());
		SimpleDateFormat sdf = null;
		if (pattern == null)
			sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		else
			sdf = new SimpleDateFormat(pattern);
		return sdf.format(now);
	}

	public static String sendContent(String mobile, String args[]) {

		Map<String, Object> input = new HashMap<String, Object>();
		Map<String, String> smsArg = new HashMap<String, String>();

		String urlPath = "http://125.64.11.43:8080/udt-see/StartServiceServlet";

		String apid = "00001801";
		String timestamp = getTimestamp(null);
		String key = null;
		String isReport = "1"; // 0-上报，1-不报
		String statusReportUrl = "http://";// 短信上报地址（url）
		String productID = "100000000000000000022";
		try {
			key = DESCoder.desEncrypt(timestamp + apid);
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		smsArg.put("APID", apid);
		smsArg.put("Key", key);
		smsArg.put("Msg", args[0]);
		smsArg.put("TimeStamp", timestamp);
		smsArg.put("IsReport", isReport);// 需要给我们回复是否发送成功
		smsArg.put("StatusReportUrl", statusReportUrl);// 接收是否发送成功消息的地址
		smsArg.put("ProductID", productID);
		smsArg.put("Num", mobile);

		input.put("serviceId", "00001020101130");
		input.put("params", smsArg);

		JSONObject object = new JSONObject(input);

		System.out.println(object.toString());
		StringBuffer sbf = new StringBuffer();
		BufferedWriter writer = null;
		BufferedReader reader = null;
		HttpURLConnection huc = null;
		try {
			URL url = new URL(urlPath);
			huc = (HttpURLConnection) url.openConnection();
			huc.setDoOutput(true);
			writer = new BufferedWriter(new OutputStreamWriter(
					huc.getOutputStream()));
			writer.write(object.toString());
			writer.flush();
			writer.close();
			reader = new BufferedReader(new InputStreamReader(
					huc.getInputStream()));
			String line;
			while ((line = reader.readLine()) != null)
				sbf.append(line);
			reader.close();
			huc.disconnect();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeIO(writer, reader);
		}
		return sbf.toString();
	}

	public static void p(Object o) {
		System.out.println(o.toString());
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		p(sendContent("15072462469", new String[] { "蛋疼sdhf;asdjf;" }));
	}

}

package server;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.util.StringTokenizer;

public class HttpRequestHandler implements Runnable {

	final static String CRLF = "/r/n";
	Socket socket;
	InputStream input;
	OutputStream output;
	BufferedReader br;

	public HttpRequestHandler(Socket socket) throws Exception {
		this.socket = socket;
		this.input = socket.getInputStream();
		this.output = socket.getOutputStream();
		this.br = new BufferedReader(new InputStreamReader(
				socket.getInputStream()));
	}

	private void processRequest() throws Exception {
		while (true) {
			// ��ȡ����ʾWeb ������ύ��������Ϣ
			String headerLine = br.readLine();
			if (headerLine.equals(CRLF) || headerLine.equals(""))
				break;
			StringTokenizer s = new StringTokenizer(headerLine);
			String temp = s.nextToken();
			if (temp.equals("GET")) {
				String fileName = s.nextToken();
				fileName = "." + fileName;
				// ����������ļ�
				FileInputStream fis = null;
				boolean fileExists = true;
				try {
					fis = new FileInputStream(fileName);
				} catch (FileNotFoundException e) {
					fileExists = false;
				}
				// ��ɻ�Ӧ��Ϣ
				String serverLine = "Server: a simple java httpServer";
				String statusLine = null;
				String contentTypeLine = null;
				String entityBody = null;
				String contentLengthLine = "error";
				if (fileExists) {
					statusLine = "HTTP/1.0 200 ok" + CRLF;
					contentTypeLine = "Content-type: " + contentType(fileName)
							+ CRLF;
					contentLengthLine = "Content-Length: "
							+ (new Integer(fis.available())).toString() + CRLF;
				} else {
					statusLine = "HTTP/1.0 404 Not Found" + CRLF;
					contentTypeLine = "text/html";
					entityBody = "<HTML>"
							+ "<HEAD><TITLE>404 Not Found</TITLE></HEAD>"
							+ "<BODY>404 Not Found"
							+ "<br>usage:http://youHostName:port/"
							+ "fileName.html</BODY></HTML>";
				}
				// ���͵���������Ϣ
				output.write(statusLine.getBytes());
				output.write(serverLine.getBytes());
				output.write(contentTypeLine.getBytes());
				output.write(contentLengthLine.getBytes());
				output.write(CRLF.getBytes());
				// ������Ϣ����
				if (fileExists) {
					sendBytes(fis, output);
					fis.close();
				} else {
					output.write((entityBody.getBytes()));
				}
			}
		}
		try {
			output.close();
			br.close();
			socket.close();
		} catch (Exception e) {

		}
	}

	private static String contentType(String fileName) {
		if (fileName.endsWith(".htm") || fileName.endsWith(".html")) {
			return "text/html";
		}
		return fileName;
	}

	private static void sendBytes(FileInputStream fis, OutputStream os)
			throws Exception {
		// ����һ�� 1K buffer
		byte[] buffer = new byte[1024];
		int bytes = 0;
		// ���ļ�������׽����������
		while ((bytes = fis.read(buffer)) != -1) {
			os.write(buffer, 0, bytes);
		}
	}

	public void run() {
		// TODO Auto-generated method stub

	}

}

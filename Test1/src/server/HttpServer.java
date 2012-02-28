package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpServer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int port = 5678;
		ServerSocket serverSocket;

		try {
			serverSocket = new ServerSocket(port);
			System.out.println("httpServer running on port:"
					+ serverSocket.getLocalPort());
			// 显示启动信息
			while (true) {
				Socket socket = serverSocket.accept();
				System.out.println("New connection accepted "
						+ socket.getInetAddress() + ":" + socket.getPort());
				//创建分线程
				try {
					HttpRequestHandler request = new HttpRequestHandler(socket);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

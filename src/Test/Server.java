package Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

//基于TCP协议的socket通信,实现客户登录
public class Server {
	public static void main(String[] args) {
		try {
			ServerSocket ss = new ServerSocket(8888);
			System.out.println("server ready to launch,"
					+ "waiting for client connection");
			Socket s = null;
			int count = 0;
			while(true){
				s = ss.accept();
				ServerThread st = new ServerThread(s);
				st.start();
				count++;
				System.out.println(count);
				InetAddress ia = s.getInetAddress();
				System.out.println(ia.getHostAddress());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

package imooc;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

//基于UDP用户登录
public class UDPServer {
	public static void main(String[] args) throws IOException {
		DatagramSocket socket = new DatagramSocket(8899);
		byte[] data = new byte[1024];
		DatagramPacket packet = new DatagramPacket(data,data.length);
		socket.receive(packet);
		String info = new String(data,0,packet.getLength());
		System.out.println("Here is server, the client says: "+
		info);
		InetAddress ia = packet.getAddress();
		int port = packet.getPort();
		byte[] data2 = "welcome".getBytes();
		DatagramPacket packet2 = new DatagramPacket(data2,data2.length,ia,port);
		socket.send(packet2);
		socket.close();
	}
}

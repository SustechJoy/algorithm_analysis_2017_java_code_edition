package imooc;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Random;

public class UDPClient {
	public static void main(String[] args) {
		Random ran = new Random();
		for(int i=0;i<106;i++){
			int k = ran.nextInt(256);
			System.out.println(k+" ");
		}
		System.out.println(-1);
	}

}

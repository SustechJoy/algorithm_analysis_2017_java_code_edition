package Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	public static void main(String[] args) {
		try {
			Socket s = new Socket("localhost",8888);
			OutputStream os = s.getOutputStream();
			PrintWriter pw = new PrintWriter(os);
			pw.write("admin:admin,password:123");
			pw.flush();
			s.shutdownOutput();
			InputStream is = s.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			String data = br.readLine();
			while(data!=null)
			{
				System.out.println("client: "+data);
				data = br.readLine();
			}
			pw.close();
			os.close();
			s.close();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

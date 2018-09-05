package Test;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerThread extends Thread {
	Socket s = null;
	public ServerThread(Socket socket) {
		this.s = socket;
	}
	@Override
	public void run(){
		InputStream is = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		OutputStream os = null;
		PrintWriter pw = null;
		try{
		is = s.getInputStream();
		isr = new InputStreamReader(is);
		br = new BufferedReader(isr);
		String data = br.readLine();
		while(data!=null)
		{
			System.out.println("server: "+data);
			data = br.readLine();
		}
		s.shutdownInput();
		os = s.getOutputStream();
		pw = new PrintWriter(os);
		pw.write("welcome");
		pw.flush();
		}
		catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
			if(pw!=null){
				pw.close();
			}
			if(os!=null){
				os.close();
			}
			if(br!=null){
				br.close();
			}
			if(is!=null){
				is.close();
			}
			if(isr!=null){
				isr.close();
			}if(s!=null){
			s.close();
			}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
	}
}

package Test;
import java.net.*;
public class Test01 {
	public static void main(String[] args) throws MalformedURLException {
		URL URL= new URL("http://www.imooc.com");
		//��Ϊ����,#Ϊê��
		URL url = new URL(URL,"/index.html?username=tom#test");
		System.out.println("protocol: "+url.getProtocol());
		System.out.println("host: "+url.getHost());
		//δָ���˿ں�,��ʹ��Ĭ�϶˿ں�,����ֵ-1
		System.out.println("port: "+url.getPort());
		System.out.println("file path: "+url.getPath());
		System.out.println("file name:"+url.getFile());
		System.out.println("relative path: "+url.getRef());
		System.out.println("query string: "+url.getQuery());
	}
}

package Test;
import java.net.*;
public class Test01 {
	public static void main(String[] args) throws MalformedURLException {
		URL URL= new URL("http://www.imooc.com");
		//？为参数,#为锚点
		URL url = new URL(URL,"/index.html?username=tom#test");
		System.out.println("protocol: "+url.getProtocol());
		System.out.println("host: "+url.getHost());
		//未指定端口号,则使用默认端口号,返回值-1
		System.out.println("port: "+url.getPort());
		System.out.println("file path: "+url.getPath());
		System.out.println("file name:"+url.getFile());
		System.out.println("relative path: "+url.getRef());
		System.out.println("query string: "+url.getQuery());
	}
}

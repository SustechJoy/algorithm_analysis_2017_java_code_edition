package test7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOriginal{
	static HashSet<String> ref;
	static StringBuilder res;
	static class InputReader {
	    public BufferedReader reader;
	    public StringTokenizer tokenizer;

	    public InputReader(InputStream stream) {
	        reader = new BufferedReader(new InputStreamReader(stream), 32768);
	        tokenizer = null;
	    }
	    public String next() {
	        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
	            try {
	                tokenizer = new StringTokenizer(reader.readLine());
	            } catch (IOException e) {
	                throw new RuntimeException(e);
	            }
	        }
	        return tokenizer.nextToken();
	    }
	    public int nextInt() {
	        return Integer.parseInt(next());
	    }
	    public long nextLong() {
	        return Long.parseLong(next());
	    }
	}
	static InputReader input;
	public static void main(String[] args) {
		init();
		solve();
	}
	public static void init() {
		input = new InputReader(System.in);
		res = new StringBuilder("");
		while(true){
			int num = input.nextInt();
			if(num==-1){
				break;
			}
			StringBuilder temp = new StringBuilder("");
			for(int i=0;i<8;i++){
				temp.append(num&1);
				num>>=1;
			}
			res.append(temp.reverse());
		}
	}
	public static void solve() {
		int cnt = 0;
		ref = new HashSet<String>();
		int pos = 0;
		while(true){
			if(cnt==256){
				break;
			}
			int cur = Integer.valueOf(res.substring(pos,pos+8),2);
			pos+=8;
			if(cur != 0){
				ref.add(res.substring(pos, pos+cur));
				pos+=cur;
			}
			cnt++;
		}
		int size = Integer.valueOf(res.substring(pos, pos+32),2);
		pos+=32;
		StringBuilder tar = new StringBuilder("");
		int ans = 0;
		for(int i=0;i<size;i++){
			tar = tar.append(res.charAt(pos+i));
			if(ref.contains(tar.toString())){
				ans++;
				tar = new StringBuilder("");
			}
		}
		System.out.println(ans);
	}
}
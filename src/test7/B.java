package test7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class B {
	static HashSet<String> ref;
	static int[] res;
	static int len;
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
		res = new int[10000000];
		len = 0;
		while(true){
			int num = input.nextInt();
			if(num==-1){
				break;
			}
			for(int i=0;i<8;i++){
				res[len*8-i+7] = num&1;
				num>>=1;
			}
			len++;
		}
	}
	public static void solve() {
		int pos = 0;
		int cnt = 0;
		ref = new HashSet<String>();
		while(true){
			if(cnt==256){
				break;
			}
			int cur = res[pos]*128+res[pos+1]*64+res[pos+2]*32+res[pos+3]*16+res[pos+4]*8
					+res[pos+5]*4+res[pos+6]*2+res[pos+7]*1;
			pos+=8;
			if(cur != 0){
				StringBuilder sb = new StringBuilder("");
				for(int i=0;i<cur;i++){
					sb.append(res[pos+i]);
				}
				ref.add(sb.toString());
			}
			pos+=cur;
			cnt++;
		}
		int size = 0;
		for(int i=0;i<32;i++){
			size+=res[pos+i]*Math.pow(2, 31-i);
		}
		pos+=32;
		StringBuilder tar = new StringBuilder("");
		int ans = 0;
		for(int i=0;i<size;i++){
			tar = tar.append(res[pos+i]);
			if(ref.contains(tar.toString())){
				ans++;
				tar = new StringBuilder("");
			}
		}
		System.out.println(ans);
	}
}

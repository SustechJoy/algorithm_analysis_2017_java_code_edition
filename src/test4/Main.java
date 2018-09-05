package test4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int m;
	static int k;
	static int t[];
	static int drop[];
	static int latest[];
	static int affectNum[];
	static int arri[];
	static int totStart = 0;
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
		n = input.nextInt();
		m = input.nextInt();
		k = input.nextInt();
		t = new int[n+1];
		drop = new int[n+2];
		latest = new int[n+1];
		for(int i=1;i<=n;i++){
			latest[i] = -1;
		}
		for(int i=1;i<n;i++){
			t[i] = input.nextInt();
		}
		for(int i=1;i<=m;i++){
			int d = input.nextInt();
			int A = input.nextInt();
			totStart += d;
			if(latest[A]==-1){
				latest[A] = d;
			}else{
				latest[A] = Math.max(latest[A], d);
			}
			int B = input.nextInt();
			drop[B]++;
		}
		arri = new int[n+1];
		arri[1] = 0;
		affectNum = new int[n+1];
		for(int i=1;i<=n;i++){
			if(latest[i-1]==-1){
				arri[i] = t[i-1]+arri[i-1];
			}else{
				arri[i] = t[i-1]+Math.max(latest[i-1], arri[i-1]);
			}
			affectNum[i] = drop[i+1];
		}
	}
	public static void solve() {
		
		int maxAffectNum = 0;
		int maxId = 0;
		for(int i=n-2;i>=1;i--){
			if(latest[i+1]==-1||arri[i+1]>latest[i+1]){
				affectNum[i] += affectNum[i+1];
			}
		}
		while(k>0){
			maxId = 0;
			maxAffectNum = 0;
			for(int i=1;i<n;i++){
				if(maxAffectNum<affectNum[i]&&t[i]>0){
					maxAffectNum = affectNum[i];
					maxId = i;
				}
			}
			if(maxId==0){
				break;
			}
			k--;
			t[maxId]--;
			arri[1] = 0;
			for(int i=maxId;i<=n;i++){
				if(latest[i-1]==-1){
					arri[i] = t[i-1]+arri[i-1];
				}else{
					arri[i] = t[i-1]+Math.max(latest[i-1], arri[i-1]);
				}
				affectNum[i] = drop[i+1];
			}
			for(int i=n-2;i>=maxId;i--){
				if(latest[i+1]==-1||arri[i+1]>latest[i+1]){
					affectNum[i] += affectNum[i+1];
				}
			}
			
		}
		int totArrive = 0;
		for(int i=2;i<=n;i++){
			totArrive += arri[i]*drop[i];
		}
		System.out.println(totArrive - totStart);
	}
}

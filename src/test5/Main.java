package test5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
class Period implements Comparable<Period>{
	int a;
	int b;
	@Override
	public int compareTo(Period p) {
		return this.b==p.b?this.a-p.a:this.b-p.b;
	}
	
}
public class Main {
	static Period[] stu;
	static int n;
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
		stu = new Period[n];
		for(int i=0;i<n;i++){
			stu[i] = new Period();
			stu[i].a = input.nextInt();
			stu[i].b = input.nextInt();
		}
	}
	
	public static void solve() {
		Arrays.sort(stu);
		int firstMax = stu[0].b;
		int secondMax = stu[0].b-1;
		int time = 2;
		for(int i=1;i<n;i++){
			if(stu[i].a>firstMax){                   //stu[i].a>firstMax
				firstMax = stu[i].b;
				secondMax = stu[i].b-1;
				time+=2;
			}else if(stu[i].a>secondMax){           //stu[i].a<=firstMax
				secondMax = firstMax;
				firstMax = stu[i].b;
				time+=1;
			}
		}
		System.out.println(time);
	}
}


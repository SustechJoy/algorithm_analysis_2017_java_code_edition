package test5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Time implements Comparable<Time>{
	int x;
	int y;
	@Override
	public int compareTo(Time p) {
		return this.y==p.y?this.x-p.x:this.y-p.y;
	}
	
}
public class Test {
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
	public static void main(String[] args) {
		InputReader input = new InputReader(System.in);
		int n = input.nextInt();
		Time[] stu = new Time[n];
		for(int i=0;i<n;i++){
			stu[i] = new Time();
			stu[i].x = input.nextInt();
			stu[i].y = input.nextInt();
		}
		Arrays.sort(stu);
		int firstMax = stu[0].y;
		int secondMax = stu[0].y-1;
		int tot = 2;
		for(int i=1;i<n;i++){
			if(firstMax<stu[i].x){
				firstMax = stu[i].y;
				secondMax = stu[i].y-1;
				tot+=2;
			}else if(secondMax<stu[i].x){
				secondMax = firstMax;
				firstMax = stu[i].y;
				tot+=1;
			}
		}
		System.out.println(tot);
	}
}

package test1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Test {
	static Map<String,Integer> man;
	static Map<String,Integer> woman;
	static Map<Integer,String> invMan;
	static Map<Integer,String> invWoman;
	static int[][] manPref;
	static String[][] manPrefPre; 
	static int[][] womanPrefInv;
	static int[] count;
	static int n;
	static int[] paired;
	static int[] output;
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
	static StringBuilder sb;
	public static void main(String[] args) {
	    input = new InputReader(System.in);
		n = input.nextInt();
		init(n);
		GS(n);
		printRes(n);
	}
	public static void init(int n){
		man = new HashMap<>();
		woman = new HashMap<>();
		invMan = new HashMap<>();
		invWoman = new HashMap<>();
		manPrefPre = new String[n+1][n+1];
		womanPrefInv = new int[n+1][n+1];
		manPref = new int[n+1][n+1];
		for(int i=1;i<=n;i++){
			String manName = input.next();
			man.put(manName, i);
			invMan.put(i, manName);
			for(int j=1;j<=n;j++){
				manPrefPre[i][j] = input.next();
			}
		}
		for(int i=1;i<=n;i++){
			String woName = input.next();
			woman.put(woName, i);
			invWoman.put(i, woName);
			for(int j=1;j<=n;j++){
				womanPrefInv[i][man.get(input.next())] = j;
			}
		}
		for(int i=1;i<=n;i++){
			for(int j=1;j<=n;j++){
				manPref[i][j] = woman.get(manPrefPre[i][j]);
			}
		}
		count = new int[n+1];
		for(int i=0;i<=n;i++){
			count[i] = 1;
		}
		paired = new int[n+1];
		for(int i=0;i<=n;i++){
			paired[i] = 0;
		}
	}
	public static void GS(int n){
		Queue<Integer> queue = new ArrayDeque<>();
		for(int i=1;i<=n;i++){
			queue.add(i);
		}
		while(!queue.isEmpty()){
			int manNo = queue.peek();
			int nowWoman = manPref[manNo][count[manNo]];
			if(paired[nowWoman]==0){
				paired[nowWoman] = manNo;
				queue.poll();
			}else if(womanPrefInv[nowWoman][paired[nowWoman]]>womanPrefInv[nowWoman][manNo]){
				queue.add(paired[nowWoman]);
				paired[nowWoman] = manNo;
				queue.poll();
			}
			count[manNo]++;
		}
	}
	private static void printRes(int n) {
		output = new int[n+1];
		sb = new StringBuilder();
		for(int i=1;i<=n;i++){
			output[paired[i]] = i;
		}
		for(int i=1;i<=n;i++){
			sb.append(invMan.get(i));
			sb.append(" "+invWoman.get(output[i])+"\n");
		}
		System.out.println(sb);
	}
}

package test2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Grid implements Comparable<Grid>{
	int F;
	int H;
	int G;
	int i;
	int j;
	int open = -1;
	int close = -1;
	boolean walk;
	@Override
	public int compareTo(Grid grid) {
		return this.F  - grid.F;
	}
}

public class Main {
	static PriorityQueue<Grid> open;
	static int n;
	static int m;
	static int[] pointX;
	static int[] pointY;
	static int count;
	static int pointNum;
	static Grid[][] boxes;
	static int totalStep;
	static final int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
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
		read();
		init(boxes);
		search(boxes);
	}
	public static void read(){
		input = new InputReader(System.in);
		n = input.nextInt();
		m = input.nextInt();
		boxes = new Grid[n][m];
		for(int i=0;i<n;i++){
			String line = input.next();
			for(int j=0;j<m;j++){
				boxes[i][j] = new Grid();
				boxes[i][j].i = i;
				boxes[i][j].j = j;
				if(line.charAt(j)=='r'){
					boxes[i][j].walk = true;
				}else{
					boxes[i][j].walk = false;
				}
			}
		}
		pointNum = input.nextInt();
		pointX = new int[pointNum];
		pointY = new int[pointNum];
		for(int i=0;i<pointNum;i++){
			pointX[i] = input.nextInt();
			pointY[i] = input.nextInt();
		}
	}
	public static void init(Grid[][] boxes){
		count = 0;
		totalStep = 0;
	}
	private static void clear() {
		while(!open.isEmpty()){
			open.poll();
		}
	}
	public static boolean check(int a,int b){
		return a>=0&&a<=n-1&&b>=0&&b<=m-1;
	}
	public static void search(Grid[][] boxes){
		open = new PriorityQueue<Grid>();
		Grid fir = boxes[0][0];
		fir.G = 0;
		fir.H = Math.abs(fir.i - pointX[count])+Math.abs(fir.j - pointY[count]);
		fir.F = fir.G+fir.H;
		fir.open = count;
		open.add(fir);
		while(!open.isEmpty()){
			Grid now = open.poll();
			if(now.i==pointX[count]&&now.j==pointY[count]){
				count++;
				totalStep += now.G;
				clear();
				if(count==pointNum){
					System.out.println(totalStep);
					return;
				}
				now.G = 0;
				now.H = Math.abs(now.i - pointX[count])+
						Math.abs(now.j - pointY[count]);
				now.F = now.G+now.H;
				now.open = count;
				open.add(now);
				continue;
			}
			now.close = count;
			for(int var=0;var<4;var++){
				if(check(now.i+dir[var][0],now.j+dir[var][1])
						&&boxes[now.i+dir[var][0]][now.j+dir[var][1]].close!=count
						&&boxes[now.i+dir[var][0]][now.j+dir[var][1]].walk==true){
					Grid temp = boxes[now.i+dir[var][0]][now.j+dir[var][1]];
					if(temp.open!=count){
						temp.H = Math.abs(temp.i - pointX[count])+
								Math.abs(temp.j - pointY[count]);
						temp.G = now.G+1;
						temp.F = temp.G+temp.H;
						temp.open = count;
						open.add(temp);
					}else{
						if(temp.G>now.G+1){
							open.remove(temp);
							temp.G = now.G+1;
							temp.F = temp.G+temp.H;
							open.add(temp);
						}
					}
				}
			}
		}
		System.out.println(-1);
	}
}
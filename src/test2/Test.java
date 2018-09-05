//package test2;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.util.PriorityQueue;
//import java.util.StringTokenizer;
//
//class Grid implements Comparable<Grid>{
//	int F;
//	int H;
//	int G;
//	int i;
//	int j;
//	int open = -1;
//	int close = -1;
//	boolean walk;
//	@Override
//	public int compareTo(Grid grid) {
//		return this.F  - grid.F;
//	}
//}
//
//public class Test {
//	static class InputReader {
//	    public BufferedReader reader;
//	    public StringTokenizer tokenizer;
//
//	    public InputReader(InputStream stream) {
//	        reader = new BufferedReader(new InputStreamReader(stream), 32768);
//	        tokenizer = null;
//	    }
//	    public String next() {
//	        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
//	            try {
//	                tokenizer = new StringTokenizer(reader.readLine());
//	            } catch (IOException e) {
//	                throw new RuntimeException(e);
//	            }
//	        }
//	        return tokenizer.nextToken();
//	    }
//	    public int nextInt() {
//	        return Integer.parseInt(next());
//	    }
//	    public long nextLong() {
//	        return Long.parseLong(next());
//	    }
//	}
//	public static void main(String[] args) {
//		int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
//		InputReader input = new InputReader(System.in);
//		int n = input.nextInt();
//		int m = input.nextInt();
//		Grid[][] map = new Grid[n][m];
//		for(int i=0;i<n;i++){
//			String line = input.next();
//			for(int j=0;j<m;j++){
//				map[i][j] = new Grid();
//				map[i][j].i = i;
//				map[i][j].j = j;
//				if(line.charAt(j)=='r'){
//					map[i][j].walk = true;
//				}else{
//					map[i][j].walk = false;
//				}
//			}
//		}
//		int num = input.nextInt();
//		int[] Xpos = new int[num];
//		int[] Ypos = new int[num];
//		for(int i=0;i<num;i++){
//			Xpos[i] = input.nextInt();
//			Ypos[i] = input.nextInt();
//		}
//		int count = 0;
//		int totalStep = 0;
//		PriorityQueue<Grid> openList = new PriorityQueue<Grid>();
//		Grid origin = map[0][0];
//		origin.G = 0;
//		origin.H = Math.abs(origin.i - Xpos[count])+Math.abs(origin.j - Ypos[count]);
//		origin.F = origin.G+origin.H;
//		origin.open = count;
//		openList.add(origin);
//		while(!openList.isEmpty()){
//			Grid now = openList.poll();
//			if(now.i==Xpos[count]&&now.j==Ypos[count]){
//				count++;
//				totalStep += now.G;
//				while(!openList.isEmpty()){
//					openList.poll();
//				}
//				if(count==num){
//					System.out.println(totalStep);
//					return;
//				}
//				now.G = 0;
//				now.H = Math.abs(now.i - Xpos[count])+
//						Math.abs(now.j - Ypos[count]);
//				now.F = now.G+now.H;
//				now.open = count;
//				openList.add(now);
//				continue;
//			}
//			now.close = count;
//			for(int p=0;p<4;p++){
//				if(now.i+dir[p][0]>=0&&now.i+dir[p][0]<=n-1&&now.j+dir[p][1]>=0&&now.j+dir[p][1]<=m-1
//						&&map[now.i+dir[p][0]][now.j+dir[p][1]].close!=count
//						&&map[now.i+dir[p][0]][now.j+dir[p][1]].walk==true){
//					int x = now.i+dir[p][0];
//					int y = now.j+dir[p][1];
//					Grid temp = map[x][y];
//					if(temp.open!=count){
//						temp.H = Math.abs(temp.i - Xpos[count])+
//								Math.abs(temp.j - Ypos[count]);
//						temp.G = now.G+1;
//						temp.open = count;
//						temp.F = temp.G+temp.H;
//						openList.add(temp);
//					}else{
//						if(temp.G>now.G+1){
//							openList.remove(temp);
//							temp.G = now.G+1;
//							temp.open = count;
//							temp.F = temp.G+temp.H;
//							openList.add(temp);
//						}
//					}
//				}
//			}
//		}
//		System.out.println(-1);
//	}
//}

//package test6;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.util.PriorityQueue;
//import java.util.StringTokenizer;
//
//class edge implements Comparable<edge>{
//	int x;
//	int y;
//	int cost;
//	@Override
//	public int compareTo(edge e) {
//		return this.cost - e.cost;
//	}
//}
//public class Main {
//	static edge[] edges;
//	static int n;
//	static int m;
//	static int[] v;
//	static int[] par;
//	static int[] deg;
//	static int[] dis;
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
//	static InputReader input;
//	public static void main(String[] args) {
//		init();
//		solve();
//	}
//	public static void init() {
//		input = new InputReader(System.in);
//		n = input.nextInt();
//		m = input.nextInt();
//		edges = new edge[m];
//		dis = new int[m];
//		v = new int[n+1];
//		par = new int[n+1];
//		deg = new int[n+1];
//		for(int i=1;i<=n;i++){
//			v[i] = input.nextInt();
//			par[i] = i;
//			deg[i] = 0;
//		}
//		for(int i=0;i<m;i++){
//			int a = input.nextInt();
//			int b = input.nextInt();
//			int d = input.nextInt();
//			edges[i] = new edge();
//			edges[i].x = a;
//			edges[i].y = b;
//			dis[i] = d;
//			deg[a]++;
//			deg[b]++;
//		}
//		for(int i=0;i<m;i++){
//			int a = edges[i].x;
//			int b = edges[i].y;
//			int cost = (Math.abs(v[a]-v[b])+1)*dis[i]*(Math.abs(deg[a]-deg[b])+1);
//			edges[i].cost = cost;
//		}
//	}
//	public static int find(int x){
//		if(par[x] != x){
//			par[x] = find(par[x]);
//		}
//		return par[x];
//	}
//	public static void union(int a,int b){
//		par[find(a)] = find(b);
//	}
//	public static void solve() {
//		PriorityQueue<edge> queue = new PriorityQueue<edge>();
//		for(int i=0;i<m;i++){
//			queue.add(edges[i]);
//		}
//		int cnt = 0;
//		int tot = 0;
//		//boolean flag = false;       //cannot be built
//		while(!queue.isEmpty()){
//			edge using = queue.poll();
//			if(find(using.x)!=find(using.y)){
//				union(using.x,using.y);
//				cnt++;
//				tot+=using.cost;
//			}
//			if(cnt==n-1){
//				//flag = true;
//				break;
//			}
//		}
//		System.out.println(tot);
//	}
//}

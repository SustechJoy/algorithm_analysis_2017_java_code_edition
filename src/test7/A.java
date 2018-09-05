//package test7;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.util.LinkedList;
//import java.util.PriorityQueue;
//import java.util.Queue;
//import java.util.StringTokenizer;
//
//class node implements Comparable<node>{
//	int ind;
//	int val;
//	node left = null;
//	node right = null;
//	String code = "";
//	@Override
//	public int compareTo(node n) {
//		return val - n.val;
//	}
//}
//public class A {
//	static int num[];
//	static int size;
//	static PriorityQueue<node> pqueue;
//	static Queue<node> queue;
//	static String[] codes;
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
//		node x = construct();
//		solve(x);
//	}
//	public static void init() {
//		input = new InputReader(System.in);
//		num = new int[256]; 
//		while(true){
//			int cur = input.nextInt();
//			if(cur==-1){
//				break;
//			}else{
//				num[cur]++;
//			}
//		}
//		pqueue = new PriorityQueue<node>();
//		for(int i=0;i<num.length;i++){
//			if(num[i]!=0){
//				node cur = new node();
//				cur.ind = i;
//				cur.val = num[i];
//				pqueue.add(cur);
//			}
//		}
//	}
//	public static node construct() {
//		node root = null;
//		if(pqueue.size()==1){
//			node cur = pqueue.poll();
//			root = new node();
//			root.ind = -1;
//			root.left = cur;
//		}else{
//			while(pqueue.size()>1){
//				node n1 = pqueue.poll();
//				node n2 = pqueue.poll();
//				node n = new node();
//				n.val = n1.val + n2.val;
//				n.ind = -1;
//				n.left = n1;
//				n.right = n2;
//				pqueue.add(n);
//			}
//			root = pqueue.poll();
//		}
//		return root;
//	}
//	public static void solve(node root) {
//		queue = new LinkedList<node>();
//		codes = new String[256];
//		queue.add(root);
//		while(!queue.isEmpty()){
//			node cur = queue.poll();
//			node l = cur.left;
//			node r = cur.right;
//			if(l!=null){
//				l.code = cur.code+"0";
//				queue.add(l);
//				if(l.ind!=-1){
//					codes[l.ind] = l.code;
//				}
//			}
//			if(r!=null){
//				queue.add(r);
//				r.code = cur.code+"1";
//				if(r.ind!=-1){
//					codes[r.ind] = r.code;
//				}
//			}
//		}
//		long tot = 0;
//		for(int i=0;i<num.length;i++){
//			if(num[i]>0){
//				tot += codes[i].length()*num[i];
//			}
//		}
//		if(tot%8 == 0){
//			System.out.println(tot/8);
//		}
//		else{
//			System.out.println(tot/8+1);
//		}
//	}
//}

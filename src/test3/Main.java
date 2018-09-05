package test3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;
class Graph{
	int V;
	LinkedList<Integer>[] list;
	Graph(int V){
		list = new LinkedList[V+1];
		for(int i=0;i<V+1;i++){
			list[i] = new LinkedList<Integer>();
		}
	}
}
public class Main {
	static int n;
	static int m;
	static Graph graph;
	static int[] ind;
	static int[] queue;
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
		input = new InputReader(System.in);
		while(true){
			n = input.nextInt();
			m = input.nextInt();
			if(n==0&&m==0){
				break;
			}
			init();
			boolean flag = true;
			for(int i=1;i<=m;i++){
				String s = input.next();
				if(flag==false){
					continue;
				}
				int in = s.charAt(0)-'A'+1;
				int out = s.charAt(2)-'A'+1;
				graph.list[in].add(out);
				ind[out]++;
				int ans = topo();
				if(ans == 3){
					flag = false;
					System.out.printf("Preference sequence determined after %d relations: ",i);
					for(int j=0;j<queue.length;j++){
						System.out.print((char)(queue[j]+'A'-1));
					}
					System.out.println(".");
				}
				if(ans == 1){
					flag = false;
					System.out.printf("Inconsistency found after %d relations.\n",i);
				}
			}
			if(flag==true){
				System.out.println("Preference sequence cannot be determined.");
			}
		}
	}
	public static int topo() {
		int flag = 3;
		int[] indNow = ind.clone();
		//1.circle   2.not yet sorted  3.sorted 
		queue = new int[n];
		int qCnt = 0;
		int pos = 0;
		for(int i=1;i<indNow.length;i++){
			int count = 0;
			for(int j=1;j<indNow.length;j++){
				if(indNow[j]==0){
					count++;
					pos = j;
				}
			}
			if(count==0){
				flag = 1;
				return flag;
			}
			if(count>1){
				flag = 2; // wait if count==0 somewhere
			}
			queue[qCnt++] = pos;
			indNow[pos] = -1;
			for(int j=0;j<graph.list[pos].size();j++){
				int x = graph.list[pos].get(j);
				indNow[x]--;
			}
		}
		
		return flag;
	}
	public static void init() {
		ind = new int[n+1];
		graph = new Graph(n);
	}
}

package test6;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Test {
	static int n;
	static int m;
	static int deg[];
	static int v[];
	static int G[][];
	static int vis[];
	static int low[];
	static int clo[];
	public static void main(String[] args) {
		init();
		solve();
	}
	private static void init() {
		Scanner input = new Scanner(System.in);		
		n = input.nextInt();
		m = input.nextInt();
		v = new int[n+1];
		G = new int[n+1][n+1];
		low = new int[n+1];
		clo = new int[n+1];
		for(int i=1;i<=n;i++){
			v[i] = input.nextInt();
		}
		for(int i=0;i<m;i++){
			int x = input.nextInt();
			int y = input.nextInt();
			deg[x]++;
			deg[y]++;
			G[x][y] = input.nextInt();
			G[y][x] = G[x][y];
		}
		for(int i=1;i<=n;i++){
			for(int j=1;j<=n;j++){
				if(G[i][j]!=0){
					G[i][j] = (Math.abs(v[i]-v[j])+1)*G[i][j]*(Math.abs(deg[i]-deg[j])+1);
				}
			}
		}
	}
	private static void solve() {
		vis = new int[n+1];
		int cnt = 1;
		int tot = 0;
		vis[1] = 1;
		low[1] = Integer.MAX_VALUE;
		for(int i=1;i<=n;i++){
			if(G[1][i]<low[1]){
				low[1] = G[1][i];
				clo[1] = i;
			}
		}
	}
	
}


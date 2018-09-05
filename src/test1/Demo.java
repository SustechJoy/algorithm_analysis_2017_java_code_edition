package test1;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class Demo {
	static Map<String,Integer> man;
	static Map<String,Integer> woman;
	static Map<Integer,String> invMan;
	static Map<Integer,String> invWoman;
	static int[][] manPref;
	static int[][] womanPrefInv;
	static int[] count;
	static int n;
	static int[] paired;
	static int[] output;
	static Scanner input;
	static StringBuilder sb;
	public static void main(String[] args) {
	    input = new Scanner(System.in);
	    int T = input.nextInt();
	    for(int i=0;i<T-1;i++){
	    	n = input.nextInt();
			init(n);
			GS(n);
			printRes(n);
			System.out.println();
			System.out.println();
	    }
	    n = input.nextInt();
		init(n);
		GS(n);
		printRes(n);
	}
	public static void init(int n){
		man = new HashMap<String,Integer>();
		woman = new HashMap<String,Integer>();
		invMan = new HashMap<Integer,String>();
		invWoman = new HashMap<Integer,String>();
		for(int i=1;i<=n;i++){
			String manName = input.next();
			man.put(manName, i);
			invMan.put(i, manName);
		}
		for(int i=1;i<=n;i++){
			String woName = input.next();
			woman.put(woName, i);
			invWoman.put(i, woName);
		}
		manPref = new int[n+1][n+1];
		womanPrefInv = new int[n+1][n+1];
		input.nextLine();
		for(int i=1;i<=n;i++){
			String s = input.nextLine();
			for(int j=1;j<=n;j++){
				manPref[i][j] = woman.get(String.valueOf(s.charAt(j+1)));
			}
		}
		for(int i=1;i<=n;i++){
			String s = input.nextLine();
			for(int j=1;j<=n;j++){
				womanPrefInv[i][man.get(String.valueOf(s.charAt(j+1)))] = j;
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
		Queue<Integer> queue = new ArrayDeque<Integer>();
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
		for(int i=1;i<n;i++){
			sb.append(invMan.get(i));
			sb.append(" "+invWoman.get(output[i])+"\n");
		}
		sb.append(invMan.get(n));
		sb.append(" "+invWoman.get(output[n]));
		System.out.print(sb);
	}
}

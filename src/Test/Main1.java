package Test;

import java.util.Scanner;

public class Main1{
	static int num;
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			num = input.nextInt();
			StringBuilder sb = new StringBuilder();
			for(int i=0;i<num;i++){
				String s = input.next();
				int x = Integer.parseInt(s.substring(2,s.length()),16);
				StringBuilder n  = new StringBuilder(Integer.toString(x,2));
				while(n.length()!=8){
					n.insert(0,"0");
				}
				sb.append(n);
			}
			int cut = input.nextInt();
			int cnt = 0;
			for(int i=0;i<cut;i++){
				int cNum = input.nextInt();
				String s = sb.toString().substring(cnt,cnt+cNum);
				if(s.length()>0){
					System.out.println(Integer.parseInt(String.valueOf(s),2));
					cnt = cnt+cNum;	
				}
			}
		}
		
	}
}
package Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		Map<String,String> map = new HashMap<String,String>();
		Scanner input = new Scanner(System.in);
		for(int i=0;i<3;i++){
			String win = input.next();
			String loss = input.next();
			map.put(loss,win);
		}
		int t = input.nextInt();
		for(int i=0;i<t;i++){
			String x = input.next();
			if(map.containsKey(x)){
				System.out.println(map.get(x));
			}else{
				System.out.println("Fake");
			}
		}
	}
}
package Test;

import java.util.Scanner;

public class Demo {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		double score = input.nextDouble();
		if(score>=90&&score<100){
			System.out.println("4.0");
		}else{
			System.out.println("not 4.0");
		}
	}
}

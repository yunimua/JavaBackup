package quiz;

import java.util.Scanner;


public class A06_GuessAge {
	public static void main(String[] args) {
	/*	
	 	사용자로부터 태어난 해와 올해의 년도를 입력받으면
	 	그 사람의 한국 나이를 계산하여 몇 살인지 알려주는 프로그램을 만들어보세요.
		
	*/
	
		Scanner sc = new Scanner(System.in);
	
	System.out.print("1. 태어난 해를 입력하세요 >> ");
	int ageyear = sc.nextInt();
	
	System.out.print("2. 올해 년도를 입력하세요 >> ");
	int year = sc.nextInt();
	
	int age = year - ageyear + 1;
	System.out.println("당신의 한국 나이는 : " + age + "세 입니다.");

	/*
		(정답)
	Scanner sc = new Scanner(System.in);
	int birthYear, thisYear;
	
	System.out.print("태어난 해를 입력 > ");
	birthYear = sc.nextInt();
	
	System.out.print("올 해를 입력 > ");
	thisYear = sc.nextInt();
	
	System.out.println("당신의 나이는" + (thisYear - birthYear + 1) + "살 입니다.");
	
	*/
	}
}

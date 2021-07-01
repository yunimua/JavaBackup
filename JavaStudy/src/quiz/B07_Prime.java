package quiz;

import java.util.Scanner;

public class B07_Prime {
	
	/*
		사용자로부터 숫자(양수)를 입력 받으면
		1부터 입력한 숫자 사이에 존재하는 소수를 모두 출력해보세요.
		(음수를 입력하면 다시 제대로 입력하게 하기)
		
		※ 나누어 떨어지는 수가 1과 자기 자신밖에 없는 숫자 
		
			2,3,5,7,11,13....
	*/
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("수를 입력하세요 > ");
		int num = sc.nextInt();
		
		
		//for (; num < 2;) {
		for (; num < 0;) {
			System.out.println("잘못된 숫자입니다. 다시 입력해주시요");
			System.out.print("> ");
			
			num = sc.nextInt();
		}
		
		//2. for (int chkNum = 3; chkNum <= num; chkNum += 2) {
		
		//2. System.out.println(2);
		
		for (int chkNum = 2; chkNum <= num; ++chkNum) {
			
			int count = 0;
			//1. boolean prime = true;
			
			for (int divNum = 1; divNum <= chkNum; ++divNum ) {
			//1. for (int divNum = 2; divNum < chkNum; ++divNum) {  
			//2. for (int divNum = 3; divNum <= Math.sqrt(chkNum); divNum +=2) { 
			//	ㄴ Math.sqrt는 chkNum의 제곱근을 확인하는 방식, 
				
				if(chkNum % divNum == 0) {
					count++;  // ㄴ 1. 위 입력시 주석처리 (2도) 
					//1. prime = false; // 2번도 포함
				}
			}
			if (count == 2) {
				System.out.println(chkNum);
			}
		}

	/*	잘못적은 답
		
		if (su > 1) {
			for (int i = 2; i <= su; ++i) {
				int su2 = 0;
				
				for (int j = 1; j <= i; ++j) {
					if (i % j == 0) {
						su2++;
					}
				}
				if (su2 == 2) {
				System.out.println("1부터 소수만 : " + i);
				}
			}
		}else {
			
			System.out.println("잘못 입력하셨습니다.");
		}
	*/	
	}
}

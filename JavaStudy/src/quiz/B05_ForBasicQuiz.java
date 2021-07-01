package quiz;

import java.util.Scanner;

public class B05_ForBasicQuiz {
	
	/*
		사용자가 숫자를 입력했을 때
		
		1. 10부터 입력한 숫자까지의 총합을 구해보세요.
		
		2. 1000부터 입력한 숫자까지 순서대로 나오게 만들어보세요.
		
		3. 1부터 입력한 숫자 사이의 5의 배수만 출력해보세요.
		
	
	*/
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int user;
		
		System.out.print("숫자를 입력 > ");
		user = sc.nextInt();
		
		int total = 0;

		for (int i = 10; i <=user; ++i) {
			total += i;
		}
		System.out.println("10부터 입력한 숫자의 총 합은 " + total + "입니다.");

		if (user > 1000) {
			for (int i = 1000; i <=user; ++i) {
				System.out.println("1000부터 입력한 숫자까지 출력 > " + i);
			}
		}else {
			for (int i = 1000; i >=user; --i) {
				System.out.println("1000부터 입력한 " + user + "까지 출력 > " + i);
			}
		}
		
		if (user > 1) {
			for (int i = 1; i <=user; ++i) {
				if (i % 5 == 0) {
					System.out.println("5의 배수만 출력 : " + i);
				}
			}
		}else {
			for (int i = 1; i >=user; --i) {
				if (i % 5 == 0) {
					System.out.println("5의 배수만 출력 : " + i);
				}
			}
		}
		
		
		/*
		//1번
		
		int sum = 0;
		
		int start, end; 
		
		if (user > 10) {
			start = 10;
			end = user;
		}else {
			start = user;
			end = 10;
		}
		
		for (int i = 10; i <= user; ++i) { // user가 10보다 클때 10부터 입력한 숫자까지 숫자출력
			sum += i;
			System.out.println("숫자출력" + sum);
		}
		//System.out.printf("10부터 %d까지의 총합은 %d입니다.", user, sum);
		System.out.println("10부터 입력한 숫자까지 총합은 : " + sum + "입니다.");
		
		
		// 2번
		if (user > 100) {
			for (int i = 1000; i <= user; ++i) {
				System.out.printf("1000부터 %d까지 출력 : %d\n", user, i);
			}
		}else {
			for (int i = 1000; i >= user; --i) {
				System.out.printf("1000부터 %d까지 출력 : %d\n", user, i);
			}
		}
		
		// 3번
		
		if (user > 1) {
			for (int i = 1; i <= user; ++i) {
				if (i % 5 == 0) {
					System.out.printf("1부터 %d까지 5의 배수만 출력 : %d\n", user, i);
				}
			}
		}else {
			for (int i = 1; i >= user; --i) {
				if (i % 5 == 0) {
					System.out.printf("1부터 %d까지 5의 배수만 출력 : %d\n", user, i);
				}
			}
		}*/

	}
}


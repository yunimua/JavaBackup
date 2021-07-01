package quiz;

import java.util.Scanner;

public class B09_GCD {
	
	/*
		두 숫자를 입력받고 두 숫자의 최대공약수를 구해보세요.
		
		# 최대공약수
		
		 - 두 숫자의 공약수 중 가장 큰 공약수
		 
		 20 : 1, 2, 4, 5, 10, 20
		 50 : 1, 2, 5, 10, 25, 50
		 
		의 경우 10이 최대 공약수다 
	*/
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("1. 수를 입력하세요 > ");
		int num1 = sc.nextInt();
		System.out.print("2. 수를 입력하세요 > ");
		int num2 = sc.nextInt();
		
//		int max = num1 > num2 ? num1 : num2;		// 큰 수 = 20 > 50 ? 50 
//		int min = num1 < num2 ? num1 : num2;		// 작은 수 = 20 < 50 ? 20
		
		int max = Math.max(num1, num2);				// Math.max : () 안 숫자 중 큰수는
		int min = Math.min(num1, num2);				// Math.max : () 안 숫자 중 작은수는
		
		int gcd = 1;
		
		for (int i = 1; i <= min; ++i) {			// i가 작은수(20)이랑 같을 때 까지 실행. => why ? 작은수의 마지막 나눠서 0이되는 수가 가장 큰수이므로!
			if (min % i == 0 && max % i == 0) {		// 작은수(50), 큰수(20)을 i로 나눴을 때 두 가지가 같은 수일 때
				gcd = i;
			}
		}
		System.out.println("최대 공약수는 " + gcd + "입니다");
		// System.out.printf("%d와 %d의 최대 공약수는 %d입니다.", num1, num2, gcd);
		
	}
}

package quiz;

import java.util.Scanner;

public class B09_Count369 {
	
	/*
		사용자로부터 정수를 하나 입력받은 후
		해당 숫자까지 369 게임이 진행된다면 박수를 총 몇 번 쳐야하는지 세어보세요.
		
		(※ 33, 36, 39...등의 숫자는 여러번 칩니다.)
		
		
		문제 해결력 - 문제를 푸는 길을 찾는 것
		구현력 - 생각해내 길을 코드로 구현하는 것
		언어 이해력 - 사용하는 언어에 대한 깊은 이해도
		
		//sysout > ctrl + space > System.out.println();
		ctrl + shift + o = import
		
	*/
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("박수 체크해볼 숫자 > ");
		int num = sc.nextInt();
		
		// 353 % 10
		// 353 / 10
		// 353 / 100 % 10
		int count =  0;
		
		for (int i = 1; i <= num; ++i) {
			int checkNum = i;
			
			System.out.printf("[%d]\t: ", checkNum);
			
			while (checkNum != 0) {
				
				int digit = checkNum % 10;
				
				if (digit % 10 != 0 && digit % 3 == 0) {
					System.out.print("짝");
					count++;
				}
				checkNum /= 10;
			}
			System.out.println();
		}
		System.out.printf("박수는 총 %d회 쳤습니다.\n", count);
	}
}
			
		/*
		int count = 0;

		System.out.print("수를 입력하세요 > ");
		int su = sc.nextInt();
		
		for (int i = 1; i <= su; ++i) {
			
			int sum = i;													//입력한 su를 sum으로 설정 (1부터 입력한 su까지)
																			// ㄴ i를 넣게되면 값을 얻을 수 없음. 1만 반복하니까, 결과값 sum으로 체크
			while(sum > 0) {												//입력한 su(sum)이 0보다 큰 경우 실행
				if (sum % 10 == 3 || sum % 10 == 6 || sum % 10 == 9) {		//나머지가 숫자 3,6,9 인 것 체크
					count++;												// 3,6,9 인 숫자가 있으면 +1씩 증가
				}
				sum /= 10;													//입력한 su(sum)를 10으로 나눴을 때 떨어지는 숫자가 3,6,9 인 것 카운트
			}
		}
		System.out.println(count);
		*/	


		
/*		for (int i = 1; i <= su; ++i) {
			for (int j = i; j > 0;) {
				if (j % 10 == 3 || j % 10 == 6 || j % 10 == 9) {
					count++;
					System.out.println("**" + count);
					System.out.println("^" + j);
				}
				j /= 10;
				System.out.println("/" + j);
			}
		}
		System.out.println(count);
	}
}*/

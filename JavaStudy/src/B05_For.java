
public class B05_For {
	
	/*
		# 반복문 (loop)
		 - for, while, do-while(X), for-each
		 - 똑같은 코드를 여러번 반복하고 싶을 때 사용한다
		 
		# for문
		 - for (초기화; 반복조건; 증가폭){
		 	가운데에 있는 반복조건이 true인 동안 반복될 명령어들을 적는 곳
		 }
	*/
	public static void main(String[] args) {
		
		// int i (1) : 시작값, 초기화한 값 체크
		// i < 100; (2) : 조건을 체크를 하여 true일 때 , false가 뜨면 중단됨.
		// ++i (3) : true일 때 해당 값을 실행
		
		/*
			1. 가장 기본적인 형태의 for문
			 - 초기값에는 0을 주고, 조건에는 반복하고 싶은 횟수를 적는다
			 - 증가는 1씩한다
			 - 원하는 횟수만큼 반복하기 가장 좋은 형태의 for문
		*/
		
		for (int i = 0; i < 10; ++i) {
			System.out.println("Hello, worid!" + i);
		}
		
		/*
			2. 초기값, 증가값 조건은 마음대로 변경할 수 있다
		
		*/
		
		for (int i = 10; i > 0; --i) {
			System.out.println("Hello, worid!" + i);
		}
		
		System.out.println("프로그램이 종료되었습니다.");
		
		/*
			3. 초기값과 증가값의 위치는 마음대로 변경할 수 있다
		*/
		
		int a = 123;
		for (; a< 234;) {
			System.out.println("Hello! " + a);
			a += 5;		// 출력을 하고 증가한다.
		}
		
		/*
			4. 반복문 내부에 다른 문법들도 자유롭게 사용할 수 있다	
		*/
		for (int month = 1; month <=12; ++month) {
			String season;
			
			switch (month) {
			case 12 : case 1 : case 2:
				season = "겨울";
				break;
			case 3 : case 4 : case 5:
				season = "봄";
				break;
			case 6 : case 7 : case 8:
				season = "여름";
				break;
			case 9 : case 10 : case 11:
				season = "가을";
				break;
			default :
				season = "계절없음";
				break;
			}
			System.out.printf("%d월은 %s입니다.\n", month, season);
		}
		
		System.out.println("프로그램이 종료되었습니다");
		
		
		
		/* 예제 연습

		 for (int i = 0; i < 10; i++) {
			for (int j = 1; j < 10 - i; j++) {
				System.out.print(' ');
			}
			for (int k = 0; k < i *2 +1; k++) {
				System.out.print('*');
			}
			System.out.println();
		}

		int num = 10;
		
		for (int i = 0; i < num; i++) {
			for (int j = 0; j < i*2 +1; j++) {
				System.out.print('*');
			}
			System.out.println();

		
		for (int k = num; k > 0; k--) {
			for (int y = k *2 -1; y > 0; y--) {
				System.out.print('*');
			}
			System.out.println();
		
		for (int i = 0; i < 10; i++) { // 9번 반복할 예제
			for (int y = 0; y < i*2 +1; y++) { // *을 출력할 조건, 별의 개수 증가형태 (1,3,5,7,9,11,13,15,17,19)
				System.out.print("*");
			}
			System.out.println();
		}
		*/
	}
}

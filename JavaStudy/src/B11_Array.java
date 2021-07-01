import java.util.Scanner;

public class B11_Array {

	/*
		# 배열 (Array)
	
		 - 같은 타입 변수를 한번에 여러개 선언하는 방법
		 - 같은 이름으로 변수를 여러개 선언한 뒤 인덱스로 구분한다
		 - 배열의 인덱스(방 번호)는 0부터 전체 길이 -1까지 있다. (100일 경우 0~99)
		 - 배열은 한번 크기가 정해지면 크기를 변경할 수 없다 (100개를 선언한 후에 개수 변경 불가)
		 - 변수와는 다르게 배열은 생성과 동시에 모든 값이 초기화 되어 있다 
		 	(정수 : 0, 실수 : 0.0, boolean: false, 참조형:null) => 기본값 default
		 - 모든 타입은 배열로 한번에 선언할 수 있다
	*/
	
	public static void main(String[] args) {
		
		Scanner[] scanners = new Scanner[10]; // 스캐너를 10개 만든다
		
		scanners[0] = new Scanner(System.in); // 스캐너 0번부터 시스템 설정
		scanners[1] = new Scanner(System.in);
		scanners[2] = new Scanner(System.in);
		
		System.out.println("첫 번째 스캐너 : " + scanners[0]);
		System.out.println("두 번째 스캐너 : " + scanners[1]);
		System.out.println("세 번째 스캐너 : " + scanners[2]);
		System.out.println("네 번째 스캐너 : " + scanners[3]); // 아무것도 들어있지 않다, null 이 들어있음.
		
		
		/*int aaaaaa, b = 17, c;
		
		System.out.println(aaaaaa); // a, c는 값이 지정되지 않고, 초기화되지 않아 오류 발생
		System.out.println(b);
		System.out.println(c);*/
		
		int[] randomNumbers = new int[100];  // int타입 변수가 100개 선언됨
		
		randomNumbers[5] = 17; // 5번에 17이라는 값을 넣음
		
		System.out.println(randomNumbers[0]);
		System.out.println(randomNumbers[1]);
		System.out.println(randomNumbers[2]);
		System.out.println(randomNumbers[3]);
		System.out.println(randomNumbers[4]);
		System.out.println(randomNumbers[5]);  // 5번에만 17이 출력되고 나머지는 모두 0
		System.out.println(randomNumbers[6]);
		System.out.println(randomNumbers[7]);
		
		
		// 배열.length를 통해 배열의 전체 길이를 알 수 있다
		System.out.println("randomNumbers의 길이 : " + randomNumbers.length); // 결과값 : 100
		System.out.println("randomNumbers의 마지막 인덱스 번호 : " + (randomNumbers.length-1));  // 99
		System.out.println("scanners의 길이 : " + scanners.length); // 10
		System.out.println("scanners의 마지막 인덱스 번호 : " + (scanners.length-1)); // 9
		
		
		/*
			# 배열 선언 방법
			 
			 1. 타입[] 변수명 = new 타입[배열크기];
			 2. 타입[] 변수명 = {값1, 값2, 값3, ...}
			 3. 타입[] 변수명 = new 타입[] {값1, 값2, 값3, ...}		
		*/
		
		int[] numbers = new int[10];
		
		char[] blacklist = {'#', '@', '&', '^', '\\', 65, 111}; // 65 = A이므로 숫자로도 넣을수있음
		boolean[] passExam = new boolean[] {true, false, false, true}; // boolean 타입으로 선언을 할수 있다. 네 아니오 아니오 네
		
		int[] units = {
				365 * 24 * 60 * 60,
				24 * 60 * 60,
				60 * 60,
				60
		};
		
		
		// 배열은 반복문과 함께 쓰도록 설계되어 있다 (for문과 함께 쓰도록 설계되어있는 배열..)
		for (int i = 0; i < blacklist.length; ++i) {
			System.out.println(blacklist[i]); // #부터 o(111)까지 순차적 출력됨
		}
		
		/* 결과값
		 	#
			@
			&
			^
			\
			A
			o
		*/
		
		// String은 char[]로 변환할 수 있다
		char[] hello = "Hello, world!".toCharArray();
		
		for (int i = 0; i < hello.length; ++i) {
			System.out.printf("hello[%d] : %c\n", i, hello[i]);
		};
		
		/* 
		 	위의 출력 값
		 	hello[0] :  H
			hello[1] :  e
			hello[2] :  l
			hello[3] :  l
			hello[4] :  o
			hello[5] :  ,
			hello[6] :   
			hello[7] :  w
			hello[8] :  o
			hello[9] :  r
			hello[10] :  l
			hello[11] :  d
			hello[12] :  !
		*/
		
		
		/*blacklist[6] = 111;
		
		char ch1 = '#';
		char ch2 = '@';*/
	}
}

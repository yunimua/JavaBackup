
public class A05_Print {
	public static void main(String[] args) {
		
		/*
			# 콘솔에 출력하는 함수들
			
				1. Print()
				 	- 줄을 자동으로 바꿔주지 않는 가장 기본 출력 함수
				 	
				2. println()
					- 줄을 자동으로 바꿔주며 출력하는 함수
					- ()에 전달한 데이터 맨 뒤에 "\n"을 추가하여 출력한다
					- ()에 아무것도 전달하지 않으면 '\n'만 출력한다
		
		*/
		
		int apple = 15;
		
		System.out.print("Hello!\n");
		System.out.print("Hello!\n");
		System.out.print("Hello!\n");
		
		System.out.print("사과 : ");
		System.out.println(apple);
		
		System.out.println();
		
		System.out.println("Hello!");
		System.out.println("Hello!");
		System.out.println("Hello!");
		
		/*
			3. printf()
				- 서식을 이용해 원하는 형태를 쉽게 만들어 출력하는 함수
				- 출력의 형태를 미리 만들고, 서식 문자 자리에 값을 순서대로 채워서 사용한다
				- 문자열을 +로 이어붙이는 방식보다 편리한 경우에 사용한다
				- 줄을 자동으로 바꿔주지 않는다
				
			※ 서식 문자의 종류
				%d : 해당 자리에 자리한 정수값을 10진수로 출력해준다 decimal
				%x, %X : 해당 자리에 전달한 정수값을 16진수로 출력해준다 (hexa decimal)
				%o : 해당 자리에 전달한 정수값을 8진수로 출력해준다 octal
				%s : 문자열
				%c : 문자
				%f : 실수
				
			※ 10 진수
				0 1 2 3 4 5 6 7 8 9 10 11
			
			※ 8 진수
				0 1 2 3 4 5 6 7 10 11 12 13 14 15 16 17 20
				
			※ 16 진수
				 0 1 2 3 4 5 6 7 8 9 A B C D E F 10 ... 1F 20 .. 2F 30 ..
				
		
		*/
		
		int year = 2021, month = 5, day = 10,
				hour = 15, minute = 50, second = 13;
		
		System.out.print(year + "년 " + month + "월 " +  day + "일\t");
		System.out.println(hour + ":" + minute + ":" + second);
		
		System.out.printf("%d년 %d월 %d일\t%d:%d:%d\n",
				year, month, day, hour, minute, second);
		
		System.out.printf("%d를 10진수로 출력하면 %d입니다.\n", year, year);
		System.out.printf("%d를 8진수로 출력하면 %o입니다.\n", year, year);
		System.out.printf("%d를 16진수로 출력하면 %x입니다.\n", year, year);
		System.out.printf("%d를 16진수로 출력하면 %X입니다.\n", year, year);
		
		/*
			※ 서식 문자 옵션들
			1. %숫자d, %숫자s...
				- 자릿수를 숫자만큼 확보하면서 오른쪽 정렬하여 출력한다
			
			2. %-숫자d,...
				- 자릴수를 숫자만큼 확보하면서 왼쪽 정렬하여 출력한다
				
			3. %0숫자d
				- 자릿수를 숫자만큼 확보하고 빈자리에 0을 채워 출력한다
				
			4. %+d
				- 양수 앞에도 부호를 붙여서 출력한다
				
			5. $.숫자f
				- 소수의 자릿수를 설정한다
		*/
		
		System.out.printf("%20d\n", 2000);
		System.out.printf("%-10s : %7d\n", "Price", 15000);
		System.out.printf("%-10s : %7d\n", "Inxcome", 300);
		System.out.printf("%-10s : %7d\n", "Calorie", 1200);
		System.out.printf("%-10s : %7d\n", "Tax", 150000);
		
		System.out.printf("%02d\n", 1);		// 0이 보여지게 표시 : 01
		System.out.printf("%02d\n", 2);
		System.out.printf("%03d\n", 11);	// 앞에 0이 표시되고 3자리까지 : 011
		System.out.printf("%04d\n", 15);	// 앞에 00이 표시되고 4자리까지 : 0015
		
		System.out.println("----------------------------------------");
		
		System.out.printf("%+d\n", -50); //-를 표시하게 출력
		System.out.printf("%+d\n", 50);  //+를 표시하게 출력
		
		// 배운 옵션들은 모두 조합이 가능하다
		System.out.printf("%020.5f\n", 123.1234567); // +0000000000123.12346 : 20자리 표시, 소수점 5자리까지 표시 
		System.out.printf("%.4f\n", 123.1234567); // 소수점 4자리까지 표시 : 123.1235
		System.out.printf("%.3f\n", 123.1234567); // 소수점 3자리까지 표시 
		System.out.printf("%.2f\n", 123.1234567); // 소수점 2자리까지 표시
		System.out.printf("%.1f\n", 123.1234567);
		System.out.printf("%.0f\n", 123.1234567);
		System.out.printf("%.300f\n", 123.1234567);
		
	}
}

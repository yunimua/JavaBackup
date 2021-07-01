package quiz;

public class A09_ConditionQuiz {
	public static void main(String[] args) {
	/*
	 	[ 알맞은 비교연산을 만들어보세요 ]
	 	
	 	1. int형 변수 a가 10보다 크고 20보다 작을 때 true
	 	2. int형 변수 b가 짝수일 때 true
	 	3. int형 변수 c가 7의 배수일 때 true
	 	4. int형 변수 hour가 0미만 24이상이 아니고, 12 이상일 떼 true
	 	5. int형 변수 d와 e의 차이가 30일때 true
	 	6. int형 변수 year가 400으로 나누어 떨어지거나
	 		또는 4로 나누어 떨어지고 100으로 나누어떨어지지 않을 때 true
	 	7. 민수가 철수보다 2살 많으면 true
	 	8. 민수가 철수보다 생일이 3달 빠르면 true 
	 	9. boolean형 변수 powerOn 이 false 일 때 true
	 	10. 문자열 참조변수 str이 "yes"일 때 true
	
	*/
	
	int a = 11;
	int b = 2;
	int	c = 28;
	int d = 13;
	int hour = 13;
	int e = 43;
	int year = 204;
	int minAge = 22, cheolAge = 20;
	int minBirth = 6, cheolBirth = 9;
	boolean powerOn = false;
	String str = "yes";
	
	System.out.print("1번 : ");
	System.out.println(a > 10 && a < 20);
	
	System.out.print("2번 : ");
	System.out.println(b % 2 == 0);
	
	System.out.print("3번 : ");
	System.out.println(c % 7 == 0);
	
	System.out.print("4번 : ");
	System.out.println(hour < 24 && hour >= 12);
	
	System.out.print("5번 : ");
	System.out.println(Math.abs(d - e) == 30);

	System.out.print("6번 : ");
	System.out.println(year % 400 == 0 || (year % 4 == 0 && year % 100 != 0));

	System.out.print("7번 : ");
	System.out.println(minAge - 2 == cheolAge);

	System.out.print("8번 : ");
	System.out.println(minBirth + 3 == cheolBirth);

	System.out.print("9번 : ");
	System.out.println(!powerOn);
	
	System.out.print("10번 : ");
	// System.out.println(str == (String)"yes"); // 적었던 답..
	System.out.println(str.equals("yes"));

	
	String str2 = "yes";
	String str3 = new String("yes");
	
	// 참조형 변수의 ==은 두 변수가 서로 같은 주소를 지니고 있는지를 비교한다
	System.out.println("str == \"yes\" : " + (str == "yes"));
	System.out.println("str == str2 : " + (str == str2));
	System.out.println("str == str3 : " + (str == str3));
	
	/* stack ,  heap 
	
		메모리에 저장되는 방식이 다르기 때문에 equals로 비교해야한다.
		- 타입명이 대문자로 시작하는 참조형 변수들은 반드시 .equals()를 이용해 비교해야 한다
		- 소문자로 시작하는 타입 변수들은 stack에 차곡차곡 쌓인다
		- 대문자로 시작하는 타입 변수들은 stack에는 주소값만 보관하고 실체는 heap에 존재한다
		- 대문자로 시작하는 타입 변수에는 주소값이 저장되어 있고, 거기에 .을 찍고 실제 데이터를 참조할 수 있다
	
	*/
	
	
	/*
		[정답]
		
		int a = 15;
		int b = 7;
		int c = 7;
		int hour = 13;
		int d = 40, e = 10;
		
	
	System.out.println(a > 10 && a < 20);
	System.out.println(b % 2 != 1);	
	System.out.println(c % 7 == 0);
	
	System.out.println(hour < 24 && hour >= 12);
	// hour >= 0 는 hour >= 12 과 동일한 조건 값이므로 삭제 : 적었던 답에는 hour > 0이 있었음..
	// (!(hour < 0 || hour >= 24) && hour >= 12);

	System.out.println(Math.abs(d - e) == 30);
	// 절대값.Math.abs 사용 : 문제 못맞춤..
	
	System.out.println(year % 400 == 0 || (year % 4 == 0 && year % 100 != 0));
	// && 값이 우선 계산되도록 () 추가 : 적은 답은 &&을 쓰지 않고, ||로만 작성, 이후 &&로 변경했으나 ()는 하지 않음
		
	System.out.println(!powerOn);
	// !만 넣으면됨 () 필요없음..
	
	System.out.println(str.equals("yes"));
	// 타입명이 대문자로 시작하는 참조형 변수들은 반드시 .equals()를 이용해 비교해야 한다
	
	*/
	}
}

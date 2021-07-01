
public class A03_VarTypes {
	public static void main(String[] args) {

		/*
			# 정수 타입
				- byte (1byte) -128 ~ 127

				1byte => 8bit

				0000 0000(0) ~ 1111 1111(255)  (부호가 없는 경우 0~255까지 표현 가능)
				부호를 사용하는 경우에는 첫 번째 bit를 부호 비트로 사용한다

				byte 타입의 양수 범위 0000 0000(0) ~ 0111 1111(127)
				byte 타입의 음수 범위 1000 0000(-128) ~ 1111 1111(-1)		

				//총 256가지, 첫번째 비트는 부호비트[-]


				- short (2byte)
					-32768 ~ 32767
						0111 1111 1111 1111(32767)
						1000 0000 0000 0000(-32768)
				- char (2byte untsigned) ※ 문자 코드 저장용
					0 ~ 65535
				- int (4byte)
					-2^31 ~ 2^31-1
				- long (8byte)
					-2^63 ~ 2^63-1
		*/

		byte a = 10;
		short b = 10;
		char c = 10;
		int d = 10;
		long e = 10;

		byte _byte = 127;
		short _short = 32727;
		char _char = 65535;
		int _int = 2147483647;

		// 정수타입 리터럴은 기본적으로 int타입이다
		// int타입의 범위를 벗어나는 값을 사용하고 싶다면 뒤에 l 또는 L을 붙여야 한다
		long _long = 2000000000000000L;

		System.out.println(a);

		/*
			# 실수 타입
				- float (4byte)
				- double (8byte)
		
				실수는 주로 그래픽 계산에 사용된다
				부동 소수점 방식을 사용한다

		*/

		// 소수 리터럴은 기본적으로 double타입이므로 double타입 변수에는 아무 문제없이 들어간다
		double _double = 123.1234;
		// 소수 뒤에 f 또는 F 를 적어주면 float타입 리터럴이라는 표시가 된다
		float _float = 123.123f;

		/*
			# 참/거짓 타입
				- boolean
		
				들어갈 수 있는 값은 true/false 밖에 없다

		*/
		boolean male = true;
		boolean female = true;
		boolean powerOn = false;
		boolean goonpil = true;
		boolean computerScience = true;

		/*
		  # 참조형 타입
		 
		  참조형 타입은 대문자로 시작한다
		  소문자로 시작하는 타입은 모두 기본형 타입이라고 부른다
		 
		  - String
		  - 그 외 모든 클래스들..

		*/

		String welcome_message = "hello, world!";
		System.out.println(welcome_message);

		// char 타입은 문자 코드 저장 정수 타입이다
		char ch = 120;

		char ch2 = 'x';
		int num1 = 'x';
		System.out.println("ch에 저장된 값 : " + ch);
		System.out.println("'x'를 저장한 char타입 변수의 출력 : " + ch2);
		System.out.println("'x'를 저장한 int타입 변수의 출력 : " + num1);

		/*
			ch에 저장된 값 : x
			'x'를 저장한 char타입 변수의 출력 : x
			'x'를 저장한 int타입 변수의 출력 : 120

		*/
	}
}

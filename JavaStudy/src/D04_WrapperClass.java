
public class D04_WrapperClass {

	/*
		# Wrapper Class
	
		  - 기본 타입들을 참조형 타입으로 감싸놓은 클래스들
		  - 각 기본 타입들에 대한 유용한 기능들이 모여있다
		  
		# 기본형 타입들
		
		  - byte, short, char, int, long, float, double, boolean
		  
		# 기본형에 대한 참조형 타입의 이름
		
		  - Byte, Short, Character, Integer, Long, Float, Double, Boolean
	*/
	public static void main(String[] args) {
		
		/*
			# parsing
			
			  - 문자열을 원하는 타입으로 변환 시키는 것
			  - 각 타입의 Wrapper 클래스에 static 메서드로서 존재한다
		*/
		
		//+ 쉽게 변환하는 방법 (스크링을 숫자로)
		int num = Integer.parseInt("123");
		System.out.println(num);
		
		//+ ㄴ String 을 숫자로 변환 : char 형으로 바꾸고, int 형으로 ...
//		for (int i = 0; i < "123".length(); ++i) {
//			char ch = "123".charAt(i);
//			int num = ch - '0';
//		}
		
		double d = Double.parseDouble("123.1234");
		System.out.println(d);
		
		/*
			# toString
			
			  - 각 타입의 값을 문자열로 변환시키는 기능
			  - 오버라이드 가능한 toString과는 다르다
		*/
		
		String result = Integer.toString(89999999);
		System.out.println(result);
		
		//+ 2진법
		result = Integer.toString(89999999, 2);
		System.out.println(result);
		
		//+ 36진법 이상을 쓸일이 없다, 36진법까지만 된다.
		// ※ 프로그래머들에게는 2진법, 8진법, 16진법이 중요하다
		for (int radix = 2; radix <= 36; ++radix) {
			result = Integer.toString(89999999, radix);
			System.out.println(radix + "진법 : " + result);
		}
		
		System.out.println(Integer.MAX_VALUE); //2147483647
		System.out.println(Long.MAX_VALUE); //9223372036854775807
		System.out.println((int)Character.MAX_VALUE); //65535 최대값 표시됨
		
		// ※ Character에는 문자를 편하게 다룰 수 있는 static 메서드들이 많다.
		Character.isLowerCase('a'); //+ 이게 알파벳이니?
		Character.isDigit('9'); //+ 이게 숫자니? 
		
		System.out.println(Character.isLowerCase('a'));

	}
}

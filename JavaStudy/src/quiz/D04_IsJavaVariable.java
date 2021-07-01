package quiz;

import java.util.Scanner;

public class D04_IsJavaVariable {

	/*
		사용자로부터 문자열을 입력받으면 해당 문자열이 자바의 변수로써 사용될 수 있는지
		검사하는 메서드를 만들고 테스트해보세요.	
		
		사용자가 허락한 문자만으로 이루어진 문자열이라면 true, 아니면 false
			(허락한 문자열 : 알파벳 소문자, 숫자, _, $, 첫번째 문자에 숫자 불가)
		
		(1) 변수의 첫 번쨰 글자는 숫자가 될 수 없다
		(2) 변수명 사이에는 공백을 사용 할 수 없다
		(3) 특수문자는 _와 $만 사용할 수 있다
		(4) 이미 사용하고 있는 키워드는 변수명으로 사용할 수 없다
		ex : int, short, char, void, static, public ...
	*/
	
	public static void main(String[] args) {
		
		String str = "JAva123";
		
		System.out.println(str.toCharArray());
		
		System.out.println(check("java123".toCharArray()));
	}
	
	public static boolean check(char[] str) {
		// Character.isJavaIdentifierStart : 자바 변수명의 첫 번째 글자로 적합한지 체크
		boolean check = Character.isJavaIdentifierStart(str[0]); 
		
		// Character.isJavaIdentifierPart : 자바 변수명의 나머지 부분으로 적합한지 체크
		for (int i = 1; i < str.length; ++i) { 
			check = check && Character.isJavaIdentifierPart(str[i]);
		}
		return check;
	}
}

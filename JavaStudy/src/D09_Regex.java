import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class D09_Regex {

	/*
		# 정규표현식 (Regular Expression)
		
		  - 문자열의 패턴을 표현할 수 있는 표현식
		  - 특정 프로그래밍 언어에 종속되지 않는 공통의 규칙이다
		  - 정의한 문자열 패턴과 일치하는 문자열을 걸러낼 수 있다
		  
		# Java에서 정규표현식을 다룰 때 사용하는 클래스
		
		  - Pattern
		  - Matcher
	*/
	
	public static void main(String[] args) {
		
		//+ boolean java.util.regex.Pattern.matches(String regex, CharSequence input)
		
		// Pattern.matches(regex, input) : input이 regex에 일치하는지 여부를 검사
		System.out.println(Pattern.matches("sleep", "sleep")); //+ true
		
		// [] : 해당 위치의 한 글자에 어떤 문자들이 올 수 있는지 정의하는 표현식 // 하나에 한글자!!!!!!!!!!!!!!!!!
		System.out.println(Pattern.matches("s[l@]eep", "sleep"));
		System.out.println(Pattern.matches("s[l@]eep", "sheep")); //+ false
		System.out.println(Pattern.matches("s[l@]eep", "s@eep"));
		System.out.println(Pattern.matches("s[l@]eep", "saeep")); //+ false
		System.out.println(Pattern.matches("s[l@]ee[abcdefghijk]", "sleek")); //+ []안에 들어간 모든 알파벳으로 체크된다, 대소문자 구분됨
		
		/*
			[abc]	: 해당 자리에 a 또는 b또는 c를 허용
			[^abc]	: 해당 자리에 abc를 제외한 모든 것을 허용
			[a-z]	: a부터 z까지 모두 허용
			[A-Z]	: A부터 Z까지 모두 허용
			[\\-]	: 문자로서 -를 허용(Escape)
			[a-e&&c-z] : a-e와 c-z를 모두 만족시키는 문자를 허용(교집합)
		*/
		System.out.println(Pattern.matches("s[A-Z]eep", "s-eep")); //+ false
		System.out.println(Pattern.matches("s[A\\-Z]eep", "s-eep")); //+ true
		System.out.println(Pattern.matches("s[a-e&&c-z]eep", "sceep")); //+ true
		
		/*
			# 하나로 여러 문자를 나타내는 것들
		
				.  : 모든 문자
				\d : 모든 숫자 [0-9]
				\D : d숫자를 제외한 모든 것
				\s : 모든 공백 (\t, \n, \r, ' ')
				\S : 공백을 제외한 모든 것 (S대문자)
				\w : 일반적인 문자들을 허용 [a-zA-Z0-9_]
				\W : \w을 제외한 모든 것 (W대문자)
				
		*/
		System.out.println(Pattern.matches("s.eep", "s eep")); //+ .은 모든문자 1개를 허용(특문, 숫자, 문자 구분없음)
		System.out.println(Pattern.matches("s\\Seep", "sdeep")); //+ 공백을 제외한 모든것 
		
		/*
			# 해당 패턴이 적용될 문자의 개수를 정의하는 방법
			
				[.]{n} : {}앞의 패턴이 n개(n은 숫자) 일치해야 한다
				[.]{n,m} : {}앞의 패턴이 최소 n개 최대 m개 일치해야 한다
				[.]{n,} : {}앞의 패턴이 최소 n개이상 일치해야 한다
				[.]? : ? 앞의 패턴이 0번또는 한번 나와야한다
				[.]+ : + 앞의 패턴이 최소 한번 이상 나와야한다
				[.]* : * 앞의 패턴이 0번 이상 나와야 한다 (나와도되고, 안나와도됨)
		*/
		
		System.out.println(Pattern.matches("[.]{5}", ".....")); //+ .이 5개 허용되는 경우에만 허용(true)
		System.out.println(Pattern.matches("[.a-zA-Z]{5}", "abs..")); //+ .과 대소문자 알파벳이 5개만 있는 경우에만 허용(true)
		System.out.println("---------------------------------------------------------");
		
		System.out.println(Pattern.matches("[.]{1,2}", ".")); //+ false
		System.out.println(Pattern.matches("[.]{1,2}", ".."));
		System.out.println(Pattern.matches("[.]{1,2}", "..."));
		System.out.println(Pattern.matches("[.]{2,5}", "...."));
		System.out.println(Pattern.matches("[.]{2,5}", "....."));
		System.out.println(Pattern.matches("[.]{2,5}", "......")); //+ false
		
		System.out.println(Pattern.matches("s?heep", "heep")); //+ true
		System.out.println(Pattern.matches("s?heep", "sssheep")); //+ false
		System.out.println(Pattern.matches("s?heep", "kheep")); //+ false, s가 없고 k는 포함되지 않은 글자이므로.
		
		System.out.println(Pattern.matches("s+heep", "ssssssheep")); //+ s가 여러번 나와도 true
		System.out.println(Pattern.matches("s?heep", "heep")); //+ s가없으면 false
		System.out.println(Pattern.matches("s*heep", "heep")); 
		
		System.out.println("---------------------------------------------------------");
	
		//내가쓴거
		System.out.println(Pattern.matches("010{1}-[2-9]\\d{3}-[0-9]{4}", "010-1234-1234"));
		System.out.println(Pattern.matches("\\d{6}-?[1-4]\\d{6}", "001231-1234567"));
		System.out.println(Pattern.matches("\\d{6}-?[1-4]\\d{6}", "111111-1234567"));
		System.out.println(Pattern.matches("\\w{2,}@\\w+.\\w+.\\w*","emaiL123@gmail.co.kr"));
	
		// 연습문제 : 해당 문자열이 핸드폰 번호인지 검사할 수 있는 정규표현식을 만들어보세요.
		System.out.println(Pattern.matches("010-?[2-9]\\d{3}-?\\d{4}", "010-2234-1234"));
		
		// 연습문제 : 해당 문자열이 주민등록번호인지 검사할 수 있는 정규표현식을 만들어보세요
		System.out.println(Pattern.matches("\\d{2}(0[1-9]|1[1-2])(0[1-9]|[12][\\d]|3[01])-?[1-4]\\d{6}", "001231-1234567"));
		
		// 연습문제 : 해당 문제열이 이메일인지 검사할 수 있는 정규표현식을 만들어보세요
		System.out.println(Pattern.matches("\\w+@\\w+(\\.\\w+)?(\\.\\w+)?","emaiL123@gmail.co.kr"));
		
		String email1 = "emaiL123@gmail.co.kr";
		
		emailChk(email1);
		emailChk("e@g.c.r");
		emailChk("@d.d");
		
		// # Matcher 사용해서 긴 문자열 검사하기
		
		String fruit = "apple/banana/orange/pineapple/greenapple/redapple/mango";
		
		Pattern pattern0 = Pattern.compile("an"); //+ (1) an과 일치하는 모든것을 찾아준다 : 4개
		Pattern pattern1 = Pattern.compile("a.{2}le"); //+ (2) . : 모든 문자 >> apple 4개
		Pattern pattern2 = Pattern.compile("na");
		
		// pattern1로 fruit을 검사한 결과를 반환한다
		Matcher matcher = pattern2.matcher(fruit); //+ import java.util.regex.Matcher; 임포트 필요!!!
		
		// matcher.find() : 찾은 것들 중에 다음 것이 존재하면 true
		while (matcher.find()) {
			System.out.println("찾은 것 : " + matcher.group());
			System.out.println("위치 : " + matcher.start() + "부터 " + matcher.end() + "까지");
			System.out.println(fruit.substring(matcher.start(), matcher.end())); //+ 위와 같은 말..
			
			System.out.println();
		}
	}
	
	static void emailChk(String email) {
		String chk = email;
		if (Pattern.matches("\\w+@\\w+(\\.\\w+)?(\\.\\w+)?", chk)) {
			System.out.println("올바른 이메일 형식 입니다.");
		}else {
			System.out.println("올바르지 않은 이메일 형식 입니다.");
		}
	}
}

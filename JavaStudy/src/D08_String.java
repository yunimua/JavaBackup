import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class D08_String {

	/*
	
	
	*/
	
	public static void main(String[] args) { //+ 문자열을 저장하는 참조형 클래스 : String, static / 인스턴스 기능들이 포함되어있다..

		String fruits = "apple/banana/orange/pineapple/kiwi"; //+ fruits에 주소가 들어있다, String 클래스에 인스턴스(과일)이 들어있다
		
		// split(delimiter) : 문자열을 원하는 기준으로 자른 문자열 배열을 반환한다
		String[] splitted = fruits.split("/");
		
		for (int i = 0; i < splitted.length; ++i) {
			System.out.println(i + " : " + splitted[i]); //+ 하나씩 꺼내서 / 기준으로 나뉜 0~4까지 5가지 과일이 순차적 출력
		}
		
		// String.join(delim, 이어붙이고 싶은 것...) : 여러 문자열을 원하는 구분자를 추가하여 이어붙인다
		String after = String.join(",", splitted);
		System.out.println(after); //+ apple,banana,orange,pineapple,kiwi
		System.out.println(String.join("-", "연어", "장어", "광어", "우럭", "도미")); //+ 연어-장어-광어-우럭-도미
		
		printRabbitWithMessage("커피", "우유", "주스", "당근", "피망"); //+ 토끼 바로 밑에 입력한 내용 출력
		printRabbitWithMessage("감자", "고구마");
		
		// substring(start) : 문자열을 start부터 마지막까지 자른다
		// substring(start, end) : 문자열을 start부터 end 미만까지 자른 인스턴스를 반환
		String sn = "991231-123457";
		
		String year = sn.substring(0,2);
		String month = sn.substring(2,4);
		String date = sn.substring(4,6);
		
		System.out.println("year : " + year); //+ 99 각 숫자를 배열에 넣은 형태로 짤라서 사용가능
		System.out.println("month : " + month); //+ 12
		System.out.println("date : " + date); //+ 31
		
		// contains(seq) : 문자열에 해당 문자열이 포함되어 있는지 검사한다
		String ph = "010-1234-1234";
		System.out.println("ph에 1234가 포함되어 있나요? " + ph.contains("1234")); //+ ph에 1234가 포함되어 있나요? true
		
		// startsWith(seq) : 문자열이 해당 문자열로 시작하는지 검사한다
		System.out.println("ph에 010으로 시작하나요? " + ph.startsWith("010")); //+ ph에 010으로 시작하나요? true
		
		// endsWith(seq) : 문자열이 해당 문자열로 끝나는지 검사한다
		System.out.println("ph가 4로 끝나나요? " + ph.endsWith("4")); //+ ph가 4로 끝나나요? true
		
		// replace(old, new) : 문자열을 다른 문자열로 교체한 인스턴스를 반환한다
		String result = ph.replace("1234", "abcd"); //+ 1234를 abcd로 바꾼다
		System.out.println("원본 : " + ph + ", 결과 : " + result); //+ 원본 : 010-1234-1234, 결과 : 010-abcd-abcd
		
		// getBytes() : 문자열을 byte[]로 변환한다
		System.out.println(Arrays.toString("hello".getBytes())); //+ [104, 101, 108, 108, 111]
		System.out.println(Arrays.toString("안녕하세요".getBytes()));
		
		// 어떤 규칙을 사용해 byte[]로 변환할 지 결정할 수 있다
		try {
			System.out.println(Arrays.toString("안녕하세요".getBytes("UTF-8"))); 
			System.out.println(Arrays.toString("안녕하세요".getBytes("UTF-16")));
			System.out.println(Arrays.toString("안녕하세요".getBytes("EUC-KR"))); //+ 안녕하세요 반갑습니다.
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		// byte[]로 나눠졌던 데이터들을 다시 문자열로 합칠 수 있다
		byte[] message = "안녕하세요 반갑습니다.".getBytes();	
		System.out.println(new String(message)); //+ String 생성자에는 byte 배열을 바꾸는 기능이 들어있다
		
		//trim() : 문자열 바깥쪽의 공백을 제거해준다
		String user_input = "\t java \n" ;
		String answer  = "java";
		System.out.println( "공백제거" + user_input.trim().equals(answer)); //+ .trim() 을 하고난 뒤 equals > 결과 : true
		
		String text = "hello, java!!";
		
		// toUpperCase() : 문자열을 대문자로 변환한 인스턴스를 반환한다
		// toLowerCase() : 문자열을 소문자로 변환한 인스턴스를 반환한다
		System.out.println(text.toUpperCase()); //+ HELLO, JAVA!!
		System.out.println(text.toUpperCase().toLowerCase()); //+ hello, java!!
		
		// indexof(seq) : 원하는 문자열의 인덱스를 반환한다
		// indexof(seq, start) : 시작 위치부터 원하는 문자열의 인덱스를 반환한다
		String languages = "Java, Pythonm, C, C++, C#, kotlin, JavaScript";
		
		languages += languages;
		languages += languages;
		languages += languages;
		
		System.out.println(languages.indexOf("Java")); //+ 얘는 0번째
		System.out.println(languages.indexOf("JavaScript", 350)); //+ 얘는 35번째, 0이아닌 1이후부터의 인덱스를 찾았기 때문
		
		// 연습 : languages에서 "Java"라는 문자열의 모든 인덱스를 찾아서 적절한 자료 컬렉션에 저장하여 출력해보세요
		//System.out.println(languages.length()); //+ 총 360글자
		
		ArrayList<Integer> indexes = new ArrayList<>();
		String search = "Java";
		
		// while문으로 쓴 경우	(3)	
		int found = -1;
		while((found = languages.indexOf(search, found+1)) != -1) {
			indexes.add(found);
		}
		System.out.println("찾은거 : " + indexes);
		
		// while문으로 쓴 경우	(2)	
//		int start = 0;
//		int found = -1;
//		while((found = languages.indexOf(search, start)) != -1) {
//			indexes.add(found);
//			start = found + 1;
//		}
		
		// while문으로 쓴 경우	(1)	
//		int start = 0;
//		while(languages.indexOf(search, start) != -1) {
//			int found = languages.indexOf(search, start);
//			indexes.add(found);
//			start = found + 1;
//		}
		
		// for문으로 쓴경우 
//		for (int start = 0; start < languages.length();) { //+ 1씩 증가시킬 필요가 없다
//			int index = languages.indexOf(search, start);
//			
//			if(index == -1) {
//				break;
//			}
//			
//			System.out.println("이번에 찾음 : " + index);
//			indexes.add(index);
//			start = index + 1;
//		}
//		System.out.println("찾은거 : " + indexes);
		
//		ArrayList<Integer> indexChk = new ArrayList<>();
//		
//		indexChk.add(languages.indexOf("Java")); //+0
//		indexChk.add(languages.indexOf("Java", 1)); //+35 (35증가)
//		indexChk.add(languages.indexOf("Java", 36)); //+45 (10증가)
//		indexChk.add(languages.indexOf("Java", 46)); //+80 (35증가)
//		indexChk.add(languages.indexOf("Java", 81)); //+90 (10증가)
//		indexChk.add(languages.indexOf("Java", 91)); //+125 (35증가) // 350까지있다..
//		System.out.println(indexChk);
		
		
	
	}
	
	//+ 가변인자 메서드 만들기
	// Type... : 가변인자, 정해지지 않은 개수의 인자를 해당 타입 배열로 넘겨받을 수 있다
	//  ※ 가변인자는 항상 메서드의 마지막에 정의해야 한다
	static void printRabbitWithMessage(String...msgs) {
		System.out.println("/)/)");
		System.out.println("( ..)");
		System.out.println("( >♡");
		System.out.println(Arrays.toString(msgs));
	}
}

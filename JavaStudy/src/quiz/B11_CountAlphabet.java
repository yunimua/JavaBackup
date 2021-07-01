package quiz;

import java.util.Scanner;

public class B11_CountAlphabet {
	
	/*
		사용자로부터 문장을 하나 입력받고
		해당 문장에 어떤 알파벳이 몇 번 등장했는지 세어서 모두 출력해보세요
		(대소문자도 구분할 것)
		
	*/

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("문장 입력 > ");
		String text = sc.nextLine();
		
		int[] lowercount = new int[26];
		int[] uppercount = new int[26];
		// 소문자, 대문자 배열을 각각 선언
		
		for (int i = 0, len = text.length(); i < len; ++i) {
			
			char ch = text.charAt(i);
			//ch는 입력한 문자열의 첫글자(0)에서 마지막글자까지
			
			if(ch >= 'a' && ch <= 'z') {
				lowercount[ch - 'a']++;
				// ch에서 소문자 a~z까지 체크, 일치하는게 있으면 다시 -a를 해서 처음으로. 체크된 알파벳에 카운트 +1 증가.
			}else if (ch >= 'A' && ch <= 'Z'){
				uppercount[ch - 'A']++;
				// ch에서 소문자 A~Z까지 체크, 일치하는게 있으면 다시 -A를 해서 처음으로. 
			}
		}
		for (int i = 0; i < 26; ++i) {
			System.out.printf("대문자는 %c는 %d번 등장했습니다.\n", 'A' + i, uppercount[i]);
			System.out.printf("소문자는 %c는 %d번 등장했습니다.\n", 'a' + i, lowercount[i]);
		}
		
		
		
//		final String SYMBOLS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
//		// final이 붙은 변수는 수정이 불가능해지는 선언임. => String SYMBOLS의 문자를 변경할 수 없다.
//		
//		int[] symbol_count = new int[SYMBOLS.length()];
//		
//		// Common sence is not so common
//		for (int i = 0, len = text.length(); i < len; ++i) {
//			
//			char ch = text.charAt(i);
//			//System.out.println("이번에 검사할 문자는 '" + ch + "'입니다.");
//			
//			for(int j = 0, len2 = SYMBOLS.length(); j<len2; ++j ) {
//				if (ch == SYMBOLS.charAt(j)) {
//					symbol_count[j]++;
//					//System.out.println("'" + ch +"'는 SYMBOLS의 " + j + "번째에 있으므로 symbol_count의 " + j + "번째 값을 증가 시킵니다." );
//					//System.out.println(symbol_count[j]);  // 입력된 문자에 대한 알파벳 카운트가 증가되는 것을 확인할 수 있음
//					break; // 알파벳 끝까지 가지 않고 찾은 문자까지만 실행 후 break가 됨
//				}
//			}
//		}
//		for (int m = 0; m < SYMBOLS.length(); ++m) {
//			System.out.println((char)(SYMBOLS.charAt(m)) + "의 개수는 : " + symbol_count[m] + "이다.");
//		}
		
		
		
		/* 입력된 문자열에서 알파벳 대소문자 개수만 세는 정도..
		int count = 0;
		
		for (int i = 0; i < text.length(); ++i) {
			char[] alpha = text.toCharArray();
			
			// alpha[i] 의 값이 알파벳 a ~ z, A ~ Z랑 일치하는지 체크 필요..
			// 배열로 알파벳 a~z를 선언하는 방법을 모르겠습니다.
			
			if ((alpha[i] >= 'a' && alpha[i] <= 'z') || (alpha[i] >= 'A' && alpha[i] <= 'Z')) {
				count++;
			}
		}
		System.out.println(count);	// 알파벳 문제열 개수
		*/
	}
}

package quiz;

import java.util.Scanner;

public class B06_is_contain_alpha {

	/*
		1. 사용자가 입력한 문자열에 알파벳이 포함되어 있으면 true를 출력, 없으면 false를 출력
		
		2. 사용자가 입력한 문자열이 알파벳으로만 이루어져 있으면 true, 아니면 false
		
		3. 사용자가 허락한 문자만으로 이루어진 문자열이라면 true, 아니면 false
			(허락한 문자열 : 알파벳 소문자, 숫자, _, $, 첫번째 문자에 숫자 불가)
	*/
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String str;
		
		System.out.print("문자를 입력하세요 > ");
		str = sc.nextLine();	
		
		/* 3번 풀다만거
		boolean check = false;
		
		for(int i = 0; i < str.length(); ++i) {
			
			char ch = str.charAt(i);
			char tm1 = '_';
			char tm2 = '$';
			
			char firstNo = str.charAt(0);
			
			
			if (ch >= 'a' && ch <= 'z' || ch >= '0' && ch <= '9') {
				if (ch == tm1 || ch == tm2) {
					if (!(ch >= '0' && ch <= '9')) {
						check = true;
				}
			}
			System.out.println(check);
		}*/
		
		
		// 1번
		
		boolean contain = false;
		
		for(int i = 0; i < str.length(); ++i) {
		// for (int i = 0; i < str.length() && !contain; ++i) 을 사용하더라도 반복문 탈출을 함
			
			char ch = str.charAt(i);
			
			if (ch >= 'A' && ch <= 'Z' || ch >= 'a' && ch <= 'z') {
				contain = true;
				break;
			}
		}
		
		System.out.println("영어가 한번이라도 나온적 있나요?" + contain);
		System.out.println("======================================");
		
		//2번
		
		boolean only_alpha = true;
		
		for (int i = 0; i < str.length(); ++i) {
			
			char ch = str.charAt(i);
			
			if (!((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z'))) {
				only_alpha = false;
				break;
			}
		}
		
		System.out.println("영어만 나왔나요? " + only_alpha);
		System.out.println("======================================");
		
		//3번
		
		boolean first_letter_check = true, letter_check = true;
		
		//first_letter_check = (str.charAt(0) >= '0' && str.charAt(0) <= '9');
		// ㄴ 이하 if문 대체 가능
		
		
		if (str.charAt(0) >= '0' && str.charAt(0) <= '9') {
			first_letter_check = false;
		}
		
			for (int i = 0; i < str.length(); ++i) {
				char ch = str.charAt(i);
			
				if (!(ch >= '0' && ch >= '9' || ch >= 'a' && ch <= 'z' || ch == '_' || ch == '$')) {  // 들어가야하는 문자가 (!) 아닐 때
					letter_check = false;
					break;
			}
			
		}
		System.out.println("올바른 문자열인가요?" + first_letter_check);
		System.out.println("올바른 문자열인가요?" + letter_check);
		System.out.println("======================================");

		
	/*		//String alpha = ""; //우선 남겨둠 잘못된 내가 적은답.
			
			for (int i = text.charAt(0); i >= 0; ++i) {			 
			if (str.charAt(i) >= 'a' && str.charAt(i) <= 'z' || 
					str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') {
				System.out.println(true);
				break;
			}else {
				System.out.println(false);
				break;
			}*/

	}
}

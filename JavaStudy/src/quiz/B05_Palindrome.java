package quiz;

import java.util.Scanner;

public class B05_Palindrome {
	
	/*
		사용자로부터 단어를 하나 입력받고 
		해당 단어가 회문이라면 "PALINDROME"을 출력
		회문이 아니라면 "NOT PALINDROME"을 출력
		
		※ 회문이란 - MOM, BOB, ABBA, MADAM, EVE, TXT
	
	*/
	public static void main(String[] args) {
		
		String str = "LEVEL";
		
		int half = str.length() /2;
		int correct = 0;
		
		for(int i = 0; i < str.length() /2; ++i) {
			
			char front = str.charAt(i);
			char back = str.charAt(str.length() - 1 - i);
			
			System.out.printf("'%c'와 '%c'를 비교합니다.\n", front, back);
			
			if (front == back) {
				correct++;
			}
		}
		if (correct == half) {
			System.out.println("PALINDROME");
		}else {
			System.out.println("NOT PALINDROME");
		}
		
		
		/*
		
		String reverse = "";
		
		for (int i = str.length()- 1; i > -1; --i) {
			reverse += str.charAt(i);
		}
		
		if (word.equals(end)) {
			System.out.println("PALINDROME");
		}else {
			System.out.println("NOT PALINDROME");
		}
		
		//내가 쓴거
		Scanner sc = new Scanner(System.in);		
		
		String word;
		String end = "";
		
		System.out.print("단어를 입력 > ");
		word = sc.nextLine();
		
		int length = word.length(); 
		
		for (int i = length - 1; i >= 0; --i) {
			end += word.charAt(i);
		}
		if (word.equals(end)) {
			System.out.println("PALINDROME");
		}else {
			System.out.println("NOT PALINDROME");
		}*/
	}
}

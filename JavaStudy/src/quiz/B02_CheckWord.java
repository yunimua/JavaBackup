package quiz;

import java.util.Scanner;

public class B02_CheckWord {

	/*
		사용자로부터 단어를 하나 입력받고
		첫 번째 글자가 영어이면서 마지막 번째 글자와 일치하면 "OK"를 출력하고
		일치하지 않으면 "NOT OK"를 출력해보세요.
	
	*/
	
	public static void main(String[] args) {
		/*
		Scanner sc = new Scanner(System.in);

		String word;
		boolean lowercase, uppercase;
		
		System.out.print("단어를 입력하세요 >>");
		word = sc.nextLine();
		
		lowercase = word.charAt(0) >= 'a' && word.charAt(0) <= 'z';
		uppercase = word.charAt(0) >= 'A' && word.charAt(0) <= 'Z';
		
		if (word.charAt(0) != word.charAt(word.length() - 1)) {
			System.out.println("NOT OK");
		}else if (lowercase || uppercase) {
			System.out.println("OK");
		}else {
			System.out.println("NOT OK");
		}
		*/
		
		Scanner sc = new Scanner(System.in);
 		String word;
 		
		System.out.print("단어를 입력하세요 >>");
		word = sc.nextLine();
		 		 
		char first_letter = word.charAt(0);
		char last_letter = word.charAt(word.length() - 1);
		
		boolean match = first_letter == last_letter;
		boolean alphabet = ((first_letter >= 'A') && (word.charAt(0) <= 'Z')) || 
							((first_letter >= 'a') && (word.charAt(0) <= 'z'));

		if (match && alphabet) {
		 	System.out.println("OK");
		}else {
			System.out.println("NOT OK");
		 
		 }
		
		 
	}
}

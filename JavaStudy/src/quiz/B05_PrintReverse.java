package quiz;

import java.util.Scanner;

public class B05_PrintReverse {

	// 사용자가 어떤 문장을 입력하면 그 문장을 거꾸로 출력해보세요.
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String text;
		
		System.out.print("문장을 입력 > ");
		text = sc.nextLine();
		
		for (int i = text.length()- 1; i > -1; --i) {
			System.out.print(text.charAt(i));
		}
		
		
		
		
		
		/*
		Scanner sc = new Scanner(System.in);
		
		String text;
		
		System.out.print("문장을 입력 > ");
		text = sc.nextLine();
		
		int cha = text.length()-1;
		
		for (int i = cha; i >= 0; --i) {
			System.out.println(text.charAt(i));
		}*/
	}
}

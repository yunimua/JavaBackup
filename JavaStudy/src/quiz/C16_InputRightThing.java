package quiz;

import java.util.InputMismatchException;
import java.util.Scanner;

public class C16_InputRightThing {

	/*
		사용자로부터 숫자를 입력받되 숫자를 제대로 입력받을 때 까지 계속 입력받는 프로그램을 만들어보세요.
		(다른 타입의 값이 입력되어도 프로그램이 강제종료 되지 않아야 합니다)
	*/
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int num = 0;
		
		while(true) {
			try {
			System.out.print("숫자를 입력하세요 > ");
			num = sc.nextInt();
			System.out.println("입력한 숫자 : " + num);
			break;
			
			} catch (InputMismatchException e) {
				System.out.println("문자를 입력하면 안됩니다.");
				System.out.println("잘못 입력됐던 것 : " + sc.nextLine());
//			} finally {
//				sc.nextLine();
			}
		}
		System.out.println("숫자가 입력되어 종료됩니다.");
	}
}

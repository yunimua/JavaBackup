package myobj.checkpass;

import java.util.Scanner;

public class InputPassword {

	static Scanner sc = new Scanner(System.in);
	
	final static int MIN_DICE_NUM = 8;
	final static int MAX_DICE_NUM = 24;
	
	static String inputp;
	
	public static void passwoed() {
		System.out.print("설정할 패스워드를 입력하세요 > ");
		inputp = sc.nextLine();
	}

	public static void inputNumber() throws NotAllNumberException {
		String s = inputp;
		
		int num = Integer.valueOf(s); //+문자를 숫자로..
		
		if (!(num >= 0 && num <= 9)) {
			throw new NotAllNumberException();
		} 
	}
	
	public static void inputSpecial() throws SpecialCharException {

		
	}
	
	public static void lmitNumber() throws lmitNumberException {
		for (int i = 0; i < MAX_DICE_NUM; ++i) {
			
		}
	}
	
	public static void main(String[] args) {
		while(true) {
			try {
				passwoed();
				inputNumber();
				inputSpecial();
				lmitNumber();
				break;
			} catch (NotAllNumberException e) {
				System.out.println("숫자만 입력할 수 없습니다.");
			} catch (SpecialCharException e) {
				System.out.println("특수문자는 [!, @, #, $, %, ^, &, *]만 사용 가능합니다.");
			} catch (lmitNumberException e) {
				System.out.println("패스워드는 8자 이상, 24자 이하로 입력해주세요.");
			} catch (NumberFormatException e) { //+ 숫자, 문자 동시 입력시 에러에 대한 예외처리
				
			}
		}
		System.out.println("패스워드 설정이 완료되었습니다.");
	}	
}

class NotAllNumberException extends Exception {
	public NotAllNumberException() {
		super("숫자만 입력할 수 없습니다.");
	}
}

class SpecialCharException extends Exception {
	public SpecialCharException() {
		super("특수문자는 [!, @, #, $, %, ^, &, *]만 사용 가능합니다.");
	}
}

class lmitNumberException extends Exception {
	public lmitNumberException() {
		super("패스워드는 8자 이상, 24자 이하로 입력해주세요.");
	}
}
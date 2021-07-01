package quiz;

import java.util.ArrayList;
import java.util.HashMap;

import myobj.Student;

public class D07_CheckValidPhoneNumber {

	/*
		사용자로부터 입력받은 문자열이 핸드폰 번호인지 구분하는 프로그램을 만들어보세요
		
		핸드폰번호가 이루어진 조건? 010으로 시작, 총 11자리다
	*/
	private static boolean checkNumeric(char[] phoneNumber)  {
		for (int i = 0; i < phoneNumber.length; ++i) {
			if ((i == 3 || i == 8) && phoneNumber[i] == '-') {
				continue;
			}else if (!(i == 3 && i == 8) && Character.isDigit(phoneNumber[i])) {
				continue;
			}else {
				return false;
			}
		}
		return true;
	}

	public static void checkValidPhoneNumber(char[] phoneNumber) {
		boolean vaild = true;
		
		String front = "" + phoneNumber[0] + phoneNumber[1] + phoneNumber[2]; 					//+ ""를 넣지않으면 숫자값으로 더해진다
		
		if (!front.equals("010")) {
			vaild = false;
			System.out.println("[WARNING] 맨 앞 숫자가 허용되지 않는 숫자입니다.");
		}else if(phoneNumber.length != 13) {
			vaild = false;
			System.out.println("[WARNING] 핸드폰 번호의 길이가 아닙니다.");
		}else if(!checkNumeric(phoneNumber)) {
			vaild = false;
			System.out.println("[WARNING] 숫자 아닌 문자가 포함되었거나 -의 위치가 이상합니다.");
		}
		System.out.println(new String(phoneNumber) + "는 "
				+ (vaild ? "올바른 핸드폰 번호입니다." : "올바르지 않은 핸드폰 번호입니다."));
	}
	
	
//	String phoneNumber;
//	String numberCount;
//	boolean numCheck;
//	ArrayList<String> number;
//	
//	public D07_CheckValidPhoneNumber() {
//		number = new ArrayList<>();
//	}
//	
//	public D07_CheckValidPhoneNumber(String phoneNumber) {
//		this.phoneNumber = phoneNumber;
//	}
//	
//	public void checkNumber(String phoneNumber) {
//		number.add(phoneNumber);
//		for (String chk : number) {
//			if(number.size() != 11) {
//				System.out.println("휴대폰 번호 자리 수가 부족합니다.");
//			}
//		}
//	}
	
	public static void main(String[] args) {
		checkValidPhoneNumber("010-ssss-2345".toCharArray());	
		checkValidPhoneNumber("010-3344-2345".toCharArray());
		checkValidPhoneNumber("010-344-12345".toCharArray());
		checkValidPhoneNumber("010-344-2345".toCharArray());
		checkValidPhoneNumber("011-3414-3145".toCharArray());
	}
}

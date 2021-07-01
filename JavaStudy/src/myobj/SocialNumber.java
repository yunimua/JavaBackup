package myobj;

public class SocialNumber {

		/*
		사용자가 주민등록번호를 입력하면
		그 주민등록번호가 유효한지 검사하는 프로그램을 만들어보세요
		
		맨 앞자리 숫자
		월 자리에 01~12 이내의 숫자
		일 자리에 01~31 이내의 숫자
		(1,3,5,7,8,10,12월이면 31 / 4,6,9,11월이면 30 / 2월은 윤년일때 29, 아니면 28)
		7번째 자리 '-'
		뒷자리 전부숫자	
		
		윤년체크 : (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0))
		
	*/
	
	// 문자열 체크
	private static boolean checkSocial(char[] socialNumber)  {
		for (int i = 0; i < socialNumber.length; ++i) {
			if ((i == 6) && socialNumber[i] == '-') {
				continue;
			}else if (Character.isDigit(socialNumber[i])) { 											//+ isDigit : 지정된 문자가 숫자인지 판별합니다.
				continue;
			}else {
				return false;
			}
		}
		return true;
	}
	
	// 윤년 2월 체크
	private static boolean checkYear(char[] socialNumber)  {
		for (int i = 0; i < socialNumber.length; ++i) {
			int chk1 = (char) (socialNumber[0]-48)*10;
			int chk2 = (char) (socialNumber[1]-48);
			int sum = chk1+chk2;
			if (!((sum % 400 == 0 || (sum % 4 == 0 && sum % 100 != 0)))) {
				continue;
			}else if (!((socialNumber[2] =='0') && (socialNumber[3] =='2'))) {
				continue;
			}else {
				return checkDay29(socialNumber);
			}
		}
		return checkDay31(socialNumber);
	}
	
	// 월(1~12) 체크
	private static boolean checkMonth(char[] socialNumber)  {
		for (int i = 0; i < socialNumber.length; ++i) {
			if ((socialNumber[2] == '0') && (socialNumber[3] >= '1' && socialNumber[3] <= '9')) {
				continue;
			}else if ((socialNumber[2] == '1') && (socialNumber[3] >= '0' && socialNumber[3] <= '2')) {
				continue;
			}else {
				return false;
			}
		}
		return true;
	}
	
	// 윤년 2월 29일 체크
	private static boolean checkDay29(char[] socialNumber)  {
		for (int i = 0; i < socialNumber.length; ++i) {
			if ((socialNumber[4] == '0') && (socialNumber[5] >= '1' && socialNumber[5] <= '9')) {
				continue;
			}else if ((socialNumber[4] == '1') && (socialNumber[5] >= '0' && socialNumber[5] <= '9')) {
				continue;
			}else if ((socialNumber[4] == '2') && (socialNumber[5] >= '0' && socialNumber[5] <= '9')) {
				continue;
			}else {
				return false;
			}
		}
		return true;
	}
	
	// 일반 31일 체크
	private static boolean checkDay31(char[] socialNumber)  {
		for (int i = 0; i < socialNumber.length; ++i) {
			if ((socialNumber[4] == '0') && (socialNumber[5] >= '1' && socialNumber[5] <= '9')) {
				continue;
			}else if ((socialNumber[4] == '1') && (socialNumber[5] >= '0' && socialNumber[5] <= '9')) {
				continue;
			}else if ((socialNumber[4] == '2') && (socialNumber[5] >= '0' && socialNumber[5] <= '9')) {
				continue;
			}else if ((socialNumber[4] == '3') && (socialNumber[5] >= '0' && socialNumber[5] <= '1')) {
				continue;
			}else {
				return false;
			}
		}
		return true;
	}
	
	
	public static void checkValidSocialNumber(char[] socialNumber) {
		boolean vaild = true;
		
		if (socialNumber.length != 14) {
			vaild = false;
			System.out.println("[WARNING] 주민등록번호 입력 수가 잘못되었습니다.");
		}else if(!checkSocial(socialNumber)) {
			vaild = false;
			System.out.println("[WARNING] 모두 숫자가 아니거나 -위치가 잘못 입력되었습니다");
		}else if(!checkMonth(socialNumber)) {
			vaild = false;
			System.out.println("[WARNING] MONTH가 잘못 입력되었습니다.");
		}else if(!checkYear(socialNumber)) {
			vaild = false;
			System.out.println("[WARNING] DAY가 잘못 입력되었습니다.");
		}else if(!checkDay31(socialNumber)) {
			vaild = false;
			System.out.println("[WARNING] DAY가 잘못 입력되었습니다.");
		}
		System.out.println(new String(socialNumber) + "는 "
				+ (vaild ? "올바른 주민등록번호입니다." : "올바르지 않은 주민등록번호입니다."));
		System.out.println();
	}
	
	public static void main(String[] args) {
		System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒[정상입력] Check");
		checkValidSocialNumber("001130-3087010".toCharArray());
		System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒[-,문자열] Check");
		checkValidSocialNumber("2102054-034010".toCharArray());
		checkValidSocialNumber("890325-s061210".toCharArray());
		System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒[월1~12] Check");
		checkValidSocialNumber("993028-1067610".toCharArray());
		System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒[윤년] Check");
		checkValidSocialNumber("920229-1067610".toCharArray());
		checkValidSocialNumber("920230-1067610".toCharArray());
		// 윤년 아닐때, 28일로 체크되어야 하지만 추가못함..
		//checkValidSocialNumber("850229-1067610".toCharArray());
	}
}

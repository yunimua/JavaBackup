package quiz;

import java.util.Scanner;

public class B03_MonthToSeason {

	/*	
		사용자로부터 달을 입력받으면 해당하는 계절을 출력해보세요
		(switch-case문을 사용할 것)
		
		12~2월 겨울
		3~5월 봄
		6~8월 여름
		9~11월 가을
	*/

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int month;
		
		System.out.print("몇 월인가요? > ");
		month = sc.nextInt();
		
		String season;
		
		switch (month) {
		case 12 : case 1 : case 2:
			season = "겨울";
			break;
		case 3 : case 4 : case 5:
			season = "봄";
			break;
		case 6 : case 7 : case 8:
			season = "여름";
			break;
		case 9 : case 10 : case 11:
			season = "가을";
			break;
		default :
			season = "계절없음";
			break;
		}
		
		if (month < 1 || month > 12) {
			System.out.println("잘못된 입력입니다.");
		}else {
			System.out.printf("%d월은 %s입니다.\n", month, season);
		}
		
		//  ㄴ season 이 case에 해당하지 않는 경우에는 경우의 수가 있기 때문에 default 가 필요
		
		
		/* 내가 작성한 내용... // case를 몰아서 작성가능
		switch (month) {
		
		case 1 :
			System.out.println("입력하신 월은 겨울입니다.");
			break;
		case 2 :
			System.out.println("입력하신 월은 겨울입니다.");
			break;
		case 3 :
			System.out.println("입력하신 월은 봄입니다.");
			break;
		case 4 :
			System.out.println("입력하신 월은 봄입니다.");
			break;
		case 5 :
			System.out.println("입력하신 월은 봄입니다.");
			break;
		case 6 :
			System.out.println("입력하신 월은 여름입니다.");
			break;
		case 7 :
			System.out.println("입력하신 월은 여름입니다.");
			break;
		case 8 :
			System.out.println("입력하신 월은 여름입니다.");
			break;
		case 9 :
			System.out.println("입력하신 월은 가을입니다.");
			break;
		case 10 :
			System.out.println("입력하신 월은 가을입니다.");
			break;
		case 11 :
			System.out.println("입력하신 월은 가을입니다.");
			break;
		case 12 :
			System.out.println("입력하신 월은 겨울입니다.");
			break;
		default :
			System.out.println("해당하는 계절이 없습니다.");
			break;	
			*/
	}
}

package quiz;

import java.util.Scanner;

public class B09_ConverSecond {

	/*
		초를 입력받으면 년/일/시간/분/초로 변환하여 출력해보세요.
		
		※ 단, 필요없는 단위는 출력하지 말 것
		
		ex: 0년 0일 13시간 0분 5초 인 경우 > 13시간 0분 5초만 나와야 함
	
	*/
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("초를 입력 > ");
		int second = sc.nextInt();
		
		int[] converted = new int[4];   // 모두 0이 들어가있다
		int[] seconds = new int[4];		// 계산식
		String[] units = {"년", "일", "시간", "분"};
		
		seconds[0] = 365 * 24 * 60 * 60;
		seconds[1] = 24 * 60 * 60;
		seconds[2] = 60 * 60;
		seconds[3] = 60;
		
		for (int i = 0; i < converted.length; ++i) { // seconds.length를 해도됨
			converted[i] = second / seconds[i];
			second %= seconds[i];
		}
		
		boolean exist = false;
		
		for (int i = 0; i < converted.length; ++i) {
			if (converted[i] !=0 || exist) {
				System.out.printf("%d%s ", converted[i], units[i]);
				exist = true;
			}
		}
		System.out.printf("%d초", second);
		System.out.println();
		
		
//		int y = 0, d = 0, h = 0, m = 0, s = 0;
//		
//		final int SECOND_PER_YEAR = 365 * 24 * 60 * 60; // 년, 일, 시간, 분
//		final int SECOND_PER_DAY = 24 * 60 * 60;
//		final int SECOND_PER_HOUR = 60 * 60;
//		final int SECOND_PER_MINUTE = 60;
//		
//		System.out.printf("'%d'초는 변환하면 ", second);
//		
//		y = second / SECOND_PER_YEAR;
//		second %= SECOND_PER_YEAR;
//		
//		d = second / SECOND_PER_DAY;
//		second %= SECOND_PER_DAY;
//		
//		h = second / SECOND_PER_HOUR;
//		second %= SECOND_PER_HOUR;
//		
//		m = second / SECOND_PER_MINUTE;
//		second %= SECOND_PER_MINUTE;
//		
//		boolean exist = false;
//		
//		if (y != 0) { // 년이 0이 아닐 때 출력
//			System.out.print(y + "년 ");
//			exist = true;
//		}
//		if (d != 0 || exist) { // 일이 0이 아닐 때 출력 // 0이 아니거나 앞에서 출력되거나
//			System.out.print(d + "일 ");
//			exist = true;
//		}
//		if (h != 0 || exist) { // 시간이 0이 아닐 때 출력
//			System.out.print(h + "시간 ");
//			exist = true;
//		}
//		if (m != 0 || exist) { // 분이 0이 아닐 때 출력
//			System.out.print(m + "분 ");
//			exist = true;
//		}
//		System.out.println(second + "초");
		
		
//		int year = second / (60 * 60 * 24 * 365);
//		second %= (60 * 60 * 24 * 365);
//		
//		int day = second / (60 * 60 * 24);
//		second %= (60 * 60 * 24);
//		
//		int hour = second / (60 * 60);
//		second %= (60 * 60);
//		
//		int min = second / 60;
//		second %= 60;
//		
//		second %= 60;
//		int se = second;
//		
//		if (year != 0) {
//			System.out.printf("입력하신 초는 : %d년 %d일 %d시간 %d분 %d초 입니다.", year, day, hour, min, se);
//		}else if (day != 0) {
//			System.out.printf("입력하신 초는 : %d일 %d시간 %d분 %d초 입니다.", day, hour, min, se);
//		}else if (hour != 0) {
//			System.out.printf("입력하신 초는 : %d시간 %d분 %d초 입니다.", hour, min, se);
//		}else if (min != 0) {
//			System.out.printf("입력하신 초는 : %d분 %d초 입니다.", min, se);
//		}else {
//			System.out.printf("입력하신 초는 : %d분 %d초 입니다.", se);
//		}
	}
}

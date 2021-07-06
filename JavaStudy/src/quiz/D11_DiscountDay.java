package quiz;

import java.text.*;
import java.util.*;

public class D11_DiscountDay {

	/*
		어떤 옷가계에서 할인 행사를 짝수번째 목요일마다 진행한다고 한다
		년도를 입력하면 해당 년도의 모든 할인 날짜를 출력해주는 프로그램을 만들어보세요	
	*/
	
	public static void main(String[] args) {
		
		int year = 2031;
		printEventOfYear(year);

		// get_year(2020);
	}
	
	public static Calendar getFristEventDay(int year) { //+ 첫번째 목요일로 세팅
		Calendar event = Calendar.getInstance();
		event.set(year, 0, 1);
		event.set(Calendar.DAY_OF_WEEK, Calendar.THURSDAY);
		
//		while (event.get(Calendar.DAY_OF_WEEK) != Calendar.THURSDAY) {
//			event.add(Calendar.DATE, 1);
//		}
		
		if (event.get(Calendar.YEAR) != year) { //+ 현재 년도와 같지 않을 때
			event.add(Calendar.DATE, 7); //+ 첫번째 목요일에서 7을 더함 = 두번째 목요일
		}
		return event;
	}
	
	public static void printEventOfYear(int year) {
		SimpleDateFormat eventDateFormat = new SimpleDateFormat("[y년 이벤트] M월 d일 E요일");
		Calendar event = getFristEventDay(year);
		
		int count = 1;
		
		while(event.get(Calendar.YEAR) == year) {
			event.add(Calendar.DATE, 7);
			
			if (event.get(Calendar.DAY_OF_WEEK_IN_MONTH) % 2 == 0) { //+ 첫번째 목요일을 찾고 짝수일 때 출력
				System.out.println(eventDateFormat.format(event.getTime()));
				count++;
			}
		}
		System.out.println("올해의 이벤트는 총 " + count + "회 입니다.");
	}
	
//	public static void get_year(int year) {
//		Calendar calendar = Calendar.getInstance();
//		SimpleDateFormat show = new SimpleDateFormat("yyyy/MM/dd EEEEE");
//		
//		calendar.set(Calendar.YEAR, year);
//		
//		for(int i = 0; i < 12; i++){
//			calendar.set(Calendar.MONTH, i); //+ 월
//			calendar.set(Calendar.WEEK_OF_MONTH, 2); //+ 해당 월의 2째주
//			calendar.set(Calendar.DAY_OF_WEEK, 5); //+ 해당 주의 목요일(5)
//			System.out.println(show.format(calendar.getTime())+"-- ☆2번째 목요일 할인행사☆");
//			calendar.set(Calendar.WEEK_OF_MONTH, 4); //+ 해당 월의 4째주
//			calendar.set(Calendar.DAY_OF_WEEK, 5);
//			System.out.println(show.format(calendar.getTime())+"-- ☆4번째 목요일 할인행사☆");
//		}
//	}
//	
//	//소영님 풀이
//	public static void discountD(int year) {
//		SimpleDateFormat current = new SimpleDateFormat("yyyy년 MM월 dd일 / EEEEE");
//		Calendar calendar = Calendar.getInstance();
//		calendar.set(year - 1, 12, 31);
//		calendar.set(Calendar.DAY_OF_WEEK, 5); //+해당 주의 목요일(5)
//		
//		for (;calendar.get(Calendar.YEAR) == year; calendar.set(Calendar.DATE, calendar.get(Calendar.DATE)+7)) {
//			if(calendar.get(Calendar.DAY_OF_WEEK_IN_MONTH) % 2 == 0) {
//				System.out.println(current.format(calendar.getTime()));
//			}
//		}
//	}
}

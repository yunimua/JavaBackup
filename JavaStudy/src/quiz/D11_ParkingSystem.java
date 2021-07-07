package quiz;

import java.time.*;
import java.util.*;

import myobj.Parking.*;

public class D11_ParkingSystem {

	/*
		1. 자량 5부제 끝자리 번호 체크 (4자리중 마지막 숫자)
			- 월요일 : 1, 6
			- 화요일 : 2, 7
			- 수요일 : 3, 8
			- 목요일 : 4, 9
			- 금요일 : 5, 0
			- 공휴일 : 제외
		
		2. 시행일자 : 2018년 9월 1일
		
		3. 공휴일(음력제외) 
			- 신정 1월 1일
			- 삼일절 3월 1일
			- 어린이날 5월 5일
			- 현충일 6월 6일
			- 광복절 8월 15일
			- 개천절 10월 3일
			- 한글날 10월 9일
			- 크리스마스 12월 25일
			
		4. 제외 차량 : 장애인, 유아동승, 경차
			- 일반 차량 제외
	 */
	
	private static ArrayList<LocalDate> holidays = new ArrayList<>() {
		private static final long serialVersionUID  = 1L; // 노란줄 나와서 추가한거다..??
		{
			this.add(LocalDate.of(2000, 1, 1)); // 익명 클래스를 만든것이다. : C14_AnonymousInnerClass 참고
			this.add(LocalDate.of(2000, 3, 1));	// 비교하기 위해 값을 채워넣어둠
			this.add(LocalDate.of(2000, 5, 5));
			this.add(LocalDate.of(2000, 6, 6));
			this.add(LocalDate.of(2000, 8, 15));
			this.add(LocalDate.of(2000, 10, 3));
			this.add(LocalDate.of(2000, 10, 9));
			this.add(LocalDate.of(2000, 12, 25));
		}
	};
	
	private boolean checkHoliday(Car car) {
		LocalDate Park_date = car.getPark_date();
		
		for(LocalDate holiday : holidays) { //holidays를 하나씩 꺼내서 비교
			if (holiday.getDayOfMonth() == Park_date.getDayOfMonth()
					&& holiday.getMonthValue() == Park_date.getMonthValue()) {
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		D11_ParkingSystem parking = new D11_ParkingSystem();
		
		for (int i = 0; i < 100; ++i) {
			Car car = new Car();
			
			if (parking.checkHoliday(car)) {
				System.out.println(car.getPark_date() + "는 공휴일입니다.");
			}else {
				System.out.println(car.getPark_date() + "는 공휴일이 아닙니다.");
			}
		}
	}
	
}

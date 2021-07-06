package quiz;

import java.text.*;
import java.time.*;
import java.util.*;

public class D11_Restriction {

	/*
		1. 자량 5부제 끝자리 번호 체크 (4자리중 마지막 숫자)
			- 월요일 : 1, 6
			- 화요일 : 2, 7
			- 수요일 : 3, 8
			- 목요일 : 4, 9
			- 금요일 : 5, 0
			- 공휴일 : 제외
		
		2. 시행일자 : 2018년 9월 1일
		3. 공휴일(음력제외) : 신정 1월 1일, 삼일절 3월 1일, 어린이날 5월 5일, 현충일 6월 6일, 
					광복절 8월 15일, 개천절 10월 3일, 한글날 10월 9일, 크리스마스 12월 25일
		4. 제외 차량 : 장애인(disabled= 'd'), 유아동승(infantRide= 'i'), 경차(lightCar= 'l')
			- 일반 차량 (normal= 'n')
			- 출입제한 / Access restricted
		
		기본적으로 토요일, 일요일은 제한이 없다
		공휴일은 제한이 없다
		제외차량은 제한이 없다
		시행일자 이전엔 제한이 없다
		
		해당 날짜에 해당하는 요일을 체크하여 차번호 끝자리 제한요일에 해당하는지 체크
	*/
	
	String carNumber; // 차량번호 4자리
	int carType; // 차량타입 = 0:일반, 1:장애인, 2:유아동승, 3:경차
	long date; // 날짜(현재안씀), now 기준으로(로컬 현재 날짜) 체크중..
	Calendar calendar;
		
	boolean except; // 적용제외 타입 체크
	boolean weekend; // 토, 일 (주말) 체크
	boolean holiday; // 주중 체크(월~금)
	boolean start; // 시행일자 시작일
	
	public D11_Restriction(String carNumber, int carType) {
		this.carNumber = carNumber;
		this.carType = carType;
		calendar = Calendar.getInstance();
	}
	
	public static String currentDate(Calendar calendar) {
		SimpleDateFormat current = new SimpleDateFormat("yyyy/MM/dd E요일 ");
	   
		return current.format(calendar.getTime());
	}

	// 적용제외 체크
	boolean checkExceptCar() { //+ 제외차량 체크
		if ((carType > 0 && carType < 4)) {
			except = true;
		}else if (carType == 0) {
			except = false;
		}else {
			System.out.println("차량 타입을 다시 확인해주세요. -- 0:일반, 1:장애인, 2:유아동승, 3:경차");
		}
		return except;
	}
	
	// 주말 체크
	boolean checkWeekEnd() { 
		int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
		
		if (dayOfWeek == 1 || dayOfWeek == 7) {
			weekend = true;
		}
		return weekend;
	}
	
	// 공휴일 체크
	boolean checkHoliday() {
		int year = 2021;
		LocalDate chkday = LocalDate.now();
		LocalDate newYear = LocalDate.of(year, 1, 1); // 신정
		LocalDate march1 = LocalDate.of(year, 3, 1); // 삼일절
		LocalDate children = LocalDate.of(year, 5, 5); // 어린이날
		LocalDate memorial = LocalDate.of(year, 6, 6); // 현충일
		LocalDate liberation = LocalDate.of(year, 8, 15); // 광복절
		LocalDate dayOfKorea = LocalDate.of(year, 10, 3); // 개천절
		LocalDate hangul = LocalDate.of(year, 10, 9); // 한글날
		LocalDate christmas = LocalDate.of(year, 12, 25); // 크리스마스
		
		if (newYear.equals(chkday)) {
			holiday = true;
		}else if (march1.equals(chkday)) {
			holiday = true;
		}else if (children.equals(chkday)) {
			holiday = true;
		}else if (memorial.equals(chkday)) {
			holiday = true;
		}else if (liberation.equals(chkday)) {
			holiday = true;
		}else if (dayOfKorea.equals(chkday)) {
			holiday = true;
		}else if (hangul.equals(chkday)) {
			holiday = true;
		}else if (christmas.equals(chkday)) {
			holiday = true;
		}
		return holiday; 
	}
	
	// 시행일자 전인지 체크 
	boolean checkStartday() {
		LocalDate startDay = LocalDate.of(2018, 8, 1);
		LocalDate chkday = LocalDate.now();
		
		return startDay.isAfter(chkday);
	}


	// 주중(월~금) 체크, 차량번호 끝자리 확인
	void checkWeekday() { 
		int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
		
		if (dayOfWeek == 2) {
			if (carNumber.endsWith("1") || carNumber.endsWith("6")) {
				System.out.println("▶[carNumber : " + carNumber +"] "
										+ "\n▶▶[※출입제한※] 월요일입니다."
										+ "\n▶▶▶[Monday_EndCarNumber : 1, 6]");
			}else {
				System.out.println("[Monday_EndCarNumber : 1, 6] 해당하지 않는 요일입니다");
			}
		}else if (dayOfWeek == 3) {
			if (carNumber.endsWith("2") || carNumber.endsWith("7")) {
				System.out.println("▶[carNumber : " + carNumber +"] "
										+ "\n▶▶[※출입제한※] 화요일입니다."
										+ "\n▶▶▶[Tuesday_EndCarNumber : 2, 7]");
			}else {
				System.out.println("[Tuesday_EndCarNumber : 2, 7] 해당하지 않는 요일입니다");
			}
		}else if (dayOfWeek == 4) {
			if (carNumber.endsWith("3") || carNumber.endsWith("8")) {
				System.out.println("▶[carNumber : " + carNumber +"] "
										+ "\n▶[※출입제한※] 수요일입니다."
										+ "\n▶▶▶[Wednesday_EndCarNumber : 3, 8]");
			}else {
				System.out.println("[carNumber : " + carNumber + "]\n[Wednesday_EndCarNumber : 3, 8] 해당하지 않는 요일입니다");
			}
		}else if (dayOfWeek == 5) {
			if (carNumber.endsWith("4") || carNumber.endsWith("9")) {
				System.out.println("▶[carNumber : " + carNumber +"] "
										+ "\n▶▶[※출입제한※] 목요일입니다."
										+ "\n▶▶▶[Thursday_EndCarNumber : 4, 9]");
			}else {
				System.out.println("[Thursday_EndCarNumber : 5, 0] 해당하지 않는 요일입니다");
			}
		}else if (dayOfWeek == 6) {
			if (carNumber.endsWith("5") || carNumber.endsWith("0")) {
				System.out.println("▶[carNumber : " + carNumber +"] "
										+ "\n▶▶[※출입제한※] 금요일입니다."
										+ "\n▶▶▶[Friday_EndCarNumber : 5, 0]");
			}else {
				System.out.println("[carNumber : " + carNumber + "]\n[Friday_EndCarNumber : 5, 0] 해당하지 않는 요일입니다");
			}
		}
	}
	
	// 제외되는 조건 체크
	public void result() {
		// 현재 날짜 출력
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("◆Today : " + currentDate(calendar));
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━┛");

		if (checkStartday()) {
			System.out.println(currentDate(calendar) + "▷▷▷ [시행 전] ▷▷▷ 자동차 5부제가 시행 전입니다.");
		}else if(checkWeekEnd()) {
			System.out.println(currentDate(calendar) + "▷▷▷ [주말제외] ▷▷▷ 주말(토/일)에는 제한이 없습니다.");
		}else if(checkHoliday()) {
			System.out.println(currentDate(calendar) + "▷▷▷ [공휴일제외] ▷▷▷ 공휴일에는 제한이 없습니다.");
			System.out.println("▷▷▷ 공휴일 :\n 01월 01일 [신정]\n 03월 01일 [삼일절]\n 05월 05일 [어린이날]\n 06월 06일 [현충일]\n"
								+ " 08월 15일 [광복절]\n 10월 09일 [한글날]\n 12월 25일 [크리스마스]\n");
		}else if(checkExceptCar()) {
			System.out.println("[carType : " + carType + "]\n" + "▷▷▷ 제한이 제외되는 차량입니다. [제외] 1:장애인, 2:유아동승, 3:경차");
		}else {
			checkWeekday();
		}
	}
	
	public static void main(String[] args) {
		
		D11_Restriction r1 = new D11_Restriction("0643", 0); // 차량번호, 차량 타입
		r1.result();
		
		D11_Restriction r2 = new D11_Restriction("0990", 0);
		r2.result();
		
		D11_Restriction r3 = new D11_Restriction("0641", 2); 
		r3.result();

	}
}

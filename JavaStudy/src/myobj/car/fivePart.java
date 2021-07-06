package myobj.car;

import java.text.*;
import java.time.*;
import java.time.format.*;
import java.util.*;

public class fivePart {
	// 양력 공휴일 
	private static String[] holiday = {"0101", "0301", "0505", "0606", "0815", "1003", "1009", "1225"};
	
	static String carNum; // 차량번호
	int carType; // 차량타입 // 0:일반, 1:장애인, 2:유아동승, 3:경차
	static String date; // 날짜
	static Calendar calendar;
	static DateTimeFormatter formatter;
	
	boolean except; // 제외 타입
	
	public fivePart(String carNum, int carType, String date) {
		this.carNum = carNum;
		this.carType = carType;
		this.date = date;
		calendar = Calendar.getInstance();
		formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
	}
	
	// 시행일자 체크 : 2018.8.1 시작 ~ 
	boolean isStartday() {
		LocalDate startDay = LocalDate.of(2018, 8, 1);
        LocalDate chkDay = LocalDate.parse(date, formatter);

		return startDay.isAfter(chkDay);
	}
        
	// 차량타입 = 0:일반, 1:장애인, 2:유아동승, 3:경차
	boolean isExceptCar() {
		if ((carType > 0 && carType < 4)) {
			except = true;
		}else if (carType == 0) {
			except = false;
		}else {
			System.out.println("차량 타입을 다시 확인해주세요. -- 0:일반, 1:장애인, 2:유아동승, 3:경차");
		}
		return except;
	}
	
	// 토, 일(주말) 체크
	boolean isWeekEnd() {
		dateFormat();
		return calendar.get(Calendar.DAY_OF_WEEK) == 1 || calendar.get(Calendar.DAY_OF_WEEK) == 7;
	}
	
	// 공휴일 체크 (양력) : 1/1신정, 3/1삼일절, 5/5어린이날, 6/6현충일, 8/15광복절, 10/3개천절, 10/9한글날, 12/25크리스마스	
	boolean isHoliday() {
        return Arrays.toString(holiday).contains(date.substring(4));
		/*
			1. contains(date.substring(4)) : date문자열에 해당 solarArr문자열이 포함되어 있는지 검사
	        2. substring(4) => 문자열(date) 4번째 자리부터 마지막짜지 자른다 
         		ㄴ date가 "20210505"일 경우 앞에 2021(0~3)뒤에 4부터 마지막이므로 0505만 남음	
		*/
    }
	
	// 예외처리
	private static void dateFormat() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		try {
			calendar.setTime(sdf.parse(date));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	// 월요일 차량 끝자리 체크
	boolean isMonday() {
		dateFormat();
        return (calendar.get(Calendar.DAY_OF_WEEK) == 2) && (carNum.endsWith("1") || carNum.endsWith("6"));
    }
	// 화요일 차량 끝자리 체크
	boolean isThesday() { 
		dateFormat();
        return (calendar.get(Calendar.DAY_OF_WEEK) == 3) && (carNum.endsWith("2") || carNum.endsWith("7"));
    }
	// 수요일 차량 끝자리 체크
	boolean isWednesday() { 
		dateFormat();
        return (calendar.get(Calendar.DAY_OF_WEEK) == 4) && (carNum.endsWith("3") || carNum.endsWith("8"));
    }
	// 목요일 차량 끝자리 체크
	boolean isThursday() { 
		dateFormat();
        return (calendar.get(Calendar.DAY_OF_WEEK) == 5) && (carNum.endsWith("4") || carNum.endsWith("9"));
    }
	// 금요일 차량 끝자리 체크
	boolean isFriday() { 
		dateFormat();
        return (calendar.get(Calendar.DAY_OF_WEEK) == 6) && (carNum.endsWith("5") || carNum.endsWith("0"));
    }
	
	private static void printDay() {
		LocalDate chkDay = LocalDate.parse(date, formatter);
		DateTimeFormatter date_format = DateTimeFormatter.ofPattern("y/M/d E요일");
        String check = date_format.format(chkDay);
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("◆CheckDay : " + check);
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
		System.out.println("▶[carNumber : " + carNum +"]");
	}
	
	// 결과 조건 체크
	public void result() {
		// 기준날짜 및 요일, 차량번호 표시
		printDay();
		// 차량타입 체크
		if (isExceptCar()) {
			System.out.println("▶[carType : " + carType + "]\n" 
					+ "▷▷▷ 제한이 제외되는 차량입니다.\n▷▷▷ [제외] 1:장애인, 2:유아동승, 3:경차\n");
		}else if (isStartday()) {
			System.out.println("▷▷▷ [시행 전]\n▷▷▷ 자동차 5부제가 시행 전입니다.\n");
		// 주말 체크
		}else if (isWeekEnd()) {
			System.out.println("▷▷▷ [주말제외]\n▷▷▷ 주말(토/일)에는 제한이 없습니다.\n");
		// 공휴일 체크(양력)
		}else if (isHoliday()) {
			System.out.println("▷▷▷ [공휴일제외]\n▷▷▷ 공휴일에는 제한이 없습니다.");
			System.out.println("▷▷▷ 공휴일 :\n 01월 01일 [신정]\n 03월 01일 [삼일절]\n 05월 05일 [어린이날]\n 06월 06일 [현충일]\n"
					+ " 08월 15일 [광복절]\n 10월 09일 [한글날]\n 12월 25일 [크리스마스]\n");
		// 차량 타입, 요일(주중), 차량끝번호 체크
		}else if(isMonday()) {
			System.out.println("▶▶[※출입제한※] 월요일입니다.\n▶▶▶[Monday_EndCarNumber : 1, 6]\n");
		}else if(isThesday()) {
			System.out.println("▶▶[※출입제한※] 화요일입니다.\n▶▶▶[Thesday_EndCarNumber : 2, 7]\n");
		}else if(isWednesday()) {
			System.out.println("▶▶[※출입제한※] 수요일입니다.\n▶▶▶[Wednesday_EndCarNumber : 3, 8]\n");
		}else if(isThursday()) {
			System.out.println("▶▶[※출입제한※] 목요일입니다.\n▶▶▶[Thursday_EndCarNumber : 4, 9]\n");
		}else if (isFriday()) {
			System.out.println("▶▶[※출입제한※] 금요일입니다.\n▶▶▶[Friday_EndCarNumber : 5, 0]\n");
		}else {
			System.out.println("제한되지 않는 요일입니다\n");
		}
	}
	
	public static void main(String[] args){
		
		fivePart f = new fivePart("0123", 0, "20180731");
		f.result();
		fivePart f1 = new fivePart("0123", 0, "20180801");
		f1.result();
		fivePart f2 = new fivePart("0123", 0, "20210505");
		f2.result();
		fivePart f3 = new fivePart("0123", 0, "20210629");
		f3.result();
		fivePart f4 = new fivePart("0123", 0, "20210630");
		f4.result();
		fivePart f5 = new fivePart("0123", 0, "20210704");
		f5.result();
		fivePart f6 = new fivePart("0123", 2, "20210706");
		f6.result();

	}
}

import java.time.*;
import java.time.format.*;

public class D11_Time {

	/*
		# java.time 패키지
		
		  - Calendar 클래스에서 set()을 하면 원래 인스턴스가 변해버린다는 단점을 보완한 클래스
		  - java.time 패키지의 클래스들은 시간을 변경한 새로운 인스턴스를 반환하는 방식을 통해
		  	원본 인스턴스를 그대로 보존한다
		  - LocalDate, LoclaTime, LocalDateTime... 등이 있다
	*/
	
	public static void main(String[] args) {
		
		// now() : 지금 시간의 인스턴스를 생성하는 메서드
		
		System.out.println("현재시간 : " + LocalTime.now()); //+ 시간만 볼때
		System.out.println("현재 날짜 : " + LocalDate.now()); //+ 날짜만 볼때 
		System.out.println("현재 날짜와 시간 : " + LocalDateTime.now()); //+ 날짜와 시간을 볼때
		
		// of() : 원하는 시간의 인스턴스를 생성하는 메서드
		System.out.println(LocalTime.of(17, 7, 30, 123456789)); //+ 원하는 시간으로 만듬(시,분,초) : 17:07:30.123456789
		System.out.println(LocalDate.of(2021, 3, 5)); //+ 원하는 날짜로 변경 : 2021-03-05
		System.out.println(LocalDate.of(2021, Month.SEPTEMBER, 5)); //+ 원하는 월로 변경 : 2021-09-05
		
		//+ LocalTime.of를 통해 숫자 입력을 할수 있으나, Month.를 통해 다른 숫자가 입력되지 않게 방지가 가능하다
		
		// Month 클래스
		System.out.println(Month.SEPTEMBER.name()); //+ SEPTEMBER
		System.out.println(Month.SEPTEMBER.getValue()); //+ 9
		
		// 변경된 시간 생성하기
		LocalDate now = LocalDate.now();
		LocalDate after3years = now.plusYears(3); //+ 3년후
		LocalDate before1000years = now.minusYears(1000); //+ 1000년전
		
		System.out.println(now);
		System.out.println(after3years); //+ 2024-07-02 : 3년후
		System.out.println(before1000years.getDayOfWeek()); //+ TUESDAY : 1000년전 요일
		System.out.println(now.getDayOfWeek()); //+ SATURDAY
		
		DayOfWeek dayofweek = now.getDayOfWeek();
		System.out.println("dayofweek : " + dayofweek); //+ dayofweek : SATURDAY
		
		
		// 시간을 문자열로 변경하기
		DateTimeFormatter my_date_format = DateTimeFormatter.ofPattern("y년 M월 d일 E요일");
		//+ java.time.format에 들어있는 필드값 
		
		String message = my_date_format.format(now);
		
		System.out.println("now : " + message); //+ now 기준으로 2021년 7월 2일 금요일
		
		// 시간 객체끼리 크기 비교하기
		int year = 2021;
		LocalDate 어린이날 = LocalDate.of(year, 5, 5);
		LocalDate 크리스마스 = LocalDate.of(2021, 12, 25);
		LocalDate 어린이날2 = LocalDate.of(2021, 5, 5);
		LocalDate now1 = LocalDate.now();
		
		System.out.println(어린이날.isAfter(크리스마스)); //+ 어린이날이 크리스마스보다 뒤니? : false = 아니요
		System.out.println(어린이날.isBefore(크리스마스)); //+ 어린이날이 크리스마스보다 앞이니? : true = 예
		System.out.println(어린이날.equals(어린이날2)); //+ true
		System.out.println("(로컬날짜 + 어린이날) : " + 어린이날.equals(now1)); //+ true
		
		String date = "20210701";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        LocalDate chkDay = LocalDate.parse(date, formatter);
        System.out.println(chkDay); //+ 2021-07-01
        
        DateTimeFormatter date_format = DateTimeFormatter.ofPattern("y/M/d E요일");
        String check = date_format.format(chkDay);
		System.out.println(check); //+ 2021/7/1 목요일
        
        

	}
}

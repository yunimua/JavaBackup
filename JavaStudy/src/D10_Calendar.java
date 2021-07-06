

import java.text.*;
import java.util.*;

public class D10_Calendar {

   /*
      # Date, Calendar, Time
      
       - 자바로 시간과 날짜를 쉽게 다룰 수 있는 클래스들
       
    */
   public static void main(String[] args) {
      
      // 시스템의 유닉스 타임을 가져오는 메서드
      // ※ 유닉스타임 - 1970년 1월 1일 이후로 시간이 얼마나 흘렀는지를 센 것 (밀리초)
      long currentTime = System.currentTimeMillis();

      System.out.println("1970년 1월 1일 이후로 " + currentTime + "밀리초 흘렀습니다");
      System.out.println("1970년 1월 1일 이후로 " + currentTime / 1000 + "초 흘렀습니다");
      System.out.println("1970년 1월 1일 이후로 " + currentTime / 1000 / 60 + "분 흘렀습니다");
      System.out.println("1970년 1월 1일 이후로 " + currentTime / 1000 / 60 / 60 + "시간 흘렀습니다");
      System.out.println("1970년 1월 1일 이후로 " + currentTime / 1000 / 60 / 60 / 24 + "일 흘렀습니다");
      System.out.println("1970년 1월 1일 이후로 " + currentTime / 1000 / 60 / 60 / 24 / 365 + "년 흘렀습니다");
      
      /*
         # java.util.Date
         
          - Date 클래스의 메서드들은 최근 버전에서는 거의 업데이트가 중단되어 있다
          - 시간을 계산할 때는 다른 클래스들을 사용할 것을 권장한다
          - 하지만 여전히 시간 데이터를 담아두기만 할 때는 Date 클래스를 많이 사용한다
          
       */
      
      Date now = new Date();
      System.out.println(now); //+ Fri Jul 02 19:02:14 KST 2021
      System.out.println(now.getDate()); //+ 7월 2일일 경우 2가 표시됨
      
      /*
         # java.util.Calender
         
          - 달력을 표현한 클래스
          - 날짜를 쉽게 계산할 수 있는 다양한 기능들이 모여있다
          - 생성자를 사용할 수 없고 getInstance()라는 스태틱 메서드를 활용한다
          - getInstance() 메서드에 경도값을 전달하여 지역별 시간을 알 수도 있다
       */
      
      Calendar now2 = Calendar.getInstance();
      System.out.println(now2);
      
      // Calendar에서 원하는 필드값을 get() 메서드를 통해 꺼낼 수 있다
      System.out.println("now2로 꺼낸 year: " + now2.get(Calendar.YEAR));
      
      // ※ 필드값중 month만 0부터 시작한다
      System.out.println("now2로 꺼낸 month: " + now2.get(Calendar.MONTH)); //+ 0부터 시작하므로 +1를 해야 현재 월이다
      System.out.println("now2로 꺼낸 date: " + now2.get(Calendar.DATE));

      System.out.println("HOUR: " + now2.get(Calendar.HOUR)); //+ 현재 시간 : 오후 7시일 경우 7
      System.out.println("HOUR_OF_DAY: " + now2.get(Calendar.HOUR_OF_DAY)); //+ 오후 7시일 경우 하루 24시간 중 19시간으로 표시
      System.out.println("MINUTE: " + now2.get(Calendar.MINUTE)); //+ 현재 분
      System.out.println("SECOND: " + now2.get(Calendar.SECOND)); //+ 현재 초
      
      System.out.println("DAY_OF_YEAR(올해가 시작되고 지난 날짜)" + now2.get(Calendar.DAY_OF_YEAR)); 
      System.out.println("DAY_OF_MONTH(이번달이 시작되고 지난 날짜)" + now2.get(Calendar.DAY_OF_MONTH));
      System.out.println("WEEK_OF_MONTH(이번달이 시작되고 몇째주)" + now2.get(Calendar.WEEK_OF_MONTH));
      System.out.println("DAY_OF_WEEK(이번주가 시작되고 지난 날짜, 시작은 일요일이 시작)" +now2.get(Calendar.DAY_OF_WEEK)); // 1~7
      System.out.println("DAY_OF_WEEK_IN_MONTH(이번달에 몇번째 해당 요일인가)" + now2.get(Calendar.DAY_OF_WEEK_IN_MONTH));
      
      
      // 다른 나라 시간 인스턴스 생성하기
      
//      for (String avail_id : TimeZone.getAvailableIDs()) {
//    	  System.out.println(avail_id);
//      }
      
      //Calendar.getInstance(TimeZone.getTimeZone("Asia/Seoel"));
      Calendar us_east = Calendar.getInstance(TimeZone.getTimeZone("US/Eastern"));
      
      System.out.printf("%d년 %d월 %d일 %02d:%02d:%02d\n", 
    		  us_east.get(Calendar.YEAR),
    		  us_east.get(Calendar.MONTH) + 1, //0번부터 시작하므로 month는 +1이 필요
    		  us_east.get(Calendar.DATE),
    		  us_east.get(Calendar.HOUR_OF_DAY),
    		  us_east.get(Calendar.MINUTE),
    		  us_east.get(Calendar.SECOND));
      
      
		/*
			# SimpleDateFormat : 시간 인스턴스를(시간데이터/날짜?) 원하는 서식으로 편리하게 출력하기
			
			# 사용할 수 있는 서식들 (※ 이거말고도 많이 있음) //+ 궁금하면 SimpleDateFormat 문서를 봐라!
			
			y : 년
			M : 월
			d : 일
			D : 일(1~365)
			
			H : 24시
			h : 12시
			m : 분
			s : 초
			
			E : 요일
			a : AM/PM			
		*/
      
      // myDateformat을 치고 빨간줄이 가면, Ctrl + Shift + O 를 누른다
      SimpleDateFormat myDateformat = new SimpleDateFormat("YYYY/MM/dd a HH:mm:ss EEEEEE"); //+ 틀린 시간이 나옴, 우리나라 현시간
      
      // Calendar 인스턴스로 Date타입 인스턴스를 생성할 수 있다
      String text = myDateformat.format(us_east.getTime());
      System.out.println(text); //+ 2021/07/04 오전 00:19:10 일요일
      
      // Calendar의 set() 메서드를 사용해 원하는 필드를 원하는 값으로 변경할 수 있다
      Calendar calendar = Calendar.getInstance();
      
      System.out.println("변경 전 : " + getCurrentDate(calendar)); //+ 변경 전 : 2021년 07월 02일 / 금요일
      
      //+ set을 쓰면 원본이 변해버린다, 변경 전 값을 보관하는 값이 없다
      calendar.set(Calendar.DATE, 30); //+ 2월은 30일이 없으므로 3월 2일이 된다
      calendar.set(Calendar.MONTH, 1); //+ 1은 2월, 3은 4월
      calendar.set(Calendar.YEAR, 2017);
      
      //+ Calendar.DATE(필드)를 쓰지않고 숫자를 입력해도 오류가 발생하지 않으나, 실행하면 오류 발생. Time클래스는 이경우를 막아둠
      
      System.out.println("변경 후 : " + getCurrentDate(calendar)); //+ 변경 후 : 2021년 02월 02일 / 화요일, 월을 바꾸면 요일도 바뀐다
      
      
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd E요일");
      String date = "20211101";
      String dateString = date.substring(0, 4) + "/" + date.substring(4, 6) + "/" + date.substring(6);
      System.out.println(dateString);
      System.out.println(sdf.format(date));
      
   }
   
   public static String getCurrentDate(Calendar calendar) {
	   SimpleDateFormat current = new SimpleDateFormat("yyyy년 MM월 dd일 / E요일");
   
	   return current.format(calendar.getTime());
   }
}


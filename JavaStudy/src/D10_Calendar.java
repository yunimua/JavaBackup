

import java.text.*;
import java.util.*;

public class D10_Calendar {

   /*
      # Date, Calendar, Time
      
       - �ڹٷ� �ð��� ��¥�� ���� �ٷ� �� �ִ� Ŭ������
       
    */
   public static void main(String[] args) {
      
      // �ý����� ���н� Ÿ���� �������� �޼���
      // �� ���н�Ÿ�� - 1970�� 1�� 1�� ���ķ� �ð��� �󸶳� �귶������ �� �� (�и���)
      long currentTime = System.currentTimeMillis();

      System.out.println("1970�� 1�� 1�� ���ķ� " + currentTime + "�и��� �귶���ϴ�");
      System.out.println("1970�� 1�� 1�� ���ķ� " + currentTime / 1000 + "�� �귶���ϴ�");
      System.out.println("1970�� 1�� 1�� ���ķ� " + currentTime / 1000 / 60 + "�� �귶���ϴ�");
      System.out.println("1970�� 1�� 1�� ���ķ� " + currentTime / 1000 / 60 / 60 + "�ð� �귶���ϴ�");
      System.out.println("1970�� 1�� 1�� ���ķ� " + currentTime / 1000 / 60 / 60 / 24 + "�� �귶���ϴ�");
      System.out.println("1970�� 1�� 1�� ���ķ� " + currentTime / 1000 / 60 / 60 / 24 / 365 + "�� �귶���ϴ�");
      
      /*
         # java.util.Date
         
          - Date Ŭ������ �޼������ �ֱ� ���������� ���� ������Ʈ�� �ߴܵǾ� �ִ�
          - �ð��� ����� ���� �ٸ� Ŭ�������� ����� ���� �����Ѵ�
          - ������ ������ �ð� �����͸� ��Ƶα⸸ �� ���� Date Ŭ������ ���� ����Ѵ�
          
       */
      
      Date now = new Date();
      System.out.println(now); //+ Fri Jul 02 19:02:14 KST 2021
      System.out.println(now.getDate()); //+ 7�� 2���� ��� 2�� ǥ�õ�
      
      /*
         # java.util.Calender
         
          - �޷��� ǥ���� Ŭ����
          - ��¥�� ���� ����� �� �ִ� �پ��� ��ɵ��� ���ִ�
          - �����ڸ� ����� �� ���� getInstance()��� ����ƽ �޼��带 Ȱ���Ѵ�
          - getInstance() �޼��忡 �浵���� �����Ͽ� ������ �ð��� �� ���� �ִ�
       */
      
      Calendar now2 = Calendar.getInstance();
      System.out.println(now2);
      
      // Calendar���� ���ϴ� �ʵ尪�� get() �޼��带 ���� ���� �� �ִ�
      System.out.println("now2�� ���� year: " + now2.get(Calendar.YEAR));
      
      // �� �ʵ尪�� month�� 0���� �����Ѵ�
      System.out.println("now2�� ���� month: " + now2.get(Calendar.MONTH)); //+ 0���� �����ϹǷ� +1�� �ؾ� ���� ���̴�
      System.out.println("now2�� ���� date: " + now2.get(Calendar.DATE));

      System.out.println("HOUR: " + now2.get(Calendar.HOUR)); //+ ���� �ð� : ���� 7���� ��� 7
      System.out.println("HOUR_OF_DAY: " + now2.get(Calendar.HOUR_OF_DAY)); //+ ���� 7���� ��� �Ϸ� 24�ð� �� 19�ð����� ǥ��
      System.out.println("MINUTE: " + now2.get(Calendar.MINUTE)); //+ ���� ��
      System.out.println("SECOND: " + now2.get(Calendar.SECOND)); //+ ���� ��
      
      System.out.println("DAY_OF_YEAR(���ذ� ���۵ǰ� ���� ��¥)" + now2.get(Calendar.DAY_OF_YEAR)); 
      System.out.println("DAY_OF_MONTH(�̹����� ���۵ǰ� ���� ��¥)" + now2.get(Calendar.DAY_OF_MONTH));
      System.out.println("WEEK_OF_MONTH(�̹����� ���۵ǰ� ��°��)" + now2.get(Calendar.WEEK_OF_MONTH));
      System.out.println("DAY_OF_WEEK(�̹��ְ� ���۵ǰ� ���� ��¥, ������ �Ͽ����� ����)" +now2.get(Calendar.DAY_OF_WEEK)); // 1~7
      System.out.println("DAY_OF_WEEK_IN_MONTH(�̹��޿� ���° �ش� �����ΰ�)" + now2.get(Calendar.DAY_OF_WEEK_IN_MONTH));
      
      
      // �ٸ� ���� �ð� �ν��Ͻ� �����ϱ�
      
//      for (String avail_id : TimeZone.getAvailableIDs()) {
//    	  System.out.println(avail_id);
//      }
      
      //Calendar.getInstance(TimeZone.getTimeZone("Asia/Seoel"));
      Calendar us_east = Calendar.getInstance(TimeZone.getTimeZone("US/Eastern"));
      
      System.out.printf("%d�� %d�� %d�� %02d:%02d:%02d\n", 
    		  us_east.get(Calendar.YEAR),
    		  us_east.get(Calendar.MONTH) + 1, //0������ �����ϹǷ� month�� +1�� �ʿ�
    		  us_east.get(Calendar.DATE),
    		  us_east.get(Calendar.HOUR_OF_DAY),
    		  us_east.get(Calendar.MINUTE),
    		  us_east.get(Calendar.SECOND));
      
      
		/*
			# SimpleDateFormat : �ð� �ν��Ͻ���(�ð�������/��¥?) ���ϴ� �������� ���ϰ� ����ϱ�
			
			# ����� �� �ִ� ���ĵ� (�� �̰Ÿ��� ���� ����) //+ �ñ��ϸ� SimpleDateFormat ������ ����!
			
			y : ��
			M : ��
			d : ��
			D : ��(1~365)
			
			H : 24��
			h : 12��
			m : ��
			s : ��
			
			E : ����
			a : AM/PM			
		*/
      
      // myDateformat�� ġ�� �������� ����, Ctrl + Shift + O �� ������
      SimpleDateFormat myDateformat = new SimpleDateFormat("YYYY/MM/dd a HH:mm:ss EEEEEE"); //+ Ʋ�� �ð��� ����, �츮���� ���ð�
      
      // Calendar �ν��Ͻ��� DateŸ�� �ν��Ͻ��� ������ �� �ִ�
      String text = myDateformat.format(us_east.getTime());
      System.out.println(text); //+ 2021/07/04 ���� 00:19:10 �Ͽ���
      
      // Calendar�� set() �޼��带 ����� ���ϴ� �ʵ带 ���ϴ� ������ ������ �� �ִ�
      Calendar calendar = Calendar.getInstance();
      
      System.out.println("���� �� : " + getCurrentDate(calendar)); //+ ���� �� : 2021�� 07�� 02�� / �ݿ���
      
      //+ set�� ���� ������ ���ع�����, ���� �� ���� �����ϴ� ���� ����
      calendar.set(Calendar.DATE, 30); //+ 2���� 30���� �����Ƿ� 3�� 2���� �ȴ�
      calendar.set(Calendar.MONTH, 1); //+ 1�� 2��, 3�� 4��
      calendar.set(Calendar.YEAR, 2017);
      
      //+ Calendar.DATE(�ʵ�)�� �����ʰ� ���ڸ� �Է��ص� ������ �߻����� ������, �����ϸ� ���� �߻�. TimeŬ������ �̰�츦 ���Ƶ�
      
      System.out.println("���� �� : " + getCurrentDate(calendar)); //+ ���� �� : 2021�� 02�� 02�� / ȭ����, ���� �ٲٸ� ���ϵ� �ٲ��
      
      
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd E����");
      String date = "20211101";
      String dateString = date.substring(0, 4) + "/" + date.substring(4, 6) + "/" + date.substring(6);
      System.out.println(dateString);
      System.out.println(sdf.format(date));
      
   }
   
   public static String getCurrentDate(Calendar calendar) {
	   SimpleDateFormat current = new SimpleDateFormat("yyyy�� MM�� dd�� / E����");
   
	   return current.format(calendar.getTime());
   }
}


package quiz;

import java.text.*;
import java.util.*;

public class D11_DiscountDay {

	/*
		� �ʰ��迡�� ���� ��縦 ¦����° ����ϸ��� �����Ѵٰ� �Ѵ�
		�⵵�� �Է��ϸ� �ش� �⵵�� ��� ���� ��¥�� ������ִ� ���α׷��� ��������	
	*/
	
	public static void main(String[] args) {
		
		int year = 2031;
		printEventOfYear(year);

		// get_year(2020);
	}
	
	public static Calendar getFristEventDay(int year) { //+ ù��° ����Ϸ� ����
		Calendar event = Calendar.getInstance();
		event.set(year, 0, 1);
		event.set(Calendar.DAY_OF_WEEK, Calendar.THURSDAY);
		
//		while (event.get(Calendar.DAY_OF_WEEK) != Calendar.THURSDAY) {
//			event.add(Calendar.DATE, 1);
//		}
		
		if (event.get(Calendar.YEAR) != year) { //+ ���� �⵵�� ���� ���� ��
			event.add(Calendar.DATE, 7); //+ ù��° ����Ͽ��� 7�� ���� = �ι�° �����
		}
		return event;
	}
	
	public static void printEventOfYear(int year) {
		SimpleDateFormat eventDateFormat = new SimpleDateFormat("[y�� �̺�Ʈ] M�� d�� E����");
		Calendar event = getFristEventDay(year);
		
		int count = 1;
		
		while(event.get(Calendar.YEAR) == year) {
			event.add(Calendar.DATE, 7);
			
			if (event.get(Calendar.DAY_OF_WEEK_IN_MONTH) % 2 == 0) { //+ ù��° ������� ã�� ¦���� �� ���
				System.out.println(eventDateFormat.format(event.getTime()));
				count++;
			}
		}
		System.out.println("������ �̺�Ʈ�� �� " + count + "ȸ �Դϴ�.");
	}
	
//	public static void get_year(int year) {
//		Calendar calendar = Calendar.getInstance();
//		SimpleDateFormat show = new SimpleDateFormat("yyyy/MM/dd EEEEE");
//		
//		calendar.set(Calendar.YEAR, year);
//		
//		for(int i = 0; i < 12; i++){
//			calendar.set(Calendar.MONTH, i); //+ ��
//			calendar.set(Calendar.WEEK_OF_MONTH, 2); //+ �ش� ���� 2°��
//			calendar.set(Calendar.DAY_OF_WEEK, 5); //+ �ش� ���� �����(5)
//			System.out.println(show.format(calendar.getTime())+"-- ��2��° ����� ��������");
//			calendar.set(Calendar.WEEK_OF_MONTH, 4); //+ �ش� ���� 4°��
//			calendar.set(Calendar.DAY_OF_WEEK, 5);
//			System.out.println(show.format(calendar.getTime())+"-- ��4��° ����� ��������");
//		}
//	}
//	
//	//�ҿ��� Ǯ��
//	public static void discountD(int year) {
//		SimpleDateFormat current = new SimpleDateFormat("yyyy�� MM�� dd�� / EEEEE");
//		Calendar calendar = Calendar.getInstance();
//		calendar.set(year - 1, 12, 31);
//		calendar.set(Calendar.DAY_OF_WEEK, 5); //+�ش� ���� �����(5)
//		
//		for (;calendar.get(Calendar.YEAR) == year; calendar.set(Calendar.DATE, calendar.get(Calendar.DATE)+7)) {
//			if(calendar.get(Calendar.DAY_OF_WEEK_IN_MONTH) % 2 == 0) {
//				System.out.println(current.format(calendar.getTime()));
//			}
//		}
//	}
}

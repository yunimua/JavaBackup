package myobj.car;

import java.text.*;
import java.time.*;
import java.time.format.*;
import java.util.*;

public class fivePart {
	// ��� ������ 
	private static String[] holiday = {"0101", "0301", "0505", "0606", "0815", "1003", "1009", "1225"};
	
	static String carNum; // ������ȣ
	int carType; // ����Ÿ�� // 0:�Ϲ�, 1:�����, 2:���Ƶ���, 3:����
	static String date; // ��¥
	static Calendar calendar;
	static DateTimeFormatter formatter;
	
	boolean except; // ���� Ÿ��
	
	public fivePart(String carNum, int carType, String date) {
		this.carNum = carNum;
		this.carType = carType;
		this.date = date;
		calendar = Calendar.getInstance();
		formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
	}
	
	// �������� üũ : 2018.8.1 ���� ~ 
	boolean isStartday() {
		LocalDate startDay = LocalDate.of(2018, 8, 1);
        LocalDate chkDay = LocalDate.parse(date, formatter);

		return startDay.isAfter(chkDay);
	}
        
	// ����Ÿ�� = 0:�Ϲ�, 1:�����, 2:���Ƶ���, 3:����
	boolean isExceptCar() {
		if ((carType > 0 && carType < 4)) {
			except = true;
		}else if (carType == 0) {
			except = false;
		}else {
			System.out.println("���� Ÿ���� �ٽ� Ȯ�����ּ���. -- 0:�Ϲ�, 1:�����, 2:���Ƶ���, 3:����");
		}
		return except;
	}
	
	// ��, ��(�ָ�) üũ
	boolean isWeekEnd() {
		dateFormat();
		return calendar.get(Calendar.DAY_OF_WEEK) == 1 || calendar.get(Calendar.DAY_OF_WEEK) == 7;
	}
	
	// ������ üũ (���) : 1/1����, 3/1������, 5/5��̳�, 6/6������, 8/15������, 10/3��õ��, 10/9�ѱ۳�, 12/25ũ��������	
	boolean isHoliday() {
        return Arrays.toString(holiday).contains(date.substring(4));
		/*
			1. contains(date.substring(4)) : date���ڿ��� �ش� solarArr���ڿ��� ���ԵǾ� �ִ��� �˻�
	        2. substring(4) => ���ڿ�(date) 4��° �ڸ����� ������¥�� �ڸ��� 
         		�� date�� "20210505"�� ��� �տ� 2021(0~3)�ڿ� 4���� �������̹Ƿ� 0505�� ����	
		*/
    }
	
	// ����ó��
	private static void dateFormat() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		try {
			calendar.setTime(sdf.parse(date));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	// ������ ���� ���ڸ� üũ
	boolean isMonday() {
		dateFormat();
        return (calendar.get(Calendar.DAY_OF_WEEK) == 2) && (carNum.endsWith("1") || carNum.endsWith("6"));
    }
	// ȭ���� ���� ���ڸ� üũ
	boolean isThesday() { 
		dateFormat();
        return (calendar.get(Calendar.DAY_OF_WEEK) == 3) && (carNum.endsWith("2") || carNum.endsWith("7"));
    }
	// ������ ���� ���ڸ� üũ
	boolean isWednesday() { 
		dateFormat();
        return (calendar.get(Calendar.DAY_OF_WEEK) == 4) && (carNum.endsWith("3") || carNum.endsWith("8"));
    }
	// ����� ���� ���ڸ� üũ
	boolean isThursday() { 
		dateFormat();
        return (calendar.get(Calendar.DAY_OF_WEEK) == 5) && (carNum.endsWith("4") || carNum.endsWith("9"));
    }
	// �ݿ��� ���� ���ڸ� üũ
	boolean isFriday() { 
		dateFormat();
        return (calendar.get(Calendar.DAY_OF_WEEK) == 6) && (carNum.endsWith("5") || carNum.endsWith("0"));
    }
	
	private static void printDay() {
		LocalDate chkDay = LocalDate.parse(date, formatter);
		DateTimeFormatter date_format = DateTimeFormatter.ofPattern("y/M/d E����");
        String check = date_format.format(chkDay);
		System.out.println("��������������������������������������������������������");
		System.out.println("��CheckDay : " + check);
		System.out.println("��������������������������������������������������������");
		System.out.println("��[carNumber : " + carNum +"]");
	}
	
	// ��� ���� üũ
	public void result() {
		// ���س�¥ �� ����, ������ȣ ǥ��
		printDay();
		// ����Ÿ�� üũ
		if (isExceptCar()) {
			System.out.println("��[carType : " + carType + "]\n" 
					+ "������ ������ ���ܵǴ� �����Դϴ�.\n������ [����] 1:�����, 2:���Ƶ���, 3:����\n");
		}else if (isStartday()) {
			System.out.println("������ [���� ��]\n������ �ڵ��� 5������ ���� ���Դϴ�.\n");
		// �ָ� üũ
		}else if (isWeekEnd()) {
			System.out.println("������ [�ָ�����]\n������ �ָ�(��/��)���� ������ �����ϴ�.\n");
		// ������ üũ(���)
		}else if (isHoliday()) {
			System.out.println("������ [����������]\n������ �����Ͽ��� ������ �����ϴ�.");
			System.out.println("������ ������ :\n 01�� 01�� [����]\n 03�� 01�� [������]\n 05�� 05�� [��̳�]\n 06�� 06�� [������]\n"
					+ " 08�� 15�� [������]\n 10�� 09�� [�ѱ۳�]\n 12�� 25�� [ũ��������]\n");
		// ���� Ÿ��, ����(����), ��������ȣ üũ
		}else if(isMonday()) {
			System.out.println("����[���������ѡ�] �������Դϴ�.\n������[Monday_EndCarNumber : 1, 6]\n");
		}else if(isThesday()) {
			System.out.println("����[���������ѡ�] ȭ�����Դϴ�.\n������[Thesday_EndCarNumber : 2, 7]\n");
		}else if(isWednesday()) {
			System.out.println("����[���������ѡ�] �������Դϴ�.\n������[Wednesday_EndCarNumber : 3, 8]\n");
		}else if(isThursday()) {
			System.out.println("����[���������ѡ�] ������Դϴ�.\n������[Thursday_EndCarNumber : 4, 9]\n");
		}else if (isFriday()) {
			System.out.println("����[���������ѡ�] �ݿ����Դϴ�.\n������[Friday_EndCarNumber : 5, 0]\n");
		}else {
			System.out.println("���ѵ��� �ʴ� �����Դϴ�\n");
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

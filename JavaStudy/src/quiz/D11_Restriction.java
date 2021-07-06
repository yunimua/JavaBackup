package quiz;

import java.text.*;
import java.time.*;
import java.util.*;

public class D11_Restriction {

	/*
		1. �ڷ� 5���� ���ڸ� ��ȣ üũ (4�ڸ��� ������ ����)
			- ������ : 1, 6
			- ȭ���� : 2, 7
			- ������ : 3, 8
			- ����� : 4, 9
			- �ݿ��� : 5, 0
			- ������ : ����
		
		2. �������� : 2018�� 9�� 1��
		3. ������(��������) : ���� 1�� 1��, ������ 3�� 1��, ��̳� 5�� 5��, ������ 6�� 6��, 
					������ 8�� 15��, ��õ�� 10�� 3��, �ѱ۳� 10�� 9��, ũ�������� 12�� 25��
		4. ���� ���� : �����(disabled= 'd'), ���Ƶ���(infantRide= 'i'), ����(lightCar= 'l')
			- �Ϲ� ���� (normal= 'n')
			- �������� / Access restricted
		
		�⺻������ �����, �Ͽ����� ������ ����
		�������� ������ ����
		���������� ������ ����
		�������� ������ ������ ����
		
		�ش� ��¥�� �ش��ϴ� ������ üũ�Ͽ� ����ȣ ���ڸ� ���ѿ��Ͽ� �ش��ϴ��� üũ
	*/
	
	String carNumber; // ������ȣ 4�ڸ�
	int carType; // ����Ÿ�� = 0:�Ϲ�, 1:�����, 2:���Ƶ���, 3:����
	long date; // ��¥(����Ⱦ�), now ��������(���� ���� ��¥) üũ��..
	Calendar calendar;
		
	boolean except; // �������� Ÿ�� üũ
	boolean weekend; // ��, �� (�ָ�) üũ
	boolean holiday; // ���� üũ(��~��)
	boolean start; // �������� ������
	
	public D11_Restriction(String carNumber, int carType) {
		this.carNumber = carNumber;
		this.carType = carType;
		calendar = Calendar.getInstance();
	}
	
	public static String currentDate(Calendar calendar) {
		SimpleDateFormat current = new SimpleDateFormat("yyyy/MM/dd E���� ");
	   
		return current.format(calendar.getTime());
	}

	// �������� üũ
	boolean checkExceptCar() { //+ �������� üũ
		if ((carType > 0 && carType < 4)) {
			except = true;
		}else if (carType == 0) {
			except = false;
		}else {
			System.out.println("���� Ÿ���� �ٽ� Ȯ�����ּ���. -- 0:�Ϲ�, 1:�����, 2:���Ƶ���, 3:����");
		}
		return except;
	}
	
	// �ָ� üũ
	boolean checkWeekEnd() { 
		int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
		
		if (dayOfWeek == 1 || dayOfWeek == 7) {
			weekend = true;
		}
		return weekend;
	}
	
	// ������ üũ
	boolean checkHoliday() {
		int year = 2021;
		LocalDate chkday = LocalDate.now();
		LocalDate newYear = LocalDate.of(year, 1, 1); // ����
		LocalDate march1 = LocalDate.of(year, 3, 1); // ������
		LocalDate children = LocalDate.of(year, 5, 5); // ��̳�
		LocalDate memorial = LocalDate.of(year, 6, 6); // ������
		LocalDate liberation = LocalDate.of(year, 8, 15); // ������
		LocalDate dayOfKorea = LocalDate.of(year, 10, 3); // ��õ��
		LocalDate hangul = LocalDate.of(year, 10, 9); // �ѱ۳�
		LocalDate christmas = LocalDate.of(year, 12, 25); // ũ��������
		
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
	
	// �������� ������ üũ 
	boolean checkStartday() {
		LocalDate startDay = LocalDate.of(2018, 8, 1);
		LocalDate chkday = LocalDate.now();
		
		return startDay.isAfter(chkday);
	}


	// ����(��~��) üũ, ������ȣ ���ڸ� Ȯ��
	void checkWeekday() { 
		int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
		
		if (dayOfWeek == 2) {
			if (carNumber.endsWith("1") || carNumber.endsWith("6")) {
				System.out.println("��[carNumber : " + carNumber +"] "
										+ "\n����[���������ѡ�] �������Դϴ�."
										+ "\n������[Monday_EndCarNumber : 1, 6]");
			}else {
				System.out.println("[Monday_EndCarNumber : 1, 6] �ش����� �ʴ� �����Դϴ�");
			}
		}else if (dayOfWeek == 3) {
			if (carNumber.endsWith("2") || carNumber.endsWith("7")) {
				System.out.println("��[carNumber : " + carNumber +"] "
										+ "\n����[���������ѡ�] ȭ�����Դϴ�."
										+ "\n������[Tuesday_EndCarNumber : 2, 7]");
			}else {
				System.out.println("[Tuesday_EndCarNumber : 2, 7] �ش����� �ʴ� �����Դϴ�");
			}
		}else if (dayOfWeek == 4) {
			if (carNumber.endsWith("3") || carNumber.endsWith("8")) {
				System.out.println("��[carNumber : " + carNumber +"] "
										+ "\n��[���������ѡ�] �������Դϴ�."
										+ "\n������[Wednesday_EndCarNumber : 3, 8]");
			}else {
				System.out.println("[carNumber : " + carNumber + "]\n[Wednesday_EndCarNumber : 3, 8] �ش����� �ʴ� �����Դϴ�");
			}
		}else if (dayOfWeek == 5) {
			if (carNumber.endsWith("4") || carNumber.endsWith("9")) {
				System.out.println("��[carNumber : " + carNumber +"] "
										+ "\n����[���������ѡ�] ������Դϴ�."
										+ "\n������[Thursday_EndCarNumber : 4, 9]");
			}else {
				System.out.println("[Thursday_EndCarNumber : 5, 0] �ش����� �ʴ� �����Դϴ�");
			}
		}else if (dayOfWeek == 6) {
			if (carNumber.endsWith("5") || carNumber.endsWith("0")) {
				System.out.println("��[carNumber : " + carNumber +"] "
										+ "\n����[���������ѡ�] �ݿ����Դϴ�."
										+ "\n������[Friday_EndCarNumber : 5, 0]");
			}else {
				System.out.println("[carNumber : " + carNumber + "]\n[Friday_EndCarNumber : 5, 0] �ش����� �ʴ� �����Դϴ�");
			}
		}
	}
	
	// ���ܵǴ� ���� üũ
	public void result() {
		// ���� ��¥ ���
		System.out.println("����������������������������������������������������");
		System.out.println("��Today : " + currentDate(calendar));
		System.out.println("����������������������������������������������������");

		if (checkStartday()) {
			System.out.println(currentDate(calendar) + "������ [���� ��] ������ �ڵ��� 5������ ���� ���Դϴ�.");
		}else if(checkWeekEnd()) {
			System.out.println(currentDate(calendar) + "������ [�ָ�����] ������ �ָ�(��/��)���� ������ �����ϴ�.");
		}else if(checkHoliday()) {
			System.out.println(currentDate(calendar) + "������ [����������] ������ �����Ͽ��� ������ �����ϴ�.");
			System.out.println("������ ������ :\n 01�� 01�� [����]\n 03�� 01�� [������]\n 05�� 05�� [��̳�]\n 06�� 06�� [������]\n"
								+ " 08�� 15�� [������]\n 10�� 09�� [�ѱ۳�]\n 12�� 25�� [ũ��������]\n");
		}else if(checkExceptCar()) {
			System.out.println("[carType : " + carType + "]\n" + "������ ������ ���ܵǴ� �����Դϴ�. [����] 1:�����, 2:���Ƶ���, 3:����");
		}else {
			checkWeekday();
		}
	}
	
	public static void main(String[] args) {
		
		D11_Restriction r1 = new D11_Restriction("0643", 0); // ������ȣ, ���� Ÿ��
		r1.result();
		
		D11_Restriction r2 = new D11_Restriction("0990", 0);
		r2.result();
		
		D11_Restriction r3 = new D11_Restriction("0641", 2); 
		r3.result();

	}
}

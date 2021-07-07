package myobj.Parking;

import java.time.*;
import java.util.*;

public class Car {
	static Random ran = new Random();
	static char[] types = {'H', 'Y', 'S', 'N', 'T', 'L', 'B'}; // H: �����, Y:���Ƶ���, S:����, N:�Ϲ�, T:Ʈ��, L:��Ʈ, B:����

	String number; // ���� ��ȣ
	char type; // ���� Ÿ��
	private LocalDate park_date; // ������ ��¥
	
	public Car() {
		this.number = String.format("%04d", ran.nextInt(10000));
		this.type = types[ran.nextInt(types.length)]; // �� Ÿ�� ������ ����
		
		this.park_date = LocalDate.of(genRamdomYear(),genRamdomMonth(), 1); // �������� �����ϰ� 1�Ϻ��� ����
		this.park_date = park_date.plusDays(ran.nextInt(park_date.lengthOfMonth())); // 1���� �״��� ������ �ϱ���
		
		// ����ε� ��¥�� ���ö����� ����
//		while(true) { // ��¥ ���� ����, 2������ ���ܰ� �ʿ��� ���� ����ó���� ���� try, catch���� ����..
//			try {
//				this.park_date = LocalDate.of(
//						genRamdomYear(),
//						genRamdomMonth(),
//						genRamdomDate()
//				);
//				break; // ����ε� ��¥�� ������ break;
//			} catch (DateTimeException e) {}
//		}
	}
	
	private int genRamdomYear() {
		return ran.nextInt(5) + 2017; // 5��ڱ���, 2017~2021
	}
	
	private int genRamdomMonth() {
		return ran.nextInt(12) + 1; // 1~12�� ����
	}
	
	private int genRamdomDate() { // �ش� ������ while���� ����Ҷ� ����
		return ran.nextInt(31) + 1; // 1~31�� ����
	}
	
	public LocalDate getPark_date() { // ������ ������� �ǵ����ִ� ��
		return park_date;
	}
	
	@Override
	public String toString() {
		return String.format("[%s/%c/%s]", number, type, park_date);
	}
	
	public static void main(String[] args) {
		for (int i = 0; i < 1000; ++i) {
			System.out.println(i + ":" + new Car());
		}
	}
	
}

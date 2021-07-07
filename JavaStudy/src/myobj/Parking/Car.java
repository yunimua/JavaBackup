package myobj.Parking;

import java.time.*;
import java.util.*;

public class Car {
	static Random ran = new Random();
	static char[] types = {'H', 'Y', 'S', 'N', 'T', 'L', 'B'}; // H: 장애인, Y:유아동승, S:경차, N:일반, T:트럭, L:렌트, B:대형

	String number; // 차량 번호
	char type; // 차량 타입
	private LocalDate park_date; // 주차한 날짜
	
	public Car() {
		this.number = String.format("%04d", ran.nextInt(10000));
		this.type = types[ran.nextInt(types.length)]; // 총 타입 수에서 랜덤
		
		this.park_date = LocalDate.of(genRamdomYear(),genRamdomMonth(), 1); // 월까지만 지정하고 1일부터 시작
		this.park_date = park_date.plusDays(ran.nextInt(park_date.lengthOfMonth())); // 1부터 그달의 마지막 일까지
		
		// 제대로된 날짜가 나올때까지 생성
//		while(true) { // 날짜 랜덤 생성, 2월같이 제외가 필요한 달은 예외처리를 위해 try, catch문을 쓴다..
//			try {
//				this.park_date = LocalDate.of(
//						genRamdomYear(),
//						genRamdomMonth(),
//						genRamdomDate()
//				);
//				break; // 제대로된 날짜가 나오면 break;
//			} catch (DateTimeException e) {}
//		}
	}
	
	private int genRamdomYear() {
		return ran.nextInt(5) + 2017; // 5년뒤까지, 2017~2021
	}
	
	private int genRamdomMonth() {
		return ran.nextInt(12) + 1; // 1~12월 까지
	}
	
	private int genRamdomDate() { // 해당 구문은 while문을 사용할때 사용됨
		return ran.nextInt(31) + 1; // 1~31일 까지
	}
	
	public LocalDate getPark_date() { // 생성된 년월일을 되돌려주는 값
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

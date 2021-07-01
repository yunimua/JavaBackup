package myinterface;

public class Main {

	public static void main(String[] args) {
		
		Bus bus = new Bus();
		test(bus);
		
		Starex str = new Starex();
		test(str);
		
		Delivery_store ds = new Delivery_store();
		check(ds);
		
	}
	
	public static void test(Vehicle vehicle) {
		
		for (int i = 0; i < 100; ++i) {
			System.out.println("속도를 더 냈습니다.");
			System.out.println("현재 속도는 " + vehicle.acceleration() + "km/h 입니다.");
		}
		
		System.out.println("무서워서 속도를 감소합니다.");
		for (int i = 0; i < 30; ++i) {
			System.out.println("현재 속도는 " + vehicle.deceleration() + "km/h 입니다.");
		}
		
		for (int i = 0; i < 15; ++i) { //+15명태우기
			if (!vehicle.ride()) {
				System.out.println("더 이상 탈 수 없습니다.");
			}else {
				System.out.println("한명이 더 탔습니다.");
			}
		}
	}
	
	public static void check(Delivery orders) {
		
		for (int i = 0; i < 10; ++i) {
			System.out.println("주문이 접수되었습니다. [현재 주문 건수 : " + orders.order() + "]");
		}
		
		for (int i = 0; i < 10; ++i) {
			System.out.println("대기 시간이 길어져 주문이 취소되었습니다. [현재 주문 건수 : " + orders.orderCancel() + "]");
		}
		
		for (int i = 0; i < 20; ++i) {
			if (!orders.orderQuantity()) {
				System.out.println("주문량이 많아 추가 주문을 받을 수 없습니다.");
			}else {
				System.out.println("주문 1건이 추가 접수되었습니다.");
			}
		}
	}
}

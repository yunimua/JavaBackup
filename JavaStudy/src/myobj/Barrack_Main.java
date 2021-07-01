package myobj;

public class Barrack_Main {
	public static void main(String[] args) {		
		
		Smartphone sp = new Smartphone();
		
		sp.brand = "삼성";
		sp.sale();
		System.out.println(sp.brand + " 기기의 가격은 : " + (int)sp.price + "원 입니다.");

		
		Barrack b1 = new Barrack();
		
		// 5개이상 생성불가 메세지 출력됨
		b1.createSheep();
		b1.createSheep();
		b1.createSheep();
		b1.createCow();
		b1.createCow();
		b1.createCow();

		System.out.println(b1.queue[0].name);
		System.out.println(b1.queue[1].name);
		System.out.println(b1.queue[2].name);
		System.out.println(b1.queue[3].name);
		System.out.println(b1.queue[4].name);	
	}
}

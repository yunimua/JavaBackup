
public class C13_LocalInnerClass {

	/*
		# 지역 내부 클래스
		
		  - 클래스는 사실 메서드 내부에서도 정의할 수 있다
		  - 메서드가 끝나면 해당 클래스도 수명이다한다	
	*/
	
	public static void main(String[] args) { //+ 메서드안에 class Apple 생성이 가능.
		
		// 메서드 내부에도 클래스를 사용할 수 있음
		class Apple {
			int price;
			int color;
			
			public Apple(int price, int color) {
				this.price = price;
				this.color = color;
			}
			@Override
			public String toString() {
			
				return "price: " + price + "원\ncolor값: " + color;
			}
		}
		
		Apple a = new Apple(1000, 1);
		System.out.println(a);
		
		//다음과 같은 상황에 o.check()를 실행할 수 없는 이유를 200자 이내로 서술하시오
//		Object o = banana(); //+ banana를 호출한 메서드
//		
//		((Banana)o).check();
		
		Fruitt fruit = execbanana();
		System.out.println("바나나는 개당 " + fruit.check() + "원입니다.");
		
	}
	
	//public static Object banana() { //+ 바나나 메서드 생성 //+ Banana banana가되면 class를 불러올수없으므로 사용불가
	public static Fruitt execbanana() { 
		class Banana extends Fruitt { //+ Fruitt에서 상속(extends)받음
	//	class Banana { //+ Banana 클래스를 생성, 이건 이전에 먼저 생성한 클래스
			int bana_count; //+몇개인가
			int price; //+ 가성비 체크 가격
			
			public Banana(int bana_count, int price) {
				this.bana_count = bana_count;
				this.price = price;
			}
			
			double check() {
				return price / (double)bana_count;
			}
		}
		//+ ┌ 이걸 출력하려면 main 메소드에 banana() 메서드 실행을 추가해야한다
		//+ │ class Banana의 인스턴스(new Banana)를 생성하고 값을 넣은 후 check를 돌리면 결과값이 출력
		// System.out.println(new Banana(11, 3000).check() + "원"); //+ 272.72727272727275원
		return new Banana(11, 3000);
	}
}

//+ abstract : 형태만 만들어 놓고 완성을 자손 클래스에게 미루는 클래스
//+ Fruitt에서 상속받은 check()를 보유
abstract class Fruitt { //+ 중복된 이름이있어서 t를 하나 더붙임
	abstract double check();
}




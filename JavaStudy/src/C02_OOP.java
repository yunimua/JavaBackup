
public class C02_OOP {
	/*
		# 객체지향 프로그래밍 (OOP : Object Oriented Programming)
		
		 - 세상에 존재하는 모든 것들을 변수와 함수로 표현하려는 프로그래밍 방법론
		 	(객체화를 시키려면 변수, 함수로 표현...)
		 - 변수와 함수를 무분별하게 사용하기 보다는 
		   현실에 존재하는 객체 단위로 묶어서 표현하여 가독성을 올린다
		 - 객체(Object) : 세상에 존재하는 모든 것 (사물, 개념, 실체가 있고 없고 모든.. 등등)
		 
		 ex: 사과
		  - 변수 : 크기, 당도, 색깔, 칼로리, 유통기한, 모양... 
		  - 함수 : 
		  		먹는다(크기가 줄어들면서 칼로리만큼 먹은 사람의 칼로리가 증가)
		  		색이 변한다
		  		유통기한이 줄어든다
		  		던진다 (크기만큼의 데미지를 입힌다)
		  		냉장고에 보관한다 (유통기한이 느리게 감소한다)
		  		
		 ※ 클래스 내부에(딸려있는) 있는 함수는 메서드라고 부른다 (java에는 메서드 밖에 없다)
		 
		 # 클래스 (Class)
		 
		  - 객체를 프로그래밍 언어로 표현한 것
		  - 클래스는 해당 객체의 설계도다 (정의한 시점에서는 실체가 없다)
		  - 설계도대로 찍어내는 실제 객체를 '인스턴스'리고 부른다 // 스캐너는 설계도였다. new Scanner는 설계도 시작
		  - 클래스는 참조형 변수 타입이다
	*/
	
	//main은 반드시 public class 내부에 존재해야 한다. 
	//(파일 이름과 같은 이름의 클래스에 존재해야 찾을 수 있다)
	public static void main(String[] args) {
		String[] flavor = {"초코", "바닐라", "딸기", "피스타치오", "망고"};
		String[] color = {"브라운", "아이보리", "핑크", "그린", "옐로"};
		int price = 1500;
		int calorie = 800;
		String product = "농심";
		String type = "콘";
		
		IceCream gugucon = new IceCream(); 
		
		IceCream[] icebox = new IceCream[10];
		
		icebox[0] = new IceCream();
		
		System.out.println(icebox[0].flavor); //null
		
		System.out.println(gugucon.color); //null
		System.out.println(gugucon.price); //0

		doSomething(1, "2", 'A', 4.0f, 5.0);
		
		// new를 통해 인스턴스 생성
		Apple a1 = new Apple();
		Apple a2 = new Apple();
		Apple a3 = new Apple();
		
		// 이게 메서드?
		a1.size = 15;
		a1.color = "빨간색";
		
		a2.size = 13;
		a2.color = "보라색";
		
		a3.size = 25;
		a3.calrorie = 100;
	
		System.out.println(a1.color);
		System.out.println(a2.color);
		
		System.out.println("먹기 전 a3의 크기 : " + a3.size);
		System.out.println("먹기 전 a3의 칼로리 : " + a3.calrorie);
		
		a3.eat();
		
		// void eat() {을 통해 ...
		System.out.println("먹은 후 a3의 크기 : " + a3.size); // -1씩 감소
		System.out.println("먹은 후 a3의 칼로리 : " + a3.calrorie); // -10씩 감소
		
		Smartphone s1 = new Smartphone();
		Smartphone s2 = new Smartphone();
		
		s1.brand = "삼성";
		s1.price = 1000000;
		s1.color = "블랙";
		
		s2.brand = "애플";
		s2.price = 1000000;
		s2.color = "화이트";
		
		s1.sale();
		s2.sale();
		
		System.out.println(s1.brand + " 기기의 할인된 가격은 : " + (int)s1.price + "원 입니다.");
		System.out.println(s2.brand + " 기기의 할인된 가격은 : " + (int)s2.price + "원 입니다.");
			
		//문제풀이 내용
		
		Window window1 = new Window();
		Window w2 = new Window();
		Window w3 = new Window();
		
		window1.open();
		window1.close();
		window1.lock();
		
		window1.status();
		
		String status = window1.getStatus();
		System.out.println("가져온 상태로 문자열로 출력: " + status);			
	}
	
	public static void doSomething(int a, String b, char c, float d, double e) {
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);
		System.out.println(e);
	}
		
	public static void doSomething(Box box) {
		System.out.println(box.a);
		System.out.println(box.b);
		System.out.println(box.c);
		System.out.println(box.d);
		System.out.println(box.e);
	}
}

class IceCream{
	String flavor;
	String color;
	int price;
	int calorie;
	String product;
	String type;
}
		
class Box {
	int a;
	String b;
	char c;
	float d;
	double e;
}

class Apple{
	/* 
	 	# 인스턴스 변수
	 	 - 클래스 내부에 선언한 변수
	  	 - 인스턴스 마다 각자의 영역을 가지고 있는 변수들
	  	 - aka. 필드, 속성, 멤버 변수, 멤버, 상태 ...
	*/ 
	// 이게 변수
	int size;
	double sweet;
	String color;
	int calrorie; // 칼로리
	
	/*
		# 인스턴스 메서드
		 - 인스턴스 변수를 통해 해당 인스턴스의 상태를 변화시키는 메서드

	*/
	void eat() {
		size--;
		calrorie -= 10;
	}
}

// 연습 문제 : 현실의 객체를 참고하여 클래스를 하나 생성한 후 인스턴스를 생성하고 값을 채운다음 출력해보세요
// ※ 인스턴스 변수는 3개 이상, 인스턴스 메서드 2개 이상, 과일 금지

class Smartphone{
	double price;
	String color;
	String brand;
	
	void sale() {
		if (brand.equals("삼성")) {
			price -= (price*0.2);
			return;
		}else if (brand.equals("애플")){
			price -= (price*0.1);
			return;
		}
		return;
	}
	
	void color() {
		if (color.equals("블랙")) {
			price += (price*0.01);
		}else if (!(color.equals("블랙"))) {
			price -= (price*0.02);
		}
	}
}

class Window {
	boolean open;
	boolean lock;
	double width;
	double height;
	
	void open() { // 창문 열렸다, 닫혔다
		open = true;
	}
	void close() {
		open = false;
	}
	void lock() { // 창문이 잠겼다, 안잠겼다
		lock = true;
	}
	void unlock() {
		lock = false;
	}
	void status() {
		System.out.printf("이 창문은 %s. [%s].\n", 
							open ? "열려 있습니다." : "닫혀있습니다.",
							lock ? "잠겨있습니다." : "잠금 해제 상태입니다.");
	}
	String getStatus() {
		// String.format() : 서식을 이용해 원하는 문자열을 생성한다
		return String.format("이 창문은 %s. [%s].\n",
							open ? "열려 있습니다." : "닫혀있습니다.",
							lock ? "잠겨있습니다." : "잠금 해제 상태입니다.");

	}
}



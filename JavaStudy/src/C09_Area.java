
public class C09_Area {

	/*
		# 변수의 범위
		
		 - 변수는 해당 변수를 선언한 {}를 벗어나면 죽는다 (변수의 생명주기)
		 - 정확하게 지칭하지 않으면 기본적으로 가장 가까운 위치의 변수를 사용한다
	*/
	
	//int a;
	// 인스턴스 변수 (instance variable)
	//	  a.k.a 멤버(member), 필드(field),속성(attribute), 속성(property)
	int a = 15;
	
	void methodA() {
		// 지역 변수 (local variable) : 메서드 내부에서 선언된 변수
		int a = 10;
		System.out.println(a); //+젤가까운 지역변수 10을 불러온다
	}
	
	void methodB() {
		int b = 0;
		System.out.println(a); //+ methodA에 있는 int a를 불러올 수 없다
		
		if (true) {
			b = 123;
			System.out.println(a);
			System.out.println(b); //+ methodB의 b(0)값을 가져와서 123으로 변환 가능
		}
	}
	
	class Area2 {
		public Area2() {
			System.out.println(a); //+ 클래스 내부에 클래스 생성, 클래스 외부(C09_Area)에 있는 a(15)를 불러올 수 있다
		}
		
		class Area3 {
			public Area3() {
			System.out.println(a);
			}
		}
	}
	
	public static void main(String[] args) {
		new C09_Area().new Area2();
	}
}
//여기서는 int a;를 불러올 수 없다.
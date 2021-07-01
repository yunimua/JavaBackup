
public class C04_Static {
	/*
		# Static (정적 영역, 클래스 영여 <=> 인스턴스 영역) //+인스턴스 영역과는 반대, 인스턴스는 각개별의 구조를 사용한다..
		
		 - static 영역은 같은 클래스의 모든 인스턴스가 공동으로 사용하는 영역이다
		 - 앞에 static이 붙은 자원은 같은 클래스로 만들어진 모든 인스턴스가
		   공동으로 사용하는 자원이 된다. //(고시원 냉장고 격..)
		 - static 영역은 아무리 인스턴스가 많아도 클래스당 하나밖에 생성되지 않기 때문에
		   메모리가 절약된다
		 - static 영역은 클래스당 하나이기 때문에 클래스 이름에 .을 찍고 접근하는 것이 가능하다 (권장)
		 			//+ 어짜피 static은 class당 하나이기때문에 불러올 수 있다.
		 - static이 붙은 자원은 인스턴스가 생기기 전에도 호출할 수 있다
		 - static 메서드는 static 자원만들 활용할 수 있는 메서드이다
		 - 인스턴스가 하나도 존재하지 않을 때도 static 메서가 사용될 가능성이 존재하기 때문에
		   static 메서드에서는 인스턴스 자원을 사용할 수 없다
	*/
	
	static int a = 10;
	int b = 10; //+ 인스턴스는 메모리를 많이 잡아먹는다..
	
	public static void main(String[] args) {
		//myobj 패키지에 static 자원을 포함한 클래스를 정의해보세요
		// ※ 가로/세로, 너비/높이 금지
		
		System.out.println(붕어빵.완벽한구운시간 + "초"); //인스턴스가 없어도 값을 볼 수 있다. : 33초
		
		붕어빵.완벽한시간변경하기(35);
		
		System.out.println(붕어빵.완벽한구운시간 + "초"); //+ 35초로 표시됨

		붕어빵 붕어1 = new 붕어빵();
		붕어빵 빵2 = new 붕어빵();
		붕어빵 붕어빵3 = new 붕어빵();
		
		System.out.println(붕어1.가로);
		System.out.println(빵2.가로);
		System.out.println(붕어빵3.가로);
		
		System.out.println(붕어빵.가로);
		//System.out.println(붕어빵.팥의양); // 모두 다른 값이기때문에 볼수없다.., 오류발생
		System.out.println(붕어빵.완벽한구운시간); //변하지 않는 값을 static으로 설정하여 하나로 묶을수 있다
		
		System.out.println(붕어1.팥의양);
		System.out.println(빵2.팥의양);
		System.out.println(붕어빵3.팥의양);
		
	}
}

class 붕어빵 {
	static int 완벽한구운시간 = 33;
	static int 가로 = 100; //+일정하다
	static int 세로 = 50;
	int 팥의양; //+일정하지 않다
	int 구운시간;	
	
	static void 완벽한시간변경하기(int time) {
		완벽한구운시간 = time;
	}
}

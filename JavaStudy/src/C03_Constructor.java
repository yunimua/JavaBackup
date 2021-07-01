import java.util.Arrays;

public class C03_Constructor {
// 클래스는 1개당 파일 하나가 기본이나, 2~3개를 할수도 있지만 1개당 1개가 기본
	/*
		# 클래스의 생성자 (Constructor)
		
		 - 클래스의 이름과 똑같은 이름의 메서드
		 - 메서드지만 리턴 타입을 정의하지 않는다
		 - 인스턴스를 생성할 때 new와 함께 사용된다	
		 - 인스턴스 생성시 가장 먼저 호출되기 때문에 주로 인스턴스 초기화에 사용된다 // 이게 인스턴스 : Orange o1 = new Orange(); 
		 - 생성자를 하나도 정의하지 않은 클래스에는 자동으로 생성된 기본 생성자가 존재한다.
		   (아무일도 하지 않음)
		 - 생성자가 존재하는 클래스는 기본생성자를 자동으로 생성하지 않는다.
		   (기본 생성자를 사용하고 싶다면 기본 생성자를 추가로 정의해야 한다) 
		   //ex : Peach peach03 = new Peach(); <<인스턴스 > Peach() {} << 기본 생성자 정의
	*/
	
	public static void main(String[] args) {
		Window w1 = new Window(); // Window가 생성자다
		Apple a1 = new Apple();
		Orange o1 = new Orange();
		Peach p1 = new Peach();
		Peach peach01 = new Peach("연분홍색");
		Peach peach02 = new Peach("덜익은색");
		Peach peach03 = new Peach();
		// Peach peach03 = new Peach(); 기본생성자로 넣을라고하면 에러가 난다. 
		// ㄴ class Peach{} : 기본생성자가 없으면 에러가 난다.
		
		System.out.println(o1.sweet); // 10.0
		System.out.println(o1.address); // 제주도
		System.out.println(Arrays.toString(o1.color)); // 결과 : [255, 255, 0]
		
		
		//바로 문자열로 생성한다 : String.format
		String str = String.format("%d : %d : %d", 10, 20, 50);
		System.out.println(str); // 결과 : 10 : 20 : 50
		
		System.out.println(p1.color); //기본색
		System.out.println(peach01.color);  //연분홍색
		// Peach peach01 = new Peach("연분홍색"); 인스턴스를 생성하면 출력되는 내용 : 연분홍색
		
		// 이하는 기본 생성자이므로 정의하지 않은 기본값이 출력된다
		System.out.println("인스턴스 변수는 배열처럼 초기화가 미리 되어있다");
		System.out.println(a1.color); // 결과 : null
		System.out.println(a1.calrorie); //결과 : 0
		System.out.println(w1.open); // false : 초기값은 false 다 
		System.out.println(w1.lock); // false
		
		System.out.println();
		System.out.println(p1.size); // 10
		System.out.println(p1.color); //기본색
		
	}
}

class Peach{
	String color; // 변하지 않는 값
	int size;
	
	// this : 인스턴스 자기 자신을 가르킨다. +++(설명)
	Peach(String color){ //생성자에 매개 변수를 준다는 것은 복숭아의 색깔을 전달해줘라, 위 Peach p1 = new Peach("분홍색");
		this.color = color; // = color;는 변할수 있는 값
	}
	
	Peach(int size) {
		this.size = size;
		this.color = "default color";
		
	}
	// 생성자 오버로딩 : Peach peach03 = new Peach();에서 오버로딩
	Peach() {
		this.color = "기본색";
		this.size = 10;
	}
}
class Orange{
	//null은 참조형 변수에 들어간다 (Array에서 찾아봐)
	int[] color;
	double sweet;
	String address; // String은 참조형이니까 null이 들어가있다
	
	Orange() { // Orange o1 = new Orange();가 생성되고 나면 아래의 값이 들어가있다
		//클래스와 동일하게 이름으로 메서드를 만들면, 언젠가 새로운 인스턴스가 만들어질때 호출된다
		// return 을 설정할 필요가 없다
		color = new int[] {255, 255, 0};
		sweet = 10.0;
		address = "제주도";
		
	}
}

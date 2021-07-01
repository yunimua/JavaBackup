public class A02_Variable {
	public static void main(String[] args) {
		/*
			# 변수 (Variable)
				- 데이터를 담을 수 있는 공간
				- 자바에서는 변수를 반드시 선언한 뒤에 사용해야 한다
				- 변수 선언시에는 그 변수에 저장할 데이터의 타입을 지정해줘야 한다
				- (같은 영역에서)같은 이름의 변수는 다시 사용할 수 없다
		*/

		/* 
		 	# 변수의 선언 (declare, declaration)
				 - 앞에 타입을 적고 뒤에 변수명을 정한다
				 - 선언과 동시에 초기화 할 수도 있다
				 - 선언 후에 초기화 하지 않은 변수는 사용할 수 없다
				 
		*/

		// 선언을 따로 하고, 뒤에 초기화 하는 방식
		int a, b, c;
		int apple;
		int banana;
		int yet;


		// ※ 프로그래밍 언어에서 =은 왼쪽의 변수에 오른쪽의 값을 넣으라는 뜻이다 (대입 연산)
		a = 3;
		b = 4;
		c = -35;
		apple = 13;
		banana = 10;

		// 선와과 동시에 초기화
		int x = 10, y = 11, z =99;
		int mango = 30;
		int grape = 123;

		// ※ 대입 연산을 하면 변수에 저장되어 있던 값은 사라진다
		a = 7;
		System.out.println("a : " + a);

		// ""문자열이 앞에있으면 이어붙이기가 됨.. 뒤에 계산값이 나오려면 ()필요..
		System.out.println("a + b + c = "  + (a + b + c));
		System.out.println("사과는 모두 " + apple + "개 있습니다.");
		System.out.println("바나나는 모두 " + banana + "개 있습니다.");
		
		System.out.println(x - y * z);
		System.out.println(mango + apple);
		
		//System.out.println(yet); // 값이 초기화되지 않아서 오류.
	}
}

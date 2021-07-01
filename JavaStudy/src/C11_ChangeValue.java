
public class C11_ChangeValue {
	
	public static void main(String[] args) {
		
		//두 변수의 값을 서로 바꾸는 방법
		
		int a = 10;
		int b = 20;
		
		int temp = a; // temp는 임시로 저장해두는 장소
		a = b; //+ 10 > 20 = 20
		b = temp; //temp에 담아둔 값으로 바뀐다
		//b = a; //+ 20 > 20 = 20 이다.
		
		System.out.println(a);
		System.out.println(b);
	}
}

package quiz;

public class A02_Gildong {
	public static void main(String[] args) {
		
		// byte타입은 데이터 전송시에 사용하는 경우가 대부분이다
		// 숫자 범위가 작다고해서 byte타입을 사용하지는 않는다
		String banner = "========== 회원 정보 ==========";
		String name = "홍길동";
		int age = 20;
		String tel = "010-123-1234";
		double height = 178.5;
		double weight = 75; // 소수 점으로 입력될 수도 있으니! int > double로 변경
		String booldType = "O";
		boolean smoker = true;
		
		System.out.println(banner + "\n");
		System.out.println("이름\t: " + name);
		System.out.println("나이\t: " + age);
		System.out.println("Tel\t: " + tel);
		System.out.println("키\t: " + height);
		System.out.println("몸무게\t: " + weight);
		System.out.println("혈액형\t: " + booldType);
		System.out.println("흡연여부\t: " + smoker);
	}
}

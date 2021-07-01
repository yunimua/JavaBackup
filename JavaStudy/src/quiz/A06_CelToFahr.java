package quiz;

import java.util.Scanner;

public class A06_CelToFahr {

	/*
	 	사용자로부터 섭씨 온도를 입력받으면 화씨 온도로 변환하여 출력해주는 프로그램을 만들어보세요.
	 	(변환 공식은 검색 활용, 출력은 소수 첫째 자리까지)
	
	
		- 계산식 : (°C × 9/5) + 32 = °F
	*/
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("섭씨 온도를 입력하세요 >> ");
		double celsius = sc.nextDouble();
		
		double fahrenheit = (celsius * 9/5 + 32.0);
		
		System.out.println("입력한 ℃ 온도의 ℉ 온도는 : " + fahrenheit + " ℉ 입니다.");
		
		/*
			(정답)
		int cel, fahr;
		
		System.out.print("섭씨 온도를 입력 > ");
		cel = new Scanner(System.in).nextInt();
		// - 두번 이상 스캐너 사용 시엔, 개별로 생성. 한번쓰고 버리는 방법
		
		fahr = cel * 9 / 5 + 32;
		
		System.out.printf("%.1f℃는 %.1f℉입니다., cel, fahr);
			
		
		*/
	}
}

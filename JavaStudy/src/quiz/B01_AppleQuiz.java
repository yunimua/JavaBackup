package quiz;

import java.util.Scanner;

public class B01_AppleQuiz {
	public static void main(String[] args) {
		
		/*
			사과를 10개씩 담을 수 있는 바구니가 있다.
			
			사용자가 구매하고 싶은 사과의 개수를 입력하면
			사과를 모두 담기위해 필요한 바구니의 개수를 알려주는 프로그램을 만들어보세요.		
		*/
		
		Scanner sc = new Scanner(System.in);
		
		int apple;
		int basket;
		int basket_su = 10;
		
		System.out.print("구매할 사과 개수를 입력하세요 >");
		apple = sc.nextInt();
		
		basket = apple / basket_su;
		
		if (apple <= 0) {
			System.out.println("잘못 입력했습니다.");
		}else if (apple % basket_su == 0) {
			System.out.println("필요한 바구니 개수는 " + (basket) + "개 입니다.");
		}else {
			System.out.println("필요한 바구니 개수는 " + (basket + 1) + "개 입니다.");
		}

		
		/* 내가 작성한 내용 
 		Scanner sc = new Scanner(System.in);
		
		
		System.out.print("구매할 사과의 개수를 입력하세요 > ");
		int apple = sc.nextInt();
		int baguni = 10;
		
		if (apple >= 1 && apple <=10) {
			System.out.println("필요한 바구니 개수는 1개 입니다.");	
		}else if (apple % baguni == 0 && apple >= 11) {
			System.out.println("필요한 바구니 개수는 " + (apple/baguni) + "개 입니다.");
		}else if (apple % baguni != 0 && apple >= 11) {
			System.out.println("필요한 바구니 개수는 " + (apple/baguni + 1) + "개 입니다.");
		}else {
			System.out.println("잘못 입력하셨습니다.");
		}
		*/
		
		/* if안쓴 정답 버전
		Scanner sc = new Scanner(System.in);
		int apple;
		double basket_size = 10;
		double basket;
		
		System.out.print("사과 몇 개? > ");
		apple = sc.nextInt();
		
		basket = apple / basket_size;
		
		// Math.ceil(a) : a를 소수 첫째자리에서 올린다
		// Math.floor(a) : a를 소수 첫째자리에서 내린다
		//System.out.println("필요한 바구니의 수는 " + (int)Math.ceil(basket) + "개 입니다.");
		System.out.println(basket);
		System.out.printf("필요한 바구니 개수는 %d개 입니다.", (int)Math.ceil(basket));
		*/
		
		/*
		Scanner sc = new Scanner(System.in);
		int apple;
		int basket_size = 10;
		int basket = 10;
		
		System.out.print("사과 몇 개? > ");
		apple = sc.nextInt();
		
		if (apple % basket_size == 0) {
			basket = apple / basket_size;
		}else {
			basket = apple / basket_size + 1;
		}
		
		if (apple < 0) {
			System.out.println("올바른 사과 개수가 아닙니다.");
		}else {
			System.out.printf("필요한 바구니의 개수는 %d개 입니다.", basket);
		}*/
	}
}

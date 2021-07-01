package quiz;

import java.util.Scanner;

public class B01_ScoreToGrade {

	/*
		점수를 입력받으면 점수에 해당하는 알맞은 등급을 출력해주는 프로그램을 만들어보세요
		
		90점 이상 : A
		80점 이상 : B
		70점 이상 : C
		60점 이상 : D
		그 외 : F
		
		※ 유효한 점수는 0 ~ 100점 입니다.
		
	*/
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int score;
		char grade = 'V';
		
		System.out.println("점수를 입력하세요 >> ");
		score = sc.nextInt();
		
		if (score < 0 || score > 100) {
			System.out.println("잘못 입력하셨습니다.");
		}else if (score >= 90) {
			grade = 'A';
		}else if (score >= 80) {
			grade = 'B';
		}else if (score >= 70) {
			grade = 'C';
		}else if (score >= 60) {
			grade = 'D';
		}else {
			grade = 'F';
		}
		
		System.out.printf("당신의 등급은 %s 입니다.\n", grade);
		
		
		// ※ 입력을 받았을 때는 잘못된 값을 먼저 거르는 것이 좋다.
		
		/*
		Scanner sc = new Scanner(System.in);
		
		char grade = 'Z';
		int score;
		
		System.out.print("점수를 입력해주세요 > ");
		score = sc.nextInt();

		if (score < 0 || score > 100) {
			System.out.println("잘못된 점수를 입력하셨습니다.");
			grade = 'F';
		}else if (score >= 90) {
			grade = 'A';
		}else if (score >= 80) {
			grade = 'B';
		}else if (score >= 70) {
			grade = 'C';
		}else if (score >= 60) {
			grade = 'D';
		}else {
			grade = 'F';
		}
		
		System.out.printf("당신의 등급은 %c입니다.\n", grade);		
		*/
	
		/* 내가 쓴 답안
		Scanner sc = new Scanner(System.in);
		
		System.out.print("점수를 입력해주세요 > ");
		int score = sc.nextInt();
		
		if (score < 0 || score > 100) { // 입력값을 벗어나는 거부터 입력하게 수정
			System.out.println("점수를 잘못 입력하셨습니다.");
		}else if (score >= 90) {  // 100점 이하 조건은 걸 필요 없음..(score <=100 이런거..)
			System.out.println("A학점 입니다.");
		}else if (score >=80) {
			System.out.println("B학점 입니다.");
		}else if (score >=70) {
			System.out.println("C학점 입니다.");
		}else if (score >=60) {
			System.out.println("D학점 입니다.");
		}else if (score < 60) {	
			System.out.println("F학점 입니다.");
		}
		*/
	}
}

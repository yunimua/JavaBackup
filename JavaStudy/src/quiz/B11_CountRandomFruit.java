package quiz;

import java.util.Scanner;

public class B11_CountRandomFruit {

	/*
		사용자로부터 숫자를 입력받으면 해당 개수 만큼 랜덤 과일을 선택한다.
		(랜덤으로 등장하는 과일 - apple, banana, kiwi, orange, grape, peach
		
		그 후 각 과일이 몇 번 등장했는지 모두 기록하고 출력
	*/
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("수량 입력 > ");
		int repeat = sc.nextInt();
		
		String[] fruits = {"apple", "banana", "kiwi", "orange", "grape", "peach"};

		int[] fruit_count = new int[fruits.length]; 				  // fruits 배열의 총 개수까지, fruits.length : 6개
		
		for (int i = 0; i< repeat; ++i) {							  // 입력한 수까지 증가(실행조건)
			int random_number = (int)(Math.random() * fruits.length); //랜덤하게 숫자 출력 (0~5 또는 1~6)
			System.out.println(fruits[random_number]);	 	 		  // 랜덤하게 과일이 출력됨.
			fruit_count[random_number]++;							  // 등장한 과일종류에 +1씩 카운트를 증가.
		}
		System.out.println("### 과일 등장 횟수 ###");
		
		for (int i = 0; i < fruits.length; ++i) {					  // 0부터 과일의 마지막 수(종류)까지 증가
			System.out.printf("%s는 %d번 등장했습니다.\n", fruits[i], fruit_count[i]); //화면 출력 : 과일 이름 / 출력된 횟수 
		}
		
		

		
//		String[] fruit = {"apple", "banana", "kiwi", "orange", "grape", "peach"};
//		int[] fruit_num = new int[fruit.length];  // 추가한 내용
//		
//		for (int i = 0; i < repeat; ++i) {
//			int su = (int)(Math.random() * fruit.length);
//			System.out.println(fruit[su]);
//			fruit_num[su]++;
//		}
//		for(int i = 0; i < fruit.length; ++i) {
//			System.out.println(fruit[i] + "는 " + fruit_num[i] + "번 나왔습니다");

			
//			if (fruit_num == 1) {
//				System.out.println(fruit[su]);
//			}else if (fruit_num == 2){
//				System.out.println(fruit[su]);
//			}else if (fruit_num == 3){
//				System.out.println(fruit[su]);
//			}else if (fruit_num == 4){
//				System.out.println(fruit[su]);
//			}else if (fruit_num == 5){
//				System.out.println(fruit[su]);
//			}else if (fruit_num == 6){
//				System.out.println(fruit[su]);
//			}
//		}
	}
}

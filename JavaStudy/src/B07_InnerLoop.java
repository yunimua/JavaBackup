
public class B07_InnerLoop {
	public static void main(String[] args) {
		
		for (int i =0; i < 10; ++i) {
			System.out.println("===================바깥쪽 반복문 " + i); // 10번 반복
			
			for (int j = 0; j < 8; ++j) {
				System.out.printf("------------안쪽 반복문 %d-%d\n", i, j); // 8번 반복, 바깥 1번에 안쪽 8번 반복 (총 80회)
				
				/*for (int k = 0; k < 3; ++k) {
					System.out.printf("+++제일 안쪽 반복문 %d-%d-%d\n", i, j, k); // 3번 반복, 2번 80*3 = 240회 반복됨..
				}*/
			}
		}
		
		/*
			# 다중 반복문으로 구구단 출력해보기
				
				- 2단 ~ 9단
				- 각 단마다 x1 ~ x9까지
		*/
		
		for (int dan = 2; dan <= 9; ++dan) {
			
			System.out.printf("####%d단####\n", dan);
			
			for (int gop = 1; gop <=9; ++gop) {
				System.out.printf("%d x %d = %d\n", dan, gop, dan* gop);
			}
			
			System.out.println();
		}
	}
}

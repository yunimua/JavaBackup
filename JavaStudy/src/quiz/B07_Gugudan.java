package quiz;

public class B07_Gugudan {
	
	/*
		1. 구구단을 다음과 같이 가로로 출력해보세요.
		
		2단 : 2X1......
		3단 : 3X1....
		
		2. 구구단을 다음과 같이 새로로 출력해보세요.
		
		2단	3단	...
		2X1	3X1	...
		2X2	3X2	...
		2X3	3X3	...
	*/
	
	public static void main(String[] args) {
		
		// 적어주신 답
		for (int dan = 2; dan <= 9; ++dan) {
			System.out.printf("%d단: " , dan);
			for (int gop = 1; gop <=9; ++gop) {
				System.out.printf("%dx%d=%-2d"+ ' ', dan, gop, dan*gop);
			}
			System.out.println();
		}
		
		for (int line = 0; line < 10; ++ line) {
			
			for (int dan = 2; dan <= 9; ++dan) {
				if (line ==0) {
					System.out.printf("%d단\t", dan);
				}else {
					System.out.printf("%dx%d=%d\t", dan, line, dan * line);
				}
			}
			System.out.println();
		}

		
//		for (int dan = 2; dan <= 9; ++dan) {
//			System.out.print(dan + "단 : ");
//			
//			for (int gop = 1; gop <=9; ++gop) {
//				System.out.print(dan + "*" + gop + "=" + dan*gop + '\t');
//			}
//			System.out.println("");
//		}
//		for (int gop = 2; gop <=9; ++gop) {	
//			System.out.print(gop + "단" + '\t');
//		}
//		System.out.println("");
//		
//		for (int gop = 1; gop <=9; ++gop) {	
//			
//			for (int dan = 2; dan <= 9; ++dan) {
//				
//				System.out.print(dan + "*" + gop + "=" + dan*gop + '\t');
//			}
//			System.out.println("");
//		}
	}
}

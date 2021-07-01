
public class B06_breakContinue {
	public static void main(String[] arg) {
		
		/*
			# break
			 - 반복문 내부에서 사용하면 속해있는 반복문을 하나만 탈출한다
			 - switch문 내부에서 사용하면 switch문을 탈출한다
			 
			# continue
			 - 반복문 내부에서 사용하면 다음 번 반복으로 바로 넘어간다
			 - continue를 만난 시점에서 밑에 있는 반복문 블록은 모두 무시된다		
		*/
		
		for (int i =0; i <100; ++i) {
			if (i == 3 || i == 4) {
				continue;  // 3,4를 만나면 다음 순으로 넘어간다.
			}
			System.out.println(i);
		}
		
		System.out.println("----------");
		
		for (int i =0; i <10; ++i) {
			if (i == 3 || i == 4) {
				break;  // 3,4를 만나면 멈춤, 나간다.(종료됨)
			}
			System.out.println(i);
		}
		
		
		
		//# for문의 무한 반복
		for (int i =0; true; ++i) {  // (; ture;)를 적어도 무한반복 동일. true일때 계속 반복되기 때문에.
			if (i == 10) {
				break;
			}
			System.out.println(i);
		}	
		
	}
}

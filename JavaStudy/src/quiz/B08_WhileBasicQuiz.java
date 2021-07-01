package quiz;

public class B08_WhileBasicQuiz {

	/*
		while문을 이용하여 다음을 구하시오.
		
		1. 1부터 100 사이에 있는 3의 배수의 총합
		
		2. 355부터 237까지 출력
		
		3. continue 를 반드시 사용하여 3000부터 5000사이의 7의 배수만 출력하기
		
		4. 1부터 200까지의 숫자 중 2의 배수도 아니고 3의 배수도 아닌 숫자들의 총합
		
	*/
	public static void main(String[] args) {
		
		int i = 1;
		int sum = 0;
		/*
		while (i < 101) {
			//System.out.println(i++); // 1~100까지 출력됨
			if (i % 3 == 0) {
				sum += i;
			}
			++i;
		}
		System.out.println(sum);
		System.out.println("-----1번");
		
		i = 1;
		
		while (i < 101) {
			if (++i % 3 == 0) {
				sum += i;
			}
		}
		
		System.out.println("-----1번");
		*/
		i = 355;
		
		while (i >= 237) {
			System.out.print(i--);
			
			if (i !=236) {
				System.out.print(", ");
			}else {
				System.out.println();
			}
		}
		System.out.println("-----2번");
		
		
		i = 3000;
		
		while (i <=5000) {
			if (i % 7 != 0) {
				++i;
				continue;
			}
			System.out.println(i);
			++i; // 위 ++i를 넣지 않으면 출력값이 없이 무한 실행
		}
		System.out.println("-----3번");
		
		
		
		//4번
		i = 1;
		sum = 0;
		
		while (i <= 200) {
			if (i % 2 != 0 && i % 3 != 0) {
				sum += i;
			}
			++i;
		}
		System.out.println(sum);
		System.out.println("-----4번");
		
		
		
		i = 0;
		int total = 0;
		
		while (i <= 100) { // 계속 실행 (조건값)
			++i;
			
			if (i % 3 == 0) {
				total += i; // ++를 쓰면 안됨!!! ㅠㅠㅠ
			}
			
		}
		System.out.println(total);
		System.out.println("-----1번");
		
		i = 356;
		
		while (i >= 237) { 
			--i;
			System.out.println(i);
		}
		System.out.println("-----2번");
		
		
		// 완전 틀림
		i = 3000;
		int j = 5000;
		
		while (j > i) { 
			// System.out.println(j--);
			if (i % 7 != 0) {
				++i;
				continue;
			}
			System.out.println(i);
			++i;
		}	
		System.out.println("-----3번");
		
		
		i = 0;
		total = 0;
		
		while (i <= 200) { 
			++i;
			
			if (i % 2 != 0 && i % 3 != 0) {
				total += (++i -1);
			}
			
		}
		System.out.println(total);
		System.out.println("-----4번");
		
	}
}

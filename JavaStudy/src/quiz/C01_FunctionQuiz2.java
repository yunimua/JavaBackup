package quiz;

import java.util.Arrays;

public class C01_FunctionQuiz2 {
	
	public static void main(String[] args) {
		
		System.out.println(Arrays.toString(range(5,10))); // Arrays.toString 문자열로 변환하기
		System.out.println(Arrays.toString(range(40, 50, 3)));
//		//1번
//		int[] number = range1(10);
//		for (int i = 0; i < number.length; ++i) {
//			System.out.print(number[i] + " ");
//		}
//		System.out.println();
//		
//		//2번
//		int[] min_max = range2(5, 10);
//		for (int i = 0; i < min_max.length; ++i) {
//			System.out.print(min_max[i] + " ");
//		}
//		System.out.println();
//		
//		//3번
//		int[] num_plus = range3(40, 50, 3);
//		for (int i = 0; i < num_plus.length; ++i) {
//			System.out.print(num_plus[i] + " ");
//		}
//		System.out.println();
	}
//		# 다음의 함수를 정의하고 올바르게 동작하는지 테스트 해보세요
//		
//		 1. 최대값을 매개변수로 전달받으면 
//		 	0부터 최대값 미만의 모든 값을 포함하는 int 배열을 생성하여 반환하는
//		 	range 함수를 만들어보세요.
// 	
//			ex: range(10)의 결과 -> [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
	
	/*
		# 함수 오버로딩(overloading)
			- 매개변수의 개수 또는 타입이 다르면 똑같은 함수를 사용할 수 있다
		
		>> int[] range 같은 이름으로 함수를 쓸 수 있었던 것도 오버로딩이다
	*/
	public static int[] range(float num) {
		// println() 에는 다양한 타입들의 오버로딩이 존재한다
		System.out.println(110);
		System.out.println("123");
		System.out.println('A');
		return null;
	}

	public static int[] range (int num) {
		
		int[] arr = new int[num];
		
		for (int i = 0; i < num; ++i) {
			arr[i] = i;
		}
		return arr;
	}
	
	
//	public static int[] range1 (int num) {
//
//		int[] number = new int[num];
//
//		for (int i = 0; i < number.length; ++i) {
//			number[i] = i; // +=는 필요없었음
//		}
//		return number;
//	}

//		 2. 최소값과 최대값을 매개변수로 전달받으면 
// 			최소값부터 최대값 미만의 모든 정수값을 포함하는 int 배열을 생성하여 반환하는
//		 	range 함수를 만들어보세요.
//		 	
//		 	range(5, 10)의 결과 -> [5, 6, 7, 8, 9]
	
	public static int[] range (int start, int end) {
				
		int increase = start > end ? -1 : 1;
		// increase들어가는 시작값은 -1이냐, 1이냐에 따라 시작조건이 시작됨
		
		int[] arr = new int[increase < 0 ? start - end : end - start];
		//start 더 크다 = -1, 그럼 start - end를 한다 (start = 5)
		// end 더 크다 = 1, 그럼 end - start를 한다	(end = 10)
		// 그럼 큰수에서 작은수를 뺀 수가 총 배열 수가 된다 (10-5 = 5)
		
		for (int value = start, index = 0; value != end; value +=increase) {
			//큰수에서 작은수를 뺀 수(5)가 시작 수가 되고, 배열은 0부터 시작되야 하니까 index = 0를 선언
			// value(큰수-작은수)가 큰수(10)까지 실행된다
			// increase(1)이며, 5+1, 5+2, 5+3, 5+4, 5+5 가 실행됨, 결과가 6,7,8,9,10이므로 -1씩 increase를 더한다 
			
			arr[index++] = value; //arr[0]부터 큰수까지 = value값을 배열에 넣기 : 5,6,7,8,9 가 배열에 들어감
		}
		return arr;
	}
	
	
//	내가쓴 2번답, 배열 총 수로 계산함	
//	public static int[] range2 (int num1, int num2) {
//		
//		int[] num_1 = new int[num1];
//		int[] num_2 = new int[num2];
//		
//		int[][] arr = {num_1, num_2};
//		
//		int max = Math.max(num1, num2);
//		int min = Math.min(num1, num2);
//		
//		boolean[] check = new boolean[max];
//		int count = 0;
//		
//		for (int i = 0; i < arr.length; ++i) {
//			for(int j = 0; j < arr[i].length; ++j) {
//				arr[i][j] += j;
//				if(arr[i][j] >= min && arr[i][j] < max) {
//					check[j-1] = true;
//					count++;
//				}
//			}
//		}
//		int[] result = new int[count];
//		int set = 0;
//		for (int i = 0; i < max; ++i) {
//			if (check[i]) {
//				result[set++] = i + 1;
//			}
//		}
//		return result;
//	}


//		 3. 최소값과 최대값과 증가값을 매개변수로 전달받으면
//		 	최소값부터 최대값 미만까지 증가값만큼 증가하는 int 배열을 생성하여 반환하는
//		 	range 함수를 만들어보세요.
//		 	
//		 	range(40, 50, 3)의 결과 -> [40, 43, 46, 49] // 40~ 50 +3씩
//		 	range(40, 45, 5)의 결과 -> [40]
	
	// /** 는 설명 기능, public 위에 작성해야 "public static int[] range"위에 마우스를 올렸을 때 메모처럼 출력됨
	/**
 	문서화 주석 (이 기능에 대한 설명을 할 수 있다)
 	
 	@start
 		시작하는 값을 넣으세요
 	@end
 		끝나는 값을 넣으세요
 	@return	
 		잘못된 값을 입력하면 null이 나오고, 제대로 넣으시면 int[]이 나옵니다.
	 */
	public static int[] range (int start, int end, int increase) {

		if (increase < 0 && start <= end) { // 0보다 작거나 start가 end보다 작으면 null을 준다
			return null;
		}else if (increase > 0 && start >= end) { // 0보다 크지만 end 값이 start보다 작으면 null을 준다
			return null;
		}else if (increase == 0) { // 0일 때 null을 준다
			return null;
		}
		
		int size;
		if (increase > 0) { // increase가 0보다 클때 실행
			int range = end - start; // range에서 최소값 체크 (end50-start40 =10)
			size = range % increase == 0 ? range / increase : range / increase + 1;
			//size = 10 % 3 ==0 ? false이므로 10 / (3+1)4 => 2.5 => 3(반올림..)
			System.out.println(increase + "++");
		}else {
			int range = start - end; // range에서 최소값 체크 (start50-end40 =10)
			size = range % (increase * -1) == 0 ? range / (increase * -1) : range / (increase * -1) + 1;
			//size = 10 % (3*-1)-3 == 0 ? false이므로 -3 +1 => -2
		}
		
		//System.out.println("size: " + size);
		int[] arr = new int[size];
		
		for (int value = start, index = 0; value != end; value += increase ) {
		// for (int value = start, index = 0; increase > 0 ? value < end : value > end; value += increase) {
		// 이하 if문 제거 필요.arr[index++] = value; 위까지.
		// (value = 40, index = 0; 40 != 50; 40 += 3){
			System.out.println(increase + "====");
			if (increase > 0 && value > end) { // increase3가 0보다 크고(O), value40 > end50 클때는(X) false
				break;
			}else if (increase < 0 && value < end) {// increase3가 0보다 작고(x), value40 < end50 클때(o)는 false
				break;
			}
			arr[index++] = value; // arr[0] 부터 [39]까지 숫자를 채워넣는다 => 40, 43, 46, 49
			//System.out.printf("arr[%d] : %d\n", index - 1, value);
		}
		return arr;
	}
		
// 	내가쓴 3번답, 배열의 총 수로 계산해버림
//	public static int[] range3 (int num1, int num2, int plus) {		
//		int[] num_1 = new int[num1];
//		int[] num_2 = new int[num2];
//		int[] plus_1 = new int[plus];
//		
//		int[][] arr = {num_1, num_2, plus_1};
//		
//		int max = Math.max(num1, num2);
//		int min = Math.min(num1, num2);
//		
//		boolean[] check = new boolean[max];
//		int count = 0;
//		
//		for (int i = 0; i < arr.length; ++i) {
//			for(int j = 0; j < arr[i].length; ++j) {
//				arr[i][j] += j;
//				for(int small = min; small < max; small += plus_1.length) {
//					if (arr[i][j] == small) {
//						check[j-1] = true;
//						count++;
//					}
//				}
//			}
//		}
//		int[] result = new int[count];
//		int set = 0;
//		for (int i = 0; i < max; ++i) {
//			if (check[i]) {
//				result[set++] = i + 1;
//			}
//		}
//		return result;
//	}
}	


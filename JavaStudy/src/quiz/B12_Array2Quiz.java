package quiz;

import java.util.Arrays;

public class B12_Array2Quiz {
	
	public static void main(String[] args) {
		
		int[][] numArr = new int[][]{
			{1, 1, 1, 1}, // 가로로 더한게 행의 합
			{1, 1, 1, 1, 1, 1, 1},
			{1, 1, 1, 1, 1},
			{1, 1},
			{1, 1, 1, 1}, // 세로로 더한것이 열의 합
		};
		
		/*
			1. numArr의 모든 값을 0~100 사이의 랜덤 정수로 바꿔보세요
			
			2. 랜덤으로 바뀐 numArr의 모든 값을 출력하고 총합과 평균(소수점 둘째자리)을 구해서 출력해보세요
			
			3. numArr의 각 행의 합을 모두 구해서 출력해보세요
			
			4. numArr의 각 열의 합을 모두 구해서 출력해보세요
		*/
		
		//1번
		for (int row = 0; row < numArr.length; ++row) {
			for (int colnum = 0; colnum < numArr[row].length; ++colnum) {
				
				numArr[row][colnum] = (int)(Math.random() * 101); // 100까지면 +1이되어야 함
			}
		}
		//2번
		int sum = 0;
		int count = 0;
		
		for (int row = 0; row < numArr.length; ++row) {
			
			int len = numArr[row].length;
			count += len;
			//System.out.println(len); // numArr[0~4]배열안에 들어있는 숫자 개수의 총합
			
			for (int colnum = 0; colnum < len; ++colnum) {
				System.out.print(numArr[row][colnum] + "\t");
				sum += numArr[row][colnum];
				//count++;			 // 숫자를 하나씩 더하거나.
			}
			System.out.println();
		}
		System.out.printf("총합 : %d, 평균 : %.2f\n", sum, sum/(double)count); // %.2f\ : 소수점 2번째짜리까지 표시
		
		//3번
		int[] rowSum = new int[numArr.length];
		
		for (int row = 0; row < numArr.length; ++row) {
			for (int colnum = 0; colnum < numArr[row].length; ++colnum) {

				rowSum[row] += numArr[row][colnum];  // if문으로 쓰면 길어짐 (영상참고)
			}
		}
		
		//4번
		int max_len = 0;
		
		for (int row = 0; row < numArr.length; ++row) {
			max_len = Math.max(max_len, numArr[row].length);
			// Math.max 는 더 큰값을 체크하는것...
			
		}
		
		int[] colSum = new int[max_len]; // 가장 큰 값으로 체크된 7이라는 값이 들어있음
		
		for (int row = 0; row < numArr.length; ++row) {
			for (int colnum = 0; colnum < numArr[row].length; ++colnum) {

				colSum[colnum] += numArr[row][colnum];
			}
		}
		
		//배열을 편리하게 문자열로 변환하기
		System.out.println("행의 합 : " + Arrays.toString(rowSum));
		System.out.println("열의 합 : " + Arrays.toString(colSum));
		

		
		
//		int sum = 0, mean = 0, rows = 0;
//		
//		
//		for (int i =0; i < numArr.length; ++i) {
//			for (int j = 0; j < numArr[i].length; ++j) {
//				int random = (int)(Math.random() * 101);					//101이어야함!!!!!!!!!
//				System.out.println(random);									// 랜덤값 0~ 100까지 중 22개 출력
//				sum += random;
//				mean += numArr[i][j] + random - numArr[i][j];
//			}
//			System.out.println("가로의 합은 : " + mean);
//			mean = 0;
//		}
//		System.out.println();
//		System.out.print("----총합 : ");
//		System.out.println(sum);											// 랜덤값 총합
//		System.out.println("----평균 : " + (double)(sum/22.0));	
		
	}
}










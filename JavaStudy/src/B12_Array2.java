
public class B12_Array2 {
	
	public static void main(String[] args) {
		
		// 배열 내부에도 배열을 넣을 수 있다
		
		int[] numbers = {1, 2, 3, 4, 5, 6};
		
		int[][] arr2 = { //배열안 배열은 길이가 모두 달라도 상관없다, 배열안에 배열을 넣을 수 있다
				{65, 66, 67, 68, 69},
				numbers,
				{9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9}
		};
//		System.out.println(arr2[0][3]);		// 결과 : 68  => {65, 66, 67, 68, 69}, 배열(0~4)의 3의 값 (=68)
//		System.out.println(arr2[0]); 		// 결과 : 주소값만 나온다. (=[I@71dac704)
//		System.out.println(numbers); 		// 결과 : 주소값만 나온다. (=[I@123772c4)
//		System.out.println(arr2[1]); 		// 결과 : 주소값만 나온다. (=[I@123772c4), numbers와 arr2[1]는 주소가 같다.
		
//		System.out.println(arr2[0][1]);
//		System.out.println(arr2[0][2]);	
//		System.out.println(arr2[0][3]);	
		
		// n차원 배열은 n중 반복문으로 모두 탐색할 수 있다
		for (int i =0; i < arr2.length; ++i) { //arr2 배열안에 있는 개수만큼 반복
			
			//int[] arr = arr2[i];
			
			for (int j = 0; j < arr2[i].length; ++j) {
				System.out.printf("arr2[%d][%d] : %d\n", i, j, arr2[i][j]);
			}
		}
		
		int[][] block1 = {
				{0, 1, 1},
				{0, 0, 1},
				{0, 0, 1}
		};
		
		int width = 3;
		int height = 3;
		//오목두기 1, 3 ??? 만들기 ??? 
		
		for (int i =0; i < width; ++i) {
			for (int j = 0; j < height; ++j) {
				if (block1[i][j] == 0) {
					System.out.print("□ ");
				}else if (block1[i][j] == 1) {
					System.out.print("■ ");
				}
			}
			System.out.println();
		}
	}
	// 스택 안에는 주소(=numbers)가 들어있다. 배열의 값(={1, 2, 3, 4, 5, 6}은 힙에 들어가 있다
}

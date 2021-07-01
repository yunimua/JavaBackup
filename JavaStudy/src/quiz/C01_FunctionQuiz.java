package quiz;

public class C01_FunctionQuiz {

	private static final boolean check_result = false;


	/*
		# 다음의 함수를 정의하고 올바르게 동작하는지 테스트 해보세요
		
		 1. 전달한 문자가 알파벳이면 true를 반환, 아니면 false를 반환하는 함수
		 2. 전달한 문자가 3의 배수이면 true를 반환, 아니면 false를 반환하는 함수
		 3. 숫자를 하나 전달하면 문자열 "짝수입니다" 또는 "홀수입니다"를 반환하는 함수
		 4. 숫자를 전달하면 해당 숫자의 모든 약수를 배열 형태로 반환하는 함수
		 5. 전달한 정수가 소수라면 true를 반환하고 아니면 false를 반환하는 함수
		 6. 숫자를 전달하면 해당 숫자의 팩토리얼 결과를 반환하는 함수
			factorial : (n)*(n-1)*(n-2)... 3*2*1
	*/
	public static void main(String[] args) {
		boolean alpha = alphabet('d');
		System.out.println(alpha);
		
		boolean three_resullt = three(13);
		System.out.println(three_resullt);
		
		String number = sniffling(14);
		System.out.println(number);
		
		int[] Yaksu = allYaksu(20);
		for (int i = 0; i < Yaksu.length; ++i) {
			System.out.print(Yaksu[i] + " ");
		}
		System.out.println();
		
//		boolean sosu_result = sosu(11);
//		System.out.println(sosu_result);
//		
//		int result = Factorial(4);
//		System.out.println(result);

		System.out.println(isPrime(1101));
		System.out.println(factorial(5));
		System.out.println("10의 재곱근은 : " + Math.sqrt(6));
		
	}
	//1번
	public static boolean alphabet (char word) {
//		boolean check = ((word >= 'a') && (word <= 'z') || ((word >= 'A') && (word <= 'Z'))) ? true : false;
//		
//		return check;
		return word >= 'a' && word <= 'z' || word >= 'A' && word <= 'Z';
	}
	
	//1번 풀이
	public static boolean isAlphabet(char ch) {
		return ch >= 'a' && ch <= 'z' || ch >= 'A' && ch <= 'Z'; // 아래와 같다
		//boolean 자리의 함수는 return이 들어갈 수 있다
		
//		if (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z'){
//			return true;
//		}else {
//			return false;
//		}
	}

	
	//2번
	public static boolean three (int num) {
//		boolean number = num % 3 == 0 ? true : false;
//		
//		return number;
		return num % 3 == 0;  // 이렇게 넣으면 된다.ㅠㅠㅠㅠ
	}
	
	
	
	//3번
	public static String sniffling (int number) {
//		String snifflings = number % 2 == 0 ? "짝수입니다" : "홀수입니다";
//		
//		return snifflings;
		return number % 2 == 0 ? "짝수입니다" : "홀수입니다";  // 한줄로 끝내기..
	}
	
	//4번 : 숫자를 전달하면 해당 숫자의 모든 약수를 배열 형태로 반환하는 함수
	public static int[] allYaksu (int num) {
		// 50인 경우 boolean타입 변수 50개를 생성
		boolean[] divided = new boolean[num];
		
		int count = 0;
		for (int i = 1; i <= num; ++i) {
			if (num % i == 0) { 
				//System.out.println(i);  // 1,2,4,5,10,20 약수가 출력됨
				divided[i - 1] = true; // 배열에 나누어 떨어진 숫자들을 표시에 놓음 : divided[0] 부터 시작이므로 -1
				// System.out.println(divided[i-1]);  // true가 6개 출력됨
				count++;				// 입력한 수까지 1부터 나누어 0으로 떨어지면 카운트를 증가 : 총 6개(num 20)
			}
		}
		//System.out.println(count); // count는 6이다

		int[] yaksu = new int[count]; //배열 6개가 생성
		int index = 0;
		
		for (int i = 0; i < num; ++i) {
			if (divided[i]) { // 변수에 저장된 값이 true일 때 카운트 증가
				yaksu[index++] = i + 1; // yaksu[index(0부터)++(1씩증가)] = 0 + 1, 1부터 +num까지
			}	
		}
		//System.out.println(yaksu[5]); // 0~5까지 저장된 약수가 출력됨
		return yaksu;
	}
	
	
	//5 : 전달한 정수가 소수라면 true를 반환하고 아니면 false를 반환하는 함수
	
	public static boolean isPrime (int num) {
		if (num < 2) { //2보다 작으면 리턴(다시입력)
			return true; 	
		}else if (num == 2) { // num이 2면 소수다
			return true; // 2가 아닐때만 밑으로 내려간다.
		}else if (num % 2 == 0) { // 2로나눠서 0으로 떨어지는게 2개이상이면 false
			return false; // 
		}
	
		for (int i = 3; i <= Math.sqrt(num); i += 2) { //Math.sqrt(num) : num의 제곱근을 구해서 반환
			if (num % i == 0) { //4의 재곱근은 : 2.0, 2로 나누어 0으로 떨어지므로 false
				return false;
			}
		}
		return true;
	}	
	
	//내가푼거,이건 모든 약수가 나오지않음(마지막 나눠진 수가 안나옴)
//	public static boolean sosu (int num) {
//		
//		boolean check = false;
//		int count = 0;
//		for (int i = 1; i <= num; ++i) {
//			if (num % i == 0) {
//				count++;
//			}
//		}
//		return check = count == 2 ? true : false;
//	}
	
	// 6. 숫자를 전달하면 해당 숫자의 팩토리얼 결과를 반환하는 함수
	// factorial : (n)*(n-1)*(n-2)... 3*2*1
	
	public static int factorial (int num) {
		int factorial = 1;
		for (int i = num; i > 0; --i) { // num입력한 수까지 -하면서 곱한다, 10입력시 (10-0)*(10-1)*(10-3)*(10-4)*...
			factorial *= i;
		}
		return factorial;
	}
	//다른방법 답안
	//어떤 함수가 자기 자신을 불러서 사용하는 것을 재귀 함수라고 부른다
	public static int recursive_factorial (int num) { // 이건 성능이 안좋음... 겉멋
		if (num == 1) {
			return 1; // 1까지 도착하면 리턴으로 돌아가라, 멈춰라
		}
		return num * recursive_factorial(num - 1);// 10을 넣으면, 9 * 8 * 7 * 6... -까지간다
	}
	
	
	//내가푼거
//	public static int factorial (int num) {
//		
//		int fac = 1;
//		for (int i = num; i > 0; --i) {
//			fac *= i;
//		}
//		return fac;
//	}
}

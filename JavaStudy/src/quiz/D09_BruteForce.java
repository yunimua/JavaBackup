package quiz;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class D09_BruteForce {

	/*
		# 비밀번호 길이를 입력받으면 다음 문자로 만들 수 있는 모든 해당 길이의 비밀번호를 출력해보세요
		
		- 영어 대/소문자 [a-z] 26개, [A-Z] 26개 => 총 52개
		- 숫자 [0-9] => 총 10개
		- 특수문자 (shift 누르고 숫자에 있는것들만) !@#$%^&*() => 총 10개
		
		도합 72개...
		
		ex) 4 > 0000 ~ zzzz
	*/
	
	static String charset = "abcdeefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^&*()"; //+ 문자들의 집합(74진수)

	public static void main(String[] args) {
		bruteforce(10);
	}
	
	/*
		 # 10진수의 경우
		 
		 	- 1234567 
		 		
		 		1234567 % 10 => 7 (일의 자리 분리)
		 		1234567 / 10 => 123456(일의 자리 삭제)
		 		123456 % 10 => 6 (일의 자리 분리)
		 		123456 / 10 => 12345 (일의 자리 삭제)
	
	*/
	
	public static void bruteforce(int password_size) {
		char[] arr = charset.toCharArray();
		int len = charset.length();
		long all_passwoed = (long) Math.pow(len, password_size); //+ Math.pow : 제곱!
		
		for (long i = 0; i < all_passwoed; ++i) {
			//System.out.println(i);
			long value = i;
			
			String password = "";
			while(value > 0) {
				password += arr[(int)value % len];
				value /= len;
			}
			
			if (password.length() < password_size) {
				int gap = password_size - password.length(); //+ 한번만 값을 구하고 그 값으로 아래를 계산
				for (int j = 0; j < gap; ++j) { //+ gap자리에 password_size - password.length(); 를 넣으면 값이 계속 감소됨
					password = "a" + password;
				}
			}
			
			System.out.println(password);
		}
		System.out.println("len : " + len);
	}

	
	// 오수빈, 윤수영님 답안??
//	private static ArrayList<Character> availableList = new ArrayList<>();
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		System.out.println("비밀번호 길이를 입력하세요.>");
//		int input = sc.nextInt();
//		
//		for(int i = '0'; i <= '9'; i++) {
//			availableList.add((char)i);
//		}
//		for(int i = 'a'; i <= 'z'; i++) {
//			availableList.add((char)i);
//		}
//		for(int i = 'A'; i <= 'Z'; i++) {
//			availableList.add((char)i);
//		}
//		Collections.addAll(availableList, '!','@','#','$','%','^','&','*','(',')');
//		// availableList : ArrayList에 숫자, 알파벳대소문자, 특수문자를 모두 넣는다
//		// System.out.println(availableList);
//		
//		char[] prevChars = new char[input-1]; //+ 배열은 0부터 시작하므로 -1
//		
//		printAllAvailablePassword(prevChars, input);
//	}
//
//	private static void printAllAvailablePassword(char[] prevChars, int len) {
//		for(int i =0, size = availableList.size(); i < size; i++) { // array배열의 마지막 크기(72)까지 증가
//			if(len == 1) {
//				for(int j = prevChars.length-1; j > -1; j--) { // 입력한 숫자 배열의 총 크기 (2면 2-1)에서 시작해서 0까지(-1)이될떄까지 실행
//					System.out.print(prevChars[j]); 
//				}
//				System.out.println(availableList.get(i)); // 입력한 수의 나머지 글자는 array리스트의 문자열을 반복하여 출력
//			} else {
//				prevChars[len-2] = availableList.get(i);
//				printAllAvailablePassword(prevChars, len-1);
//			}
//		}
//	}
	
	
	// 소영님답안
//	public static String pw = "abcdeefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^&*()";
//	public static int cnt = pw.length();
//	   
//   public static void main(String[] args) {
//      Scanner sc = new Scanner(System.in);
//      int len; // 입력받는 비밀번호 길이.
//
//      System.out.print("how long? ");
//      len = sc.nextInt();
//      System.out.println("length: " + len);
//      
//      int[] count = new int[len]; // 길이별 몇 번째 글자를 출력할지 저장해두는 배열.
//      boolean[] check = new boolean[len]; // 3자리 이상일 때 이전 자리수가 전전자리수가 바뀔때까지 계속 0으로 나누어 떨어지니까.. 체크해주는 용.
//      
//      while(count[0] != cnt) {
//         for (int i = 0; i < len; i++) {
//            System.out.print(pw.charAt(count[i] % cnt));
//         }
//         System.out.print("\n");
//         
//         count[len-1]++;
//         for (int j = len - 2; j >= 0; j--) {
//            if (count[j + 1] != 0 && count[j + 1] % cnt == 0 && check[j] == false) {
//               count[j]++;
//               check[j] = true;
//            } else if (count[j + 1] != 0 && count[j + 1] % cnt != 0 && check[j] == true) {
//            	check[j] = false;
//            }
//         }
//      }
//   }
}

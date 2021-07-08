package quiz;

import java.io.*;
import java.util.*;

public class E05_HackTool {

	/*
		우리가 사용한 암호 방식은 키 값이 25개밖에 없는 허접한 암호화 방식입니다.
		목표 파일의 맨 앞 부분 10줄을 1 ~ 25의 키로 모두 복호화 해보세요.
	
	*/
	
	public static void main(String[] args) {
		bruteforce("files/frankenstein_encrypted.txt");
	}
	
	public static void bruteforce(String path) {
		ArrayList<String> lines = new ArrayList<>();
		
		File target = new File(path);
		
		try (
				FileReader fin = new FileReader(target);
				BufferedReader in = new BufferedReader(fin);
		) {
			
			// 10번 또는 파일이 끝날 때까지 반복 : i가 10이면서 Line이 null이 아니어야 한다
			String line;
			for (int i = 0; i < 10 && (line = in.readLine()) != null; ++i) {
				// 비어있는 줄 제외하고 꽉 찬 열줄을 보고 싶음
				//if (line.trim().equals("")) {
				
				// 줄이 비어있거나 문자가 5개도 안되는 줄은 안본걸로 치겠다
				if (line.trim().equals("") || line.length() < 5) {
					--i;
				}else {
					lines.add(line);
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Scanner sc = new Scanner(System.in);
		
		for (int key = 1; key < 26; ++key) {
			System.out.printf("-----key: %d -------------------------------\n", key);
			for (String line : lines) {
				for (char ch : line.toCharArray()) {
					if (Character.isUpperCase(ch)) {
						ch = (char) (ch - key < 'A' ? ch - key + 26 : ch - key); //A보다 작으면 +26을 더하고, 아니면 뺀걸 준다
					}else if (Character.isLowerCase(ch)) {
						ch = (char) (ch - key < 'a' ? ch - key + 26 : ch - key);
					}
					System.out.print(ch);
				}
				System.out.println();
			}

		}
		System.out.println("프로그램 끝!!");
	}
}

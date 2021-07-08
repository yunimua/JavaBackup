package quiz;

import java.io.*;
import java.nio.charset.*;
import java.util.*;

public class E05_Encrypt {
	
	/*
		frankenstein.txt를 암호화한 파일 frankenstein_encrypted.txt를 만들어보세요
		※ 열쇠값은 랜덤인데 0이랑 26은 안됨, 원본과 같은 결과가 나와서는 안됨
		
		# 암호 열쇠 값이 1인 경우
			 +1
		   C --> D
		   A --> B
		   R --> S
		   
		# 암호 열쇠 값이 2인 경우
			 +2
		   C --> E
		   A --> C
		   R --> T
		   
		CAR --> ECT
		ZOO --> BQQ
		
		
		1. 영문 대소문자 조건 > +2(열쇠값)
		 - z일 경우 +a
		2. 영문이 아닐 경우 그대로
		3. 
	*/

	
	public static void main(String[] args) {

		encryption("files/frankenstein.txt", (int)(Math.random() * 24)+ 1);
		
	}
	
	public static boolean encryption(String path, int key) {
		
		//path에는 String 파일명 : "files/frankenstein.txt"
		File file = new File(path); 
	    
		// 파일이름 : frankenstein.txt
	    String fileName = file.getName(); 
	    
	    // substring(0, .)파일 이름 첫글자부터 .으로 끝나는 부분까지 짜르기
	    String realFileName = fileName.substring(0, fileName.indexOf("."));
		
	    // .까지 자른 파일 이름에 + "_encrypted.txt" => files/frankenstein_encrypted.txt
		File dst = new File("files/" + realFileName + "_encrypted.txt");
		
		try (
//				FileReader fin = new FileReader(file);
//				BufferedReader in = new BufferedReader(fin);
//				FileWriter fout = new FileWriter(dst);
//				BufferedWriter out = new BufferedWriter(fout);
		
				//위와 같은 형태
				BufferedReader in = new BufferedReader(new FileReader(file));
				BufferedWriter out = new BufferedWriter(new FileWriter(dst));
		
		) {
			String line;
			while((line = in.readLine()) != null) { // 한줄씩 반복됨
				for (char ch : line.toCharArray()) { // 한줄씩 꺼낸다
					if(Character.isUpperCase(ch)) { // 영어 대문자 체크
						ch = (char)((ch - 'A' + key) % 26 + 'A'); 
					}else if (Character.isLowerCase(ch)) { // 영어 소문자 체크
						ch = (char)((ch - 'a' + key) % 26 + 'a');
					}
					out.append(ch); //알파벳으로 찾은 문자를 저장한다
				}
				out.append("\n");
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.printf("암호화 성공! [키: %d]\n" , key);
		return true;
	}
		
}

package quiz;

import java.io.*;
import java.util.*;

public class E05_Decrypt {

	/*
		사용자로부터 파일명과 열쇠값을 입력받으면
		해당 열쇠값으로 복호화 한 결과물을 생성하는 프로그램을 만들어보세요.
		
		test. 암호화되어있는 frankenstein_encrypted.txt를 복호화 해보세요
	
	*/
	public static void main(String[] args) {
		
		encryption("files/frankenstein_encrypted.txt");
	}
	
	public static void encryption(String path) {
		
		ArrayList<String> lines = new ArrayList<>();
		File target = new File(path);
		
		try (BufferedReader in = new BufferedReader(new FileReader(target));) {
			String line;
			while((line = in.readLine()) != null) {
				lines.add(line);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		//System.out.printf("복호화 성공! [키: %d]\n" , key_value);
		Scanner sc = new Scanner(System.in);
		System.out.print("key 값을 입력 : ");
		int key_value = sc.nextInt();
		
		for (String line : lines) {
			for (char ch : line.toCharArray()) {
				if (Character.isUpperCase(ch)) {
					ch = (char) (ch - key_value < 'A' ? ch - key_value + 26 : ch - key_value); //A보다 작으면 +26을 더하고, 아니면 뺀걸 준다
				}else if (Character.isLowerCase(ch)) {
					ch = (char) (ch - key_value < 'a' ? ch - key_value + 26 : ch - key_value);
				}
				System.out.print(ch);
			}
			System.out.println();
		}
		System.out.printf("복호화 성공! [키: %d]\n" , key_value);
	}
}

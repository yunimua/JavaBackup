package quiz;

import java.io.*;

public class E05_Decrypt {

	/*
		사용자로부터 파일명과 열쇠값을 입력받으면
		해당 열쇠값으로 복호화 한 결과물을 생성하는 프로그램을 만들어보세요.
		
		test. 암호화되어있는 frankenstein_encrypted.txt를 복호화 해보세요
	
	*/
	public static void main(String[] args) {
		
		encryption("files/frankenstein.txt", (int)(Math.random() * 24)+1);
	}
	
	public static boolean encryption(String path, int key) {
		
		File file = new File(path);
	      
	    String fileName = file.getName();
	    String realFileName = fileName.substring(0, fileName.indexOf("."));
		
		File dst = new File("files/" + realFileName + "_encrypted.txt");
		
		try (
				FileReader fin = new FileReader(file);
				BufferedReader in = new BufferedReader(fin);
				FileWriter fout = new FileWriter(dst);
				BufferedWriter out = new BufferedWriter(fout);
		) {
			String line;
			while((line = in.readLine()) != null) { // 한줄씩 반복됨
				System.out.println(line);
				
				for (char ch : line.toCharArray()) { // 한줄씩 꺼낸다
					if(Character.isUpperCase(ch)) { // 영어 대문자 체크
						ch = (char)((ch - 'A' + key) % 26 + 'A'); 
					}else if (Character.isLowerCase(ch)) { // 영어 소문자 체크
						ch = (char)((ch - 'a' + key) % 26 + 'a');
					}
					out.append(ch);
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

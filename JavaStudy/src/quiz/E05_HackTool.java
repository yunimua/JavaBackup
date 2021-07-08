package quiz;

import java.io.*;
import java.util.*;

public class E05_HackTool {

	/*
		�츮�� ����� ��ȣ ����� Ű ���� 25���ۿ� ���� ������ ��ȣȭ ����Դϴ�.
		��ǥ ������ �� �� �κ� 10���� 1 ~ 25�� Ű�� ��� ��ȣȭ �غ�����.
	
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
			
			// 10�� �Ǵ� ������ ���� ������ �ݺ� : i�� 10�̸鼭 Line�� null�� �ƴϾ�� �Ѵ�
			String line;
			for (int i = 0; i < 10 && (line = in.readLine()) != null; ++i) {
				// ����ִ� �� �����ϰ� �� �� ������ ���� ����
				//if (line.trim().equals("")) {
				
				// ���� ����ְų� ���ڰ� 5���� �ȵǴ� ���� �Ⱥ��ɷ� ġ�ڴ�
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
						ch = (char) (ch - key < 'A' ? ch - key + 26 : ch - key); //A���� ������ +26�� ���ϰ�, �ƴϸ� ���� �ش�
					}else if (Character.isLowerCase(ch)) {
						ch = (char) (ch - key < 'a' ? ch - key + 26 : ch - key);
					}
					System.out.print(ch);
				}
				System.out.println();
			}

		}
		System.out.println("���α׷� ��!!");
	}
}

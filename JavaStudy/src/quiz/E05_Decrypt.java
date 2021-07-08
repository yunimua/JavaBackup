package quiz;

import java.io.*;
import java.util.*;

public class E05_Decrypt {

	/*
		����ڷκ��� ���ϸ�� ���谪�� �Է¹�����
		�ش� ���谪���� ��ȣȭ �� ������� �����ϴ� ���α׷��� ��������.
		
		test. ��ȣȭ�Ǿ��ִ� frankenstein_encrypted.txt�� ��ȣȭ �غ�����
	
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
		//System.out.printf("��ȣȭ ����! [Ű: %d]\n" , key_value);
		Scanner sc = new Scanner(System.in);
		System.out.print("key ���� �Է� : ");
		int key_value = sc.nextInt();
		
		for (String line : lines) {
			for (char ch : line.toCharArray()) {
				if (Character.isUpperCase(ch)) {
					ch = (char) (ch - key_value < 'A' ? ch - key_value + 26 : ch - key_value); //A���� ������ +26�� ���ϰ�, �ƴϸ� ���� �ش�
				}else if (Character.isLowerCase(ch)) {
					ch = (char) (ch - key_value < 'a' ? ch - key_value + 26 : ch - key_value);
				}
				System.out.print(ch);
			}
			System.out.println();
		}
		System.out.printf("��ȣȭ ����! [Ű: %d]\n" , key_value);
	}
}

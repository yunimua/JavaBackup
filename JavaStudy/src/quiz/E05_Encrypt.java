package quiz;

import java.io.*;
import java.nio.charset.*;
import java.util.*;

public class E05_Encrypt {
	
	/*
		frankenstein.txt�� ��ȣȭ�� ���� frankenstein_encrypted.txt�� ��������
		�� ���谪�� �����ε� 0�̶� 26�� �ȵ�, ������ ���� ����� ���ͼ��� �ȵ�
		
		# ��ȣ ���� ���� 1�� ���
			 +1
		   C --> D
		   A --> B
		   R --> S
		   
		# ��ȣ ���� ���� 2�� ���
			 +2
		   C --> E
		   A --> C
		   R --> T
		   
		CAR --> ECT
		ZOO --> BQQ
		
		
		1. ���� ��ҹ��� ���� > +2(���谪)
		 - z�� ��� +a
		2. ������ �ƴ� ��� �״��
		3. 
	*/

	
	public static void main(String[] args) {

		encryption("files/frankenstein.txt", (int)(Math.random() * 24)+ 1);
		
	}
	
	public static boolean encryption(String path, int key) {
		
		//path���� String ���ϸ� : "files/frankenstein.txt"
		File file = new File(path); 
	    
		// �����̸� : frankenstein.txt
	    String fileName = file.getName(); 
	    
	    // substring(0, .)���� �̸� ù���ں��� .���� ������ �κб��� ¥����
	    String realFileName = fileName.substring(0, fileName.indexOf("."));
		
	    // .���� �ڸ� ���� �̸��� + "_encrypted.txt" => files/frankenstein_encrypted.txt
		File dst = new File("files/" + realFileName + "_encrypted.txt");
		
		try (
//				FileReader fin = new FileReader(file);
//				BufferedReader in = new BufferedReader(fin);
//				FileWriter fout = new FileWriter(dst);
//				BufferedWriter out = new BufferedWriter(fout);
		
				//���� ���� ����
				BufferedReader in = new BufferedReader(new FileReader(file));
				BufferedWriter out = new BufferedWriter(new FileWriter(dst));
		
		) {
			String line;
			while((line = in.readLine()) != null) { // ���پ� �ݺ���
				for (char ch : line.toCharArray()) { // ���پ� ������
					if(Character.isUpperCase(ch)) { // ���� �빮�� üũ
						ch = (char)((ch - 'A' + key) % 26 + 'A'); 
					}else if (Character.isLowerCase(ch)) { // ���� �ҹ��� üũ
						ch = (char)((ch - 'a' + key) % 26 + 'a');
					}
					out.append(ch); //���ĺ����� ã�� ���ڸ� �����Ѵ�
				}
				out.append("\n");
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.printf("��ȣȭ ����! [Ű: %d]\n" , key);
		return true;
	}
		
}

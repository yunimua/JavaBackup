package quiz;

import java.io.*;

public class E05_Decrypt {

	/*
		����ڷκ��� ���ϸ�� ���谪�� �Է¹�����
		�ش� ���谪���� ��ȣȭ �� ������� �����ϴ� ���α׷��� ��������.
		
		test. ��ȣȭ�Ǿ��ִ� frankenstein_encrypted.txt�� ��ȣȭ �غ�����
	
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
			while((line = in.readLine()) != null) { // ���پ� �ݺ���
				System.out.println(line);
				
				for (char ch : line.toCharArray()) { // ���پ� ������
					if(Character.isUpperCase(ch)) { // ���� �빮�� üũ
						ch = (char)((ch - 'A' + key) % 26 + 'A'); 
					}else if (Character.isLowerCase(ch)) { // ���� �ҹ��� üũ
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
		System.out.printf("��ȣȭ ����! [Ű: %d]\n" , key);
		return true;
	}
	
}

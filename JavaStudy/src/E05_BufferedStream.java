import java.io.*;
import java.nio.charset.*;

public class E05_BufferedStream {

	/*
		# Buffered
		
		  - �����͸� �аų� �� �� �� ���ھ� ��ũ���� ������ ����ϴ� �� ����
		  	�ѹ��� ���� ���� �����͸� �ּ������� ����ϴ� ���� ���������� �� �پ��.
		  - ���� ����� �̸� ������ Ŭ�������� �տ� Buffered��� �̸��� �پ� �ִ�.
	*/
	
	public static void main(String[] args) {

		// byte ����� ��� �͵��� ������ �� ����Ѵ� (InputStream, OutputStream)
		
		try {
			BufferedOutputStream out = new BufferedOutputStream( //+ ���۴� �������� �˾Ƽ� ������?
					new FileOutputStream("files/d.txt"), 2048);
			
			for (int i = 0; i < 1000; ++i) {
				out.write("�ȳ��ϼ��� �ݰ����ϴ�.\n ".getBytes());
			}
			
			// out.flush(); // buffer�� ������������ ������ ���� ����
			
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// char ����� ���ڸ� ���ϰ� ������ �� ����Ѵ� (Reader, Writer)
		try {
			BufferedWriter out = new BufferedWriter(
					new FileWriter("files/e.txt", Charset.forName("MS949")), 2048);
			for (int i = 0; i < 1000; ++i) {
				out.write("�ȳ��ϼ��� �ݰ����ϴ�.\n");
			}
			
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("�� ����ϴ�.");
		
		// try-catch�� AutoClose�� �����Ǿ��ִ�.
		try (BufferedReader in = new BufferedReader(new FileReader("files/e.txt", Charset.forName("EUC-KR")))){ //+ 2048�� ���� ������ ����
			// BufferedReader in = new BufferedReader(new FileReader("files/e.txt", Charset.forName("UTF-8")), 2048);
			//+ { >> �ȿ� ���� �ʰ�, ()�� ������ Close�� �ڵ����εȴ�. in.close�� �ȳ־ �ȴ�.
			
			String line;
			while((line = in.readLine()) != null) { // in.readLine() : null ������ ������, null�� �ƴҶ��� �����ϸ� null���� ����ȴ�
				System.out.println(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

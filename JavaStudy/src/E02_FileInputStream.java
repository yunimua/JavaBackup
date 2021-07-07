import java.io.*;
import java.util.*;

public class E02_FileInputStream {

	public static void main(String[] args) {
		
		try {
			// ������ �о���̴� ���
			FileInputStream in = new FileInputStream("a.txt");
			
			/*
				InputStream.read() : �� ���ھ� �о���δ�. (�ѱ��� ������)
				InputStream.read(byte[]) : ������ �����͸� byte[]�� ũ�⸸ŭ �о���δ�.
				InputStream.read(byte[], start, end) : ������ �Ϻκи� �бⰡ �����ϴ�
				
				�� ������ �޼��� ��� �� �̻� ���� ���� ���ٸ� -1�� ��ȯ�Ѵ�.
			*/
			
			byte[] buffer = new byte[16];		
			// line1:
			buffer[0] = 'l';
			buffer[1] = 'i';
			buffer[2] = 'n';
			buffer[3] = 'e';
			buffer[4] = ':';
			
			int len = -1, count = 0;
			while ((len = in.read(buffer, 6, 10)) != -1) { // (buffer, 6, 10) 6��°���� 10��°���� �о��ּ���
				buffer[4] = (byte)(count++ + '0');
				System.out.println(buffer[0]);
				System.out.println(new String(buffer));
				System.out.println("---------------------");
			
//			byte[] buffer = new byte[10];
//			
//			int len = -1;
//			while ((len = in.read(buffer)) != -1) {
//				System.out.println(new String(buffer));
//				System.out.println("---------------------");
			
			
			// [65, 66, 67, 68, 10, 72, 101, 108, 108, 111]-- 10���� => A, B, C, D, H, e, l, l, o
			// [32, 119, 111, 117, 108, 100, 33, 33, 10, 111]-- 9���� => (���), w, o, u, l, d, !, !, -
//			System.out.print(Arrays.toString(buffer));
//			System.out.printf("-- %d����\n", len);
			
			}

		
			// 3��° Ǯ�� : �ѱ��ھ� ���� ���� �ش� �ݺ����� �⺻�� �ȴ�
//			int ch = -1;
//			while ((ch = in.read()) != -1) {
//				System.out.print((char)ch);
//			}
			
			// 2��° Ǯ��
//			while(true) {
//				int ch = in.read();
//				
//				if (ch == -1) {
//					System.out.println("������ ������ �о����ϴ�!");
//					break;
//				}else {
//					System.out.print((char)ch);
//				}
//			}
			
			// 1��° Ǯ��(for������ ����) : Hello������ ��µ� >> E01_JavaIO �����ϴ� ���뿡�� �ѱ��̾��� �κ��� �������� ����
//			for (int i = 0; i < 10; ++i) { 
//				System.out.print((char)in.read());
//			}

			// 1��° �ҷ����� Ȯ��
//			System.out.println(in.read()); // 65 : A
//			System.out.println(in.read()); // 66 : B
//			System.out.println(in.read()); // 67 : C
//			System.out.println(in.read()); // 68 : D
//			System.out.println(in.read()); // ���ϴ� �ѱ��� ����
//			System.out.println(in.read());
			
			in.close();			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

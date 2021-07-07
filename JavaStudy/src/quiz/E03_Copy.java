package quiz;

import java.io.*;
import java.util.*;

public class E03_Copy {

	/*
		# image ���� ������ ��� ������ image_copy ���� ���η� �����غ�����
		
		EASY : �׳� ���۸� �ϸ� ����
		HARD : ���߿� ���� ������ ���� �̸��� ���ϴ��� �ùٸ��� �����ϸ� ����
	*/
	
	
	public static void main(String[] args) throws IOException {
		
		File src = new File("image"); // ������ �̹��� ������
		
		File dst = new File("image_copy"); // ī���� ����
		
		if (!dst.exists()) {
			dst.mkdir(); // ������ �����
		}
		
		File[] src_files = src.listFiles(); // ���丮�ȿ� ������ �迭�� �ִ´�
		
		for (File file : src_files) {	// ���� ����Ʈ�� �ϳ��� �����´�		
			System.out.println(file);
			System.out.println("���丮 ���� : " + (file.isDirectory() ? "Y" : "N"));
			System.out.println("-------------------");
			
			if (file.isDirectory()) { // ���丮���� üũ
				System.out.println("Dir to create : " + file.getName());
				
				File new_dir = new File(dst, file.getName()); // new_dir ���丮�� dst���丮 + �ȿ� file �̸��� �����ͼ� ���丮�� ����
				new_dir.mkdirs();
				
				File[] inner_files = file.listFiles(); // ���丮 �ȿ� ���� ����Ʈ
				
				for (File file2 : inner_files) { // �ȿ��ִ� ���� ����Ʈ�� �ϳ��� ������
					System.out.println(file2);
					System.out.println("���丮 ����2 : " + (file2.isDirectory() ? "Y" : "N"));
					System.out.println("-------------------");
					
					if (!file2.isDirectory()) { // file2�� ���丮�� �ƴ� ���
						// 3��° Ǯ�� �����ϰ� >> file2 / new_dir / file2 ���� ����
						FileInputStream in = new FileInputStream(file2); // ���ϸ���Ʈ�� ����
						FileOutputStream out = new FileOutputStream(new File(new_dir, file2.getName())); // ���ο� File�� ���丮 ����
						
						byte[] buffer = new byte[2048]; // 2048���� �д´�
						int len = -1;
						while((len = in.read(buffer)) != -1) { // ���丮 �ȿ� ������ ���� �о, to_write �迭�� ����
							byte[] to_write = new byte[len];
							
							for (int i = 0; i < len; ++i) {
								to_write[i] = buffer[i];
							}
							out.write(buffer); // FileInputStream���� �ҷ��� ������ ����(out = Input = save)
						}
						out.close();
						in.close();
					}
				}
			}else {
				FileInputStream in = new FileInputStream(file);
				FileOutputStream out = new FileOutputStream(new File(dst, file.getName()));
				
				byte[] buffer = new byte[2048]; // 2048���� �д´�
				// 3��° Ǯ��
				int len = -1;
				while((len = in.read(buffer)) != -1) {
					byte[] to_write = new byte[len];
					
					for (int i = 0; i < len; ++i) {
						to_write[i] = buffer[i];
					}
					out.write(buffer);
				}
				
				// 2��° Ǯ��
//				int _byte = -1;
//				while((_byte = in.read()) != -1) {
//					out.write(_byte);
//				}
				
				// 1��° Ǯ��
//				int len = -1;
//				while((len = in.read(buffer)) != -1) {
//					out.write(Arrays.copyOf(buffer, len)); //copyOf() : ������ ���̱����� ���纻�� ����Ѵ� = ��� �ǹ�
//				}
				
				out.close();
				in.close();
			}
		}
		
		System.out.println("���簡 ��� �������ϴ�.");
		
		
//		String original = "C:\\JavaStudy\\Java\\JavaStudy_local\\image";
//		File cp = new File("image_copy/flower");
//		
//		if (!cp.exists()) {
//			cp.mkdirs(); // image_copy/flower ���丮 ����
//			System.out.println("���丮 �ű� ����"); 
//		}else {
//			System.out.println("�̹� �����ϴ� ���丮 �Դϴ�.");
//		}
	}
}

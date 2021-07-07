package quiz;

import java.io.*;
import java.util.*;

public class E03_Copy {

	/*
		# image 폴더 내부의 모든 내용을 image_copy 폴더 내부로 복사해보세요
		
		EASY : 그냥 동작만 하면 정답
		HARD : 나중에 폴더 구조나 파일 이름이 변하더라도 올바르게 동작하면 정답
	*/
	
	
	public static void main(String[] args) throws IOException {
		
		File src = new File("image"); // 원본은 이미지 폴더다
		
		File dst = new File("image_copy"); // 카피할 폴더
		
		if (!dst.exists()) {
			dst.mkdir(); // 없으면 만든다
		}
		
		File[] src_files = src.listFiles(); // 디렉토리안에 파일을 배열에 넣는다
		
		for (File file : src_files) {	// 파일 리스트를 하나씩 꺼내온다		
			System.out.println(file);
			System.out.println("디렉토리 여부 : " + (file.isDirectory() ? "Y" : "N"));
			System.out.println("-------------------");
			
			if (file.isDirectory()) { // 디렉토리인지 체크
				System.out.println("Dir to create : " + file.getName());
				
				File new_dir = new File(dst, file.getName()); // new_dir 디렉토리에 dst디렉토리 + 안에 file 이름을 가져와서 디렉토리를 생성
				new_dir.mkdirs();
				
				File[] inner_files = file.listFiles(); // 디렉토리 안에 파일 리스트
				
				for (File file2 : inner_files) { // 안에있는 파일 리스트를 하나씩 꺼낸다
					System.out.println(file2);
					System.out.println("디렉토리 여부2 : " + (file2.isDirectory() ? "Y" : "N"));
					System.out.println("-------------------");
					
					if (!file2.isDirectory()) { // file2가 디렉토리가 아닐 경우
						// 3번째 풀이 복사하고 >> file2 / new_dir / file2 으로 수정
						FileInputStream in = new FileInputStream(file2); // 파일리스트를 저장
						FileOutputStream out = new FileOutputStream(new File(new_dir, file2.getName())); // 새로운 File에 디렉토리 생성
						
						byte[] buffer = new byte[2048]; // 2048개씩 읽는다
						int len = -1;
						while((len = in.read(buffer)) != -1) { // 디렉토리 안에 파일을 전부 읽어서, to_write 배열에 저장
							byte[] to_write = new byte[len];
							
							for (int i = 0; i < len; ++i) {
								to_write[i] = buffer[i];
							}
							out.write(buffer); // FileInputStream으로 불러온 정보를 저장(out = Input = save)
						}
						out.close();
						in.close();
					}
				}
			}else {
				FileInputStream in = new FileInputStream(file);
				FileOutputStream out = new FileOutputStream(new File(dst, file.getName()));
				
				byte[] buffer = new byte[2048]; // 2048개씩 읽는다
				// 3번째 풀이
				int len = -1;
				while((len = in.read(buffer)) != -1) {
					byte[] to_write = new byte[len];
					
					for (int i = 0; i < len; ++i) {
						to_write[i] = buffer[i];
					}
					out.write(buffer);
				}
				
				// 2번째 풀이
//				int _byte = -1;
//				while((_byte = in.read()) != -1) {
//					out.write(_byte);
//				}
				
				// 1번째 풀이
//				int len = -1;
//				while((len = in.read(buffer)) != -1) {
//					out.write(Arrays.copyOf(buffer, len)); //copyOf() : 마지막 길이까지만 복사본을 써야한다 = 라는 의미
//				}
				
				out.close();
				in.close();
			}
		}
		
		System.out.println("복사가 모두 끝났습니다.");
		
		
//		String original = "C:\\JavaStudy\\Java\\JavaStudy_local\\image";
//		File cp = new File("image_copy/flower");
//		
//		if (!cp.exists()) {
//			cp.mkdirs(); // image_copy/flower 디렉토리 생성
//			System.out.println("디렉토리 신규 생성"); 
//		}else {
//			System.out.println("이미 존재하는 디렉토리 입니다.");
//		}
	}
}

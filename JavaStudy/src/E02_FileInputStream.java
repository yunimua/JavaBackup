import java.io.*;
import java.util.*;

public class E02_FileInputStream {

	public static void main(String[] args) {
		
		try {
			// 파일을 읽어들이는 통로
			FileInputStream in = new FileInputStream("a.txt");
			
			/*
				InputStream.read() : 한 글자씩 읽어들인다. (한글이 깨진다)
				InputStream.read(byte[]) : 파일의 데이터를 byte[]의 크기만큼 읽어들인다.
				InputStream.read(byte[], start, end) : 버퍼의 일부분만 읽기가 가능하다
				
				※ 세가지 메서드 모두 더 이상 읽을 것이 없다면 -1을 반환한다.
			*/
			
			byte[] buffer = new byte[16];		
			// line1:
			buffer[0] = 'l';
			buffer[1] = 'i';
			buffer[2] = 'n';
			buffer[3] = 'e';
			buffer[4] = ':';
			
			int len = -1, count = 0;
			while ((len = in.read(buffer, 6, 10)) != -1) { // (buffer, 6, 10) 6번째부터 10번째까지 읽어주세요
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
			
			
			// [65, 66, 67, 68, 10, 72, 101, 108, 108, 111]-- 10글자 => A, B, C, D, H, e, l, l, o
			// [32, 119, 111, 117, 108, 100, 33, 33, 10, 111]-- 9글자 => (띄움), w, o, u, l, d, !, !, -
//			System.out.print(Arrays.toString(buffer));
//			System.out.printf("-- %d글자\n", len);
			
			}

		
			// 3번째 풀이 : 한글자씩 읽을 때는 해당 반복문이 기본이 된다
//			int ch = -1;
//			while ((ch = in.read()) != -1) {
//				System.out.print((char)ch);
//			}
			
			// 2번째 풀이
//			while(true) {
//				int ch = in.read();
//				
//				if (ch == -1) {
//					System.out.println("파일의 끝까지 읽었습니다!");
//					break;
//				}else {
//					System.out.print((char)ch);
//				}
//			}
			
			// 1번째 풀이(for문으로 변경) : Hello까지만 출력됨 >> E01_JavaIO 저장하는 내용에서 한글이었던 부분을 영문으로 수정
//			for (int i = 0; i < 10; ++i) { 
//				System.out.print((char)in.read());
//			}

			// 1번째 불러오기 확인
//			System.out.println(in.read()); // 65 : A
//			System.out.println(in.read()); // 66 : B
//			System.out.println(in.read()); // 67 : C
//			System.out.println(in.read()); // 68 : D
//			System.out.println(in.read()); // 이하는 한글은 깨짐
//			System.out.println(in.read());
			
			in.close();			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

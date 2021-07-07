import java.io.*;
import java.nio.charset.*;

public class E05_BufferedStream {

	/*
		# Buffered
		
		  - 데이터를 읽거나 쓸 때 한 글자씩 스크림을 여러번 통과하는 것 보다
		  	한번에 많은 양의 데이터를 최소한으로 통과하는 것이 성능적으로 더 뛰어나다.
		  - 버퍼 방식이 미리 구현된 클래스들은 앞에 Buffered라는 이름이 붙어 있다.
	*/
	
	public static void main(String[] args) {

		// byte 방식은 모든 것들을 전송할 때 사용한다 (InputStream, OutputStream)
		
		try {
			BufferedOutputStream out = new BufferedOutputStream( //+ 버퍼는 가득차면 알아서 보낸다?
					new FileOutputStream("files/d.txt"), 2048);
			
			for (int i = 0; i < 1000; ++i) {
				out.write("안녕하세요 반갑습니다.\n ".getBytes());
			}
			
			// out.flush(); // buffer가 가득차기전에 강제로 값을 보냄
			
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// char 방식은 문자를 편리하게 전송할 때 사용한다 (Reader, Writer)
		try {
			BufferedWriter out = new BufferedWriter(
					new FileWriter("files/e.txt", Charset.forName("MS949")), 2048);
			for (int i = 0; i < 1000; ++i) {
				out.write("안녕하세요 반갑습니다.\n");
			}
			
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("다 썼습니다.");
		
		// try-catch의 AutoClose가 구현되어있다.
		try (BufferedReader in = new BufferedReader(new FileReader("files/e.txt", Charset.forName("EUC-KR")))){ //+ 2048은 성능 문제로 제거
			// BufferedReader in = new BufferedReader(new FileReader("files/e.txt", Charset.forName("UTF-8")), 2048);
			//+ { >> 안에 넣지 않고, ()에 넣으면 Close가 자동으로된다. in.close를 안넣어도 된다.
			
			String line;
			while((line = in.readLine()) != null) { // in.readLine() : null 값으로 끝난다, null이 아닐때로 실행하면 null까지 실행된다
				System.out.println(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

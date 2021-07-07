import java.io.*;
import java.nio.charset.*;

public class E04_StreamForChar {

	/*
		# Reader/Writer
		
		  - InputStream과 OutputStream은 데이터를 byte 단위로 전송한다
		  - 데이터가 스트림을 통화하기 위해서는 바이트 단위로 데이터를 나눠야하기 때문에
		  	1바이트 이상의 데이터는 다시 합치는 과정이 필요하다
		  	
		  	//+ Reader/Writer : char타입이 붙기 좋은 스트림
		  	//+ 코드화 되는 방식들을 인코딩이라 칭한다 
		  	//+ incode 했던 타입으로 decode를 해야 글자가 깨지지 않는다
	*/
	
	public static void main(String[] args) {
		
		try {
			File textFile = new File("Files/c.txt");
			Charset charset = Charset.forName("UTF-8"); // forName에 전달한 타입으로 Charset으로 name을 꺼내온다
			FileWriter out = new FileWriter(
					textFile, charset);
			
			out.write("문자열을 편하게 쓸수있네\n");
			out.write("getBytes도 안쓰고\n");
			
			// SortedMap<String, Charset> java.nio.charset.Charset.availableCharsets()
			for (String charset_name : Charset.availableCharsets().keySet()) {
				out.write(charset_name + "\n");
			}
			
			out.close();
			
			FileReader in = new FileReader(textFile, charset);
			
			char[] buffer = new char[2048];
			
			int len = -1; // int len만 써도된다. 
			while ((len = in.read(buffer)) != -1) { // 0~2048 > 0~2047 순으로 읽어들이고 밑에 기록(sysout), -1까지 실행됨
				System.out.println(new String(buffer, 0, len)); // 출력 화면에서는 한글이 깨지지 않는다
			}

			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// 1번째 풀이 : FileOutputStream / FileInputStream 사용예
		// 쓸 때의 인코딩 타입과 읽을 때의 인코딩 타입이 일치해야 한다
		try {
			File textFile = new File("Files/b.txt");
			FileOutputStream out = new FileOutputStream(textFile);
			
			String message = "안녕하헤효";
			
			// getBytes() : 해당 메서드는 문자열을 바이트로 쪼갤 때의 방식을 선택할 수 있다.
			// 유명한 charSet : UTF-8, EUC-KR, MS949...
			out.write(message.getBytes("UTF-8")); // 메세지를 byte로 쪼개야한다 (1)
			
			out.close();
			
			FileInputStream in = new FileInputStream(textFile);
			
			byte[] buffer = new byte[1024];// 1024byte를 읽자.
			
			// in.read() : 한 바이트씩 읽을 때는 이번에 읽은 바이트값이 리턴
			// in.read(배열) : 이번에 읽어들인 바이트의 개수가 리턴
			int len = in.read(buffer);
			
			System.out.println(new String(buffer, 0, len, "UTF-8")); // "UTF-8" : (2) , (1)과 같은 타입이어야 한다
			// (buffer, 0, len) >> ?븞?뀞?븯?뿤?슚 >> (buffer, 0, len, "UTF-8") >> "UTF-8"를 넣으면 제대로 읽어옴
			
			in.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) { // 입력된 "UTF-8" 인코딩 값이 존재하지 않을때의 예외처리
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
}

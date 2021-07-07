import java.io.*;

public class E01_JavaIO {

	/*
		# Java I/O (input / Output)
		
		  - 자바는 스트림이라는 개념을 이용해 프로그램의 입/출력을 다룬다
		  - 프로그램으로 들어오는 모든 데이터들을 입력이라고 부른다 (Input)
		  - 프로그램에서 계산되어 나가는 데이터들을 출력이라고 부른다 (Output)
		  
		  	
		# Stream
		
		  - 데이터들이 오고가는 통로
		  - 데이터들이 순차적으로 프로그램으로 들어오는 통로를 InputStream이라고 부른다
		  - 데이터들이 출력되는 곳으로 보내지는 통로를 OutputStream이라고 부른다
		  - 데이터가 Stream을 통해 이동하기 위해서는 데이터를 byte 타입으로 변환시켜야 한다 : 2진법으로 변환할 때 가장 편하기 때문
		
		//+ 나가는 곳 예시 : console, file..
		//+ 프로그램이 저장된 위치 : HDD (하드디스크)
		//+ CPU에서 RAM으로 왔다갔다..하고 결과는 HDD에 저장됨 > 결과 출력은 모니터에 표시
		//+ Ram에서 out되는 위치 : 모니터(GUI/CLI), 프린터, 랜카드, HDD, 스피커..
		//+ HDD에 저장한 내용을 RAM으로 보내는 것은 In, 이후 다른 위치로 이동하면 out
	*/
	
	public static void main(String[] args) {
		
		try {
			// FileOutputStream : 파일로 내보낼 수 있는 통로를 생성한다
			//+ "a.txt"이라는 파일이 없을 때의 예외처리 필요!
			FileOutputStream out = new FileOutputStream("a.txt", false); //+반드시 처리해야하는 예외가 발생하기 때문에 예외처리가 필요하다
			//+ true를 추가하면 데이터 내용이 계속 추가된다 (실행을 다시하면 //안녕하세요 반갑습니다~// 가 하나 더 추가되어있음)
			out.write(65); // A
			out.write(66); // B
			out.write(67); // C
			out.write(68); // D
			
			out.write("\nHello would!!\n".getBytes()); //+ getBytes() : byte타입으로 변환
			
			// 다 쓴 통로는 반드시 닫아줘야 한다. 
			//+ 실행 후 프로젝트탭에서 F5(새로고침)을 하면 a.txt 파일이 추가된 걸 확인할 수 있다
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

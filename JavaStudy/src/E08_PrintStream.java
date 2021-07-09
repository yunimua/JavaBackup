import java.io.*;
import java.nio.charset.*;

public class E08_PrintStream {

	/*
		# PrintWriter, PrintStream
		
		  - 모든 데이터들을 더 편리하게 스트림으로 내보낼 수 있는 클래스
		  - 대표적으로 printf(), println()등의 메서드들이 구현되어 있다
	*/
	
	public static void main(String[] args) {
		
		File f = new File("files/myfile.txt");
		
		try (
			FileOutputStream fout = new FileOutputStream(f);
			BufferedOutputStream bout = new BufferedOutputStream(fout);
			PrintStream out = new PrintStream(bout);
		){
			//sysout과 같은 프린트 스트링이다.
			out.println("Hello, world!");
			out.println(" /)/)");
			out.println("(  ..)");
			out.println("(  >♡");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e1) {
			e1.printStackTrace();
		} 
		
		// 1번째 상속받은 class 사용한 예
//		try (
//				MyFile f = new MyFile("files/myfile.txt"); //myfile.txt를 만들어주겠다 
//		){
//			//sysout과 같은 프린트 스트링이다.
//			f.out.println("Hello, world!");
//			f.out.println(" /)/)");
//			f.out.println("(  ..)");
//			f.out.println("(  >♡");
//			
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (Exception e1) {
//			e1.printStackTrace();
//		} 
	}
}

// File클래스를 상속받았다 > MyFile에.. 
class MyFile extends File implements AutoCloseable{
	// OutputStreamWriter으로 문자를 내보내는 역할
	FileOutputStream fout;
	BufferedOutputStream bout;
	PrintStream out;
	
	public MyFile(String pathname) throws FileNotFoundException {
		super(pathname);
		
		fout = new FileOutputStream(this);
		bout = new BufferedOutputStream(fout);
		out = new PrintStream(bout, true, Charset.forName("UTF-8"));
	}
	
	@Override //자동으로 닫히는 것을 구현, Exception이 필요.
	public void close() throws Exception {
		out.close();
		bout.close();
		fout.close();
	}
	
//	// out 필드 추가
//	PrintStream out;
//	
//	// 기본타입 생성자가 없으므로 MyFile 생성자를 생성해준다
//	public MyFile(String pathname) throws FileNotFoundException {
//		super(pathname);
//		out = new PrintStream(this);
//	}
//
//	@Override //자동으로 닫히는 것을 구현, Exception이 필요.
//	public void close() throws Exception {
//		out.close();
//	}
	
}

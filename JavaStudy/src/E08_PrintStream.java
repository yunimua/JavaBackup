import java.io.*;
import java.nio.charset.*;

public class E08_PrintStream {

	/*
		# PrintWriter, PrintStream
		
		  - ��� �����͵��� �� ���ϰ� ��Ʈ������ ������ �� �ִ� Ŭ����
		  - ��ǥ������ printf(), println()���� �޼������ �����Ǿ� �ִ�
	*/
	
	public static void main(String[] args) {
		
		File f = new File("files/myfile.txt");
		
		try (
			FileOutputStream fout = new FileOutputStream(f);
			BufferedOutputStream bout = new BufferedOutputStream(fout);
			PrintStream out = new PrintStream(bout);
		){
			//sysout�� ���� ����Ʈ ��Ʈ���̴�.
			out.println("Hello, world!");
			out.println(" /)/)");
			out.println("(  ..)");
			out.println("(  >��");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e1) {
			e1.printStackTrace();
		} 
		
		// 1��° ��ӹ��� class ����� ��
//		try (
//				MyFile f = new MyFile("files/myfile.txt"); //myfile.txt�� ������ְڴ� 
//		){
//			//sysout�� ���� ����Ʈ ��Ʈ���̴�.
//			f.out.println("Hello, world!");
//			f.out.println(" /)/)");
//			f.out.println("(  ..)");
//			f.out.println("(  >��");
//			
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (Exception e1) {
//			e1.printStackTrace();
//		} 
	}
}

// FileŬ������ ��ӹ޾Ҵ� > MyFile��.. 
class MyFile extends File implements AutoCloseable{
	// OutputStreamWriter���� ���ڸ� �������� ����
	FileOutputStream fout;
	BufferedOutputStream bout;
	PrintStream out;
	
	public MyFile(String pathname) throws FileNotFoundException {
		super(pathname);
		
		fout = new FileOutputStream(this);
		bout = new BufferedOutputStream(fout);
		out = new PrintStream(bout, true, Charset.forName("UTF-8"));
	}
	
	@Override //�ڵ����� ������ ���� ����, Exception�� �ʿ�.
	public void close() throws Exception {
		out.close();
		bout.close();
		fout.close();
	}
	
//	// out �ʵ� �߰�
//	PrintStream out;
//	
//	// �⺻Ÿ�� �����ڰ� �����Ƿ� MyFile �����ڸ� �������ش�
//	public MyFile(String pathname) throws FileNotFoundException {
//		super(pathname);
//		out = new PrintStream(this);
//	}
//
//	@Override //�ڵ����� ������ ���� ����, Exception�� �ʿ�.
//	public void close() throws Exception {
//		out.close();
//	}
	
}

import java.io.*;
import java.nio.charset.*;

public class E04_StreamForChar {

	/*
		# Reader/Writer
		
		  - InputStream�� OutputStream�� �����͸� byte ������ �����Ѵ�
		  - �����Ͱ� ��Ʈ���� ��ȭ�ϱ� ���ؼ��� ����Ʈ ������ �����͸� �������ϱ� ������
		  	1����Ʈ �̻��� �����ʹ� �ٽ� ��ġ�� ������ �ʿ��ϴ�
		  	
		  	//+ Reader/Writer : charŸ���� �ٱ� ���� ��Ʈ��
		  	//+ �ڵ�ȭ �Ǵ� ��ĵ��� ���ڵ��̶� Ī�Ѵ� 
		  	//+ incode �ߴ� Ÿ������ decode�� �ؾ� ���ڰ� ������ �ʴ´�
	*/
	
	public static void main(String[] args) {
		
		try {
			File textFile = new File("Files/c.txt");
			Charset charset = Charset.forName("UTF-8"); // forName�� ������ Ÿ������ Charset���� name�� �����´�
			FileWriter out = new FileWriter(
					textFile, charset);
			
			out.write("���ڿ��� ���ϰ� �����ֳ�\n");
			out.write("getBytes�� �Ⱦ���\n");
			
			// SortedMap<String, Charset> java.nio.charset.Charset.availableCharsets()
			for (String charset_name : Charset.availableCharsets().keySet()) {
				out.write(charset_name + "\n");
			}
			
			out.close();
			
			FileReader in = new FileReader(textFile, charset);
			
			char[] buffer = new char[2048];
			
			int len = -1; // int len�� �ᵵ�ȴ�. 
			while ((len = in.read(buffer)) != -1) { // 0~2048 > 0~2047 ������ �о���̰� �ؿ� ���(sysout), -1���� �����
				System.out.println(new String(buffer, 0, len)); // ��� ȭ�鿡���� �ѱ��� ������ �ʴ´�
			}

			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// 1��° Ǯ�� : FileOutputStream / FileInputStream ��뿹
		// �� ���� ���ڵ� Ÿ�԰� ���� ���� ���ڵ� Ÿ���� ��ġ�ؾ� �Ѵ�
		try {
			File textFile = new File("Files/b.txt");
			FileOutputStream out = new FileOutputStream(textFile);
			
			String message = "�ȳ�����ȿ";
			
			// getBytes() : �ش� �޼���� ���ڿ��� ����Ʈ�� �ɰ� ���� ����� ������ �� �ִ�.
			// ������ charSet : UTF-8, EUC-KR, MS949...
			out.write(message.getBytes("UTF-8")); // �޼����� byte�� �ɰ����Ѵ� (1)
			
			out.close();
			
			FileInputStream in = new FileInputStream(textFile);
			
			byte[] buffer = new byte[1024];// 1024byte�� ����.
			
			// in.read() : �� ����Ʈ�� ���� ���� �̹��� ���� ����Ʈ���� ����
			// in.read(�迭) : �̹��� �о���� ����Ʈ�� ������ ����
			int len = in.read(buffer);
			
			System.out.println(new String(buffer, 0, len, "UTF-8")); // "UTF-8" : (2) , (1)�� ���� Ÿ���̾�� �Ѵ�
			// (buffer, 0, len) >> ?��?��?��?��?�� >> (buffer, 0, len, "UTF-8") >> "UTF-8"�� ������ ����� �о��
			
			in.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) { // �Էµ� "UTF-8" ���ڵ� ���� �������� �������� ����ó��
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
}

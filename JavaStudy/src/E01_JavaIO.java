import java.io.*;

public class E01_JavaIO {

	/*
		# Java I/O (input / Output)
		
		  - �ڹٴ� ��Ʈ���̶�� ������ �̿��� ���α׷��� ��/����� �ٷ��
		  - ���α׷����� ������ ��� �����͵��� �Է��̶�� �θ��� (Input)
		  - ���α׷����� ���Ǿ� ������ �����͵��� ����̶�� �θ��� (Output)
		  
		  	
		# Stream
		
		  - �����͵��� ������ ���
		  - �����͵��� ���������� ���α׷����� ������ ��θ� InputStream�̶�� �θ���
		  - �����͵��� ��µǴ� ������ �������� ��θ� OutputStream�̶�� �θ���
		  - �����Ͱ� Stream�� ���� �̵��ϱ� ���ؼ��� �����͸� byte Ÿ������ ��ȯ���Ѿ� �Ѵ� : 2�������� ��ȯ�� �� ���� ���ϱ� ����
		
		//+ ������ �� ���� : console, file..
		//+ ���α׷��� ����� ��ġ : HDD (�ϵ��ũ)
		//+ CPU���� RAM���� �Դٰ���..�ϰ� ����� HDD�� ����� > ��� ����� ����Ϳ� ǥ��
		//+ Ram���� out�Ǵ� ��ġ : �����(GUI/CLI), ������, ��ī��, HDD, ����Ŀ..
		//+ HDD�� ������ ������ RAM���� ������ ���� In, ���� �ٸ� ��ġ�� �̵��ϸ� out
	*/
	
	public static void main(String[] args) {
		
		try {
			// FileOutputStream : ���Ϸ� ������ �� �ִ� ��θ� �����Ѵ�
			//+ "a.txt"�̶�� ������ ���� ���� ����ó�� �ʿ�!
			FileOutputStream out = new FileOutputStream("a.txt", false); //+�ݵ�� ó���ؾ��ϴ� ���ܰ� �߻��ϱ� ������ ����ó���� �ʿ��ϴ�
			//+ true�� �߰��ϸ� ������ ������ ��� �߰��ȴ� (������ �ٽ��ϸ� //�ȳ��ϼ��� �ݰ����ϴ�~// �� �ϳ� �� �߰��Ǿ�����)
			out.write(65); // A
			out.write(66); // B
			out.write(67); // C
			out.write(68); // D
			
			out.write("\nHello would!!\n".getBytes()); //+ getBytes() : byteŸ������ ��ȯ
			
			// �� �� ��δ� �ݵ�� �ݾ���� �Ѵ�. 
			//+ ���� �� ������Ʈ�ǿ��� F5(���ΰ�ħ)�� �ϸ� a.txt ������ �߰��� �� Ȯ���� �� �ִ�
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

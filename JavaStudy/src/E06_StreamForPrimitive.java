import java.io.*;

public class E06_StreamForPrimitive {

	/*
		# DataOutputStream, DataInputStream
		
		  - �⺻�� Ÿ���� �ս��� ��Ʈ������ �����ϱ� ���� Ŭ����
		  - Java�� �⺻�� Ÿ���̱� ������ Java �̿��� ������ ���� �� ����
		  - �����͸� �־��� ������� ������ �Ѵ�
		  
		
		//+ �⺻�� Ÿ���� ������ ��� (int, double...) >> DataOutputStream, DataInputStream
		//+ �������������� ��, ��, �и� ���� �����ؼ� ������..(=����)
	*/
	
	public static void main(String[] args) {
		
		File f = new File("files/dout.txt"); // dout.txt ���� ���� �� ����
		
		try(
			FileOutputStream fout = new FileOutputStream(f);
			DataOutputStream out = new DataOutputStream(fout);
		){
			//+ HDD ��ũ���� byte�� ����Ǿ� �ִ� (����Ʈ)
			// out���� ������ �������� > �� Ÿ�Ժ��� ������ �Ǿ��ִ�
			out.writeDouble(1234.1234);
			out.writeLong(1234567L);
			out.writeShort((short)1234);
			out.writeUTF("����������"); //õ����Ȳ����
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("������ �� �������ϴ�.");
		
		// ������ �����͸� �ٽ� ��������
		try(
				FileInputStream fin = new FileInputStream(f);
				DataInputStream in = new DataInputStream(fin);
		){
			// ������ ������ ��� ��µȴ�
			System.out.println(in.readDouble());
			System.out.println(in.readLong());
			System.out.println(in.readShort());
			System.out.println(in.readUTF());
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
}

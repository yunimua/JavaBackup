import java.io.*;

public class E07_StreamForObject {

	/*
		# ObjectOutputStream, ObjectInputStream
		
		  - ������ ������(Ŭ����)���� ���ϰ� ��Ʈ���� ����� �� �ְ� ���ִ� Ŭ����
		  - ObjectOutputStream�� �ν��Ͻ��� byte�� ��ȯ�ϴ� Ŭ������
		  	ObjectInputStream�� �о���� byte�� �ν��Ͻ� ���·� �ٽ� ��ġ�� Ŭ������
	
	*/
	
	public static void main(String[] args) {
		// ����ȭ�� ���� �������̽� ������ �ʿ��ϴ�
		class Apple implements Serializable {
			//+ Apple�� ����� > serialVersion �߰� ���ý� �ڵ����� ������
			// ����ȭ�� �ص� �Ǵ� Ŭ����! ��� �ǹ�, ����ȭ�Ǵ� ��Ģ�� ���Ǵ� �� / ������ �⺻��
			private static final long serialVersionUID = -1453145982145476284L;
			
			public int size;
			public int grade;
			
			public Apple(int size, int grade) {
				this.size = size;
				this.grade = grade;
			}
		}
		
		File f = new File("files/oout.txt");
		
		try(
			
			FileOutputStream fout = new FileOutputStream(f);
			ObjectOutputStream out = new ObjectOutputStream(fout);
		){
			// AppleŬ������ ����Ͽ� ���� ����..
			out.writeObject(new Apple(10, 11));
			out.writeObject(new Apple(1, 2));
			out.writeObject(new Apple(5, 6));
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("������Ʈ ���Ⱑ �������ϴ�.");
		
		// ���� ������ ���� �б�	
		try(
			FileInputStream fin = new FileInputStream(f);
			ObjectInputStream in = new ObjectInputStream(fin);
				
		){
			Apple a1 = (Apple)in.readObject();
			Apple a2 = (Apple)in.readObject();
			Apple a3 = (Apple)in.readObject();
			
			// Apple�� int size ��� 
			System.out.println(a1.size); // 10
			System.out.println(a2.size); // 1
			System.out.println(a3.size); // 5
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}

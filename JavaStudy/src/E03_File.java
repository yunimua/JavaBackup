import java.io.File;
import java.util.*;

public class E03_File {

	/*
		# java.io.File
		
		  - ���� �ý��ۿ� ����Ǿ� �ִ� ������ ������ ���� �� �ִ� Ŭ����
		  - File �ν��Ͻ��� ����ִ� ������ �������� �ش� ������ �����ϰų�
		  	���ο� ���� �Ǵ� ���丮�� ������ �� �ִ�
	
	*/
	
	public static void main(String[] args) {
		File f1 = new File("note/Git��� ����.txt");
		File f2 = new File("note/Git��� ����");
		File f3 = new File("files"); // ������
		File f4 = new File(f3, "game.sav"); // parent, child  : (f3, "game.sav") = (�θ�, �ڽ�)
		File f5 = new File("image/flower");
		
		// list() : �ش� ���丮 ������ ���� �̸����� String[] ���ڿ� �迭�� �����´�
		// listFiles() : �ش� ���丮 ������ ��� ���ϵ��� File[] �迭�� �����´�
		System.out.println("f3 ������ ���� �̸���: " + Arrays.toString(f3.list()));
		
		
		System.out.println("f1�� �����մϱ�? " + f1.exists()); // f1�� �����մϱ�? true
		System.out.println("f2�� �����մϱ�? " + f2.exists()); // f2�� �����մϱ�? false
		
		System.out.println("�б� ������ �ִ� �����ΰ���? " + f1.canRead()); // �б� ������ �ִ� �����ΰ���? true
		System.out.println("���� ������ �ִ� �����ΰ���? " + f1.canWrite()); // ���� ������ �ִ� �����ΰ���? true
		System.out.println("���� ������ �ִ� �����ΰ���? " + f1.canExecute()); // ���� ������ �ִ� �����ΰ���? true
		
		System.out.println("f1�� ����ִ� ��ΰ� ���� ����ΰ���? " + f1.isAbsolute()); // f1�� ����ִ� ��ΰ� ���� ����ΰ���? false
		System.out.println("f1�� ���� ���: " + f1.getAbsolutePath()); // C:\JavaStudy\Java\JavaStudy_local\note\Git��� ����.txt
		System.out.println("f1�� ���丮�ΰ���? " +f1.isDirectory()); // f1�� ���丮�ΰ���? false
		System.out.println(f1); // note\Git��� ����.txt
		System.out.println("f3�� ���丮�ΰ���? " +f3.isDirectory()); // true
		System.out.println(f4); // files\game.sav
		System.out.println("f4�� ���� ���: " + f4.getAbsolutePath()); // C:\JavaStudy\Java\JavaStudy_local\files\game.sav
		
		if (!f5.exists()) { //+ (f5)��� �̸����� ǥ�õ� ���� �Ǵ� ���͸��� �ִ��� ����üũ, !�� ��� ������ üũ
			// mkdir : �ش� ��η� ���ο� ���丮(����) ���� (�θ� ���丮�� ������ �������� ����)
			// f5.mkdir();
			// mkdirs : �θ� ���丮�� �������� �ʴ� ��쿡�� ���丮�� ����
			f5.mkdirs();
			System.out.println("���� ������"); // 1��° ���� �� >> ���� ������
		}else {
			System.out.println("�̹� �����ؼ� �������� ����."); // �ݺ� ����� ���
		}
	}
}

import java.io.*;

public class E07_StreamForObject {

	/*
		# ObjectOutputStream, ObjectInputStream
		
		  - 참조형 데이터(클래스)들이 편리하게 스트림을 통과할 수 있게 해주는 클래스
		  - ObjectOutputStream은 인스턴스를 byte로 변환하는 클래스고
		  	ObjectInputStream은 읽어들인 byte를 인스턴스 형태로 다시 합치는 클래스다
	
	*/
	
	public static void main(String[] args) {
		// 직렬화를 위해 인터페이스 구현이 필요하다
		class Apple implements Serializable {
			//+ Apple에 노란줄 > serialVersion 추가 선택시 자동으로 생성됨
			// 직렬화를 해도 되는 클래스! 라는 의미, 직렬화되는 규칙에 사용되는 값 / 없으면 기본값
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
			// Apple클래스를 사용하여 값을 저장..
			out.writeObject(new Apple(10, 11));
			out.writeObject(new Apple(1, 2));
			out.writeObject(new Apple(5, 6));
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("오브젝트 쓰기가 끝났습니다.");
		
		// 위에 저장한 파일 읽기	
		try(
			FileInputStream fin = new FileInputStream(f);
			ObjectInputStream in = new ObjectInputStream(fin);
				
		){
			Apple a1 = (Apple)in.readObject();
			Apple a2 = (Apple)in.readObject();
			Apple a3 = (Apple)in.readObject();
			
			// Apple의 int size 출력 
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

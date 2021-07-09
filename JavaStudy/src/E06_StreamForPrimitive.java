import java.io.*;

public class E06_StreamForPrimitive {

	/*
		# DataOutputStream, DataInputStream
		
		  - 기본형 타입을 손쉽게 스트림으로 전송하기 위한 클래스
		  - Java의 기본형 타입이기 때문에 Java 이외의 언어에서는 받을 수 없다
		  - 데이터를 넣었던 순서대로 꺼내야 한다
		  
		
		//+ 기본형 타입을 넣을때 사용 (int, double...) >> DataOutputStream, DataInputStream
		//+ 가위바위보에서 승, 무, 패를 각각 저장해서 꺼낸다..(=응용)
	*/
	
	public static void main(String[] args) {
		
		File f = new File("files/dout.txt"); // dout.txt 파일 생성 및 저장
		
		try(
			FileOutputStream fout = new FileOutputStream(f);
			DataOutputStream out = new DataOutputStream(fout);
		){
			//+ HDD 디스크에는 byte로 저장되어 있다 (디폴트)
			// out으로 데이터 내보내기 > 각 타입별로 저장이 되어있다
			out.writeDouble(1234.1234);
			out.writeLong(1234567L);
			out.writeShort((short)1234);
			out.writeUTF("天地玄黃宇宙"); //천지현황우주
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("파일이 잘 써졌습니다.");
		
		// 저장한 데이터를 다시 꺼내본다
		try(
				FileInputStream fin = new FileInputStream(f);
				DataInputStream in = new DataInputStream(fin);
		){
			// 저장한 내용이 모두 출력된다
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

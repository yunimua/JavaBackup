import java.io.File;
import java.util.*;

public class E03_File {

	/*
		# java.io.File
		
		  - 파일 시스템에 저장되어 있는 파일의 정보를 담을 수 있는 클래스
		  - File 인스턴스에 담겨있는 정보를 바탕으로 해당 파일을 수정하거나
		  	새로운 파일 또는 디렉토리를 생성할 수 있다
	
	*/
	
	public static void main(String[] args) {
		File f1 = new File("note/Git사용 설명서.txt");
		File f2 = new File("note/Git사용 설명서");
		File f3 = new File("files"); // 폴더다
		File f4 = new File(f3, "game.sav"); // parent, child  : (f3, "game.sav") = (부모, 자식)
		File f5 = new File("image/flower");
		
		// list() : 해당 디렉토리 내부의 파일 이름들을 String[] 문자열 배열로 가져온다
		// listFiles() : 해당 디렉토리 내부의 모든 파일들을 File[] 배열로 가져온다
		System.out.println("f3 내부의 파일 이름들: " + Arrays.toString(f3.list()));
		
		
		System.out.println("f1이 존재합니까? " + f1.exists()); // f1이 존재합니까? true
		System.out.println("f2가 존재합니까? " + f2.exists()); // f2가 존재합니까? false
		
		System.out.println("읽기 권한이 있는 파일인가요? " + f1.canRead()); // 읽기 권한이 있는 파일인가요? true
		System.out.println("쓰기 권한이 있는 파일인가요? " + f1.canWrite()); // 쓰기 권한이 있는 파일인가요? true
		System.out.println("실행 권한이 있는 파일인가요? " + f1.canExecute()); // 실행 권한이 있는 파일인가요? true
		
		System.out.println("f1에 담겨있는 경로가 절대 경로인가요? " + f1.isAbsolute()); // f1에 담겨있는 경로가 절대 경로인가요? false
		System.out.println("f1의 절대 경로: " + f1.getAbsolutePath()); // C:\JavaStudy\Java\JavaStudy_local\note\Git사용 설명서.txt
		System.out.println("f1은 디렉토리인가요? " +f1.isDirectory()); // f1은 디렉토리인가요? false
		System.out.println(f1); // note\Git사용 설명서.txt
		System.out.println("f3은 디렉토리인가요? " +f3.isDirectory()); // true
		System.out.println(f4); // files\game.sav
		System.out.println("f4의 절대 경로: " + f4.getAbsolutePath()); // C:\JavaStudy\Java\JavaStudy_local\files\game.sav
		
		if (!f5.exists()) { //+ (f5)경로 이름으로 표시된 파일 또는 디렉터리가 있는지 조건체크, !일 경우 없는지 체크
			// mkdir : 해당 경로로 새로운 디렉토리(폴더) 생성 (부모 디렉토리가 없으면 생성하지 않음)
			// f5.mkdir();
			// mkdirs : 부모 디렉토리가 존재하지 않는 경우에도 디렉토리를 생성
			f5.mkdirs();
			System.out.println("새로 생성함"); // 1번째 실행 시 >> 새로 생성함
		}else {
			System.out.println("이미 존재해서 생성하지 않음."); // 반복 실행시 출력
		}
	}
}

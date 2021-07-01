import java.util.InputMismatchException;
import java.util.Scanner;

public class C16_Exception {

	/*
		# 예외 (Exception)
		  
		  - 우리가 에러라고 알고 있던 빨간 글씨들을 사실 예외라고 부른다
		  - 자바의 문법을 틀리는 것은 예외가 아니라 컴파일 에러라고 부른다(오타 등)
		  - 프로그래머가 발생 가능한 예외를 미리 예상하고 대비해두는 것을 예외처리라고 부른다
		  - 예외처리의 기본 동작은 프로그램 강제종료이지만 프로그래머가 다른 조치를 취한다면
		    프로그램을 계속해서 진행할 수 있다
		    
		# 예외 처리
		
		  - 예외가 발생할 가능성이 있는 코드를 try문 내부에 포함시킨다
		  - try문 내부의 코드에서 예외가 발생하지 않으면 모두 정상 실행된다
		  - try문 내부에서 예외가 발생하는 즉시 실행이 중단하고 발생한 예외를 담당하는 
		    catch문으로 넘어가게 된다
		  - catch문에는 발생한 예외에 대한 정보를 담고있는 예외 인스턴스가 전달된다
		  - catch문은 중첩해서 여러개 사용할 수 있다
		  - 예외가 발생하든 안하든 무조건 실행하고 싶은 코드는 finally절에 작성한다
	*/
	
	public static void main(String[] args) {
		//System.out.println(10/0); //+ 오류는 발생하지 않지만, 실행시 에러가 발생
		// Exception in thread "main" java.lang.ArithmeticException: / by zero 에러를 통해 ArithmeticException 에러를 확인가능하다
		
		Scanner sc = new Scanner(System.in);
		//int[] values = new int[5];
		int[] values = null;
		
		// 예외처리 스타일 2가지(둘 중 택1)
		// 1. if문 예술적으로
		// 2. 예외처리
		
		try {
			//System.out.println(values[3]);
			System.out.println(values.length);
			System.out.println(10/1);
			System.out.print("반드시 10진수 정수만 입력해주세요 ^^");
			int a = sc.nextInt();			
		} catch (ArithmeticException e) { //+ 예외에대한 정보가 들어오는것이 e다
			// e.printStackTrace() : 예외가 발생한 시점의 스택 모습을 출력하는 메서드
			e.printStackTrace(); //+ java.lang.ArithmeticException: / by zero //+ at C16_Exception.main(C16_Exception.java:19)
			//System.out.println(e.toString()); //+ java.lang.ArithmeticException: / by zero //+이런 메세지가 출력됨
			System.out.println("말도 안되는 계산을 하셨네요. 다음부터는 그러지 마세요.");			
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("최대 인덱스는 길이보다 1작습니다--- ^^");
		} catch (InputMismatchException e) {
			System.out.println("반드시 10진수 정수만 입력하라고 했을텐데?");
		} catch (NullPointerException e) {
			System.out.println("null 값을 고쳐야하지 않을까..?");
		} finally { //+finally는 예외가 발생하지 않던, 발생하던 무조건 출력된다
			System.out.println(" /)/)");
			System.out.println("(  ..)");
			System.out.println("(  >♡");
		}
		
		System.out.println("프로그램 끝!!");
	}
}

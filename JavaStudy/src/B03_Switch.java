
public class B03_Switch {

	/*
		# switch-case문
		
		- () 안의 연산 결과에 따라 실행할 코드를 결정한다
		- () 안에 boolean 타입은 들어갈 수 없다
		- if 문으로 완벽하게 대체 가능하다
		- default는 if문의 else 역할을 한다
		- break를 안쓰면 break를 만날 때까지 내려가면서 모든 case를 실행한다

	*/
	
	
	public static void main(String[] args) {
		 
		int a = 2;
		
		switch (a) {  // () 연산 결과에 따라서 case에 적힌다.. case에는 결과만 입력가능
		
		case 0 :
			System.out.println("case 0 블록이 실행되었습니다.");
			System.out.println("a는 짝수입니다.");
			break;
			
		case 1 :
			System.out.println("case 1 블록이 실행되었습니다.");
			System.out.println("a는 홀수입니다.");
			break;
		// default 는 위 case에 해당 하지 않는 경우 실행된다
		default :
			System.out.println("default 블록이 실행되었습니다.");
			System.out.println("위에 해당하는 case가 없습니다.");
			break;
		}
		
		char cmd = 'a'; // 알파벳 전체 조건문 불가, 한개면 아래와 같이 조건부 case 가능
		
		switch (cmd) {
		case 'w' :
			System.out.println("move forward");
	
		case 's' :
			System.out.println("move backward");

		case 'a' :
			System.out.println("move left");
			// break를 걸지 않으면 이하 조건문까지 모두 출력된 후 끝난다.
		case 'd' :
			System.out.println("move right");
			break;
		case 'p' :
			System.out.println("pause");
			break;
		case 'q' :
			System.out.println("quit");
			break;
		default :
			System.out.println("해당하는 커맨드가 없습니다");
			break;
		}
	}
}

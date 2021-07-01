
public class C15_Interface {

	/*
		# 인터페이스 (Interface)
		
		  - abstract class는 상속을 여러개 받을 수 없다는 점을 보완한 것
		  - 인터페이스 내부의 메서드는 자동으로 abstract public이 된다
		  - 인터페이스 내부의 변수는 자동으로 final static이 된다
	*/
	
	public static void main(String[] args) {
		kick(new AppleTree());
		kick(new Ball());
		kick(new CanKick() {

			@Override
			public void kick() {
				System.out.println("대문을 발로 찼습니다.");
				
			}
		});		
		
		click(new AppleTree());
		// click(new Ball()); //+ ball은 메서드가 생성되지 않아 사용할 수 없다
	}
	
	public static void kick(CanKick to_kick) { //+ abstract 클래스의 메소드를 가져다 쓸수 있다
		to_kick.kick();
	}
	
	public static void click(CanClick to_click) { //+ abstract 클래스의 메소드를 가져다 쓸수 있다
		to_click.click();
	}	
}

// 인터페이스는 빈 껍데기만 만들어 놓는다
interface CanKick { //+abstract class CanKick {
	public abstract void kick(); //+ 메소드 생성
}

interface CanClick { //+ //+abstract class CanClick {
	public abstract void click(); //+ 이걸 상속받은 모든 메소드는 클릭이라는 메소드를 사용할수 있다.
}

// 빈 껍데기에 불과한 인터페이스를 모두 구현한 클래스라는 것을 명시한다
class AppleTree implements CanKick, CanClick { //+ 이렇게 두가지를 모두 사용하려면 인터페이스를 붙이면된다.
	// class AppleTree extends CanKick, CanClick {  > 을 변경

	@Override
	public void kick() {
		System.out.println("사과나무를 발로 찼더니 나뭇가지와 사과가 떨어졌습니다.");	
	}

	@Override
	public void click() {
		System.out.println("사과나무를 클릭해서 사과를 수확했습니다.");
			
	}
}

class Ball implements CanKick {

	@Override
	public void kick() {
		System.out.println("공을 발로 찼습니다.");
	}
}

public class C07_Abstract {
	
	/*
		# 추상 클래스 (abstract class)
		  
		  - 형태만 만들어 놓고 완성을 자손 클래스에게 미루는 클래스
		  - 내부에 추상 메서드를 포함하고 있는 클래스
		  
		# 추상 메서드 (abstract method)
		
		  - 몸통이 없는 메서드
		  - abstract가 붙은 메서드는 직접 구현할 수 없고, 상속받은 클래스에서 구현해야한다
	*/
	public static void main(String[] args) {
		testPokemon(new Pikachu());
		testPokemon(new LongStone());
	}
	
	//Pokemon 클래스를 상속받은 모든 인스턴스가 매개변수로 들어올 수 있는 메서드
	public static void testPokemon(Pokemon p) {
		p.skill1();
		p.skill2();
	}
	//+ 아래의 메서드를 추가 생성하지 않고 위 메서드 1가지로 모든 스킬 정보를 불러올 수 있다
	
	// 이렇게 만들면 포켓몬 한마리 추가할때 마다 메서드가 하나씩 추가된다..
//	public static void testPokemon(Pikachu p) {
//		p.skill1();
//		p.skill2();
//	}
//	public static void testPokemon(LongStone stone) {
//		stone.skill1();
//		stone.skill2();
//	}
}

abstract class Pokemon { //+ abstract 클래스에는 안에도 abstract를 붙여야한다
	//+ Pokemon을 상속받은 모든 클래스는 스킬1,2를 가지고있다
	abstract void skill1();
	abstract void skill2();
}

class Pikachu extends Pokemon {
	// skill 1, 2에 대한 오버라이드가 필요하지만 안내가 안찍힘, 오버라이드 하기전엔 에러가 발생함, 이하 내용없을 때
	@Override
	void skill1() {
		System.out.println("몸통박치기");	
	}

	@Override
	void skill2() {
		System.out.println("백만볼트");
	}	
}

class LongStone extends Pokemon {

	@Override
	void skill1() {
		System.out.println("땅파기");
	}

	@Override
	void skill2() {
		System.out.println("박치기");
	}
	
}

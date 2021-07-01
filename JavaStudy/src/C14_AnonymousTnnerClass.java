
public class C14_AnonymousTnnerClass {

	/*
		# 익명 내부 클래스
		
		  - 클래스를 정의하자마자 이름도 짓지않고 바로 사용한다음 버리는 방식
		  - 일회용이다
	*/
	
	public static void main(String[] args) {
		
		fight(new Dragon()); //+ private static void fight(Monster monster) 이 있어야 해당구문 사용가능
		fight(new SkeletonWarrior()); //+ (Monster monster) = (new SkeletonWarrior() =>  monster에 스켈레톤전사를 넣음
		
		// 익명 내부 클래스는 즉석으로 해당 클래스의 상속을 구현한다
		// 생성자 뒤에 {}를 열어서 즉석해서 클래스를 개조해서 사용하는 방법을 익명 내부 클래스라고 한다
		Dragon dragon01 = new Dragon() { //+ 바로 상속받아서 아래를 구현한다. (이건 업캐스팅이다) //+ new Dragon()는 Dragon의 자식이다
			@Override
			void attack() { //+어떤 드래곤 몬스터인지는 알수없으나, 익명 드래곤 몬스터이다
				//super.attack(); //+얘는 기본값
				System.out.println("얼음 드래곤은 얼음을 뿜어서 공격합니다.");
			}
		}; //+ 이게 상속, 이걸 열어서 개조하겠다(!!!)
		
		fight(dragon01);
		fight(new SkeletonWarrior() { //+어떤 해골 몬스터인지는 알수없으나, 익명 해골 몬스터이다
			@Override
			void attack() {
				//super.attack(); //+해골전사가 칼을 휘둘러서 공격합니다.
				System.out.println("스켈레톤 방패병은 방패를 밀어서 공격합니다.");
			}
		});
		
		// 인스턴스화 할 수 없는 추상 클래스를 즉석해서 상속받아 구현해버릴 수 있다
		Monster monster01  = new Monster() { //+어떤 몬스터인지는 알수없으나, 익명 자손(몬스터)이다
			@Override
			void attack() {
				System.out.println("몸통 박치기!");
			}
		};
		fight(monster01);
	}
	private static void fight(Monster monster) { //+ Monster타입의 monster를 전달하면,
		monster.attack(); //+ monster가 공격(attack)을한다
	}
}
//+ abstract : 형태만 만들어 놓고 완성을 자손 클래스에게 미루는 클래스
abstract class Monster {
	abstract void attack();
}
//+ abstract class Monster의 자손 클래스
class Dragon extends Monster { //+ abstract class Monster에서 동작할 내부 기능을 만든다(오버라이드)
	
	@Override
	void attack() { //+ 익명클래스에서 아래의 내용을 개조한다. 새로운 드래곤이된다(!!!)
		System.out.println("드래곤은 불을 뿜어서 공격합니다.");
	}
}

class SkeletonWarrior extends Monster {
	
	@Override
	void attack() {
		System.out.println("해골전사가 칼을 휘둘러서 공격합니다.");	
	}
}
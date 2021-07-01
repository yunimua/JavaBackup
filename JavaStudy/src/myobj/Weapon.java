package myobj;

public class Weapon {

	/*	
		무기의 속성
		 - 공격력
		 - 현재 강화 등급
		 - 강화 등급별 강화 확률 (등급마다 강화 확률이 다름)
		 - 레벨별 공격력 증가폭
		 
		무기의 메서드
		 - 강화하기
		   (레벨별 강화 확률에 따라 강화가 성공하거나 실패한다) : 랜덤
		   성공하면 강화 등급이 1 증가한다
		   실패하면 강화 등급이 그대로 유지된다 (원한다면 떨어뜨려도 좋음)
	*/
	String name;
	int attack;
	int grade;
	int[] upgrade_chance = {
			90, 90, 80, 80, 80, 70, 70, 30 ,30, 30, 
			15, 15, 15, 10, 10, 10, 10, 5, 5, 5
			};
	//확률은 정할수가 없다.
	int[] attack_incremaent = {
			10, 30, 100, 150, 200, 300, 700, 700, 700, 700,
			1000, 1000, 1000, 1000, 1500, 1500, 2500, 2500, 3000, 3500
			};
			
	Weapon(){
		name = "나뭇가지";
		attack = 5;
		grade = 0;
	}

	Weapon(int attack, String name){
		this.attack = attack;
		this.name = name;
		grade = 0;
	}
	
	boolean upgrade() {
		int value = (int) (Math.random() * 100); // 0~99 
		
		if(value < upgrade_chance[grade]) { // upgrade_chance[0] = 90, upgrade_chance[19] = 5
			System.out.printf("\"%s %+d\" 강화에 성공하셨습니다\n", name, grade);
			grade++;
			return true;
		}else {
			System.out.println("강화 실패...");
			return false;
		}
	}
	
	void attack() {
		int damage = attack;
		
		for (int i = 0; i < grade; ++i) {
			damage += attack_incremaent[i];
		}
		
		System.out.printf("\"%s %+d\"를 휘둘렀습니다.[ 데미지:%d ]\n", 
				name, grade, damage);
	}

	//메인은 다른 영역에 있다.
	public static void main(String[] args) {
		//객체지향은 내가 만든 메서드가 메인에서 어떻게 갖다스일지 생각하면서 만드는 것이 좋다
		Weapon w = new Weapon();
		Weapon gun = new Weapon(10, "비눗방울 총");
		
		for (int i = 0; i < 30; ++i) {
			gun.upgrade();
			gun.attack();
		}
		
		//System.out.println(w.upgrade_chance.length); // 20개 
		//System.out.println(w.attack_incremaent.length); // 20개
	
	}	

}

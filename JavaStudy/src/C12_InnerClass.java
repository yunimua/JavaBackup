
public class C12_InnerClass {
	
	/*
	  	# 클래스 내부에 클래스 사용하기
	  	
	  	 - 클래스 내부에도 클래스를 정의하고 사용할 수 있다
	  	 - 클래스 내부에 존재하는 클래스는 바깥쪽 클래스의 인스턴스가 존재해야 사용할 수 있다
	  	 - static 클래스로 정의하면 인스턴스가 없어도 사용할 수 있다	
	
	*/
	public static void main(String[] args) {
		// 내부 인스턴스 클래스의 인스턴스 생성
		MintChocoLatte drink = new MintChocoLatte(true);
		MintChocoLatte drink2 = new MintChocoLatte(false);
		
		drink.new Chocolate(); //+ 초콜릿이 다 녹았습니다.
		drink2.new Chocolate(); //+ 초콜릿이 잘 안녹습니다.
		
		// 내부 스태틱 클래스의 인스턴스 생성 //+hot의 영향을 받지않는다
		MintChocoLatte.Mint mint = new MintChocoLatte.Mint(); //+민트는 온도에 영향을 받지 않고 치약맛이 납니다.
	}
}

class MintChocoLatte { //+민트 초코라떼라니..
	
	boolean hot;
	
	public MintChocoLatte(boolean ishot) { //+ishot을 받으면, 그게 hot다(false)상태
		hot = ishot;
	}
	
	/**
		내부의 클래스는 MintChocoLatte의 인스턴스가 존재해야 함께 생성되는 설계도이다. 
		내부에서 민트초코라떼의 인스턴스 변수에 영향을 받는 클래스를 생성할 수 있다
	*/ 
	//+ hot 여부가 결정되어야 Chocolate 클래스 생성이 가능하다
	class Chocolate {
		String msg;
		
		public Chocolate() {
			if(hot) {
				System.out.println("초콜릿이 다 녹았습니다.");
			}else {
				System.out.println("초콜릿이 잘 안녹습니다.");
			}
		}
	}
	/**
	   내부에 인스턴스의 영향을 받지 않는 스태틱 클래스를 정의하는 것도 가능하다.
	*/
	
	static class Mint {
		public Mint() {
			System.out.println("민트는 온도에 영향을 받지 않고 치약맛이 납니다.");
		}
	}
}

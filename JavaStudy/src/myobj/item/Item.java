package myobj.item;

/*
	 이 클래스를 상속받아 3가지 아이템을 만들어보세요
	 ※ 단 Item 클래스는 수정하지 말 것
*/
abstract public class Item {

	String name;
	int price;
	
	public Item(String name, int price) {
		this.name = name;
		this.price = price;
	}
	
	// final를 붙인 메서드는 자식 클래스에서 오버라이드를 금지시킨다.
	final public void info() {
		System.out.println("이름 : " + name);
		System.out.println("가격 : " + price + "원");
	}
	
	abstract public void use();	
}
	
	
	//잘못 적은 답 : 클래스를 새로 생성했어야한다!!!!
//	public class Cup extends Item {
//	
//		public Cup(String name, int price) {
//			super(name, price);
//		}
//	
//		@Override
//		public void use() {
//			name = "유리컵";
//			price = 5000;
//			System.out.println(name + price);
//		}
//	}
//
//	public class Het extends Item {
//	
//		public Het(String name, int price) {
//			super(name, price);
//		}
//	
//		@Override
//		public void use() {
//			name = "캡모자";
//			price = 17000;
//			System.out.println(name + price);
//		}
//	}

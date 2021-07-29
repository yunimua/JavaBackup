package jdbc.model;

// 프로그램을 운영하기 위한 데이터를 보관하기 위해 만들어놓은 코드들을 모델이라고 한다.
public class Coffee { //+ 데이터를 보관하는 박스, 용도분리용

	private int id;
	private String name;
	private int price;
	
	public Coffee(int id, String name, int price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}
	
	public int getId() { //+ get 쓰고 Ctrl+스페이스를 누르면 자동완성이 된다
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public int getPrice() {
		return price;
	}
	
	@Override
	public String toString() {
		return String.format("%d/%s/%d\n", id, name, price);
	}
}

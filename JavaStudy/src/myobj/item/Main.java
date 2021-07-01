package myobj.item;

public class Main {
	
	int money;
	
	public Main() {
		money = 10000;
	}
	
	public void purchase(Item item) {
		this.money -= item.price;
		System.out.println(item.name + "을 사고 " + this.money + "원이 남았습니다.");
	}
	public static void main(String[] args) {
		Main m = new Main();
		
		m.purchase(new Glue());
		m.purchase(new Sharp());
		m.purchase(new Eraser());
	}
}

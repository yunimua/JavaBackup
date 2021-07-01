package myobj;

public class Smartphone { 

	String brand;
	int price;
	double sale;
	
	Smartphone(){
		price = 1000000;
	}
	
	void sale() {
		if (brand.equals("삼성")) {
			price -= (price*0.2);
		}else if (brand.equals("애플")){
			price -= (price*0.1);
		}else {
			System.out.println("할인이 불가능합니다.");
			return;
		}
	}
}

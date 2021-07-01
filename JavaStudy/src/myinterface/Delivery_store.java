package myinterface;

public class Delivery_store implements Delivery {
	
	int order;
	int cancel;
	int max_quantity = 15;
	int quantity = 0;
	
	@Override
	public int order() {
		return order += 2;
	}

	@Override
	public int orderCancel() {
		return order -= 1;
	}

	@Override
	public boolean orderQuantity() {
		if (quantity == max_quantity) {
			return false;
		}else {
			quantity++;
			return true;
		}
	}
}

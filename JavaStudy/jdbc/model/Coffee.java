package jdbc.model;

// ���α׷��� ��ϱ� ���� �����͸� �����ϱ� ���� �������� �ڵ���� ���̶�� �Ѵ�.
public class Coffee { //+ �����͸� �����ϴ� �ڽ�, �뵵�и���

	private int id;
	private String name;
	private int price;
	
	public Coffee(int id, String name, int price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}
	
	public int getId() { //+ get ���� Ctrl+�����̽��� ������ �ڵ��ϼ��� �ȴ�
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

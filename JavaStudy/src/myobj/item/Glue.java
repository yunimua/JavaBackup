package myobj.item;

public class Glue extends Item {

	public Glue() {
		super("딱풀", 1000);
	}

	@Override
	public void use() {
		System.out.println("풀을 사용했더니 잘 붙었습니다.");
	}
}

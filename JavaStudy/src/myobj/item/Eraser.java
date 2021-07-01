package myobj.item;

public class Eraser extends Item {

	public Eraser() {
		super("지우개", 500);
	}

	@Override
	public void use() {
		System.out.println("필기를 지울 수 있습니다. 볼펜은 못지웁니다.");
	}

}

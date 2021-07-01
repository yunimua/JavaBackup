package myobj.item;

public class Sharp extends Item {

	public Sharp() {
		super("샤프", 3000);
	}

	@Override
	public void use() {
		System.out.println("샤프심을 채우고 글을 씁니다.");
	}

}

package myobj.pirate;

public class Player {
	
	String name; //+이름
	int win; //+승
	int lose; //+패
	
	public Player(String name) {
		this.name = name; //+이름을 가지고 참여하게됨
	}
	
	public void win() {
		this.win++;
	}
	
	public void lose() {
		this.lose++;
	}
	
	public String getName() {
		return name;
	}
}

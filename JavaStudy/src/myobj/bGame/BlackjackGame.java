package myobj.bGame;

public class BlackjackGame {

	CardSet cards; //(16번)
	User user; //(18번)
	
	BlackjackGame() { 
		cards = new CardSet();  //(17번)
		user = new User(); //(20번)
	} 

	public void newGame() {
		
		user.add(cards.next()); // player한테 카드 2장
		user.add(cards.next());
		
		System.out.println(user);
	}
	
	public static void main(String[] args) {
		new BlackjackGame().newGame();
	}
}

package myobj.blackJack;

public class Dealer extends Player { //+player와 유사한 내용이므로 상속받는다

	
//	Dealer() {
//		tables = new Card[11];
//	}
	
	void add(Card card) {
		if(count == 0) {
			card.hidden = true; //+첫번째카드만 히든으로, 1장만 보여준다
		}
		if (card.rank == 0) {
			ace_count++;
		}
		
		tables[count++] = card;
	}
	
}

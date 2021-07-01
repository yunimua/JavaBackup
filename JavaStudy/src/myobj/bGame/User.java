package myobj.bGame;

public class User {
	
	final static int MAX_TCARD = 11; //(10번) : 최대 뽑을 수 있는 카드는 11장이다
	
	CardName[] table; //(11번) 테이블에 올리는 카드 배열
	
	int count; //(13번)
	int aceCount;
	
	User() {
		table = new CardName[MAX_TCARD]; //(12번)
	}
	
	void add(CardName card) {
		if (card.cdName == 0) { //(14번) : 받은 카드가 0번(A)라면 ace카운트 1이 증가한다
			aceCount++;
		}
		table[count++] = card; //(13번) : 카드를 받으면 카운트가 ++1 증가한다
	}
	
	@Override
	public String toString() { //테이블에 올라간 카드를 표시하기 위한 String
		String str = "";
		for (int i = 0; i < MAX_TCARD; ++i) {
			if (table[i] == null) { //뽑히지 않은 카드는 null, 표시하지 않도록 한다
				break;
			}else {
				str += "[" + table[i] + "]";
			}
		}
		return str;
	}
}

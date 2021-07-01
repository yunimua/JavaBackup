package myobj.blackJack;

import java.util.Arrays;

public class Player {
	
	final static int MAX_TABLE_SIZE = 11;
	
	Card[] tables; //+테이블에 깔린 카드
	
	//+ 여태 받은 카드의 숫자
	int count; //+한장 받을때 마다 카드 카운트 증가
	int ace_count;
	
	Player() { //+public을 지움
		tables = new Card[MAX_TABLE_SIZE]; //+ 제일 많이받을 수 있는 카드는 11장이다. 1 1 1 1 2 2 2 2 3 3 3, (1벌일 경우)
	}
	
	void add(Card card) { //+ 내 테이블에 카드 1장을 추가하는 메서드
		if(card.rank == 0) { //+0은 A다. A가 나오면 카운트 1을 증가시킨다
			ace_count++;
		}
		tables[count++] = card;	
	}
	
	int calc() { //+받은 카드 숫자 계산
		int value = 0; //+ value는 카드의 VALUES에 있는 값을 리턴하기 위한 값, 카드를 2장뽑으면 합산되어야 하므로 value+value
		for (int i = 0; i < count; ++i) {
			value += tables[i].getValue(); //+ Cards > Card class에 있는 getValue값을 가져와서 더한다
			
		}
		int i = 0;
		while (ace_count - i> 0 && value > 21) { //+ace_count -1을 했을 때 0보다 크고(1이라도 증가했고)
			value -= 10;						// ㄴ value 합이 21이면 -10을 한다(A카드 -10)
			i++;
		}
		return value; //+더한 값을 리턴해서 보낸다
	}
	
	
	public String toString() {
		String str = "";
		for (int i= 0; i < MAX_TABLE_SIZE; ++i) {
			if (tables[i] == null) {
				break;
			}else {
				str += "[" + tables[i] + "]";
			}
		}
		return str;
	}
}

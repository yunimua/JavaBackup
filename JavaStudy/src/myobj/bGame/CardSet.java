package myobj.bGame;

import java.util.Arrays;
import java.util.Scanner;

public class CardSet {
	
	final public static int CARD_SHAPE = 4; //문양은 4개
	final public static int CARD_NUM = 13; // 카드종류는 13장
	final public static int SIZE = CARD_SHAPE * CARD_NUM; //총 개수는 52개

	CardName[] cards; //(0번)
	
	private int nextcd;
	
	Scanner sc = new Scanner(System.in);
	
	User user; //(15번) : player 클래스를 불러온다
	
	public CardSet() { //+(2변)
		cards = new CardName[SIZE];
		
		for (int i = 0; i < CARD_SHAPE; ++i) {
			for (int j = 0; j < CARD_NUM; ++j) {
				cards[i*CARD_NUM+j]= new CardName(i,j); //+ (1번)을 가져온다
			}
		}	
		mix(1000); //천번섞기 (6번) : mix 만들고 추가
	}
	
	//(5번)
	public void mix(int su) { //+몇번 섞을 지, 횟수가 들어가야 하므로 (int "") 선언이 필요
		for (int i = 0; i < su; ++i) {
			int a = (int)(Math.random() * SIZE); //+ 랜덤하게만 설정하면, 낮은수부터 순차적으로 나오게됨
			int b = (int)(Math.random() * SIZE);
			
			CardName temp = cards[a];
			cards[a] = cards[b];
			cards[b] = temp;
		}
	}
	
	public CardName next() { //(7번)
		if( nextcd > SIZE - 1) {
			mix(500); //(8번) = 카드 52장을 모두 썼을 때 다시 섞어준다
			nextcd = 0; //(9번) = 리셋을 위해 0을 추가해준다
		}
		return cards[nextcd++];
	}

	@Override
	public String toString() { //(4번)
		return Arrays.toString(cards);
	}

	public static void main(String[] args) { //(3번)
		CardSet cards = new CardSet();
		System.out.println(cards);
//		
//		//System.out.println(Arrays.toString(new CardSet().newCard));
//		 //ㄴ String toString 메서드를 오버라이드 하기전까지는 위 형태로 출력함
	}
}

class CardName { //(0번) 처음 만들때부터 클래스를 추가해둠
	static char[] CARDPATTERN = {'♥', '♣', '♠', '◆'}; // char 형으로 넣은건 용량 줄이기, 변경되지 않는 배열
	static String[] cardName = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
	static int[] cardNum = {11, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10}; // 점수에 계산될 숫자

	int cdPt;
	int cdName;
	boolean hide; //(14번) : 카드를 한장만 가려두는 조건문
	
	CardName(int cdPt, int cdName) { //(+1번)
		this.cdPt = cdPt;
		this.cdName = cdName;
	}
	
	@Override
	public String toString() { //(3번)
		return CARDPATTERN[cdPt] + cardName[cdName];
	}
}

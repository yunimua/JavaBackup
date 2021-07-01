package myobj.blackJack;

import java.util.Arrays;

public class Cards {
	
	final public static int NUM_OF_SUITS = 4; //+문양은 4개
	final public static int NUM_OF_RANKS = 13; //+ 랭크는 13개가 있다
	final public static int CARD_SIZE = NUM_OF_SUITS * NUM_OF_RANKS;
	
	Card[] cards; //+Card 클래스의 cards 배열을 추가..
	//+ cards라는 배열에 숫자를 채워넣고(1), int 배열의 숫자에 따라 char형과 String 배열안의 모양을 넣어 출력한다
	
	private int cursor;
	
	public Cards() {
		cards = new Card[CARD_SIZE]; //+총 카드 수
		
		for (int i = 0; i < NUM_OF_SUITS; ++i) {
			for (int j = 0; j < NUM_OF_RANKS; ++j) {
				cards[i * NUM_OF_RANKS + j] = new Card(i, j); //+ 0 * 13 + 0 = 0이지.. => new card(0, 0) 부터들어간다.
			}
		}
		shuffle(1000); //+ 카드를 천번 섞는다, (1000  = shuffle > int times)
	}
	//+ 섞어주는 메서드
	public void shuffle (int times){ //+ int times 몇번 섞을 지를 위한 값
		for (int i = 0; i < times; ++i) {
			int x = (int)(Math.random() * CARD_SIZE);
			int y = (int)(Math.random() * CARD_SIZE);
			
			Card temp = cards[x];
			cards[x] = cards[y];
			cards[y] = temp;
		}
	}
	
	public Card next() { //+카드를 하나씩 꺼내는 메서드
		// 이 부분에 알맞은 소스를 제출해보세요
		if (cursor > CARD_SIZE -1) {
			shuffle(500); //+ 다시 섞어준다 (+1이랜다)
			cursor = 0; //+ 52장이 넘어가면 (에러)터지니까 0으로 바꿔서 넣는다
		}
		return cards[cursor++]; //+ % CARD_SIZE 을 넣으면 (-1점이랜다), : cards[cursor++ % CARD_SIZE]; 
	}
	
	@Override
	public String toString() {
		return Arrays.toString(cards); //+ 카드를 모양과 숫자로 String 해서 보여주기위한 return값
	}
	
	public static void main(String[] args) {
		Cards cards = new Cards();
		System.out.println(cards);
		
		for (int i = 0; i < 30; ++i) {
			System.out.println(i + "번째로 뽑은 카드 : " + cards.next()); //+ next 메서드를 통해 랜덤하게 생성된 카드뽑힌 결과를 출력
		}
		
		
//		System.out.println(Arrays.toString(new Cards().cards)); //+ Cards를 불러와서 안에 cards를 불러온다
//		//+ 위 내용을 String 형태로 보기 위해서는 아래의 SUITS[suit] + RANKS[rank]; return이 필요하다, 안그럼 배열 주소록출력..
//		
//		System.out.println(new Card(0,0).toString());
//		
//		// println()은 사실 전달한 인스턴스의 toString()을 호출해 콘솔에 출력하는 메서드다
//		System.out.println(new Integer(10).toString());
//		
//		// JAVA의 모든 클래스는 toString() 메서드를 가지고 있다
//		// 모든 클래스의 부모인 Object 클래스가 toString()을 가지고 있다
//		Object o1 = 10;
//		Object o2 = "ABCD";
//		Object o3 = new Card(1, 5); //+ Object는 부모이기 때문에 모든 값을 넣어 사용할 수 있다
	}
}

class Card {
	
	private static char[] SUITS = {'♠', '♣', '◆', '♥'};
	private static String[] RANKS = {
			"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"}; //+10때문에 String배열이 되어야한다
	private static int[] VALUES = {11, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10};
	
	int suit; //+ 카드 인스턴스 배열이다!
	int rank; //+ 카드 점수체크용..
	boolean hidden; //+ 카드가 뒤집혀있는지 체크 : public String toString() 여기서 체크함 
	
	public Card(int suit, int rank) {
		this.suit = suit; //+ {'♠', '♣', '◆', '♥'};를 돌려주기 위한 인스턴스 배열
		this.rank = rank; 
	}
	
	int getValue() { //+ VALUES 값을 리턴하기 위한 메서드
		return VALUES[rank];
	}
	
	// # 클래스의 toString() 메서드를 오버라이드
	//  - 이 클래스가 문자열로 표현되어야 할 때 어떻게 보여야 하는지를 정의해 놓는다
	@Override //+ (ctrl+스페이스) + toString 오버라이드
	public String toString() {
		if(hidden) {
			return "H";
		}else {
			return SUITS[suit] + RANKS[rank];
		}
		
		//return (hidden ? "H" : SUITS[suit]) + (hidden ? "" : RANKS[rank]); 
		//+ hidden이면 문양이 H로 표시, 숫자는 표시하지 않음으로 조건문을 건 형태, if문으로 대체
		
		//+ return SUITS[suit] + RANKS[rank];
		//+  ㄴ 위의 (new Cards().cards) 를 String 형태로 보여주는것
	}
	
}
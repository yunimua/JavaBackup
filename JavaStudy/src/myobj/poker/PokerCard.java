package myobj.poker;

import java.util.*;

/*
		poker
			- 로열 스트레이트 플레쉬 : 같은 무늬, 10 / J / Q / K / A
			- 백 스트레이트 플레쉬 : 같은 무늬, A / 2 / 3 / 4 / 5
			- 스트레이트 플레쉬 : 같은 무늬, 연속된 숫자 5개
			- 포카드 : 같은 숫자 4개
			- 풀하우스 : 같은 숫자 3개, 같은 숫자 2개
			- 플러쉬 : 같은 무늬 3장
			- 백 스트레이트 : A / 2 / 3 / 4 / 5
			- 스트레이트 : 연속된 숫자 5개
			- 트리플 : 같은 숫자 3개
			- 투페어 : 같은 숫자 2개
			- 원페어 : 같은 숫자 1개
			- 노페어 : 가장 높은 숫자 1장으로 승패
			- 무늬 별 높은 등급 ? : ♠ > ◆ > ♥ > ♣ (다른 경우도 있음..동네마다 다름)

*/

public class PokerCard {
	
//    private static final String[] CARD = {"♠A", "♠2", "♠3", "♠4", "♠5", "♠6", "♠7", "♠8", "♠9", "♠10", "♠J", "♠Q", "♠K", 
//    		"♧A", "♧2", "♧3", "♧4", "♧5", "♧6", "♧7", "♧8", "♧9", "♧10", "♧J", "♧Q", "♧K",
//    		"◆A", "◆2", "◆3", "◆4", "◆5", "◆6", "◆7", "◆8", "◆9", "◆10", "◆J", "◆Q", "◆K",
//    		"♡A", "♡2", "♡3", "♡4", "♡5", "♡6", "♡7", "♡8", "♡9", "♡10", "♡J", "♡Q", "♡K"};
	
	final public static int NUM_OF_SUITS = 4; 
	final public static int NUM_OF_RANKS = 13;
	final public static int CARD_SIZE = NUM_OF_SUITS * NUM_OF_RANKS;
	
	PokerCard() {
		ArrayList deck = new ArrayList(NUM_OF_SUITS * NUM_OF_RANKS);
		
		for (int i = 0; i < NUM_OF_SUITS; ++i) {
			for (int j = 0; j < NUM_OF_RANKS; ++j) {
				deck.add(new CardSet(i, j + 1));
			}
		}
		Collections.shuffle(deck);
	}
	
	public void tableSet() {
		
	}
	
}

class CardSet {
	
	private int rank, suit;
	
    private static char[] SUITS = {'♠', '♧', '◆', '♡'};
    private static String[] RANKS = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
    
    CardSet(int rank, int suit) {
    	this.rank = rank;
    	this.suit = suit;
    }
    
    @Override
    public String toString() {
    	return RANKS[rank] + SUITS[suit];
    }
    
}

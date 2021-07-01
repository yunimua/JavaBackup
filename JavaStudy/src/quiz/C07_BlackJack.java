package quiz;

import java.util.Scanner;

import myobj.bGame.CardSet;

public class C07_BlackJack {
	
	/*
	 	# 참고자료
	 	
	 		https://www.247blackjack.com/
	 	
	 	# 카드
	 		4가지 문양 : 하트, 클로버, 다이아몬드, 스페이드(총 52장, 문양별 13장)
	 		
	 		숫자 : A, 2, 3, 4, 5, 6, 7, 8, 9, 10, J, Q, K
	 		- J, Q, K는 10
	 		※ 블랙잭에서는 A는 1로 쓸 수도 있고 11로도 쓸 수 있음
	 	
		# 블랙잭을 만들어 보세요
		
		1. 컴퓨터(딜러)와 사람(플레이어)이 카드를 뽑는다
		
		2. 처음에는 둘 모두 2장씩 받는다. 이 때 딜러의 카드는 한장 가려놓는다.
		- 가려진카드 1장, 보이는 카드 1장이 있어야 한다
		
		3. 플레이어는 상황을 보고 더 뽑을지 (hit) 여기서 멈출지를(stand) 결정한다
		- 내카드 2장과 상대방 카드 1장을 보고 판단이 필요하다
		
		4. 플레이어가 멈추면 딜러가 가려져있던 카드를 오픈하고 큐칙에 따라 카드를 뽑는다
			(딜러는 반드시 카드 합이 16이하일때 무조건 뽑고, 17이상이면 무조건 멈춰야 한다)
			
		5. 플레이어의 카드 숫자들의 합이 딜러보다 높거나 정확하게 21이라면 승리한다.
			플레이어의 카드 숫자들의 합이 21보다 크면 패배한다. (A ~ K)
	
	*/

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		CardSet bl = new CardSet();

		
	}
}


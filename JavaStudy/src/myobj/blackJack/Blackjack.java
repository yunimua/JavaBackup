package myobj.blackJack;

import java.util.Scanner;

public class Blackjack {

	Scanner sc;
	Cards cards;
	Player player;
	Dealer dealer;
	
	public Blackjack() {
		cards = new Cards();
		player = new Player();
		dealer = new Dealer();
		sc = new Scanner(System.in);
	}
	
	public void new_game() { 
		dealer.add(cards.next());
		dealer.add(cards.next());
		
		player.add(cards.next());
		player.add(cards.next());
		
		int pv = -1;
		while (choice()) { //+ hit이냐 stand냐, 
			player.add(cards.next());
			
			pv = player.calc();
			if (pv >= 21) { //+ 버스트일때 멈춤!break
				break;
			}
		}
		info(); //+결과노출
		
		if(pv <= 21) { // 딜러가 마저 카드를 여는 로직, 21보다 크거나 같으면 오픈
			open(); //+  open() 메소드 추가
		} else {
			System.out.println("플레이어 버스트!!!");
		}
		
		last_info(); //+ 끝나면서 최종 결과 노출 : last_info 메서드 추가
		whowin();
		System.out.println("게임 끝!!");
	}
	
	private void whowin() {
		int dv = dealer.calc(); //+ 딜러 카드 점수
		int pv = player.calc(); //+ 플레이어 카드 점수
		
		if (dv == pv) {
			System.out.println("무승부!"); //+카드 합산 점수가 같으면 무승부
		}else if (dv > 21 && pv <= 21) {
			System.out.println("플레이어 승리!");
		}else if (pv > 21 && dv <= 21) {
			System.out.println("딜러의 승리!");
		}else if (pv > dv) {
			System.out.println("플레이어 승리!");
		}else {
			System.out.println("딜러의 승리!");
		}
		dealer.tables[0].hidden = false;
	}
	
	
	
	private void open() {
		
		while(dealer.calc() < 17) { //+ 17보다 작으면 계속 뽑아라
			dealer.add(cards.next());
		}
		dealer.tables[0].hidden = false; //+ 히든이었던 카드(true상태)를 false로 바꾼다
	}
	
	private void info() { //+ 멈췄을 때 결과 노출
		System.out.println("딜러의 카드: " + dealer); 
		System.out.println(player + "의 value: " + player.calc()); //+ 위와 동일 : player.calc()
	}
	
	private void last_info() { //+ 최종 결과 노출
		System.out.println("딜러의 카드: " + dealer + ", value: " + dealer.calc()); //+ calc에서 계산한 값 : dealer.calc()
		System.out.println(player + "의 value: " + player.calc());
	}
	
	
	//+ 파이썬 표절
	private int input(String notice) {
		System.out.print(notice); //+ boolean choice()에서 입력한 내용 출력
		return sc.nextInt(); //+ Scanner로 입력할 수 있게 추가
	}
	
	//+ 파이썬 표절
	private boolean choice() {
		while (true) {
			info();
			int choice = input("1. hit\t2. stand > "); //+ input(String notice)으로 String으로 출력, 입력하게 Scanner추가
			
			if (choice  == 1) { //+ 1을 선택하면 true;
				return true;
			}else {
				return false;
			}
		}
	}
	
	public static void main(String[] args) { //+ 게임실행
		new Blackjack().new_game();
	}
}






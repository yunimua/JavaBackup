package myobj;

import java.util.Scanner;

public class PiratePlay {
	
	int hole; // 구멍 수
	int player; // 플레이어 수
	
	int lose_hole; //함정
	int choice_hole;//플레이어가 선택한 수
	
	boolean[] choice; //+초기값은 모두 false
	boolean[] overlap;
	
	Scanner sc = new Scanner(System.in);
	
	public PiratePlay(int player, int hole) {
		this.hole = hole;
		this.player = player;
	}
	
	public boolean popUp; //+ 튀어나와서 게임 종료되는 값
	
	public void checkHole(int hole) {
		choice = new boolean[hole]; //선택한 카드 배열
		overlap = new boolean[hole]; //함정카드 배열
		
		for (int i = 0; i < 3; ++i) {
			overlap[(int)(Math.random()*hole)] = true;
		}
	}
	
	public boolean Select(int num) {
		if(choice[num]) {
			return false;
		}else {
			choice[num] = true;
			popUp = overlap[num];
			return true;
		}
	}
	
	public void choicePrint() {
		for (int i = 0, len = choice.length; i < len; ++i) {
			System.out.print(!choice[i] ? "■ " : "□ ");
		}
		System.out.println();
	}

	public void new_Game() {
		while(player < 2) {
			System.out.print("플레이 할 인원(2명▲이상) 입력: ");
			player = sc.nextInt();
		}
		while(hole < player || hole == player) {
			System.out.print("총 구멍 수를 입력: ");
			hole = sc.nextInt();
		}
		checkHole(hole);
		
		int i = 0;
		while(i < hole) {
			choicePrint();
			System.out.printf("플레이어[%d] 찌르기 > ", i % player+1);
			choice_hole = sc.nextInt();
			
			if(choice_hole > hole || choice_hole < 1) {
				continue;
			}
			if (Select(choice_hole - 1)) {
				if(popUp) {
					System.out.println("패배...");
					break;
				}else {
					System.out.printf("공격 성공!! 다음 > \n", i % player+1);
					++i;
				}
			}else {
				System.out.println("이미 찌른 위치 입니다. 다시 선택 > ");
			}
		}
		System.out.println("칼을 모두 사용하였습니다.");
	}
}

package myobj.FiveDice;

import java.util.Arrays;

public class FiveDice {
	
	final static int MAX_DICE_NUM = 6;
	final static int FIVEDICE = 5;
	
	static int[] dice; 
	static int[] count;
	
	boolean five;
	boolean four;
	boolean two;
	boolean three;
	boolean strL;
	boolean strS;
	
	public void randomDice() {
		dice = new int[FIVEDICE]; // 5개의 주사위
		count = new int[MAX_DICE_NUM]; // 6개의 숫자
		
		for(int i = 0; i < FIVEDICE; ++i) { // 5개의 주사위(0~4까지 5번 실행)
			dice[i] = (int)(Math.random() * MAX_DICE_NUM +1); // 1~6 랜덤 숫자 (0~5가 되지 않기 위해 +1)
		}
		for (int i = 0; i < FIVEDICE; i++) {
			count[dice[i] - 1]++; // 1이나오면 count[0]에 넣기 위해서 -1이 필요
			//System.out.print (count[(dice[i] -1)] + " "); // 같은 숫자일 때 카운트 증가되는거 확인
		}
	}
	
	boolean fiveDice(){
		for (int chk : count) {
			if (chk == 5) {
				five = true;
			}
		}
		System.out.println("[5same_Num] ? : " + five); // true, false 체크용..
		return five;
	}
	
	boolean fourDice() {
		for (int chk : count) {
			if (chk == 4) {
				four = true;
			}
		}
		System.out.println("[4same_Num] ? : " + four);
		return four;
	}
	
	boolean fullHouse() {
		for (int chk : count) {
			if (chk == 2) { // 숫자 두개가 같을 때 , chk == 2 && chk == 3 을 넣게되면 111이 나왔을 때도 true가 됨
				two = true;
			}else if (chk == 3) { // 숫자 세개가 같을 때, 나눠서 체크
				three = true;
			}
		}
		System.out.println("[2]+[3]same_Num ? : " + (two && three));
		return two && three; // 2가지 조건이 모두 true 일때..
	}
	
	boolean largeStraight() {
		for (int chk : count) {
			//System.out.print(chk + "-"); // 각 숫자별 카운트된 수를 체크..
			if (count[1] >= 1 && count[2] >= 1 && count[3] >= 1 && count[4] >= 1 ) { // 1~6에서 2,3,4,5가 1일때
				if (count[0] >= 1 || count[5] >= 1) { // 1~6에서 1,6이 1일 때
					strL = true;
				}
			}
		}
		System.out.println("[5Serial_Num] ? : " + strL);
		return strL;
	}
	
	boolean smallStraight() {
		for (int chk : count) {
			//System.out.print(chk + " "); 
			if (count[2] >= 1 && count[3] >= 1) { // 1~6에서 3,4가 1일때
				if (count[0] >= 1 && count[1] >= 1 || // 1~6에서 1,2가 1일때
					count[1] >= 1 && count[4] >= 1 || // 1~6에서 2,5가 1일때
					count[4] >= 1 && count[5] >= 1) {   // 1~6에서 5,6가 1일때
					strS = true;
				}
			}
		}
		System.out.println("[4Serial_Num] ? : " + strS);
		return strS;
	}
	
	public void result() {
		if(fiveDice()) {
			System.out.println("   ▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
			System.out.println("   ▒▒       5Dice!        ▒▒");
			System.out.println("   ▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
		}else if (fourDice()) {
			System.out.println("   ▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
			System.out.println("   ▒▒       4Dice!        ▒▒");
			System.out.println("   ▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
		}else if (fullHouse()) {
			System.out.println("   ▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
			System.out.println("   ▒▒     FULL HOUSE!!    ▒▒");
			System.out.println("   ▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
		}else if(largeStraight()) {
			System.out.println("   ▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
			System.out.println("   ▒▒   largeStraight!!!  ▒▒");
			System.out.println("   ▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
		}else if (smallStraight()) {
			System.out.println("   ▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
			System.out.println("   ▒▒   Small Straight!!  ▒▒");
			System.out.println("   ▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
		}else {
			System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
			System.out.println("   실패!!! 성공한 조합이 없습니다. ");
			System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
		}
		System.out.println(">>>>> 게임이 종료되었습니다.");
	}
	@Override
	public String toString() {
		return Arrays.toString(dice);
	}

//	public static void main(String[] args) { // 메인 체크용..
//		FiveDice dice = new FiveDice();
//		
//		dice.randomDice();
//		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
//		System.out.println(" Random Dice : " + dice);
//		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
//		dice.result();
//		
//	}
}






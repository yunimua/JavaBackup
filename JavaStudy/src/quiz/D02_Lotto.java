package quiz;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import myobj.Lotto;

public class D02_Lotto {

	/*
		1. 1부터 45 사이의 중복없는 랜덤 숫자 6개 또는 7개를 생성하는 메서드를 작성해보세요
			(당첨번호 6개 + 보너스번호 1개, 손님이 고르는 번호는 6개)
		
		2. 프로그램이 시작되면 당첨번호를 하나 지정하고 (숫자 7개)
		   당첨번호와 일치하는 6개의 숫자가 나올 때까지 번호를 계속 뽑아보세요
		   
		3. 1등 또는 2등에 당첨될때까지 돈을 얼마나 썼는지 계산해보세요
			(숫자 6개 뽑을 때마다 천원, 1등인지 2등인지도 알려줘야 함)
	*/
	
	final private static int LOTTO_SIZE = 45;
	final private static int BONUS_INDEX = 4;
	
	private static int bonus = 0;
	
	
	public static Set<Integer> generate(int len) {
		HashSet<Integer> lotto = new HashSet<>();
		
		while (lotto.size() != len) {
			int ranNum = (int) (Math.random() * LOTTO_SIZE +1);
			//System.out.println("Set에" + ranNum + "이 더해집니다.");
			lotto.add(ranNum);
			
			if (len == 7 && lotto.size() == BONUS_INDEX) { //+ 4번째 수를 보너스 번호로 지정
				bonus = ranNum;
			}
		}
		return lotto;
	}
	
	public void test() {
		Set<Integer> win = generate(7); //+ len은 7이다
		System.out.println("당첨 번호는 " + win + "입니다.\n 그 중 보너스 번호는 " + bonus + "입니다." );
		
		List<Integer> checkList = new ArrayList<>(7); //+사이즈는 7이다(=당첨번호 개수가 변화하지않기 때문에 7로 지정)
		
		long spent = 0;
		int count = 0;
		
		while (true) {
			Set<Integer> blackcow = generate(6);
			count++;
			
			checkList.addAll(win); //+당첨번호
			checkList.removeAll(blackcow); //+뽑은번호
			
			if (checkList.size() == 1) {
				spent = count * 1000;
				if (checkList.get(0) == bonus) { //+ 남은 숫자가 보너스번호면 1등 	
					System.out.println("1등 당첨입니다. " + count + "번 도전하셨으며, 여태까지 쓰신 돈은 " 
								+ spent * 1000 + "원 입니다.");
				}else {
					System.out.println("2등 당첨입니다. " + count + "번 도전하셨으며, 여태까지 쓰신 돈은 " 
							+ spent * 1000 + "원 입니다.");
				}
				break;
			}
			checkList.clear();
		}
	}
	
	
	public static void main(String[] args) {
		D02_Lotto quiz = new D02_Lotto();
		quiz.test();
		
//		Set<Integer> win = quiz.generate(7); //+ 당첨번호 뽑았다.
//		
//		System.out.println("당첨 번호는 " + win + "입니다.\n 그 중 보너스 번호는 " + quiz.bonus + "입니다." );
//		
//		List<Integer> checkList = new ArrayList<>(7); //+사이즈는 7이다
//		
//		long spent = 0;
//		int count = 0;
//		while (true) {
//			Set<Integer> blackcow = quiz.generate(6);
//			count++;
//			
//			checkList.addAll(win);
//			checkList.removeAll(blackcow);
//			
//			if (checkList.size() == 1) {
//				spent = count * 1000;
//				if (checkList.get(0) == quiz.bonus) {
//					System.out.println("1등 당첨입니다. " + count + "번 도전하셨으며, 여태까지 쓰신 돈은 " 
//								+ spent * 1000 + "원 입니다.");
//				}else {
//					System.out.println("2등 당첨입니다. " + count + "번 도전하셨으며, 여태까지 쓰신 돈은 " 
//							+ spent * 1000 + "원 입니다.");
//				}
//				break;
//			}
//			checkList.clear();
//		}
		
	}
}
		// +내가 푼거
//		List<Integer> winlist = new ArrayList<>();
//		List<Integer> picklist = new ArrayList<>();
//		
//		winlist = new ArrayList<>(Lotto.winningLotto());
//		
//		Collections.sort(winlist);
//		Collections.sort(picklist);
//		System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
//		System.out.printf("> 1등 당첨 번호 : [%d, %d, %d, %d, %d, %d]\n> 보너스 번호 : [%d]\n", 
//				winlist.get(0),winlist.get(1),winlist.get(2),winlist.get(4),
//				winlist.get(5),winlist.get(6),winlist.get(3));
//		System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
//		
//		long count = 0L;
//		while(true) {
//			count++;
//			picklist = new ArrayList<>(Lotto.pickLotto());
//			inter(picklist, winlist);
//			if (inter(picklist, winlist).size() == 5 && winlist.get(3) != null) {
//					System.out.println("----------2등 당첨 >>> 일치한 번호 : " 
//							+ inter(picklist, winlist) + "[" + winlist.get(3) +"]");
//					break;
//			}
//		}
//		System.out.println("사용한 금액은 : " + (count*1000) + "원 입니다.");
//		
//		winlist.remove(3);
//		
//		count = 0;
//		while(true) {
//			count++;
//			picklist = new ArrayList<>(Lotto.pickLotto());
//			inter(picklist, winlist);
//			if (inter(picklist, winlist).size() == 6) {
//				System.out.println("----------1등 당첨 >>> 일치한 번호 : " + inter(picklist, winlist));
//				break;
//			}	
//		}
//		System.out.println("사용한 금액은 : " + (count*1000) + "원 입니다.");
//	}
//	
//	public static ArrayList<Integer> inter(Collection<Integer> picklist, Collection<Integer> winlist) {
//		ArrayList<Integer> inter = new ArrayList<>();
//		inter.addAll(winlist);
//		inter.retainAll(picklist);
//		
//		return inter;
//	}
//}
